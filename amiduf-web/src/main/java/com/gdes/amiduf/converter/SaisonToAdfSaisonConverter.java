package com.gdes.amiduf.converter;

import org.springframework.core.convert.converter.Converter;

import com.gdes.amiduf.contrat.AdfSaison;
import com.gdes.amiduf.domain.Saison;

public class SaisonToAdfSaisonConverter implements Converter<Saison, AdfSaison>{

	@Override
	public AdfSaison convert(Saison saison) {
		return new AdfSaison(saison.getLibelle());
	}
	

}
