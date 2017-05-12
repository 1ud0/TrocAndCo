package com.tac.test;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.tac.entity.Categorie;
import com.tac.entity.Message;
import com.tac.entity.Proposition;

import javassist.compiler.ast.CastExpr;


public class Test {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("TAC_TestQuery");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        
		final String req = "SELECT p.categorie, COUNT(*) FROM Proposition p GROUP BY p.categorie";
		Query query = em.createQuery(req);
		 List<Object[]> bob = query.getResultList();
		 for (Object[] objects : bob) {
			 Categorie categorie = (Categorie) objects[0];
			 	System.out.println(categorie.getIntitule());
			 Long count = (Long) objects[1];
			 System.out.println(count);
		}
        
      
		
	
		
        
        
        tx.commit();
        em.close();
        emf.close();
	}
}
