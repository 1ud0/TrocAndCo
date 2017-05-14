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
        
        final String req = "SELECT c FROM Categorie c WHERE EXISTS (SELECT t FROM Tag t WHERE t.intitule LIKE :ptitre AND t.categorie = c))";
        Query query = em.createQuery(req);
        query.setParameter("ptitre", "%vieux%");
        List<Categorie> cats = query.getResultList();
        for (Categorie categorie : cats) {
			System.out.println(categorie.getIntitule());
        
        tx.commit();
        em.close();
        emf.close();
        }
	}
}
