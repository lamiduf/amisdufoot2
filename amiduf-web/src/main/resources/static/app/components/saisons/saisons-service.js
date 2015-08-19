'use strict';

amiduf.factory('saisonsService',['$http', function($http) {
	
	var listerSaisons = function() {
		return $http.get("/saison");		
	};
	
	var ajouterSaison = function(saison) {
		return $http.post("/saison",saison);
	}
	
	return {
		listerSaisons : listerSaisons,
		ajouterSaison : ajouterSaison
	}
}]);