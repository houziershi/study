var app = angular.module('myApp', []);

app.factory('audio', ['$document', function($document) {
  var audio = $document[0].createElement('audio');
  audio.type="audio/mpeg"
  audio.id = "audio";
  return audio;
}]);

app.factory('player', ['audio', '$rootScope', function(audio, $rootScope) {
  var player = {

    current: null,
    progress: 0,
    playing: false,

    play: function(program) {
      if (player.playing) 
        player.stop();

      var url = program.audio[0].format.mp4.$text;
      player.current = program;
      audio.src = url;
      audio.play();
      player.playing = true;
      console.log("player", audio);
    },

    stop: function() {
      if (player.playing) {
        audio.pause();
        player.playing = false;
        player.current = null;
      }
    },

    currentTime: function() {
      return audio.currentTime;
    },

    currentDuration: function() {
      return parseInt(audio.duration);
    }
  };

  audio.addEventListener('timeupdate', function(evt) {
    $rootScope.$apply(function() {
      player.progress = player.currentTime();
      player.progress_percent = (player.progress / player.currentDuration()) * 100;
    });
  });

  audio.addEventListener('ended', function() {
    $rootScope.$apply(player.stop());
  });

  audio.addEventListener('canplay', function() {
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

app.controller('DemoPlayerController1', ['$scope', 'player', 
  function($scope, player) {
    $scope.program = {
      audio: [{
        format: {
          mp4: {
            $text: '../test.mp3'
          }
        }
      }]
    }
    $scope.player = player;
}]);
