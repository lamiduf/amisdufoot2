package gdes.adf.web.converter;
import gdes.adf.web.common.AdfSaison;
import gdes.adf.web.domain.Saison;

import org.springframework.core.convert.converter.Converter;

public class SaisonToAdfSaisonConverter implements Converter<Saison, AdfSaison> {

	@Override
	public AdfSaison convert(Saison saison) {
		return new AdfSaison(saison.getNom());
	}

}
