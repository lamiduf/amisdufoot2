'use strict';

amisdufoot.factory('saisonsService',[function() {
	
	var listerSaisons = function() {
		return [{ nom : "2014-2015"} , {nom : "2013-2014"} , {nom : "2012-2013"}];		
	};
	
	return {
		listerSaisons : listerSaisons
	}
}]);