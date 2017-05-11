package com.tac.business.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import com.tac.business.api.IServiceMessage;
import com.tac.data.api.IDaoMessage;
import com.tac.entity.Membre;
import com.tac.entity.Message;
import com.tac.entity.Proposition;

@Remote(IServiceMessage.class)
@Stateless
public class ServiceMessage implements IServiceMessage {
	
	@EJB
	private IDaoMessage proxyDaoMessage;

	@Override
	public Message envoyerMessage(Message message) {
		return proxyDaoMessage.addMessage(message);
	}

	@Override
	public List<Message> getByMembre(Membre membre) {
		return proxyDaoMessage.getByMembreId(membre.getIdMembre());
	}	

	@Override
	public List<Message> getMsgAboutProp(Membre chercheur, Proposition prop) {
		return proxyDaoMessage.getMsgAboutEchange(chercheur.getIdMembre(), prop.getIdProposition());
	}

	@Override
	public Message messageLu(Message msg) {
		return proxyDaoMessage.updateMessageLu(msg);
	}

	@Override
	public List<Message> getConversation(Membre membre1, Membre membre2) {
		return proxyDaoMessage.getConversations(membre1.getIdMembre(), membre2.getIdMembre());
	}

	@Override
	public List<Message> messageNonLuQuandRecepteur(Membre membre) {
		return proxyDaoMessage.getWhereRecepteurNonLu(membre.getIdMembre());
	}
		
	public List<Message> getConversationAboutProposition(int idMembre1, int idMembre2, int idProposition) {		
		return proxyDaoMessage.getConversationAboutProposition(idMembre1, idMembre2, idProposition);
	}

	@Override
	public List<Message> getConversationList(Membre membre) {
		return proxyDaoMessage.getAllConversations(membre.getIdMembre());
	}

}
