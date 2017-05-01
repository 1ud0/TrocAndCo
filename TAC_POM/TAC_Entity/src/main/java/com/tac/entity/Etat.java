package com.tac.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the etat database table.
 * 
 */
@Entity
@Table(name="etat")
@NamedQuery(name="Etat.findAll", query="SELECT e FROM Etat e")
public class Etat implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_etat")
	private Integer idEtat;

	@Column(name="intitule")
	private String intitule;

	//bi-directional many-to-one association to Proposition
	@OneToMany(mappedBy="etat")
	private List<Proposition> propositions;

	public Etat() {
	}

	public Integer getIdEtat() {
		return this.idEtat;
	}

	public void setIdEtat(Integer idEtat) {
		this.idEtat = idEtat;
	}

	public String getIntitule() {
		return this.intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public List<Proposition> getPropositions() {
		return this.propositions;
	}

	public void setPropositions(List<Proposition> propositions) {
		this.propositions = propositions;
	}

	public Proposition addProposition(Proposition proposition) {
		getPropositions().add(proposition);
		proposition.setEtat(this);

		return proposition;
	}

	public Proposition removeProposition(Proposition proposition) {
		getPropositions().remove(proposition);
		proposition.setEtat(null);

		return proposition;
	}

}