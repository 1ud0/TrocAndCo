package com.tac.data.impl;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.tac.data.api.IDaoFavori;
import com.tac.entity.Localisation;
import com.tac.entity.Membre;
import com.tac.entity.Photo;
import com.tac.entity.Proposition;

@Remote(IDaoFavori.class)
@Stateless
public class DaoFavori implements IDaoFavori {

	@PersistenceContext(unitName = "TAC_Data_EJB")
	EntityManager em;

	@Override
	public Proposition addFavori(Proposition proposition, Membre membre) {
		String req = "INSERT INTO Favori (membre_id, proposition_id) values (:pidMembre, :pidProposition)";
		Query query = em.createNativeQuery(req);
		query.setParameter("pidMembre", membre.getIdMembre()).setParameter("pidProposition",
				proposition.getIdProposition());
		query.executeUpdate();
		return proposition;
	}

	@Override
	public void deleteFavori(Proposition proposition, Membre membre) {
		String req = "DELETE FROM Favori  WHERE Membre_id = :pidMembre " + "AND Proposition_id = :pidProposition";
		Query query = em.createNativeQuery(req);
		query.setParameter("pidMembre", membre.getIdMembre()).setParameter("pidProposition",
				proposition.getIdProposition());
		query.executeUpdate();

	}

	@Override
	public void deleteAllFavori(Proposition proposition) {
		String req = "DELETE FROM Favori  WHERE Proposition_id = :pidProposition ";
		Query query = em.createNativeQuery(req);
		query.setParameter("pidProposition", proposition.getIdProposition());
		query.executeUpdate();

	}

	@Override
	public List<Proposition> getFavorisByMembre(Membre membre) {
		membre = em.merge(membre);
		List<Proposition> propositions = membre.getFavoris();
		if (propositions != null) {
			for (Proposition p : propositions) {
				List<Localisation> localisations = p.getLocalisations();
				List<Photo> photos = p.getPhotos();
				localisations.size();
				photos.size();
			}
		}
		return propositions;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean isAlreadyFavorite(Proposition proposition, Membre membre) {
		final String requete = "SELECT m FROM Membre m WHERE :prop MEMBER OF m.favoris AND m.idMembre = :pid";
		Query query = em.createQuery(requete);
		query.setParameter("prop", proposition).setParameter("pid", membre.getIdMembre());
		List<Membre> membres = query.getResultList();
		if (membres.size() > 0) {
			return true;
		} else {
			return false;
		}
	}

}
