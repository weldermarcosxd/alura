(function() {
  'use strict';

  angular
    .module('starter')
    .controller('CarrosFinalizarController', CarrosFinalizarController);

  CarrosFinalizarController.$inject = ['$scope', '$stateParams', '$state', '$ionicPopup', 'PedidosService'];

  /* @ngInject */
  function CarrosFinalizarController($scope, $stateParams, $state, $ionicPopup, PedidosService) {
    var vm = this;

    vm.carro = angular.fromJson($stateParams);
    vm.carro.preco = parseInt(vm.carro.preco);

    vm.finalizar = function() {

      PedidosService.pedidos(vm.carro).then(function(response) {
        var popup = $ionicPopup.alert({
          title: 'Compra Finalizada',
          template: 'Sua compra foi efetuada com sucesso!'
        });

        popup.then(function() {
          $state.go('carros');
        });
      }, function (err) {
        var popup = $ionicPopup.alert({
          title: 'Erro',
          template: err
        });

        popup.then(function() {
          $state.go('carros');
        });
      });
    }
  }
})();
