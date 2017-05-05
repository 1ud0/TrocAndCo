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
        
        final String reqGetByMemberId = "SELECT e FROM Echange e WHERE e.proposition.membre.idMembre= :pidMembreDonneur AND e.dateValidation IS NOT NULL";
		Query queryGetByIdMembreDonneur = em.createQuery(reqGetByMemberId);
		queryGetByIdMembreDonneur.setParameter("pidMembreDonneur", 2);
		List<Echange> echangesDuDonneur = queryGetByIdMembreDonneur.getResultList();
		int credit = 0;
		for (Echange echange : echangesDuDonneur) {
			credit = credit + echange.getPrix();
		}
		
		System.out.println(credit);
		
		final String req = "SELECT SUM(e.prix) FROM Echange e WHERE e.proposition.membre.idMembre= 2 AND e.dateValidation IS NOT NULL";
		Query query = em.createQuery(req);
		Number result = (Number) query.getSingleResult();
		System.out.println(result.getClass());
		System.out.println(result);
		
        tx.commit();
        em.close();
        emf.close();
	}
}
