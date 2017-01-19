(function() {
  'use strict';

  angular
    .module('starter')
    .controller('CarrosDetalheController', CarrosDetalheController);

  CarrosDetalheController.$inject = ['$scope', '$stateParams'];

  /* @ngInject */
  function CarrosDetalheController($scope, $stateParams) {
    var vm = this;

    vm.carro = angular.fromJson($stateParams);
    vm.carro.preco = parseInt(vm.carro.preco);

    vm.acessories = [
      {'nome':'ABS','preco':1000},
      {'nome':'AR CONDICIONADO','preco':2000},
      {'nome':'FARÓIS DE MILHA','preco':1200}
    ];

    vm.increment = function (value, sum) {
      if(sum){
        vm.carro.preco += value;
      }else{
        vm.carro.preco -= value;
      }
    }

    activate();

    function activate() {

    }
  }
})();
