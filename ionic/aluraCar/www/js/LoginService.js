(function() {
    'use strict';

    angular
      .module('starter')
      .service('LoginService', LoginService);

    LoginService.$inject = ['$http'];

    /* @ngInject */
    function LoginService($http) {
      this.authenticate = function() {
        var url = 'https://aluracar.heroapp.com/login';

        return $http.get(url).then(function(response) {
          return response.data;
        }, function (err) {
          return err;
        });
      };
    }
  })();
