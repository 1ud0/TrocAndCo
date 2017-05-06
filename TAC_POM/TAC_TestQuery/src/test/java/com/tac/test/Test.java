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
     
        final String req = "SELECT p.id_proposition, p.intitule, p.categorie_id, p.description, p.date_ajout, p.date_suppression, p.etat_id, p.membre_id, p.sous_categorie_id, p.valeur_id FROM proposition p left JOIN echange e on e.proposition_id=p.id_proposition where e.date_validation is null and p.date_suppression is null and p.membre_id=:pid";
		Query query = em.createNativeQuery(req, Proposition.class);
		query.setParameter("pid", 6);
		List<Proposition> props= query.getResultList();
		
		for (Proposition proposition : props) {
			System.out.println(proposition.getIntitule());
		}
		
        tx.commit();
        em.close();
        emf.close();
	}
}
