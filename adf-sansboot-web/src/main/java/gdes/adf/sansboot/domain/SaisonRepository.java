package gdes.adf.sansboot.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface SaisonRepository extends CrudRepository<Saison, Long> {

	public Saison findByNom(String nom);
}