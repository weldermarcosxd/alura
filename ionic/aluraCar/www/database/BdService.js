(function() {
  'use strict';

  angular
    .module('starter')
    .service('BdService', BdService);

  BdService.$inject = ['DatabaseValues'];

  /* @ngInject */
  function BdService(DatabaseValues) {
    this.persistAgendamento = function(pedido) {
      DatabaseValues.setup();

      var cliente = pedido.cliente;
      var email = pedido.email;
      var endereco = pedido.endereco;
      var nome = pedido.nome;
      var preco = pedido.preco;
      var dataSelecionada = pedido.dataSelecionada;
      var confirmado = pedido.confirmado;

      DatabaseValues.bancoDeDados.transaction(function(transacao) {
        transacao.executeSql('INSERT INTO agendamentos(nome, endereco, email, dataAgendamento, modelo, preco, confirmado) VALUES (?,?,?,?,?,?,?)', [cliente, endereco, email, dataSelecionada, nome, preco, confirmado])
      });

    }
  };
})();
