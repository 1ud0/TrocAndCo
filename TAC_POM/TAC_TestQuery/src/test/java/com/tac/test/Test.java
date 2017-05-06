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
     
		
		final String req = "SELECT * FROM proposition p inner JOIN echange e on e.proposition_id=p.id_proposition where e.date_validation is null and p.date_suppression is null;";
		Query query = em.createNativeQuery(req);
		List<Proposition> propositionDispo = query.getResultList();
		for (Proposition proposition : propositionDispo) {
			System.out.println(proposition.getIntitule());
		}
		
        tx.commit();
        em.close();
        emf.close();
	}
}
