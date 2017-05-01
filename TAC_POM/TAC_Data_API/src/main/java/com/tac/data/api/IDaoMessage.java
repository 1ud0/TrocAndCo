package com.tac.data.api;

import java.util.List;

import com.tac.entity.Message;

public interface IDaoMessage {
	
	Message addMessage(Message message);
	Message updateMessage(Message message);
	void deleteMessage(Message message);
	List<Message> getConversations(int idMembre1, int idMembre2);
	List<Message> getMsgAboutEchange(int idChercheur, int idProp);
	List<Message> getByMembreId(int idMembre);

}
