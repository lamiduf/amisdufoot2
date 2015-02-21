package gdes.adf.web.converter;
import gdes.adf.web.common.AdfSaison;
import gdes.adf.web.domain.Saison;

import org.springframework.core.convert.converter.Converter;


public class AdfSaisonToSaisonConverter implements Converter<AdfSaison, Saison> {

	@Override
	public Saison convert(AdfSaison adfSaison) {
		return new Saison(adfSaison.getNom());
	}

}
