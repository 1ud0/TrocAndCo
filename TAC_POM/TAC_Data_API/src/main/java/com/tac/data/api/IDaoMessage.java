package com.tac.data.api;

import java.util.List;

import com.tac.entity.Message;

public interface IDaoMessage {
	
	Message addMessage(Message message);
	Message updateMessageLu(Message message);
	void deleteMessage(Message message);
	List<Message> getConversations(int idMembre1, int idMembre2);
	List<Message> getMsgAboutEchange(int idChercheur, int idProp);
	List<Message> getByMembreId(int idMembre);
	List<Message> getByConversation(int idMembre);
	List<Message> getWhereRecepteur(int idMembre);
}
