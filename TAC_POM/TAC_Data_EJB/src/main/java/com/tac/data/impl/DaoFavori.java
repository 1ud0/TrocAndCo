package com.tac.data.impl;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.tac.data.api.IDaoFavori;
import com.tac.entity.Membre;
import com.tac.entity.Proposition;

@Remote(IDaoFavori.class)
@Stateless
public class DaoFavori implements IDaoFavori {

	@PersistenceContext(unitName = "TAC_Data_EJB")
	EntityManager em;

	@Override
	public Proposition addFavori(Proposition proposition, Membre membre) {
		String req = "INSERT INTO Favori (Membre_idMembre, Proposition_idProposition) values (:pidMembre, :pidProposition)";
		Query query = em.createQuery(req);
		query.setParameter("pidMembre", membre.getIdMembre()).setParameter("pidProposition",
				proposition.getIdProposition());
		query.executeUpdate();
		return proposition;
	}

	@Override
	public void deleteFavori(Proposition proposition, Membre membre) {
		String req = "DELETE FROM Favori  WHERE Membre_idMembre = :pidMembre "
				+ "AND Proposition_idProposition = :pidProposition";
		Query query = em.createQuery(req);
		query.setParameter("pidMembre", membre.getIdMembre()).setParameter("pidProposition",
				proposition.getIdProposition());
		query.executeUpdate();


	}

	@Override
	public void deleteAllFavori(Proposition proposition) {
		String req = "DELETE FROM Favori  WHERE Proposition_idProposition = :pidProposition ";
		Query query = em.createQuery(req);
		query.setParameter("pidProposition", proposition.getIdProposition());
		query.executeUpdate();

	}

	
	@Override
	public List<Proposition> getFavorisByMembre(Membre membre) {
		
		return membre.getFavoris();
		
	}

}
