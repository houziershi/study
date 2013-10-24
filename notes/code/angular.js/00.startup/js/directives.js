
var app = angular.module('myApp', []);
 
app.controller('MyController', function($scope) {
	$scope.person = { name: "Ari Lerner" };
	$scope.sayHello = function() {
		alert("hello!");
	}
	$scope.roommates = [
		{ name: 'Ari'},
		{ name: 'Q'},
		{ name: 'Sean'},
		{ name: 'Anand'}
	];
	$scope.people = {
		'Ari': 'orange',
		'Q': 'purple',
		'Sean': 'green'
	}
});
