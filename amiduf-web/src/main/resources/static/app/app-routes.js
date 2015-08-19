'use strict';

amiduf.config([ '$routeProvider', function($routeProvider) {
	
	$routeProvider.
	when('/saisons', {templateUrl : 'app/components/saisons/saisons-view.html',controller : 'SaisonsCtrl'}).
	when('/todo', {templateUrl : 'todo.html'}).
	otherwise({redirectTo: '/todo'});

	
}]);