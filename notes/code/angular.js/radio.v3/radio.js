var app = angular.module('myApp', []);

app.controller('RelatedController', ['$scope', function($scope) { }]);

 
app.controller('PlayerController', function($scope, $http) {

	$scope.audio = document.createElement('audio');
	$scope.playing = false;

	var apiKey = 'MDEyNDkyMTc4MDEzODMxMTI3MTkxMjU5OQ001';
	var nprUrl = 'http://api.npr.org/query?id=61&fields=relatedLink,title,byline,text,audio,image,pullQuote,all&output=JSON';
	// Hidden our previous section's content
	// construct our http request
	$http({
		method: 'JSONP',
		url: nprUrl + '&apiKey=' + apiKey + '&callback=JSON_CALLBACK'
	}).success(function(data, status) {
		// Now we have a list of the stories (data.list.story)
		// in the data object that the NPR API
		// returns in JSON that looks like:
		// data: { "list": {
		//	 "title": ...
		//	 "story": [
		//		 { "id": ...
		//			 "title": ...
		$scope.programs = data.list.story;
	}).error(function(data, status) {
		// Some error occurred
	});

	// format.mp4.$text is the route to the mp4 file from the NPR api
	$scope.play = function(program) {
		if ($scope.playing) $scope.audio.pause();
		var url = program.audio[0].format.mp4.$text;
		$scope.audio.src = url;
		$scope.audio.play();
		// Store the state of the player as playing
		$scope.playing = true;
	}

});

