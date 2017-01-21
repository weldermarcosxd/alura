angular.module('starter').config(config);

config.$inject = ['$stateProvider', '$urlRouterProvider'];

function config($stateProvider, $urlRouterProvider) {

  // Ionic uses AngularUI Router which uses the concept of states
  // Learn more here: https://github.com/angular-ui/ui-router
  // Set up the various states which the app can be in.
  // Each state's controller can be found in controllers.js
  $stateProvider

    .state('login', {
      url: '/login',
      templateUrl: 'templates/login.html',
      controller: 'LoginController',
      controllerAs: 'Login'
    })

    .state('menu', {
      url: '/menu',
      templateUrl: 'templates/menu.html',
      abstract: true,
      controller: 'MenuController',
      controllerAs: 'Menu'
    })

    .state('menu.perfil', {
      url: '/perfil',
      views: {
        'menuContent': {
          templateUrl: 'templates/perfil.html',
          controller: 'PerfilController',
          controllerAs: 'Perfil'
        }
      }
    })

    .state('menu.agendamentos', {
      url: '/agendamentos',
      views: {
        'menuContent': {
          templateUrl: 'templates/agendamentos.html',
          controller: 'AgendamentoController',
          controllerAs: 'Agendamento'
        }
      }
    })

    .state('menu.carros', {
      url: '/carros',
      views: {
        'menuContent': {
          templateUrl: 'templates/carros.html',
          controller: 'CarrosController',
          controllerAs: 'Carros'
        }
      }
    })

    .state('menu.detalhe', {
      url: '/detalhe/:nome/:preco',
      views: {
        'menuContent': {
          templateUrl: 'templates/carrosDetalhe.html',
          controller: 'CarrosDetalheController',
          controllerAs: 'Detalhe'
        }
      }
    })

    .state('menu.finalizar', {
      url: '/finalizar/:nome/:preco',
      views: {
        'menuContent': {
          templateUrl: 'templates/CarrosFinalizar.html',
          controller: 'CarrosFinalizarController',
          controllerAs: 'Finalizar'
        }
      }
    })

  $urlRouterProvider.otherwise('/menu/carros');

};
