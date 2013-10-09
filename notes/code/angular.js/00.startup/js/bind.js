
var app = angular.module('myApp', []);
 
app.controller('MyController', function($scope) {
	$scope.person = { name: "Ari Lerner" };
	var updateClock = function() { $scope.clock = new Date(); };
	var timer = setInterval(function() { $scope.$apply(updateClock); }, 1000);  
	updateClock();}
);

app.controller('DemoController', function($scope) {
  $scope.counter = 0;
  $scope.add = function(amount) { $scope.counter += amount; };
  $scope.subtract = function(amount) { $scope.counter -= amount; };
});

$http({ method: 'JSONP',  
	url: 'http://api.openbeerdatabase.com/v1/beers.json?callback=JSON_CALLBACK'
}).success(function(data, status, headers, config) {  
	// data contains the response  
	// status is the HTTP status  
	// headers is the header getter function  
	// config is the object that was used to create the HTTP request
}).error(function(data, status, headers, config) {});
