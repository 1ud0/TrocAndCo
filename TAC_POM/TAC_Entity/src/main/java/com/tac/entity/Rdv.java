package com.tac.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the rdv database table.
 * 
 */
@Entity
@Table(name="rdv")
@NamedQuery(name="Rdv.findAll", query="SELECT r FROM Rdv r")
public class Rdv implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_rdv")
	private Integer idRDV;

	@Column(name="date_annulation")
	@Temporal(TemporalType.TIMESTAMP)
	private Date annulationRDV;

	@Column(name="commentaire")
	private String commentaire;

	@Column(name="date_rdv")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateRdv;

	@Column(name="lieu")
	private String lieu;

	//bi-directional many-to-one association to Echange
	@ManyToOne
	@JoinColumn(name="echange_id")
	private Echange echange;

	public Rdv() {
	}

	public Integer getIdRDV() {
		return this.idRDV;
	}

	public void setIdRDV(Integer idRDV) {
		this.idRDV = idRDV;
	}

	public Date getAnnulationRDV() {
		return this.annulationRDV;
	}

	public void setAnnulationRDV(Date annulationRDV) {
		this.annulationRDV = annulationRDV;
	}

	public String getCommentaire() {
		return this.commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public Date getDateRdv() {
		return this.dateRdv;
	}

	public void setDateRdv(Date dateRdv) {
		this.dateRdv = dateRdv;
	}

	public String getLieu() {
		return this.lieu;
	}

	public void setLieu(String lieu) {
		this.lieu = lieu;
	}

	public Echange getEchange() {
		return this.echange;
	}

	public void setEchange(Echange echange) {
		this.echange = echange;
	}

}