'use strict';

amisdufoot.controller('SaisonsCtrl', function($scope,saisonsService) {
	$scope.titrePage = "Gestion des Saisons";
	
	
	saisonsService.listerSaisons().then(function(result) {
		$scope.saisonsList = result.data;
	},function(error) {
		$scope.errorMessage= "Erreur technique lors du chargement des saisons existantes"
	});
	
	$scope.mode="search";
	$scope.typeModification = "";
	$scope.errorMessage ="";

	$scope.currentSaison={ nom : ""};
	
	$scope.afficheFormCreationSaison = function() {
		$scope.mode="create";
		$scope.typeModification = "Ajouter Une Saison";
	};
	
	$scope.isModeMaj = function() {
		return ($scope.mode == "create" ||  $scope.mode == "update");
	}

	$scope.valideMaj = function () {
		
		saisonsService.ajouterSaison($scope.currentSaison).then(function() {
			$scope.saisonsList.push($scope.currentSaison);
			$scope.currentSaison={ nom : "" };
			$scope.mode="search";
		},function(error) {
			$scope.errorMessage= "Erreur technique lors de l'ajout de la saison"
		});
		
		
	}
});
