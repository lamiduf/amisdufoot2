'use strict';

amisdufoot.factory('saisonsService',['$http', function($http) {
	
	var listerSaisons = function() {
		return $http.get("/saisons");		
	};
	
	var ajouterSaison = function(saison) {
		return $http.post("/saisons",saison);
	}
	
	return {
		listerSaisons : listerSaisons,
		ajouterSaison : ajouterSaison
	}
}]);