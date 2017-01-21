(function() {
    'use strict';

    angular
      .module('starter')
      .controller('AgendamentoController', AgendamentoController);

    AgendamentoController.$inject = ['$scope', '$ionicPopup', 'DatabaseValues', 'PedidosService'];

    /* @ngInject */
    function AgendamentoController($scope, $ionicPopup, DatabaseValues, PedidosService) {
      var vm = this;

      vm.agendamentos = [];

      DatabaseValues.setup();
      DatabaseValues.bancoDeDados.transaction(function(transacao) {
        transacao.executeSql('SELECT * FROM agendamentos', [], function(transacao, resultados) {
          for (var i = 0; i < resultados.rows.length; i++) {
            vm.agendamentos.push(resultados.rows[i]);
          }
        })
      });

      vm.reenviar = function(agendamento) {
        PedidosService.pedidos(agendamento).then(function(dados) {
          DatabaseValues.setup();
          DatabaseValues.bancoDeDados.transaction(function(transacao) {
            transacao.executeSql("UPDATE agendamentos SET confirmado = 'true' WHERE id = ? ", [agendamento.id])
          });

          $ionicPopup.alert({
            title: 'Parabens',
            template: 'Seu agendamento foi confirmado com sucesso'
          }).then(function() {
            $state.go($state.current, {}, {
              reload: true
            })
          }, function(err) {
            $ionicPopup.alert({
              title: 'Ops!',
              template: 'O servidor continua com erro. Tente mais tarde' + err
            });
          });
        })
      };

    }
  })();
