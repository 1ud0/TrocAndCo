package com.tac.data.impl;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.tac.data.api.IDaoProposition;
import com.tac.entity.Proposition;

@Remote(IDaoProposition.class)
@Stateless
public class DaoProposition implements IDaoProposition{

	@PersistenceContext(unitName = "TAC_Data_EJB")
	private EntityManager em;
	
	@Override
	public Proposition addProposition(Proposition proposition) {
		em.persist(proposition);
		return proposition;
	}

	@Override
	public Proposition updateProsition(Proposition proposition) {

		em.merge(proposition);
		return proposition;
	}

	@Override
	public void deleteProposition(Proposition proposition) {
		em.remove(proposition);
	}

	@Override
	public Proposition getById(int idProposition) {
		String req = "SELECT p FROM Proposition p WHERE p.idProposition like :pid";
		Query query = em.createQuery(req);
		query.setParameter("pid", idProposition);
		Proposition retour = (Proposition)query.getSingleResult();
		
		return retour;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Proposition> getByMembre(int idMembre) {
		String req = "SELECT p FROM Proposition p WHERE p.Membre_idMembre like :pid";
		Query query = em.createQuery(req);
		query.setParameter("pid", idMembre);
		return query.getResultList();
	}

	@Override
	public List<Proposition> getPropDispo() {
		
		return null;
	}

	@Override
	public List<Proposition> getNouveautes(int nombre) {
		// TODO Auto-generated method stub
		return null;
	}

}
