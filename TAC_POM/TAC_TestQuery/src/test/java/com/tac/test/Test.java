package com.tac.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.tac.entity.Echange;
import com.tac.entity.Membre;
import com.tac.entity.Proposition;
import com.tac.entity.Rdv;

public class Test {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("TAC_TestQuery");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        //
        // 
		final String reqGetMoyNote="SELECT e FROM Echange e WHERE (e.proposition.membre.idMembre= :pidMembre AND e.noteDonneur IS NOT NULL) OR (e.membre.idMembre = :pidMembre AND e.noteChercheur IS NOT NULL)";
		Query queryGetMoyNote = em.createQuery(reqGetMoyNote);
		queryGetMoyNote.setParameter("pidMembre", 10);
		List<Echange> echangesDuMembre = queryGetMoyNote.getResultList();
		System.out.println(echangesDuMembre.size());
		Double totalNote=0.0;
		for(Echange echange : echangesDuMembre){			
			totalNote=totalNote+echange.getNoteDonneur();			
		}
		Double noteMoyenne = totalNote/(double)echangesDuMembre.size();
		System.out.println(noteMoyenne);
        tx.commit();
        em.close();
        emf.close();
	}
}
