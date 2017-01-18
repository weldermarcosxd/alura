(function() {
    'use strict';

    angular
      .module('starter')
      .service('PedidosService', PedidosService);

    PedidosService.$inject = ['$http'];

    /* @ngInject */
    function PedidosService($http) {
      this.pedidos = function(pedido) {
        var url = 'https://aluracar.heroapp.com/salvarPedido';

        return $http.post(url, pedido).then(function(response) {
          return response.data;
        }, function (err) {
          return err;
        });
      };
    }
  })();
