(function() {
  'use strict';

  angular
    .module('starter')
    .controller('CarrosController', CarrosController);

  CarrosController.$inject = ['$scope', '$stateParams'];

  /* @ngInject */
  function CarrosController($scope, $stateParams) {
    var vm = this;

    vm.listaCarros = [
      {"nome":"BMW 120i","preco":46545},
      {"nome":"Onix 1.6","preco":45665},
      {"nome":"Fiesta 2.0","preco":46665},
      {"nome":"C3 1.0","preco":46775},
      {"nome":"Uno Fire","preco":11145},
      {"nome":"Sentra 2.0","preco":12344},
      {"nome":"Astra Sedan","preco":55555},
      {"nome":"Vectra 2.0 Turbo","preco":12342},
      {"nome":"Hilux 4x4","preco":445566},
      {"nome":"Montana Cabine Dupla","preco":123123}
    ];


    activate();

    function activate() {

    }
  }
})();
