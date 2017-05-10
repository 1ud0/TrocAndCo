package com.tac.business.api;

import java.util.List;

import com.tac.entity.Membre;
import com.tac.entity.Message;
import com.tac.entity.Proposition;

public interface IServiceMessage {
	
	Message envoyerMessage(Message message);
	List<Message> getByMembre(Membre membre);
	List<Message> getConversation(Membre membre1, Membre membre2);
	List<Message> getMsgAboutProp(Membre chercheur, Proposition prop);
	Message messageLu(Message msg);
	List<Message> messageNonLuQuandRecepteur(Membre membre);
	List<Message> getConversationAboutProposition(int idMembre1, int idMembre2, int idProposition) ;
	List<Message> getConversationList(Membre membre);
}
