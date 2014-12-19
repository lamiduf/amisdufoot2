describe("test du controller de saison", function() {
  
	var $scope;
	
	var mockSaisonsService = {
			listerSaisons : function() {
				return [{ nom : "2014-2015"} , {nom : "2013-2014"} ];		
			}	
	};
	
	// injection du module
	beforeEach(angular.mock.module('amisdufoot'));
	
	// injection du controller à tester
	beforeEach(inject(function($rootScope, $controller) {
		$scope = $rootScope.$new(); 
		$controller('SaisonsCtrl',{$scope:$scope, saisonsService:mockSaisonsService});
	}));
	
	it('test init du controller', function() {
		expect($scope.mode).toBe('search');
		expect($scope.typeModification).toBe('');
		expect($scope.currentSaison.nom).toBe('');
		expect($scope.saisonsList.length).toBe(2);
		expect($scope.saisonsList[0].nom).toBe('2014-2015');
		expect($scope.saisonsList[1].nom).toBe('2013-2014');
	  });
	
	it('test afficheFormCreationSaison et isModeMaj', function() {
		
		expect($scope.isModeMaj()).toBe(false);
		
		$scope.afficheFormCreationSaison();
		expect($scope.mode).toBe('create');
		expect($scope.typeModification).toBe('Ajouter Une Saison');
		
		expect($scope.isModeMaj()).toBe(true);
		
	  });

	it('test valideMaj', function() {
		$scope.mode="create";
		$scope.currentSaison = {nom : "newSaison"};
		$scope.valideMaj();
		expect($scope.saisonsList.length).toBe(3);
		expect($scope.currentSaison.nom).toBe('');
		expect($scope.mode).toBe('search');
	  });

});