package com.tac.test;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


public class Test {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("TAC_TestQuery");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        //code here
        
        
        tx.commit();
        em.close();
        emf.close();
	}
}
