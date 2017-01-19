(function() {
  'use strict';

  angular
    .module('starter')
    .controller('LoginController', LoginController);

  LoginController.$inject = ['$rootScope', '$scope', '$stateParams','$state', 'LoginService'];

  /* @ngInject */
  function LoginController($rootScope, $scope, $stateParams, $state, LoginService) {
    var vm = this;

    vm.credentials = {};

    vm.authenticate = function () {
      LoginService.authenticate(vm.credentials).then(function (result) {
        if(result.email == null){
          $rootScope.usuario = {
            "nome": "Welder Marcos",
            "email": "weldermarcosxd@gmail.com",
            "dataNascimento": "15/12/1993",
            "telefone": "37998191067"
          };
        }
        $state.go('menu.carros');
      });
    }
  }
})();
