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
    $scope.id = $routeParams.uuid
    console.log($scope.id)
    $scope.url = "http://sepdesa.colonseguros.com.ar/b2c/idTransaccion=" + $scope.id;
    console.log($scope.url)
  }]);
