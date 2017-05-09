package com.tac.test;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.tac.entity.Message;
import com.tac.entity.Proposition;


public class Test {

	public static void main(String[] args) {
		//SELECT DISTINCT m.favoris FROM Membre m LEFT JOIN FETCH m.favoris.photos LEFT JOIN FETCH m.favoris.localisations  WHERE m.idMembre = :pid 
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("TAC_TestQuery");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        
        final String req = "SELECT m FROM Message m WHERE m.emetteur.idMembre =:pid group by m.recepteur.nom, m.proposition.intitule CASE WHEN m.recepteur =:pid THEN group by m.emetteur";
		Query query = em.createQuery(req);
		query.setParameter("pid", 6);
		List<Message> messages= query.getResultList();
		
		for (Message message : messages) {
			System.out.println(message.getIdMessage() + " texte message : "+ message.getTexte() +" nom proposition : "+ message.getProposition().getIntitule()+ " nom recepteur:"+ message.getRecepteur().getNom());
		}
        tx.commit();
        em.close();
        emf.close();
	}
}
