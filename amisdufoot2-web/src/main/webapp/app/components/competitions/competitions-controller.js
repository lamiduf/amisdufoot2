'use strict';

amisdufoot.controller('CompetitionsCtrl', function($scope) {
	$scope.titrePage = "Page Competitions";
	
	
	$scope.competitionList = [{ nom : "Championnat Foot Loisir - groupe A" , saison : {nom : "2014-2015"} },
	                          { nom : "Championnat Foot Loisir - groupe B" , saison : {nom : "2014-2015"} },
	                          { nom : "Coupe Questroy Foot Loisir" , saison : {nom : "2014-2015"} },
	                          { nom : "Championnat Foot Loisir - groupe A" , saison : {nom : "2013-2014"}}];
	
	$scope.mode="search";
	$scope.typeModification = "";

	$scope.currentCompetition={ nom : "" , saison : {nom : ""}};
	
	$scope.afficheFormCreation = function() {
		$scope.mode="create";
		$scope.typeModification = "Ajouter Une Competition";
	};
	
	$scope.isModeMaj = function() {
		return ($scope.mode == "create" ||  $scope.mode == "update");
	}

	$scope.valideMaj = function () {
		$scope.competitionList.push($scope.currentCompetition);
		$scope.currentCompetition={ nom : "" , saison : {nom : ""}};
		$scope.mode="search";
	}
});
