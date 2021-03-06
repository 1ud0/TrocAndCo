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
	@Column(name="id_echange")
	private Integer idEchange;

	@Column(name="code_echange")
	private Integer codeEchange;

	@Column(name="comm_chercheur")
	private String comChercheur;

	@Column(name="comm_donneur")
	private String comDonneur;

	@Column(name="date_acceptation")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateAcceptation;

	@Column(name="date_init")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateinit;
	
	@Column(name="date_annul")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateAnnul;


	@Column(name="date_refus")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateRefus;

	@Column(name="date_validation")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateValidation;

	@Column(name="note_chercheur")
	private Integer noteChercheur;

	@Column(name="note_donneur")
	private Integer noteDonneur;

	@Column(name="prix")
	private Integer prix;

	@Column(name="reference_echange")
	private String referenceEchange;

	//bi-directional many-to-one association to Membre
	@ManyToOne
	@JoinColumn(name="membre_id")
	private Membre membre;

	//bi-directional many-to-one association to Proposition
	@ManyToOne
	@JoinColumn(name="proposition_id")
	private Proposition proposition;

	//bi-directional many-to-one association to Rdv
	@OneToMany(mappedBy="echange")
	private List<Rdv> rdvs;
	
	public Echange() {
	}

	public Integer getIdEchange() {
		return this.idEchange;
	}

	public void setIdEchange(Integer idEchange) {
		this.idEchange = idEchange;
	}


	public Date getDateAnnul() {
		return dateAnnul;
	}

	public void setDateAnnul(Date dateAnnul) {
		this.dateAnnul = dateAnnul;
	}
	public Integer getCodeEchange() {
		return this.codeEchange;
	}

	public void setCodeEchange(Integer codeEchange) {
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

	public Integer getNoteChercheur() {
		return this.noteChercheur;
	}

	public void setNoteChercheur(Integer noteChercheur) {
		this.noteChercheur = noteChercheur;
	}

	public Integer getNoteDonneur() {
		return this.noteDonneur;
	}

	public void setNoteDonneur(Integer noteDonneur) {
		this.noteDonneur = noteDonneur;
	}

	public Integer getPrix() {
		return this.prix;
	}

	public void setPrix(Integer prix) {
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