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
	@Column(name="id_localisation")
	private Integer idLocalisation;

	@Column(name="adresse")
	private String adresse;

	@Column(name="code_postal")
	private Integer codePostal;

	@Column(name="latitude")
	private Float latitude;

	@Column(name="longitude")
	private Float longitude;

	@Column(name="ville")
	private String ville;

	//bi-directional many-to-one association to Membre
	@ManyToOne
	@JoinColumn(name="membre_id")
	private Membre membre;

	//bi-directional many-to-many association to Proposition
	@ManyToMany
	@JoinTable(
		name="localiser"
		, joinColumns={
			@JoinColumn(name="localisation_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="proposition_id")
			}
		)
	private List<Proposition> proposedHere;

	public Localisation() {
	}

	public Integer getIdLocalisation() {
		return idLocalisation;
	}

	public void setIdLocalisation(Integer idLocalisation) {
		this.idLocalisation = idLocalisation;
	}


	public String getAdresse() {
		return this.adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public Integer getCodePostal() {
		return this.codePostal;
	}

	public void setCodePostal(Integer codePostal) {
		this.codePostal = codePostal;
	}

	public Float getLatitude() {
		return this.latitude;
	}

	public void setLatitude(Float latitude) {
		this.latitude = latitude;
	}

	public Float getLongitude() {
		return this.longitude;
	}

	public void setLongitude(Float longitude) {
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