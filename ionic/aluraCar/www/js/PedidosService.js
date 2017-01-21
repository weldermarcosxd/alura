(function() {
    'use strict';

    angular
      .module('starter')
      .service('PedidosService', PedidosService);

    PedidosService.$inject = ['$http', 'BdService'];

    /* @ngInject */
    function PedidosService($http, BdService) {
      this.pedidos = function(pedido) {
        var url = 'https://aluracar.heroapp.com/salvarPedido';

        return $http.post(url, pedido).then(function(response) {
          pedido.confirmado = true;
          //BdService.persistAgendamento(pedido);
          return response.data;
        }, function (err) {
          pedido.confirmado = false;
          //BdService.persistAgendamento(pedido);
          return err;
        });
      };
    }
  })();
