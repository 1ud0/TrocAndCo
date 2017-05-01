package com.tac.data.impl;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.tac.data.api.IDaoEnvie;
import com.tac.data.api.IDaoTag;
import com.tac.entity.Envie;
import com.tac.entity.Proposition;

@Remote(IDaoEnvie.class)
@Stateless
public class DaoEnvie implements IDaoEnvie {
	
	@PersistenceContext(unitName = "TAC_Data_EJB")
	private EntityManager em;

	@Override
	public Envie addEnvie(Envie envie) {
		em.persist(envie);
		return envie;
	}

	@Override
	public void deleteEnvie(Envie envie) {
		em.remove(envie);
		
	}

	@Override
	public Envie getById(int idEnvie) {
		String req = "SELECT e FROM Envie e WHERE e.idEnvie = :eid";
		Query query = em.createQuery(req);
		query.setParameter("eid", idEnvie);
		Envie retour = (Envie)query.getSingleResult();
		
		return retour;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Envie> getByListeId(int idListe) {
		
		String req = "SELECT e from Envie e WHERE e.idListe = :lid";
		Query query = em.createQuery(req);
		query.setParameter("lid", idListe);
		return query.getResultList();
	}
	
	

}
