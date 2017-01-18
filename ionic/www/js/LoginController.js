(function() {
  'use strict';

  angular
    .module('starter')
    .controller('LoginController', LoginController);

  LoginController.$inject = ['$scope', '$stateParams','$state', 'LoginService'];

  /* @ngInject */
  function LoginController($scope, $stateParams, $state, LoginService) {
    var vm = this;

    vm.credentials = {};

    vm.authenticate = function () {
      LoginService.authenticate(vm.credentials).then(function (result) {
        $state.go('carros');
      });
    }
  }
})();
