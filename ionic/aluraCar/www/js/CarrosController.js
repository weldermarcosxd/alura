(function() {
  'use strict';

  angular
    .module('starter')
    .controller('CarrosController', CarrosController);

  CarrosController.$inject = ['$scope', '$stateParams','CarrosService'];

  /* @ngInject */
  function CarrosController($scope, $stateParams, CarrosService) {
    var vm = this;

    CarrosService.carros().then(function (result) {
      vm.listaCarros = result;
    });
  }
})();
