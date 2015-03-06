'use strict';

// Declare app level module which depends on views, and components
var amisdufoot = angular.module('amisdufoot', [ 'ngRoute' ,'ui.bootstrap']);

amisdufoot.config([ '$routeProvider', function($routeProvider) {
	$routeProvider.
		when('/actualites', {templateUrl : 'app/components/actualites/actualites-view.html',controller : 'ActualitesCtrl'}).
		when('/matches/creer', {templateUrl : 'app/components/matches/matches-creation-view.html',controller : 'MatchesCtrl'}).
		when('/competitions', {templateUrl : 'app/components/competitions/competitions-view.html',controller : 'CompetitionsCtrl'}).
		when('/saisons', {templateUrl : 'app/components/saisons/saisons-view.html',controller : 'SaisonsCtrl'}).
		when('/todo', {templateUrl : 'todo.html'}).
		otherwise({redirectTo: '/todo'});
	}]);

