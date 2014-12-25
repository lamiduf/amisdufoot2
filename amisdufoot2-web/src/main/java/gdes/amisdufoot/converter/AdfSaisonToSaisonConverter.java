package gdes.amisdufoot.converter;
import gdes.amisdufoot.AdfSaison;
import gdes.amisdufoot.domain.Saison;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;


public class AdfSaisonToSaisonConverter implements Converter<AdfSaison, Saison> {

	@Override
	public Saison convert(AdfSaison adfSaison) {
		return new Saison(adfSaison.getNom());
	}

}
