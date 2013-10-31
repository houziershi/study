var app = angular.module('myApp', []);

app.controller('RelatedController', ['$scope', function($scope) { }]);

app.controller('PlayerController', ['$scope', function($scope) {
	$scope.audio = document.createElement('audio');
	$scope.audio.src = '../test.mp3';

	$scope.playing = false;

	$scope.play = function() {
		$scope.audio.play();
		$scope.playing = true;
	};
	$scope.stop = function() {
		$scope.audio.pause();
		$scope.playing = false;
	};

	$scope.audio.addEventListener('ended', function() {
		$scope.$apply(function() {
			$scope.stop()
		});
	});
}]);


