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
	private int idRDV;

	@Temporal(TemporalType.TIMESTAMP)
	private Date annulationRDV;

	private String commentaire;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateRdv;

	private String lieu;

	//bi-directional many-to-one association to Echange
	@ManyToOne
	private Echange echange;

	public Rdv() {
	}

	public int getIdRDV() {
		return this.idRDV;
	}

	public void setIdRDV(int idRDV) {
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