package com.tac.data.impl;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.tac.data.api.IDaoLocalisation;
import com.tac.data.api.IDaoMembre;
import com.tac.entity.Localisation;
import com.tac.entity.Membre;
import com.tac.entity.Proposition;

@Remote(IDaoLocalisation.class)
@Stateless
public class DaoLocalisation implements IDaoLocalisation {

	@PersistenceContext(unitName = "TAC_Data_EJB")
	private EntityManager em;
	
	@Override
	public Localisation addLocalisation(Localisation loc) {
		em.persist(loc);
		return loc;
	}

	@Override
	public Localisation updateLocalisation(Localisation loc) {
		em.merge(loc);
		return loc;
	}

	@Override
	public void deleteLocalisation(Localisation loc) {
		em.remove(em.merge(loc));
	}

	@Override
	public Localisation getById(Integer id) {
		final String req = "SELECT l FROM Localisation l WHERE l.idLocalisation = :pid";
		Query query = em.createQuery(req).setParameter("pid", id);
		Localisation localisation = (Localisation)query.getSingleResult();
		return localisation;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Localisation> getMembreLocalisations(Integer id) {
		
		final String req = "SELECT l FROM Localisation l WHERE l.membre.idMembre = :pid";
		Query query = em.createQuery(req).setParameter("pid", id);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Localisation> getPropositionLocalisations(Proposition proposition) {
		String req = "SELECT p.localisations FROM Proposition p WHERE p.idProposition = :pid";
		Query query = em.createQuery(req).setParameter("pid", proposition.getIdProposition());
		return query.getResultList();
	}

}
