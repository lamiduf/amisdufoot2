package com.gdes.amiduf.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CommentaireMatch {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private TypeCommentaireMatchEnum type;
    
    private String commentaire;

    protected CommentaireMatch() {};

	public CommentaireMatch(TypeCommentaireMatchEnum type, String commentaire) {
		super();
		this.type = type;
		this.commentaire = commentaire;
	}

	public Long getId() {
		return id;
	}

	public TypeCommentaireMatchEnum getType() {
		return type;
	}

	public String getCommentaire() {
		return commentaire;
	}

	@Override
	public String toString() {
		return "CommentaireMatch [id=" + id + ", type=" + type + ", commentaire=" + commentaire + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CommentaireMatch other = (CommentaireMatch) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	
}
