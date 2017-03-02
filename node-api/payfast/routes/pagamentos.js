module.exports = function(app) {

    app.get('/pagamentos', (req, res) => {
        console.log('Hitting /pagamentos route');
        res.sendStatus(200);
    })

    app.get('/cartao', (req, res) => {
        var clientCard = new app.services.cartoesClient();
        clientCard.autorizado((err, request, response, retorno) => {
            if (err) {
                res.status(500).send("Erro na validação do cartão: " + err);
            } else {
                console.log("Validação do cartão efetuada com sucesso");
                res.status(202).json(retorno);
            }
        });
    });

    app.post('/pagamentos/pagamento', (req, res) => {
        var pagamento = req.body["pagamento"];
        console.log("Processando pagamento...");

        req.assert("pagamento.forma", "Forma de pagamento não pode ser vazia").notEmpty();
        req.assert("pagamento.valor", "Valor não pode ser vazio ou diferente de decimal").notEmpty().isFloat();

        var err = req.validationErrors();

        if (err) {
            res.status(400).send("Erro na validação do pagamento: " + err);
            return;
        }

        pagamento.data = new Date;
        pagamento.status = "CRIADO";

        var card = req.body["cartao"];

        var clientCard = new app.services.cartoesClient();
        clientCard.autoriza(card, (err, request, response, retorno) => {
            if (err) {
                res.status(500).send("Erro na validação do cartão:" + err);
                return;
            } else {

                var connection = app.persistence.connectionFactory();
                var pagamentoDao = new app.persistence.PagamentoDao(connection);

                pagamentoDao.persist(pagamento, (err, result) => {
                    if (err) {
                        console.log("Não foi possível perssitir o pagamento: " + err);
                        res.status(500).send("Erro na persistencia do pagamento: " + err);
                        return;
                    } else {
                        pagamento.id = result.insertId;
                        console.log("Pagamento efetuado com sucesso!");
                        res.location("/pagamentos/pagamento/" + pagamento.id);

                        var retorno = {
                            pagamento_info: pagamento,
                            card_info: card,
                            links: [{
                                rel: "Confirmar",
                                href: "/pagamentos/pagamento/" + pagamento.id,
                                method: "PUT"
                            }, {
                                rel: "Cancelar",
                                href: "/pagamentos/pagamento/" + pagamento.id,
                                method: "DELETE"
                            }]
                        }
                        res.status(201).json(retorno);
                    }
                });
            }
        });
    });

    app.put('/pagamentos/pagamento/:id', (req, res) => {
        var id = req.params.id;
        console.log("Confirmando pagamento...");
        var pagamento = {};

        pagamento.id = id;
        pagamento.status = "CONFIRMADO";

        var connection = app.persistence.connectionFactory();
        var pagamentoDao = new app.persistence.PagamentoDao(connection);

        pagamentoDao.updateStatus(pagamento, (err, result) => {
            if (err) {
                console.log("Não foi possível atualizar o pagamento: " + err);
                res.status(500).send("Erro na confirmação do pagamento: " + err);
            } else {
                console.log("Pagamento confirmado com sucesso!");
                res.status(200).send(result);
            }
        })
    });

    app.delete('/pagamentos/pagamento/:id', (req, res) => {
        var id = req.params.id;
        console.log("Cancelando pagamento...");
        var pagamento = {};

        pagamento.id = id;
        pagamento.status = "CANCELADO";

        var connection = app.persistence.connectionFactory();
        var pagamentoDao = new app.persistence.PagamentoDao(connection);

        pagamentoDao.updateStatus(pagamento, (err, result) => {
            if (err) {
                console.log("Não foi possível cancelar o pagamento: " + err);
                res.status(500).send("Erro no cancelamento do pagamento: " + err);
            } else {
                console.log("Pagamento cancelado com sucesso!");
                res.status(204).send(result);
            }
        })
    });

}
