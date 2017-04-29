package com.tac.data.impl;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.tac.data.api.IDaoRdv;
import com.tac.entity.Rdv;

@Remote(IDaoRdv.class)
public class DaoRdv implements IDaoRdv{
	
	@PersistenceContext(unitName = "TAC_Data_EJB")
	private EntityManager em;
	@SuppressWarnings("unchecked")

	@Override
	public Rdv addRdv(Rdv rdv) {
		em.persist(rdv);
		return rdv;
	}

	@Override
	public Rdv updateRdv(Rdv rdv) {
		em.merge(rdv);
		return rdv;
	}

	@Override
	public void deleteRdv(Rdv rdv) {
		em.remove(em.merge(rdv));
	}

	@Override
	public List<Rdv> getByMembreId(Integer IdMembre) {
		final String req = "SELECT r FROM RDV r WHERE r.id = :prdv";	
		Query query = em.createQuery(req).setParameter("prdv", rdv.);
		return query.getResultList();
	}

}
