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
	@Column(name="id_valeur")
	private Integer idValeur;

	@Column(name="intitule")
	private String intitule;

	@Column(name="valeur")
	private Integer valeur;

	//bi-directional many-to-one association to Envie
	@OneToMany(mappedBy="valeur")
	private List<Envie> envies;

	//bi-directional many-to-one association to Proposition
	@OneToMany(mappedBy="valeur")
	private List<Proposition> propositions;

	public Valeur() {
	}

	public Integer getIdValeur() {
		return this.idValeur;
	}

	public void setIdValeur(Integer idValeur) {
		this.idValeur = idValeur;
	}

	public String getIntitule() {
		return this.intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public Integer getValeur() {
		return this.valeur;
	}

	public void setValeur(Integer valeur) {
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