package gdes.adf.sansbootjavaconfig.converter;
import gdes.adf.sansbootjavaconfig.common.AdfSaison;
import gdes.adf.sansbootjavaconfig.domain.Saison;

import org.springframework.core.convert.converter.Converter;


public class AdfSaisonToSaisonConverter implements Converter<AdfSaison, Saison> {

	@Override
	public Saison convert(AdfSaison adfSaison) {
		return new Saison(adfSaison.getNom());
	}

}
