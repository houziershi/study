var app = angular.module('myApp', []);


app.controller('LastController', ['$scope', function($scope) {
	$scope.name = "Ari Lerner";
	$scope.today = new Date();

	$scope.todayFilter = function(expr) {
		return $filter('date')($scope.today, expr);
	}

	$scope.isCapitalized = function(str) {
		return str[0] == str[0].toUpperCase(); 
	}
}]);


app.filter('capitalize', function() {
  return function(input) {
    if (input) 
      return input[0].toUpperCase() + input.slice(1);
  }
});

/*
angular.module('myApp.filters', []).filter('capitalize', function() {
  return function(input) {
    // input will be ginger in the usage below
    if (input)
      return input[0].toUpperCase() + input.slice(1);
  } 
});
 */

