package com.tac.data.impl;


import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.tac.data.api.IDaoFavori;
import com.tac.data.api.IDaoLocaliser;
import com.tac.entity.Localisation;
import com.tac.entity.Proposition;

@Remote(IDaoLocaliser.class)
@Stateless
public class DaoLocaliser implements IDaoLocaliser {

	@PersistenceContext(unitName = "TAC_Data_EJB")
	EntityManager em;


	@Override
	public void addLocaliser(Proposition proposition, Localisation localisation) {
		String req = "INSERT INTO Localiser (localisation_id, proposition_id) VALUES (:pidLocalisation, :pidProposition)";
		Query query = em.createNativeQuery(req);
		query.setParameter("pidLocalisation", localisation.getIdLocalisation());
		query.setParameter("pidProposition", proposition.getIdProposition());
		query.executeUpdate();		
	}

	@Override
	public void deleteFavori(Proposition proposition, Localisation localisation) {
		String req = "DELETE FROM Localiser  WHERE localisation_id = :pidLocalisation AND proposition_id = :pidProposition";
		Query query = em.createNativeQuery(req);
		query.setParameter("pidLocalisation", localisation.getIdLocalisation());
		query.setParameter("pidProposition", proposition.getIdProposition());
		query.executeUpdate();		
	}

}
