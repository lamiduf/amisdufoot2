package gdes.adf.sansboot.converter;
import gdes.adf.sansboot.common.AdfSaison;
import gdes.adf.sansboot.domain.Saison;

import org.springframework.core.convert.converter.Converter;

public class SaisonToAdfSaisonConverter implements Converter<Saison, AdfSaison> {

	@Override
	public AdfSaison convert(Saison saison) {
		return new AdfSaison(saison.getNom());
	}

}
