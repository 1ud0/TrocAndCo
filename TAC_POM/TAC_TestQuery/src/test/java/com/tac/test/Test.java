package com.tac.test;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.tac.entity.Proposition;


public class Test {

	public static void main(String[] args) {
		//SELECT DISTINCT m.favoris FROM Membre m LEFT JOIN FETCH m.favoris.photos LEFT JOIN FETCH m.favoris.localisations  WHERE m.idMembre = :pid 
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("TAC_TestQuery");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        
		final String req = "SELECT proposition FROM Echange e WHERE e.idEchange = :pidEchange";
		Query query = em.createQuery(req);
		query.setParameter("pidEchange", 1);
        Proposition p = (Proposition) query.getSingleResult();
		
        System.out.println(p.getIntitule() + p.getIdProposition());
        tx.commit();
        em.close();
        emf.close();
	}
}
