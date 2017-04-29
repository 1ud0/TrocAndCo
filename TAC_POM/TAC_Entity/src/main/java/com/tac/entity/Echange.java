package com.tac.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the echange database table.
 * 
 */
@Entity
@Table(name="echange")
@NamedQuery(name="Echange.findAll", query="SELECT e FROM Echange e")
public class Echange implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idEchange;

	private int codeEchange;

	private String comChercheur;

	private String comDonneur;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateAcceptation;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateinit;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateRefus;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateValidation;

	private int noteChercheur;

	private int noteDonneur;

	private int prix;

	private String referenceEchange;

	//bi-directional many-to-one association to Membre
	@ManyToOne
	private Membre membre;

	//bi-directional many-to-one association to Proposition
	@ManyToOne
	private Proposition proposition;

	//bi-directional many-to-one association to Rdv
	@OneToMany(mappedBy="echange")
	private List<Rdv> rdvs;

	public Echange() {
	}

	public int getIdEchange() {
		return this.idEchange;
	}

	public void setIdEchange(int idEchange) {
		this.idEchange = idEchange;
	}

	public int getCodeEchange() {
		return this.codeEchange;
	}

	public void setCodeEchange(int codeEchange) {
		this.codeEchange = codeEchange;
	}

	public String getComChercheur() {
		return this.comChercheur;
	}

	public void setComChercheur(String comChercheur) {
		this.comChercheur = comChercheur;
	}

	public String getComDonneur() {
		return this.comDonneur;
	}

	public void setComDonneur(String comDonneur) {
		this.comDonneur = comDonneur;
	}

	public Date getDateAcceptation() {
		return this.dateAcceptation;
	}

	public void setDateAcceptation(Date dateAcceptation) {
		this.dateAcceptation = dateAcceptation;
	}


	public Date getDateinit() {
		return this.dateinit;
	}

	public void setDateinit(Date dateinit) {
		this.dateinit = dateinit;
	}

	public Date getDateRefus() {
		return this.dateRefus;
	}

	public void setDateRefus(Date dateRefus) {
		this.dateRefus = dateRefus;
	}

	public Date getDateValidation() {
		return this.dateValidation;
	}

	public void setDateValidation(Date dateValidation) {
		this.dateValidation = dateValidation;
	}

	public int getNoteChercheur() {
		return this.noteChercheur;
	}

	public void setNoteChercheur(int noteChercheur) {
		this.noteChercheur = noteChercheur;
	}

	public int getNoteDonneur() {
		return this.noteDonneur;
	}

	public void setNoteDonneur(int noteDonneur) {
		this.noteDonneur = noteDonneur;
	}

	public int getPrix() {
		return this.prix;
	}

	public void setPrix(int prix) {
		this.prix = prix;
	}

	public String getReferenceEchange() {
		return this.referenceEchange;
	}

	public void setReferenceEchange(String referenceEchange) {
		this.referenceEchange = referenceEchange;
	}

	public Membre getMembre() {
		return this.membre;
	}

	public void setMembre(Membre membre) {
		this.membre = membre;
	}

	public Proposition getProposition() {
		return this.proposition;
	}

	public void setProposition(Proposition proposition) {
		this.proposition = proposition;
	}

	public List<Rdv> getRdvs() {
		return this.rdvs;
	}

	public void setRdvs(List<Rdv> rdvs) {
		this.rdvs = rdvs;
	}

	public Rdv addRdv(Rdv rdv) {
		getRdvs().add(rdv);
		rdv.setEchange(this);

		return rdv;
	}

	public Rdv removeRdv(Rdv rdv) {
		getRdvs().remove(rdv);
		rdv.setEchange(null);

		return rdv;
	}

}