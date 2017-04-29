package com.tac.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the message database table.
 * 
 */
@Entity
@Table(name="message")
@NamedQuery(name="Message.findAll", query="SELECT m FROM Message m")
public class Message implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idMessage;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateEnvoi;

	private boolean lu;

	private String texte;

	//bi-directional many-to-one association to Membre
	@ManyToOne
	@JoinColumn(name="Membre_idEmetteur")
	private Membre emetteur;

	//bi-directional many-to-one association to Membre
	@ManyToOne
	@JoinColumn(name="Membre_idRecepteur")
	private Membre recepteur;

	//bi-directional many-to-one association to Proposition
	@ManyToOne
	private Proposition proposition;

	public Message() {
	}

	public int getIdMessage() {
		return this.idMessage;
	}

	public void setIdMessage(int idMessage) {
		this.idMessage = idMessage;
	}

	public Date getDateEnvoi() {
		return this.dateEnvoi;
	}

	public void setDateEnvoi(Date dateEnvoi) {
		this.dateEnvoi = dateEnvoi;
	}

	public boolean isLu() {
		return lu;
	}

	public void setLu(boolean lu) {
		this.lu = lu;
	}

	public Membre getEmetteur() {
		return emetteur;
	}

	public void setEmetteur(Membre emetteur) {
		this.emetteur = emetteur;
	}

	public Membre getRecepteur() {
		return recepteur;
	}

	public void setRecepteur(Membre recepteur) {
		this.recepteur = recepteur;
	}

	public String getTexte() {
		return this.texte;
	}

	public void setTexte(String texte) {
		this.texte = texte;
	}

	public Proposition getProposition() {
		return this.proposition;
	}

	public void setProposition(Proposition proposition) {
		this.proposition = proposition;
	}

}