package com.tac.data.impl;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.tac.data.api.IDaoCompte;
import com.tac.entity.Compte;

@Remote(IDaoCompte.class)
@Stateless
public class DaoCompte implements IDaoCompte{

	public static final String COMPTE_USER = "membre";
	public static final String COMPTE_ADMIN = "admin";
	
	@PersistenceContext(unitName = "TAC_Data_EJB")
	private EntityManager em;
	
	@Override
	public Compte getCompteUser() {
		final String requete = "SELECT c FROM Compte c WHERE c.type = :ptype";
		Query query = em.createQuery(requete);
		query.setParameter("ptype", COMPTE_USER);
		return (Compte) query.getSingleResult();
	}

	@Override
	public Compte getCompteAdmin() {
		final String requete = "SELECT c FROM Compte c WHERE c.type = :ptype";
		Query query = em.createQuery(requete);
		query.setParameter("ptype", COMPTE_ADMIN);
		return (Compte) query.getSingleResult();
	}

}
