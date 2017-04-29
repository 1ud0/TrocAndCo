package com.tac.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the membre database table.
 * 
 */
@Entity
@Table(name="membre")
@NamedQuery(name="Membre.findAll", query="SELECT m FROM Membre m")
public class Membre implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idMembre;

	private String avatar;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateDesinscription;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateInscription;

	@Temporal(TemporalType.DATE)
	private Date dateNaissance;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateRadiation;

	private String mail;

	private String motifRadiation;

	private String nom;

	private String password;

	private String prenom;

	private String pseudo;

	private String telephone;

	//bi-directional many-to-one association to Echange
	@OneToMany(mappedBy="membre")
	private List<Echange> echanges;

	//bi-directional many-to-many association to Proposition
	@ManyToMany
	@JoinTable(
		name="favori"
		, joinColumns={
			@JoinColumn(name="Membre_idMembre")
			}
		, inverseJoinColumns={
			@JoinColumn(name="Proposition_idProposition")
			}
		)
	private List<Proposition> favoris;

	//bi-directional many-to-one association to Liste
	@OneToMany(mappedBy="membre")
	private List<Liste> listes;

	//bi-directional many-to-one association to Localisation
	@OneToMany(mappedBy="membre")
	private List<Localisation> localisations;

	//bi-directional many-to-one association to Compte
	@ManyToOne
	private Compte compte;

	//bi-directional many-to-one association to Message
	@OneToMany(mappedBy="emetteur")
	private List<Message> messagesSent;

	//bi-directional many-to-one association to Message
	@OneToMany(mappedBy="recepteur")
	private List<Message> messagesReceived;

	//bi-directional many-to-one association to Proposition
	@OneToMany(mappedBy="membre")
	private List<Proposition> propositions;

	//bi-directional many-to-one association to Suggestion
	@OneToMany(mappedBy="membre")
	private List<Suggestion> suggestions;

	public Membre() {
	}

	public int getIdMembre() {
		return this.idMembre;
	}

	public void setIdMembre(int idMembre) {
		this.idMembre = idMembre;
	}

	public String getAvatar() {
		return this.avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public Date getDateDesinscription() {
		return this.dateDesinscription;
	}

	public void setDateDesinscription(Date dateDesinscription) {
		this.dateDesinscription = dateDesinscription;
	}

	public Date getDateInscription() {
		return this.dateInscription;
	}

	public void setDateInscription(Date dateInscription) {
		this.dateInscription = dateInscription;
	}

	public Date getDateNaissance() {
		return this.dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public Date getDateRadiation() {
		return this.dateRadiation;
	}

	public void setDateRadiation(Date dateRadiation) {
		this.dateRadiation = dateRadiation;
	}

	public String getMail() {
		return this.mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getMotifRadiation() {
		return this.motifRadiation;
	}

	public void setMotifRadiation(String motifRadiation) {
		this.motifRadiation = motifRadiation;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getPseudo() {
		return this.pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public List<Echange> getEchanges() {
		return this.echanges;
	}

	public void setEchanges(List<Echange> echanges) {
		this.echanges = echanges;
	}

	public Echange addEchange(Echange echange) {
		getEchanges().add(echange);
		echange.setMembre(this);

		return echange;
	}

	public Echange removeEchange(Echange echange) {
		getEchanges().remove(echange);
		echange.setMembre(null);

		return echange;
	}

	

	public List<Proposition> getFavoris() {
		return favoris;
	}

	public void setFavoris(List<Proposition> favoris) {
		this.favoris = favoris;
	}

	public List<Liste> getListes() {
		return this.listes;
	}

	public void setListes(List<Liste> listes) {
		this.listes = listes;
	}

	public Liste addListe(Liste liste) {
		getListes().add(liste);
		liste.setMembre(this);

		return liste;
	}

	public Liste removeListe(Liste liste) {
		getListes().remove(liste);
		liste.setMembre(null);

		return liste;
	}

	public List<Localisation> getLocalisations() {
		return this.localisations;
	}

	public void setLocalisations(List<Localisation> localisations) {
		this.localisations = localisations;
	}

	public Localisation addLocalisation(Localisation localisation) {
		getLocalisations().add(localisation);
		localisation.setMembre(this);

		return localisation;
	}

	public Localisation removeLocalisation(Localisation localisation) {
		getLocalisations().remove(localisation);
		localisation.setMembre(null);

		return localisation;
	}

	public Compte getCompte() {
		return this.compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	
	public List<Message> getMessagesSent() {
		return messagesSent;
	}

	public void setMessagesSent(List<Message> messagesSent) {
		this.messagesSent = messagesSent;
	}

	public List<Message> getMessagesReceived() {
		return messagesReceived;
	}

	public void setMessagesReceived(List<Message> messagesReceived) {
		this.messagesReceived = messagesReceived;
	}

	public Message addMessagesSent(Message messages) {
		getMessagesSent().add(messages);
		messages.setEmetteur(this);

		return messages;
	}

	public Message removeMessagesSent(Message messages) {
		getMessagesSent().remove(messages);
		messages.setEmetteur(null);

		return messages;
	}


	public Message addMessagesReceived(Message messages) {
		getMessagesReceived().add(messages);
		messages.setRecepteur(this);

		return messages;
	}

	public Message removeMessagesReceived(Message messages) {
		getMessagesReceived().remove(messages);
		messages.setRecepteur(null);

		return messages;
	}

	public List<Proposition> getPropositions() {
		return this.propositions;
	}

	public void setPropositions(List<Proposition> propositions) {
		this.propositions = propositions;
	}

	public Proposition addPropositions(Proposition propositions) {
		getPropositions().add(propositions);
		propositions.setMembre(this);

		return propositions;
	}

	public Proposition removePropositions(Proposition propositions) {
		getPropositions().remove(propositions);
		propositions.setMembre(null);

		return propositions;
	}

	public List<Suggestion> getSuggestions() {
		return this.suggestions;
	}

	public void setSuggestions(List<Suggestion> suggestions) {
		this.suggestions = suggestions;
	}

	public Suggestion addSuggestion(Suggestion suggestion) {
		getSuggestions().add(suggestion);
		suggestion.setMembre(this);

		return suggestion;
	}

	public Suggestion removeSuggestion(Suggestion suggestion) {
		getSuggestions().remove(suggestion);
		suggestion.setMembre(null);

		return suggestion;
	}

}