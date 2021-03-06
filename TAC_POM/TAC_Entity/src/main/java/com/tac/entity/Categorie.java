package com.tac.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the categorie database table.
 * 
 */
@Entity
@Table(name="categorie")
@NamedQuery(name="Categorie.findAll", query="SELECT c FROM Categorie c")
public class Categorie implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_categorie")
	private Integer idCategorie;

	@Column(name="intitule")
	private String intitule;

	//bi-directional many-to-one association to Categorie
	@ManyToOne
	@JoinColumn(name="id_categorie_mere")
	private Categorie categorieMere;

	//bi-directional many-to-one association to Categorie
	@OneToMany(mappedBy="categorieMere")
	private List<Categorie> sousCategories;

	//bi-directional many-to-one association to Envie
	@OneToMany(mappedBy="categorie")
	private List<Envie> enviesCategorie;

	//bi-directional many-to-one association to Envie
	@OneToMany(mappedBy="sousCategorie")
	private List<Envie> enviesSousCategorie;

	//bi-directional many-to-one association to Proposition
	@OneToMany(mappedBy="categorie")
	private List<Proposition> propositionsCategorie;

	//bi-directional many-to-one association to Proposition
	@OneToMany(mappedBy="sousCategorie")
	private List<Proposition> propositionsSousCategorie;

	//bi-directional many-to-one association to Suggestion
	@OneToMany(mappedBy="categorie")
	private List<Suggestion> suggestionsCategorie;

	//bi-directional many-to-one association to Suggestion
	@OneToMany(mappedBy="sousCategorie")
	private List<Suggestion> suggestionsSousCategorie;

	//bi-directional many-to-one association to Tag
	@OneToMany(mappedBy="categorie")
	private List<Tag> tags;

	public Categorie() {
	}

	public Integer getIdCategorie() {
		return this.idCategorie;
	}

	public void setIdCategorie(Integer idCategorie) {
		this.idCategorie = idCategorie;
	}

	public String getIntitule() {
		return this.intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public Categorie getCategorieMere() {
		return categorieMere;
	}

	public void setCategorieMere(Categorie categorieMere) {
		this.categorieMere = categorieMere;
	}

	public List<Categorie> getSousCategories() {
		return sousCategories;
	}

	public void setSousCategories(List<Categorie> sousCategories) {
		this.sousCategories = sousCategories;
	}

	public Categorie addCategory(Categorie category) {
		getSousCategories().add(category);
		category.setCategorieMere(this);

		return category;
	}

	public Categorie removeCategory(Categorie category) {
		getSousCategories().remove(category);
		category.setCategorieMere(null);

		return category;
	}

	

	public Envie addEnviesCategorie(Envie envie) {
		getEnviesCategorie().add(envie);
		envie.setCategorie(this);

		return envie;
	}

	public Envie removeEnviesCategorie(Envie envie) {
		getEnviesCategorie().remove(envie);
		envie.setCategorie(null);

		return envie;
	}


	public Envie addEnviesSousCategorie(Envie envie) {
		getEnviesSousCategorie().add(envie);
		envie.setCategorie(this);

		return envie;
	}

	public Envie removeEnviesSousCategorie(Envie envie) {
		getEnviesSousCategorie().remove(envie);
		envie.setCategorie(null);

		return envie;
	}

	
	public Proposition addPropositionsCategorie(Proposition proposition) {
		getPropositionsCategorie().add(proposition);
		proposition.setCategorie(this);

		return proposition;
	}

	public Proposition removePropositionsCategorie(Proposition proposition) {
		getPropositionsCategorie().remove(proposition);
		proposition.setCategorie(null);

		return proposition;
	}


	public Proposition addPropositionsSousCategorie(Proposition proposition) {
		getPropositionsSousCategorie().add(proposition);
		proposition.setSousCategorie(this);

		return proposition;
	}

	public Proposition removePropositionsSousCategorie(Proposition proposition) {
		getPropositionsSousCategorie().remove(proposition);
		proposition.setSousCategorie(null);

		return proposition;
	}


	public Suggestion addSuggestionsCategorie(Suggestion suggestion) {
		getSuggestionsCategorie().add(suggestion);
		suggestion.setCategorie(this);

		return suggestion;
	}

	public Suggestion removeSuggestionsCategorie(Suggestion suggestion) {
		getSuggestionsCategorie().remove(suggestion);
		suggestion.setCategorie(null);

		return suggestion;
	}

	public Suggestion addSuggestionsSousCategorie(Suggestion suggestion) {
		getSuggestionsSousCategorie().add(suggestion);
		suggestion.setSousCategorie(this);

		return suggestion;
	}

	public Suggestion removeSuggestionsSousCategorie(Suggestion suggestion) {
		getSuggestionsSousCategorie().remove(suggestion);
		suggestion.setSousCategorie(null);

		return suggestion;
	}

	public List<Tag> getTags() {
		return this.tags;
	}

	public List<Envie> getEnviesCategorie() {
		return enviesCategorie;
	}

	public void setEnviesCategorie(List<Envie> enviesCategorie) {
		this.enviesCategorie = enviesCategorie;
	}

	public List<Envie> getEnviesSousCategorie() {
		return enviesSousCategorie;
	}

	public void setEnviesSousCategorie(List<Envie> enviesSousCategorie) {
		this.enviesSousCategorie = enviesSousCategorie;
	}

	public List<Proposition> getPropositionsCategorie() {
		return propositionsCategorie;
	}

	public void setPropositionsCategorie(List<Proposition> propositionsCategorie) {
		this.propositionsCategorie = propositionsCategorie;
	}

	public List<Proposition> getPropositionsSousCategorie() {
		return propositionsSousCategorie;
	}

	public void setPropositionsSousCategorie(List<Proposition> propositionsSousCategorie) {
		this.propositionsSousCategorie = propositionsSousCategorie;
	}

	public List<Suggestion> getSuggestionsCategorie() {
		return suggestionsCategorie;
	}

	public void setSuggestionsCategorie(List<Suggestion> suggestionsCategorie) {
		this.suggestionsCategorie = suggestionsCategorie;
	}

	public List<Suggestion> getSuggestionsSousCategorie() {
		return suggestionsSousCategorie;
	}

	public void setSuggestionsSousCategorie(List<Suggestion> suggestionsSousCategorie) {
		this.suggestionsSousCategorie = suggestionsSousCategorie;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	public Tag addTag(Tag tag) {
		getTags().add(tag);
		tag.setCategorie(this);

		return tag;
	}

	public Tag removeTag(Tag tag) {
		getTags().remove(tag);
		tag.setCategorie(null);

		return tag;
	}

}