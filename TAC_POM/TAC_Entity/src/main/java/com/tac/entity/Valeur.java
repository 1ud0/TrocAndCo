package com.tac.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the valeur database table.
 * 
 */
@Entity
@Table(name="valeur")
@NamedQuery(name="Valeur.findAll", query="SELECT v FROM Valeur v")
public class Valeur implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idValeur;

	private String intitule;

	private int valeur;

	//bi-directional many-to-one association to Envie
	@OneToMany(mappedBy="valeur")
	private List<Envie> envies;

	//bi-directional many-to-one association to Proposition
	@OneToMany(mappedBy="valeur")
	private List<Proposition> propositions;

	public Valeur() {
	}

	public int getIdValeur() {
		return this.idValeur;
	}

	public void setIdValeur(int idValeur) {
		this.idValeur = idValeur;
	}

	public String getIntitule() {
		return this.intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public int getValeur() {
		return this.valeur;
	}

	public void setValeur(int valeur) {
		this.valeur = valeur;
	}

	public List<Envie> getEnvies() {
		return this.envies;
	}

	public void setEnvies(List<Envie> envies) {
		this.envies = envies;
	}

	public Envie addEnvy(Envie envy) {
		getEnvies().add(envy);
		envy.setValeur(this);

		return envy;
	}

	public Envie removeEnvy(Envie envy) {
		getEnvies().remove(envy);
		envy.setValeur(null);

		return envy;
	}

	public List<Proposition> getPropositions() {
		return this.propositions;
	}

	public void setPropositions(List<Proposition> propositions) {
		this.propositions = propositions;
	}

	public Proposition addProposition(Proposition proposition) {
		getPropositions().add(proposition);
		proposition.setValeur(this);

		return proposition;
	}

	public Proposition removeProposition(Proposition proposition) {
		getPropositions().remove(proposition);
		proposition.setValeur(null);

		return proposition;
	}

}