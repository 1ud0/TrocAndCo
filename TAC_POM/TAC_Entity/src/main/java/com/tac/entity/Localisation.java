package com.tac.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the localisation database table.
 * 
 */
@Entity
@Table(name="localisation")
@NamedQuery(name="Localisation.findAll", query="SELECT l FROM Localisation l")
public class Localisation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idLocalisation;

	private String adresse;

	private int codePostal;

	private float latitude;

	private float longitude;

	private String ville;

	//bi-directional many-to-one association to Membre
	@ManyToOne
	private Membre membre;

	//bi-directional many-to-many association to Proposition
	@ManyToMany
	@JoinTable(
		name="localiser"
		, joinColumns={
			@JoinColumn(name="Localisation_idLocalisation")
			}
		, inverseJoinColumns={
			@JoinColumn(name="Proposition_idProposition")
			}
		)
	private List<Proposition> proposedHere;

	public Localisation() {
	}


	public int getIdLocalisation() {
		return idLocalisation;
	}


	public void setIdLocalisation(int idLocalisation) {
		this.idLocalisation = idLocalisation;
	}


	public String getAdresse() {
		return this.adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public int getCodePostal() {
		return this.codePostal;
	}

	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}

	public float getLatitude() {
		return this.latitude;
	}

	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}

	public float getLongitude() {
		return this.longitude;
	}

	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}

	public String getVille() {
		return this.ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public Membre getMembre() {
		return this.membre;
	}

	public void setMembre(Membre membre) {
		this.membre = membre;
	}

	public List<Proposition> getProposedHere() {
		return proposedHere;
	}

	public void setProposedHere(List<Proposition> proposedHere) {
		this.proposedHere = proposedHere;
	}


}