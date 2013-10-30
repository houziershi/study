var app = angular.module('myApp', []);

app.factory('githubService1', ['$http', function($http) {
	var doRequest = function(username, path) {
		return $http({
			method: 'JSONP',
			url: 'https://api.github.com/users/' + username + '/' + path 
				+ '?callback=JSON_CALLBACK'
		});
	}

	return {
		events: function(user) { return doRequest(user, 'events'); }
	};
}]);

app.factory('githubService2', ['$http', function($http) {
	var _username;

	var doRequest = function(path) {
		return $http({
			method: 'JSONP',
			url: 'https://api.github.com/users/' + _username + '/' + path 
				+ '?callback=JSON_CALLBACK'
		});
	}

	return {
		events: function() { return doRequest('events'); },
		setUsername: function(username) { _username = username; }
	};
}]);

app.controller('ServiceController', [
	'$scope', '$timeout', 'githubService1', 'githubService2',
	function($scope, $timeout, githubService1, githubService2) {
		var timeout;
		$scope.$watch('username', function(newVal) {
			if (newVal) {
				if (timeout) $timeout.cancel(timeout);
				timeout = $timeout(function() {
					githubService2.setUsername(newVal);
					githubService2.events()
					.success(function(data, status) {
						$scope.events = data.data;
					});
				}, 350);
			}
		});

		$scope.fetchEvents = function() {
			$scope.auserEvents = null;
			githubService1.events($scope.username).success(
				function(data, status, headers) {
					$scope.auserEvents = data.data;
				}
			);
		}
	}
]);


