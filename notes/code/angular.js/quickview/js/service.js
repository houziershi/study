var app = angular.module('myApp', []);

angular.module('myApp.services', []).factory('githubService', ['$http', 
	function($http) {
		var doRequest = function(username, path) {
			return $http({
				method: 'JSONP',
				url: 'https://api.github.com/users/' + username + '/' + path + '?callback=JSON_CALLBACK'
			});
		}
		return {
			events: function(username) {
				return doRequest(username, 'events'); 
			},
		};
}]);

app.controller('ServiceController', ['$scope', '$timeout', 'githubService',
	function($scope, $timeout, githubService) {
		// $timeout service
		var timeout;
		// Watch for changes on the username property.
		// If there is a change, run the function
		$scope.$watch('username', function(newVal) {
			if (newVal) {
				if (timeout) {
					$timeout.cancel(timeout);
				}
				timeout = $timeout(function() {
					// uses the $http service to call the GitHub API
					// and returns the resulting promise
					githubService.events(newVal).success(function(data, status) {
						// the success function wraps the response in data
						// so we need to call data.data to fetch the raw data
						$scope.events = data.data;
					});
				}, 350);
			}
		});
	}
]);


