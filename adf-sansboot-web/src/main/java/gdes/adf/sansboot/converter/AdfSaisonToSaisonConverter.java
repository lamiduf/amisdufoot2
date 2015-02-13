package gdes.adf.sansboot.converter;
import gdes.adf.sansboot.common.AdfSaison;
import gdes.adf.sansboot.domain.Saison;

import org.springframework.core.convert.converter.Converter;


public class AdfSaisonToSaisonConverter implements Converter<AdfSaison, Saison> {

	@Override
	public Saison convert(AdfSaison adfSaison) {
		return new Saison(adfSaison.getNom());
	}

}
