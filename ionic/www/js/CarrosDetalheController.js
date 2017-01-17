(function() {
  'use strict';

  angular
    .module('starter')
    .controller('CarrosDetalheController', CarrosDetalheController);

  CarrosDetalheController.$inject = ['$scope', '$stateParams'];

  /* @ngInject */
  function CarrosDetalheController($scope, $stateParams) {
    var vm = this;

    vm.carro = $stateParams.carros;

    console.log($stateParams);

    activate();

    function activate() {

    }
  }
})();
