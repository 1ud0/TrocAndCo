package com.tac.data.impl;

import java.util.List;

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
		em.remove(em.merge(etat));

	}

	@Override
	public Etat getById(int idEtat) {
		String req = "SELECT e FROM Etat e WHERE e.idEtat = :pid";
		Query query = em.createQuery(req);
		query.setParameter("pid", idEtat);
		Etat retour = (Etat)query.getSingleResult();
		return retour;
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Etat> getAllEtat() {
		String req="SELECT e FROM Etat e";
		Query query = em.createQuery(req);
		return query.getResultList();
	}

}
