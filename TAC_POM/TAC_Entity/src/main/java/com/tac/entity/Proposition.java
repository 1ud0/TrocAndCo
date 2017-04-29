package com.tac.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the proposition database table.
 * 
 */
@Entity
@Table(name="proposition")
@NamedQuery(name="Proposition.findAll", query="SELECT p FROM Proposition p")
public class Proposition implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idProposition;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateAjout;

	private String description;

	private String intitule;

	//bi-directional many-to-one association to Echange
	@OneToMany(mappedBy="proposition")
	private List<Echange> echanges;

	//bi-directional many-to-many association to Membre
	@ManyToMany(mappedBy="favoris")
	private List<Membre> membresDuFavori;

	//bi-directional many-to-many association to Localisation
	@ManyToMany(mappedBy="proposedHere")
	private List<Localisation> localisations;

	//bi-directional many-to-one association to Message
	@OneToMany(mappedBy="proposition")
	private List<Message> messages;

	//bi-directional many-to-one association to Membre
	@ManyToOne
	private Membre membre;

	//bi-directional many-to-one association to Categorie
	@ManyToOne
	@JoinColumn(name="Categorie_idCategorie")
	private Categorie categorie;

	//bi-directional many-to-one association to Categorie
	@ManyToOne
	@JoinColumn(name="Categorie_idSousCategorie")
	private Categorie sousCategorie;

	//bi-directional many-to-one association to Etat
	@ManyToOne
	private Etat etat;

	//bi-directional many-to-one association to Valeur
	@ManyToOne
	private Valeur valeur;

	public Proposition() {
	}

	public int getIdProposition() {
		return this.idProposition;
	}

	public void setIdProposition(int idProposition) {
		this.idProposition = idProposition;
	}

	public Date getDateAjout() {
		return this.dateAjout;
	}

	public void setDateAjout(Date dateAjout) {
		this.dateAjout = dateAjout;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIntitule() {
		return this.intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public List<Echange> getEchanges() {
		return this.echanges;
	}

	public void setEchanges(List<Echange> echanges) {
		this.echanges = echanges;
	}

	public Echange addEchange(Echange echange) {
		getEchanges().add(echange);
		echange.setProposition(this);

		return echange;
	}

	public Echange removeEchange(Echange echange) {
		getEchanges().remove(echange);
		echange.setProposition(null);

		return echange;
	}

	

	public List<Membre> getMembresDuFavori() {
		return membresDuFavori;
	}

	public void setMembresDuFavori(List<Membre> membresDuFavori) {
		this.membresDuFavori = membresDuFavori;
	}

	public List<Localisation> getLocalisations() {
		return this.localisations;
	}

	public void setLocalisations(List<Localisation> localisations) {
		this.localisations = localisations;
	}

	public List<Message> getMessages() {
		return this.messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	public Message addMessage(Message message) {
		getMessages().add(message);
		message.setProposition(this);

		return message;
	}

	public Message removeMessage(Message message) {
		getMessages().remove(message);
		message.setProposition(null);

		return message;
	}

	public Membre getMembre() {
		return this.membre;
	}

	public void setMembre(Membre membre) {
		this.membre = membre;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public Categorie getSousCategorie() {
		return sousCategorie;
	}

	public void setSousCategorie(Categorie sousCategorie) {
		this.sousCategorie = sousCategorie;
	}

	public Etat getEtat() {
		return this.etat;
	}

	public void setEtat(Etat etat) {
		this.etat = etat;
	}

	public Valeur getValeur() {
		return this.valeur;
	}

	public void setValeur(Valeur valeur) {
		this.valeur = valeur;
	}

}