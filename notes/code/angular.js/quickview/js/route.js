var app = angular.module('myApp', []);

app.controller('FrameController', ['$scope', '$location', '$routeParams', 
	function($scope, $location, $routeParams) {
		$scope.routeParams = $routeParams;
}])
app.controller('HomeController', ['$scope', '$location', '$routeParams', 
	function($scope, $location, $routeParams) {
	$scope.routeParams = $routeParams;
}])
app.controller('PeopleController', ['$scope', '$routeParams', '$location',
	function($scope, $routeParams, $location) {
		$scope.routeParams = $routeParams;
		$scope.name = "Ari";
}]);

app.config(['$routeProvider', function($routeProvider) {
	$routeProvider.when('/', {
		controller: 'HomeController',
		template: "<h2>We are home</h2><hr /><h4>This is view at /</h4><h4>Route params: {{ routeParams }}</h4>"
	})
	.when('/person/:id', {
		controller: 'PeopleController',
		template: '<div>Person show page: {{ name }}</div><hr /><h4>This is view at /person/42</h4><h4>Route params: {{ routeParams }}</h4>'
	})
	.otherwise({redirectTo: '/'});
}]);
