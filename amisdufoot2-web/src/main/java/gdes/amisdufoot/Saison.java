package gdes.amisdufoot;

public class Saison {
	
	private Long id;
	private String libelle;
	
	
	public Saison() {
		super();
	}
	public Saison(Long id, String libelle) {
		super();
		this.id = id;
		this.libelle = libelle;
	}
	public Long getId() {
		return id;
	}
	public String getLibelle() {
		return libelle;
	}
	@Override
	public String toString() {
		return "Saison [id=" + id + ", libelle=" + libelle + "]";
	}

	
	
}
