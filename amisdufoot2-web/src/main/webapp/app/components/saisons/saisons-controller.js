'use strict';

amisdufoot.controller('SaisonsCtrl', function($scope,saisonsService) {
	$scope.titrePage = "Gestion des Saisons";
	
	
	$scope.saisonsList = saisonsService.listerSaisons();
	
	$scope.mode="search";
	$scope.typeModification = "";

	$scope.currentSaison={ nom : ""};
	
	$scope.afficheFormCreationSaison = function() {
		$scope.mode="create";
		$scope.typeModification = "Ajouter Une Saison";
	};
	
	$scope.isModeMaj = function() {
		return ($scope.mode == "create" ||  $scope.mode == "update");
	}

	$scope.valideMaj = function () {
		$scope.saisonsList.push($scope.currentSaison);
		$scope.currentSaison={ nom : "" };
		$scope.mode="search";
	}
});
