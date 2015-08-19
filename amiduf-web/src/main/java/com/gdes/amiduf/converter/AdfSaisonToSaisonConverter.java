package com.gdes.amiduf.converter;

import org.springframework.core.convert.converter.Converter;

import com.gdes.amiduf.contrat.AdfSaison;
import com.gdes.amiduf.domain.Saison;

public class AdfSaisonToSaisonConverter implements Converter<AdfSaison,Saison>{

	@Override
	public Saison convert(AdfSaison adfSaison) {
		return new Saison(adfSaison.getLibelle());
	}
	

}
