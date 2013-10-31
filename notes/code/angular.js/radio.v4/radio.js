var apiKey = 'MDEyNDkyMTc4MDEzODMxMTI3MTkxMjU5OQ001';
var nprUrl = 'http://api.npr.org/query?id=61&fields=relatedLink,title,byline,text,audio,image,pullQuote,all&output=JSON';

var app = angular.module('myApp', []);

app.factory('audio', ['$document', function($document) {
	var audio = $document[0].createElement('audio');
	return audio;
}]);

app.factory('player', ['audio', '$rootScope', function(audio, $rootScope) {
	var player = {
		playing: false,
		current: null,
		ready: true,
		play: function(program) {
			// If we are playing, stop the current playback
			if (player.playing) player.stop();
			var url = program.audio[0].format.mp4.$text; // from the npr API
			player.current = program; // Store the current program
			audio.src = url;
			audio.play(); // Start playback of the url
			player.playing = true
		},
		stop: function() {
			if (player.playing) {
				audio.pause(); // stop playback
				// Clear the state of the player
				player.ready = player.playing = false;
				player.current = null;
			}
		},
		currentTime: function() {
			return audio.currentTime;
		},
		currentDuration: function() {
			return parseInt(audio.duration);
		},
	};
	audio.addEventListener('ended', function() {
		$rootScope.$apply(player.stop());
	});
	audio.addEventListener('timeupdate', function(evt) {
		$rootScope.$apply(function() {
			player.progress = player.currentTime();
			player.progress_percent = player.progress / player.currentDuration();
		});
	});
	audio.addEventListener('canplay', function(evt) {
		$rootScope.$apply(function() {
			player.ready = true;
		});
	});
	return player;
}]);



app.factory('nprService', ['$http', function($http) {

	var doRequest = function(apiKey) {
		return $http({
			method: 'JSONP',
			url: nprUrl + '&apiKey=' + apiKey + '&callback=JSON_CALLBACK'
		});
	}

	return {
		programs: function(apiKey) { return doRequest(apiKey); }
	};
}]);

app.controller('PlayerController', ['$scope', 'nprService', 'player',
	function($scope, nprService, player) {
		$scope.player = player;

		nprService.programs(apiKey).success(function(data, status) {
			$scope.programs = data.list.story;
		}).error(function(data, status) {
			// Some error occurred
		});

	}
]);

app.directive('nprLink', function() {
	return {
		restrict: 'EA',
		require: ['^ngModel'],
		replace: true,
		scope: {
			ngModel: '=',
			player: '='
		},
		templateUrl: '/code/views/nprListItem',
		link: function(scope, ele, attr) {
			scope.duration = scope.ngModel.audio[0].duration.$text;
		}
	}
});

app.controller('RelatedController', ['$scope', 'player',
	function($scope, player) {
		$scope.player = player;
	 
		$scope.$watch('player.current', function(program) {
			if (program) {
				$scope.related = [];
				angular.forEach(program.relatedLink, function(link) {
					$scope.related.push({
						link: link.link[0].$text,
						caption: link.caption.$text
					});
				});
			}
		});
	}
]);
