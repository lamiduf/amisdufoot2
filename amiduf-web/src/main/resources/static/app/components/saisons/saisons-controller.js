'use strict';

amiduf.controller('SaisonsCtrl', ['$scope', 'saisonsService', function($scope,saisonsService) {

	saisonsService.listerSaisons().then(function(result) {
		$scope.saisonsList = result.data;
	},function(error) {
		$scope.errorMessage= "Erreur technique lors du chargement des saisons existantes"
	});
	
	$scope.mode="search";
	$scope.typeModification = "";
	$scope.errorMessage ="";

	$scope.currentSaison={ libelle : ""};
	
	$scope.afficheFormCreationSaison = function() {
		$scope.mode="create";
		$scope.typeModification = "Ajouter Une Saison";
	};
	
	$scope.isModeMaj = function() {
		return ($scope.mode == "create" ||  $scope.mode == "update") ? "" : "collapse";
	}

	$scope.valideMaj = function () {
		
		saisonsService.ajouterSaison($scope.currentSaison).then(function() {
			$scope.saisonsList.push($scope.currentSaison);
			$scope.currentSaison={ libelle : "" };
			$scope.mode="search";
			$scope.errorMessage ="";
		},function(error) {
			if (error.status == 400) {
				$scope.errorMessage = error.data.libelle;
			}
			else {
				$scope.errorMessage= "Erreur technique lors de l'ajout de la saison"
			}		
		});
		
		
	}

}]);
