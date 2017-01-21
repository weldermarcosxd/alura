(function() {
  'use strict';

  angular
    .module('starter')
    .controller('CarrosFinalizarController', CarrosFinalizarController);

  CarrosFinalizarController.$inject = ['$scope', '$stateParams', '$state', '$ionicPopup', '$ionicPlatform', '$ionicHistory', 'ionicDatePicker', 'PedidosService'];

  /* @ngInject */
  function CarrosFinalizarController($scope, $stateParams, $state, $ionicPopup, $ionicPlatform, $ionicHistory, ionicDatePicker, PedidosService) {
    var vm = this;

    vm.carro = angular.fromJson($stateParams);
    vm.carro.preco = parseInt(vm.carro.preco);
    vm.carro.dataSelecionada = new Date();

    $ionicHistory.nextViewOptions({
      disableBack: true,
      historyRoot: false
    });

    $ionicPlatform.ready(function() {
      $ionicHistory.nextViewOptions({
        disableBack: true,
        historyRoot: false
      });
    });

    vm.calendario = function() {
      var configuracoes = {
        callback: function(data) {
          vm.carro.dataSelecionada = new Date(data);
        },
        weeksList: ['D', 'S', 'T', 'Q', 'Q', 'S', 'S']
      }
      ionicDatePicker.openDatePicker(configuracoes)
    };

    vm.finalizar = function() {

      PedidosService.pedidos(vm.carro).then(function(response) {
        var popup = $ionicPopup.alert({
          title: 'Compra Finalizada',
          template: 'Sua compra foi efetuada com sucesso!'
        });

        popup.then(function() {
          $state.go('menu.carros');
        });
      }, function(err) {
        var popup = $ionicPopup.alert({
          title: 'Erro',
          template: err
        });

        popup.then(function() {
          $state.go('menu.carros');
        });
      });
    }
  }
})();
