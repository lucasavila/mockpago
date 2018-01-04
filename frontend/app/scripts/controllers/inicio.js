'use strict';

/**
 * @ngdoc function
 * @name frontendApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the frontendApp
 */
angular.module('frontendApp')
  .controller('InicioCtrl',['$routeParams','$scope', function ($routeParams, $scope) {
    this.awesomeThings = ['HTML5 Boilerplate','AngularJS','Karma'];

    console.log($routeParams)
    $scope.id = $routeParams.uuid

    $scope.routes = {
      localhost:"http://localhost:3000",
      testing: "https://ecommercetest.ecolon.com.ar",
      preprod: "https://ecommercepreprod.ecolon.com.ar"
    }

    $scope.server = eval("$scope.routes."+ $routeParams.server)
    console.log($scope.server)

    $scope.url = $scope.server + "/bienvenida?product=&_id=" + $scope.id + "&status=authorized&statusDetail=pending_capture";
    $scope.urlReintento = $scope.server + "/bienvenida";

    console.log("url: "+$scope.url)
    console.log("urlReintento" + $scope.urlReintento)
  }]);
