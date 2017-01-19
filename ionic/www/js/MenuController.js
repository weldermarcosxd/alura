(function() {
  'use strict';

  angular
    .module('starter')
    .controller('MenuController', MenuController);

  MenuController.$inject = ['$rootScope', '$scope', '$stateParams', 'CarrosService'];

  /* @ngInject */
  function MenuController($rootScope, $scope, $stateParams, CarrosService) {
    var vm = this;

    $rootScope.usuario = {
      "nome": "Welder Marcos",
      "email": "weldermarcosxd@gmail.com",
      "dataNascimento": "15/12/1993",
      "telefone": "37998191067"
    };

    vm.usuarioLogado = $rootScope.usuario;
  }
})();
