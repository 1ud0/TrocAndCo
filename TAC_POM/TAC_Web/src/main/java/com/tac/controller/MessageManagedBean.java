package com.tac.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import com.tac.business.api.IServiceMessage;
import com.tac.business.api.IServiceProposition;
import com.tac.entity.Membre;
import com.tac.entity.Message;
import com.tac.entity.Proposition;
import com.tac.exception.DataAccessException;

@ManagedBean(name = "mbMessage")
@ViewScoped
public class MessageManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EJB
	private IServiceMessage proxyMessage;
	@EJB
	private IServiceProposition proxyProposition;
	
	@ManagedProperty(value = "#{mbIdentif}")
	private IdentificationManagedBean identifBean;
	
	private Membre membreCourant;
	private String tempsDepuisEnvoi="";
	private Proposition propositionAvecMessagesSelected;
	private List<Message> messagesOfPropositionSelected = new ArrayList<>();
	
	//ChatBox
	private List<Message> chat = new ArrayList<>();
	private String messageAEnvoyer;
	List<Message> messagesDuMembre = new ArrayList<>();
	private Proposition propositionOfInterest;
	
	
	public List<Message> getMessagesDuMembre() {
		return messagesDuMembre;
	}


	public void setMessagesDuMembre(List<Message> messagesDuMembre) {
		this.messagesDuMembre = messagesDuMembre;
	}


	@PostConstruct
	void init(){
		membreCourant = identifBean.getMembreConnected();
		if (membreCourant != null)
			messagesDuMembre = proxyMessage.getConversationList(membreCourant);
	}
	
	
	public Message envoyerMessage(){
		membreCourant = identifBean.getMembreConnected();
		Message nouveauMessage = new Message();
		nouveauMessage.setEmetteur(membreCourant);
		nouveauMessage.setDateEnvoi(new Date());
		nouveauMessage.setLu(false);
		
		if (chat.size()>0){
			nouveauMessage.setProposition(chat.get(0).getProposition());
			if(chat.get(0).getEmetteur().getIdMembre()==membreCourant.getIdMembre()){
				nouveauMessage.setRecepteur(chat.get(0).getRecepteur());
			}
			else{
				nouveauMessage.setRecepteur(chat.get(0).getEmetteur());
			}
		}
		else {
			nouveauMessage.setProposition(propositionOfInterest); 
			nouveauMessage.setRecepteur(propositionOfInterest.getMembre());
		}
		
		nouveauMessage.setTexte(messageAEnvoyer);
		Message messageAjoute = proxyMessage.envoyerMessage(nouveauMessage);
		messageAEnvoyer = "";
		return messageAjoute;
	}
	


	public String dureeEnvoieMessage(Date date) {
		Date now = new Date();
		long time = now.getTime() - date.getTime();
		int msToJour = 3600 * 1000 * 24;
		int msToHeure = 3600 * 1000;
		int msToMin = 1000 * 60;
		long dureejours = time / msToJour;
		long dureeheures = time / msToHeure - dureejours * 24;
		long dureemin = time / msToMin - dureeheures * 60 - dureejours * 24 * 60;
		tempsDepuisEnvoi=" Il y a " + dureejours + "j " + dureeheures + "h " + dureemin + "min!";
		return tempsDepuisEnvoi;
	}
	
	
	public String avecQui(Message message){
		membreCourant = identifBean.getMembreConnected();
		if(message.getEmetteur().getIdMembre()==membreCourant.getIdMembre()){
			return message.getRecepteur().getPseudo();
		}
		else{
			return message.getEmetteur().getPseudo();
		}
	}
	
	public List<Message> getAllOther(Message message){
		membreCourant = identifBean.getMembreConnected();
		int autre;
		if(message.getEmetteur().getIdMembre()==membreCourant.getIdMembre()){
			autre = message.getRecepteur().getIdMembre();
		}
		else{
			autre = message.getEmetteur().getIdMembre();
		}
		return proxyMessage.getConversationAboutProposition(membreCourant.getIdMembre(), autre, message.getProposition().getIdProposition());
	}

	public void loadChat(Message message){
		membreCourant = identifBean.getMembreConnected();
		chat = getAllOther(message);
		for(Message m : chat){
			if(m.getRecepteur().getIdMembre() == membreCourant.getIdMembre()){
				m = proxyMessage.messageLu(m);
			}
		}
	}
	
	public void loadNewChat(Proposition proposition){
		propositionOfInterest = proposition;
		chat = new ArrayList<>();
	}
	
	public void refreshChat(){
		membreCourant = identifBean.getMembreConnected();
		Message message = envoyerMessage();
		loadChat(message);
	}
	
	public Proposition propAvecPhotos(int idProposition) throws DataAccessException{
		return proxyProposition.getById(idProposition);
	}
	
	public String debutDernierMessage(Message message){
		String resultat = dernierMessage(message).getTexte();
		if(resultat.length()>28){
			resultat=resultat.substring(0, 25);
			resultat=resultat+"...";
		}		
		return resultat;
	}
	
	public Boolean isMemeEmetteurQuePrecedent(int index){
		if(index !=0){
			if(chat.get(index).getEmetteur().getIdMembre() ==  chat.get(index-1).getEmetteur().getIdMembre()){
				return true;
			}
		}
		return false;
	}
	
	public Message dernierMessage(Message message){
		membreCourant = identifBean.getMembreConnected();
		List<Message> msgList = getAllOther(message);
		Message resultat=message;
		Message messageCourant=message;
		for (Message message2 : msgList) {
			if(message2.getDateEnvoi().after(messageCourant.getDateEnvoi())){
				resultat=message2;
				messageCourant=message2;
			}
		}
		return resultat;
	}

	
	public String depuisQuand(Message message){
		membreCourant = identifBean.getMembreConnected();
		List<Message> msgList = getAllOther(message);
		Date dateEnvoiDernierMessage = message.getDateEnvoi();
		Message messageCourant=message;
		for (Message message2 : msgList) {
			if(message2.getDateEnvoi().after(messageCourant.getDateEnvoi())){
				dateEnvoiDernierMessage=message2.getDateEnvoi();
				messageCourant=message2;
			}
		}
		String resultat = dureeEnvoieMessage(dateEnvoiDernierMessage);
		return resultat;
	}

	public IServiceMessage getProxyMessage() {
		return proxyMessage;
	}

	public void setProxyMessage(IServiceMessage proxyMessage) {
		this.proxyMessage = proxyMessage;
	}

	public IServiceProposition getProxyProposition() {
		return proxyProposition;
	}

	public void setProxyProposition(IServiceProposition proxyProposition) {
		this.proxyProposition = proxyProposition;
	}

	public IdentificationManagedBean getIdentifBean() {
		return identifBean;
	}

	public void setIdentifBean(IdentificationManagedBean identifBean) {
		this.identifBean = identifBean;
	}

	public Membre getMembreCourant() {
		return membreCourant;
	}

	public void setMembreCourant(Membre membreCourant) {
		this.membreCourant = membreCourant;
	}

	public String getTempsDepuisEnvoi() {
		return tempsDepuisEnvoi;
	}

	public void setTempsDepuisEnvoi(String tempsDepuisEnvoi) {
		this.tempsDepuisEnvoi = tempsDepuisEnvoi;
	}

	public Proposition getPropositionAvecMessagesSelected() {
		return propositionAvecMessagesSelected;
	}

	public void setPropositionAvecMessagesSelected(Proposition propositionAvecMessagesSelected) {
		this.propositionAvecMessagesSelected = propositionAvecMessagesSelected;
	}

	public List<Message> getMessagesOfPropositionSelected() {
		return messagesOfPropositionSelected;
	}

	public void setMessagesOfPropositionSelected(List<Message> messagesOfPropositionSelected) {
		this.messagesOfPropositionSelected = messagesOfPropositionSelected;
	}

	public List<Message> getChat() {
		return chat;
	}

	public void setChat(List<Message> chat) {
		this.chat = chat;
	}

	public String getMessageAEnvoyer() {
		return messageAEnvoyer;
	}

	public void setMessageAEnvoyer(String messageAEnvoyer) {
		this.messageAEnvoyer = messageAEnvoyer;
	}


	public Proposition getPropositionOfInterest() {
		return propositionOfInterest;
	}


	public void setPropositionOfInterest(Proposition propositionOfInterest) {
		this.propositionOfInterest = propositionOfInterest;
	}
	
	

}
