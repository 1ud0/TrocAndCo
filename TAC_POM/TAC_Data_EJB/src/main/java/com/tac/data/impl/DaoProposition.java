
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
	public Proposition updateProposition(Proposition proposition) {

		em.merge(proposition);
		return proposition;
	}

	@Override
	public void deleteProposition(Proposition proposition) {
		em.remove(em.merge(proposition));
	}

	@Override
	public Proposition getById(int idProposition) {
		final String req = "SELECT p FROM Proposition p WHERE p.idProposition = :pid";
		Query query = em.createQuery(req);
		query.setParameter("pid", idProposition);
		Proposition retour = (Proposition)query.getSingleResult();
		
		return retour;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Proposition> getByMembre(int idMembre) {
		final String req = "SELECT p FROM Proposition p WHERE p.membre.idMembre = :pid";
		Query query = em.createQuery(req);
		query.setParameter("pid", idMembre);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Proposition> getPropDispo() {
		final String req = "SELECT p FROM Proposition p WHERE SIZE(p.echanges)=0";
		Query query = em.createQuery(req);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Proposition> getNouveautes(int nombre) {
		final String req = "SELECT DISTINCT p FROM Proposition p LEFT JOIN FETCH p.categorie LEFT JOIN FETCH p.photos ORDER BY p.dateAjout DESC";
		Query query = em.createQuery(req);
		query.setMaxResults(nombre);
		return query.getResultList();
	}

}
