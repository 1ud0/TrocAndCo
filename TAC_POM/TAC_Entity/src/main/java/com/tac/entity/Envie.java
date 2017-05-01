package com.tac.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the envie database table.
 * 
 */
@Entity
@Table(name="envie")
@NamedQuery(name="Envie.findAll", query="SELECT e FROM Envie e")
public class Envie implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_envie")
	private Integer idEnvie;

	@Column(name="distance")
	private Integer distance;

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

	//bi-directional many-to-one association to Liste
	@ManyToOne
	@JoinColumn(name="liste_id")
	private Liste liste;

	//bi-directional many-to-one association to Valeur
	@ManyToOne
	@JoinColumn(name="valeur_id")
	private Valeur valeur;

	public Envie() {
	}

	public Integer getIdEnvie() {
		return this.idEnvie;
	}

	public void setIdEnvie(Integer idEnvie) {
		this.idEnvie = idEnvie;
	}

	public Integer getDistance() {
		return this.distance;
	}

	public void setDistance(Integer distance) {
		this.distance = distance;
	}

	public String getIntitule() {
		return this.intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public Categorie getCategorie() {
		return this.categorie;
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

	public Liste getListe() {
		return this.liste;
	}

	public void setListe(Liste liste) {
		this.liste = liste;
	}

	public Valeur getValeur() {
		return this.valeur;
	}

	public void setValeur(Valeur valeur) {
		this.valeur = valeur;
	}

}