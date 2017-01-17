angular.module('starter').config(config);

config.$inject = ['$stateProvider', '$urlRouterProvider'];

function config($stateProvider, $urlRouterProvider) {

  // Ionic uses AngularUI Router which uses the concept of states
  // Learn more here: https://github.com/angular-ui/ui-router
  // Set up the various states which the app can be in.
  // Each state's controller can be found in controllers.js
  $stateProvider

    .state('carros', {
      url: '/carros',
      templateUrl: 'templates/carros.html',
      controller: 'CarrosController',
      controllerAs: 'Carros'
    })

    .state('detalhe', {
      url: '/detalhe/:carros',
      templateUrl: 'templates/carrosDetalhe.html',
      controller: 'CarrosDetalheController',
      controllerAs: 'Detalhe'
    })

  $urlRouterProvider.otherwise('/carros/detalhe');

};
