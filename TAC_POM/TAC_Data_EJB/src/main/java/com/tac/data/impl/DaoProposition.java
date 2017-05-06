
package com.tac.data.impl;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.tac.data.api.IDaoProposition;
import com.tac.entity.Proposition;
import com.tac.exception.DataAccessException;

@Remote(IDaoProposition.class)
@Stateless
public class DaoProposition implements IDaoProposition {

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

	@SuppressWarnings("unchecked")
	@Override
	public Proposition getById(int idProposition) throws DataAccessException {
		final String req = "SELECT p FROM Proposition p LEFT JOIN FETCH p.categorie LEFT JOIN FETCH p.photos WHERE p.idProposition = :pid";
		Query query = em.createQuery(req);
		query.setParameter("pid", idProposition);
		List<Proposition> propositions = query.getResultList();
		Proposition retour = null;
		if (!propositions.isEmpty()) {
			retour = propositions.get(0);
		} else {
			throw new DataAccessException("Aucun objet trouvé");
		}
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
	public List<Proposition> getNouveautes(int nombre) {
		final String req = "SELECT DISTINCT p FROM Proposition p LEFT JOIN FETCH p.categorie LEFT JOIN FETCH p.photos WHERE p.dateSuppression IS NULL ORDER BY p.dateAjout DESC";
		Query query = em.createQuery(req);
		query.setMaxResults(nombre);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Proposition> getPropDispo() {
		final String req = "SELECT p.id_proposition, p.intitule, p.categorie_id, p.description, p.date_ajout, p.date_suppression, p.etat_id, p.membre_id, p.sous_categorie_id, p.valeur_id FROM proposition p left JOIN echange e on e.proposition_id=p.id_proposition where e.date_validation is null and p.date_suppression is null";
		Query query = em.createNativeQuery(req);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Proposition> getPropoDispoByMembre(int idMembre) {
		final String req = "SELECT p.id_proposition, p.intitule, p.categorie_id, p.description, p.date_ajout, p.date_suppression, p.etat_id, p.membre_id, p.sous_categorie_id, p.valeur_id FROM proposition p left JOIN echange e on e.proposition_id=p.id_proposition where e.date_validation is null and p.date_suppression is null and p.membre_id=:pid";
		Query query = em.createNativeQuery(req, Proposition.class);
		query.setParameter("pid", idMembre);
		return query.getResultList();
	}

}
