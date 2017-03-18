describe("Agendamento", function() {

    var agendamento;
    var paciente;

    beforeEach(function() {
        agendamento = new Agendamento();
        paciente = new PacienteBuilder().constroi();
    });

    it("Deve agendar o retorno para 20 dias depois", function() {
        var consulta = new Consulta(paciente, [], false, true, new Date(2017,2,17));
        var novaConsulta = agendamento.para(consulta);
        expect(novaConsulta.getData().toString()).toEqual(new Date(2017, 3, 6).toString());
    });

    it("Deve agendar o retorno para 20 dias úteis depois", function() {
        var consulta = new Consulta(paciente, [], false, true, new Date(2017,2,19));
        var novaConsulta = agendamento.para(consulta);
        expect(novaConsulta.getData().toString()).toEqual(new Date(2017, 3, 10).toString());
    });

});
