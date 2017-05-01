package com.tac.business.api;

import java.util.List;

import com.tac.entity.Echange;
import com.tac.entity.Membre;
import com.tac.entity.Message;
import com.tac.entity.Proposition;

public interface IServiceMessage {
	
	Message envoyerMessage(Message message);
	List<Message> getByMembre(Membre membre);
	List<Message> getMsgEchange(Echange echange);
	List<Message> getMsgAboutProp(Membre chercheur, Proposition prop);
	Message messageLu(Message msg);

}
