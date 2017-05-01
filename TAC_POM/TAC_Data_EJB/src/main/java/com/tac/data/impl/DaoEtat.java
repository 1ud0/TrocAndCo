package com.tac.data.impl;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.tac.data.api.IDaoEtat;
import com.tac.entity.Etat;

@Remote(IDaoEtat.class)
@Stateless
public class DaoEtat implements IDaoEtat {

	@PersistenceContext(unitName = "TAC_Data_EJB")
	private EntityManager em;

	@Override
	public Etat addEtat(Etat etat) {
		em.persist(etat);
		return etat;
	}

	@Override
	public Etat updateEtat(Etat etat) {
		em.merge(etat);
		return etat;
	}

	@Override
	public void deleteEtat(Etat etat) {
		em.remove(etat);

	}

	@Override
	public Etat getById(int idEtat) {
		String req = "SELECT e FROM Etat e WHERE e.idEtat like :pid";
		Query query = em.createQuery(req);
		query.setParameter("pid", idEtat);
		Etat retour = (Etat)query.getSingleResult();
		return retour;
	}

}
