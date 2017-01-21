(function() {
  'use strict';

  angular
    .module('starter')
    .controller('PerfilController', PerfilController);

  PerfilController.$inject = ['$rootScope', '$scope', '$stateParams','$ionicPlatform', '$cordovaCamera'];

  /* @ngInject */
  function PerfilController($rootScope, $scope, $stateParams,$ionicPlatform, $cordovaCamera) {
    var vm = this;

    vm.usuarioLogado = $rootScope.usuario;

    vm.editando = false;
    vm.botao = {
      "label": "Editar",
      "class": "button-assertive"
    };

    vm.tirarFoto = function() {
      var opcoes = {
        correctOrientation:true,
        quality: 70
      }

      $ionicPlatform.ready(function() {
        $cordovaCamera.getPicture(opcoes).then(
          function(foto) {
            vm.usuarioLogado.foto = foto;
          }, function(erro) {
            console.log(erro);
          });
      });
    };

    vm.alterarEstado = function() {
      vm.editando = !vm.editando;
      if (vm.editando) {
        vm.botao.label = "Salvar";
        vm.botao.class = "button-positive";
      } else {
        vm.botao.label = "Editar";
        vm.botao.class = "button-assertive";
      }
    }
  }
})();
