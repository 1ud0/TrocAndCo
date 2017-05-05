package com.tac.data.impl;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.tac.data.api.IDaoMessage;
import com.tac.entity.Message;

@Remote(IDaoMessage.class)
@Stateless
public class DaoMessage implements IDaoMessage {
	
	@PersistenceContext(unitName = "TAC_Data_EJB")
	private EntityManager em;

	@Override
	public Message addMessage(Message message) {
		em.persist(message);
		return message;
	}

	@Override
	public Message updateMessageLu(Message message) {
		message.setLu(true);
		em.merge(message);
		return message;
	}

	@Override
	public void deleteMessage(Message message) {
		em.remove(message);
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Message> getConversations(int idMembre1, int idMembre2) {
		String req="SELECT m FROM Message m WHERE (m.emetteur.idMembre= :mid1 AND m.recepteur.idMembre = :mid2) OR (m.emetteur.idMembre= :mid2 AND m.recepteur.idMembre = :mid1) ORDER BY m.dateEnvoi";
		Query query = em.createQuery(req);
		query.setParameter("mid1", idMembre1).setParameter("mid2", idMembre2);
		
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Message> getMsgAboutEchange(int idChercheur, int idProp) {
		String req="SELECT m FROM Message m WHERE (m.proposition.idProposition= :pid AND m.emetteur.idMembre = :cid) OR (m.proposition.idProposition= :pid AND m.recepteur.idMembre = :cid) ORDER BY m.dateEnvoi";
		Query query = em.createQuery(req);
		query.setParameter("cid", idChercheur).setParameter("pid", idProp);
		
		return query.getResultList();
	}
	
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Message> getByMembreId(int idMembre) {
		String req="SELECT m FROM Message m WHERE m.emetteur.idMembre= :mid OR m.recepteur.idMembre= :mid";
		Query query = em.createQuery(req);
		query.setParameter("mid", idMembre);
		return query.getResultList();
	}

	

	

}
