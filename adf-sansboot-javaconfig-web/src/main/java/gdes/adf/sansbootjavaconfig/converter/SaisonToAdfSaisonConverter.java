package gdes.adf.sansbootjavaconfig.converter;
import gdes.adf.sansbootjavaconfig.common.AdfSaison;
import gdes.adf.sansbootjavaconfig.domain.Saison;

import org.springframework.core.convert.converter.Converter;

public class SaisonToAdfSaisonConverter implements Converter<Saison, AdfSaison> {

	@Override
	public AdfSaison convert(Saison saison) {
		return new AdfSaison(saison.getNom());
	}

}
