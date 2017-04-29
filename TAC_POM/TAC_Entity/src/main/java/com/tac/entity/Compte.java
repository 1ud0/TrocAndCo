package com.tac.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the compte database table.
 * 
 */
@Entity
@Table(name="compte")
@NamedQuery(name="Compte.findAll", query="SELECT c FROM Compte c")
public class Compte implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idCompte;

	private String type;

	//bi-directional many-to-one association to Membre
	@OneToMany(mappedBy="compte")
	private List<Membre> membres;

	public Compte() {
	}

	public int getIdCompte() {
		return this.idCompte;
	}

	public void setIdCompte(int idCompte) {
		this.idCompte = idCompte;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Membre> getMembres() {
		return this.membres;
	}

	public void setMembres(List<Membre> membres) {
		this.membres = membres;
	}

	public Membre addMembre(Membre membre) {
		getMembres().add(membre);
		membre.setCompte(this);

		return membre;
	}

	public Membre removeMembre(Membre membre) {
		getMembres().remove(membre);
		membre.setCompte(null);

		return membre;
	}

}