module.exports = function(app) {

    app.post('/correios/calcula-prazo', (req, res) => {
        var dados = req.body;

        var correios = new app.services.correiosClient();
        correios.calculaPrazo(dados, (err, data) => {
          if(err){
            res.status(500).send("Erro no calculo do prazo: " + err);
            return;
          }else {
            res.status(200).json(data);
          }
        });
    })
}
