package com.tac.data.impl;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.tac.data.api.IDaoValeur;
import com.tac.entity.Valeur;

@Remote(IDaoValeur.class)
@Stateless
public class DaoValeur implements IDaoValeur{
	
	@PersistenceContext(unitName="TAC_Data_EJB")
	private EntityManager em;

	@Override
	public Valeur addValeur(Valeur valeur) {
		em.persist(valeur);
		return valeur;
	}

	@Override
	public Valeur updateValeur(Valeur valeur) {
		em.merge(valeur);
		return valeur;
	}

	@Override
	public void deleteValeur(Valeur valeur) {
		em.remove(em.merge(valeur));		
	}

	@Override
	public Valeur getById(int idValeur) {
		String req ="SELECT v FROM Valeur v WHERE v.idValeur = :pid";
		Query query = em.createQuery(req);
		query.setParameter("pid", idValeur);
		Valeur retour = (Valeur)query.getSingleResult();
		return retour;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Valeur> getAllValeur() {
		String req ="SELECT v FROM Valeur v";
		Query query = em.createQuery(req);	
		List<Valeur> valeurs = query.getResultList();
		return valeurs;
	}

}
