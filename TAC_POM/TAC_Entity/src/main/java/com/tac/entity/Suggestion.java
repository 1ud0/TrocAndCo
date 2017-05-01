package com.tac.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the suggestion database table.
 * 
 */
@Entity
@Table(name="suggestion")
@NamedQuery(name="Suggestion.findAll", query="SELECT s FROM Suggestion s")
public class Suggestion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_suggestion")
	private Integer idSuggestion;

	@Column(name="intitule")
	private String intitule;

	//bi-directional many-to-one association to Categorie
	@ManyToOne
	@JoinColumn(name="categorie_id")
	private Categorie categorie;

	//bi-directional many-to-one association to Categorie
	@ManyToOne
	@JoinColumn(name="sous_categorie_id")
	private Categorie sousCategorie;

	//bi-directional many-to-one association to Membre
	@ManyToOne
	@JoinColumn(name="membre_id")
	private Membre membre;

	public Suggestion() {
	}

	public Integer getIdSuggestion() {
		return this.idSuggestion;
	}

	public void setIdSuggestion(Integer idSuggestion) {
		this.idSuggestion = idSuggestion;
	}

	public String getIntitule() {
		return this.intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}


	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public Categorie getSousCategorie() {
		return sousCategorie;
	}

	public void setSousCategorie(Categorie sousCategorie) {
		this.sousCategorie = sousCategorie;
	}

	public Membre getMembre() {
		return this.membre;
	}

	public void setMembre(Membre membre) {
		this.membre = membre;
	}

}