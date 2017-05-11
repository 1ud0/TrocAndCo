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
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("TAC_TestQuery");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        
        final String req = "SELECT m FROM Message m WHERE m.emetteur.idMembre = 6 GROUP BY m.recepteur, m.proposition";
		Query query = em.createQuery(req);
		List<Message> messages = query.getResultList();
		
		for (Message m : messages) {
			System.out.println(m.getTexte());
		}
        
        
        tx.commit();
        em.close();
        emf.close();
	}
}
