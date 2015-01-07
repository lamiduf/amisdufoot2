describe('gestion des saisons', function() {

    var listeSaisons = element.all(by.repeater('saison in saisonsList'));
    var inputRecherche = element(by.id("saisonsFormRechercheInputSaison"));
    var buttonAjouterUneSaison = element(by.id("buttonAjouterUneSaison"));
    var saisonsDivMaj = element(by.id("saisonsDivMaj"));
    var saisonsFormMajInputSaison = element(by.id("saisonsFormMajInputSaison"));
    var saisonsFormButtonValider = element(by.id("saisonsFormButtonValider"));
    
	it('saisons - scenario 1', function() {
    
		browser.get('http://localhost:8080/#/saisons');
	
		// test titre de la page
	    expect(browser.getTitle()).toEqual('Amis du foot Manager');
	    
	    // test liste initiales des saisons 
	    expect(listeSaisons.count()).toEqual(0);
	    
	    
	    // test ajout
	    buttonAjouterUneSaison.click();
	    saisonsFormMajInputSaison.sendKeys("2011-2012");
	    saisonsFormButtonValider.click();
	    expect(listeSaisons.count()).toEqual(1);
	    expect(listeSaisons.get(0).getText()).toEqual("2011-2012");
	    
	    buttonAjouterUneSaison.click();
	    saisonsFormMajInputSaison.sendKeys("2010-2011");
	    saisonsFormButtonValider.click();
	    expect(listeSaisons.count()).toEqual(2);
	    expect(listeSaisons.get(0).getText()).toEqual("2011-2012");
	    expect(listeSaisons.get(1).getText()).toEqual("2010-2011");

	    // test recherche
	    inputRecherche.sendKeys("2010");
	    expect(listeSaisons.count()).toEqual(1);
	    expect(listeSaisons.get(0).getText()).toEqual("2010-2011");
	    inputRecherche.clear();
	    inputRecherche.sendKeys("aaaaa");
	    expect(listeSaisons.count()).toEqual(0);
	    inputRecherche.clear();
	    expect(listeSaisons.count()).toEqual(2);

  });
	
});