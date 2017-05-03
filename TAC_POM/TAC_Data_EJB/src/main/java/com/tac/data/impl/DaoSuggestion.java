package com.tac.data.impl;

import java.util.List;


import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.tac.data.api.IDaoSuggestion;
import com.tac.entity.Suggestion;

@Remote(IDaoSuggestion.class)
@Stateless
public class DaoSuggestion implements IDaoSuggestion {

	@PersistenceContext(unitName="TAC_Data_EJB")
	EntityManager em;
	
	@Override
	public Suggestion addSuggestion(Suggestion suggestion) {
		em.persist(suggestion);
		return suggestion;
	}

	@Override
	public void deleteSuggestion(Suggestion suggestion) {
		em.remove(em.merge(suggestion));

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Suggestion> getSuggestionsByIdMembre(int idMembre) {
		String req = "SELECT s FROM Suggestion s WHERE s.membre.idMembre = :pid";
		Query query = em.createQuery(req);
		query.setParameter("pid", idMembre);
		
		return query.getResultList();
	}

}
