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
     
        final String req = "SELECT DISTINCT p FROM Proposition p LEFT JOIN FETCH p.categorie LEFT JOIN FETCH p.photos WHERE p.dateSuppression IS NULL ORDER BY p.dateAjout DESC ";
		Query query = em.createQuery(req);
		query.setMaxResults(20);
		List<Proposition> props = query.getResultList();
		
		for (Proposition proposition : props) {
			System.out.println(proposition.getIntitule());
		}
		
        tx.commit();
        em.close();
        emf.close();
	}
}
