package gdes.adf.web.domain;

import org.springframework.data.repository.CrudRepository;

public interface SaisonRepository extends CrudRepository<Saison, Long> {

	public Saison findByNom(String nom);
}