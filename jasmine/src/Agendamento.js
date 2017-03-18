function Agendamento(paciente, procedimentos, particular, retorno, data) {

    var clazz = {
        para : function(consulta) {
          var dia = 1000 * 60 * 60 * 24;
          var novaData = new Date(consulta.getData().getTime() + (dia * 20));

          while (novaData.getDay() == 0 || novaData.getDay() == 6) {
            novaData = new Date(novaData.getTime() + dia);
          }

          var novaConsulta = new Consulta(consulta.getNome(), [], true, false, novaData);
          return novaConsulta;
        }
    }
    return clazz;
};
