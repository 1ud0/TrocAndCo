package com.tac.data.impl;

import java.util.List;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import com.tac.data.api.IDaoListe;
import com.tac.entity.Liste;

@Remote(IDaoListe.class)
@Stateless
public class DaoListe implements IDaoListe{

	@PersistenceContext(unitName = "TAC_Data_EJB")
	private EntityManager em;
	
	@Override
	public Liste addListe(Liste liste) {
		em.persist(liste);
		return liste;
	}

	@Override
	public Liste updateListe(Liste newListe) {
		em.merge(newListe);
		return newListe;
	}

	@Override
	public boolean deleteListe(Integer id) {
		em.remove(em.merge(id));
		return true;
	}

	@Override
	public Liste getById(Integer id) {
		final String reqGetById = "SELECT l FROM Liste l WHERE l.id = :pid";
		Query queryGetById = em.createQuery(reqGetById);
		queryGetById.setParameter("pid", id);
		Liste listetById = (Liste) queryGetById.getSingleResult();
		return listetById;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Liste> getByMembreId(Integer idMembre) {
		final String req = "SELECT DISTINCT l FROM Liste l LEFT JOIN FETCH l.envies WHERE l.membre.idMembre = :pid";
		Query query = em.createQuery(req);
		query.setParameter("pid", idMembre);
		return query.getResultList();
	}

}
