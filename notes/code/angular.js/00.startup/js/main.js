
var app = angular.module('myApp', []);
 
app.controller('PlayerController', ['$scope', function($scope) {
  $scope.playing = false;
  $scope.audio = document.createElement('audio');
  $scope.audio.src = '/media/npr.mp4';
}]);

app.controller('RelatedController', ['$scope', function($scope) { }]);
