package com.tac.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the liste database table.
 * 
 */
@Entity
@Table(name="liste")
@NamedQuery(name="Liste.findAll", query="SELECT l FROM Liste l")
public class Liste implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_liste")
	private Integer idListe;

	@Column(name="date_creation")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreation;

	@Column(name="date_valid")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateValid;

	@Column(name="titre_liste")
	private String titreListe;

	//bi-directional many-to-one association to Envie
	@OneToMany(mappedBy="liste")
	private List<Envie> envies;

	//bi-directional many-to-one association to Membre
	@ManyToOne
	@JoinColumn(name="membre_id")
	private Membre membre;

	public Liste() {
	}

	public Integer getIdListe() {
		return this.idListe;
	}

	public void setIdListe(Integer idListe) {
		this.idListe = idListe;
	}

	public Date getDateCreation() {
		return this.dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public Date getDateValid() {
		return this.dateValid;
	}

	public void setDateValid(Date dateValid) {
		this.dateValid = dateValid;
	}

	public String getTitreListe() {
		return this.titreListe;
	}

	public void setTitreListe(String titreListe) {
		this.titreListe = titreListe;
	}

	public List<Envie> getEnvies() {
		return this.envies;
	}

	public void setEnvies(List<Envie> envies) {
		this.envies = envies;
	}

	public Envie addEnvy(Envie envy) {
		getEnvies().add(envy);
		envy.setListe(this);

		return envy;
	}

	public Envie removeEnvy(Envie envy) {
		getEnvies().remove(envy);
		envy.setListe(null);

		return envy;
	}

	public Membre getMembre() {
		return this.membre;
	}

	public void setMembre(Membre membre) {
		this.membre = membre;
	}

}