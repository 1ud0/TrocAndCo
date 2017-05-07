package com.tac.test;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.tac.entity.Echange;
import com.tac.entity.Proposition;


public class Test {

	public static void main(String[] args) {
		//SELECT DISTINCT m.favoris FROM Membre m LEFT JOIN FETCH m.favoris.photos LEFT JOIN FETCH m.favoris.localisations  WHERE m.idMembre = :pid 
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("TAC_TestQuery");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        
        final String req = "SELECT p FROM Proposition p WHERE EXISTS (SELECT loc FROM Localisation loc WHERE p MEMBER OF loc.proposedHere AND loc.codePostal LIKE :pdep)";
		Query query = em.createQuery(req);
		query.setParameter("pdep", "73%");
		List<Proposition> props= query.getResultList();
		
		for (Proposition proposition : props) {
			System.out.println(proposition.getIntitule());
		}
		

        tx.commit();
        em.close();
        emf.close();
	}
}
