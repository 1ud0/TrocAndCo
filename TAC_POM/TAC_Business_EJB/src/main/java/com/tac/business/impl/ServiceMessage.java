package com.tac.business.impl;

import java.util.List;

import com.tac.business.api.IServiceMessage;
import com.tac.entity.Echange;
import com.tac.entity.Membre;
import com.tac.entity.Message;
import com.tac.entity.Proposition;

public class ServiceMessage implements IServiceMessage {

	@Override
	public Message envoyerMessage(Message message) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Message> getByMembre(Membre membre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Message> getMsgEchange(Echange echange) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Message> getMsgAboutProp(Membre chercheur, Proposition prop) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Message messageLu(Message msg) {
		// TODO Auto-generated method stub
		return null;
	}

}
