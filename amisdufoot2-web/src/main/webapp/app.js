'use strict';

// Declare app level module which depends on views, and components
var amisdufoot = angular.module('amisdufoot', [ 'ngRoute' ,'ui.bootstrap']);

amisdufoot.config([ '$routeProvider', function($routeProvider) {
	$routeProvider.
		when('/actualites', {templateUrl : 'actualites/actualites.html',controller : 'ActualitesCtrl'}).
		when('/matches/creer', {templateUrl : 'matches/matches_creer.html',controller : 'MatchesCtrl'}).
		when('/competitions', {templateUrl : 'competitions/competitions.html',controller : 'CompetitionsCtrl'}).
		when('/todo', {templateUrl : 'todo.html'}).
		otherwise({redirectTo: '/todo'});
	}]);

