
package com.tac.data.impl;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.tac.data.api.IDaoProposition;
import com.tac.entity.Categorie;
import com.tac.entity.Localisation;
import com.tac.entity.Proposition;
import com.tac.exception.DataAccessException;
import com.tac.util.CritereSearch;

@Remote(IDaoProposition.class)
@Stateless
public class DaoProposition implements IDaoProposition {

	public static final String QUERY_PROP_DISPO = 
			"SELECT DISTINCT p.id_proposition, p.intitule, p.categorie_id, p.description, p.date_ajout, p.date_suppression, p.etat_id, p.membre_id, p.sous_categorie_id, p.valeur_id"
			+ " FROM proposition p"
			+ " WHERE NOT EXISTS (SELECT e.id_echange FROM echange e WHERE e.date_validation IS NOT NULL AND e.proposition_id = p.id_proposition)"
			+ " AND p.date_suppression IS NULL";

	
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
			List<Localisation> locs  = retour.getLocalisations();
			locs.size();
		} else {
			throw new DataAccessException("Aucun objet trouvé");
		}
		return retour;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Proposition> getByMembre(int idMembre) {
		final String req = "SELECT DISTINCT p FROM Proposition p LEFT JOIN FETCH p.photos WHERE p.membre.idMembre = :pid";
		Query query = em.createQuery(req);
		query.setParameter("pid", idMembre);
		List<Proposition> props = query.getResultList();
		for (Proposition prop : props) {
			List<Localisation> locs = prop.getLocalisations();
			locs.size();
		}
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Proposition> getPropDispo() {
		Query query = em.createNativeQuery(QUERY_PROP_DISPO, Proposition.class);
		return query.getResultList();
	}
	


	@SuppressWarnings("unchecked")
	@Override
	public List<Proposition> getNouveautes(int nombre, Integer idMembre) {
		StringBuilder req = new StringBuilder();
		req.append("SELECT DISTINCT p FROM Proposition p LEFT JOIN FETCH p.categorie LEFT JOIN FETCH p.photos WHERE p.dateSuppression IS NULL");
		if (idMembre != null && idMembre != 0) {
			req.append(" AND p.membre.idMembre != :pid");
		}
		req.append(" ORDER BY p.dateAjout DESC");
		Query query = em.createQuery(req.toString());
		if (idMembre != null && idMembre != 0) {
			query.setParameter("pid", idMembre);
		}
		query.setMaxResults(nombre);
		return query.getResultList();
	}
	
	////////////////Test_Ayda
	@SuppressWarnings("unchecked")
	@Override
	public List<Proposition> LoadAllPropositions() {
		final String req = "SELECT DISTINCT p FROM Proposition p LEFT JOIN FETCH p.categorie LEFT JOIN FETCH p.photos WHERE p.membre.dateRadiation IS NULL";
		Query query = em.createQuery(req);
		return query.getResultList();
	}
	
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Proposition> getPropoDispoByMembre(int idMembre) {
        final String req = QUERY_PROP_DISPO + " AND p.membre_id = :pid";
		Query query = em.createNativeQuery(req, Proposition.class);
		query.setParameter("pid", idMembre);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Proposition> rechercher(CritereSearch carac, Integer idMembre, int nombreResult) {
		String requete = constructQuery(carac, idMembre);
		Query query = setParam(requete, carac, idMembre);
		if (nombreResult != 0) {
			query.setMaxResults(nombreResult);
		}
		List<Proposition> props = query.getResultList();
		for (Proposition proposition : props) {
			List<Localisation> locs = proposition.getLocalisations();
			locs.size();
		}
 		return query.getResultList();
	}

	//methode pour set les paramètres de la requete
	private Query setParam(String requete, CritereSearch carac, Integer idMembre) {
		Query query = em.createQuery(requete);
		//clause id membre
		if (idMembre != null) {
			query.setParameter("pid", idMembre);
		}
		//clause intitule
		List<String> keywords = carac.getKeyWords();
		if (keywords.size() != 0) {
			for (int i = 0; i < keywords.size(); i++) {
				query.setParameter("pword" + i, "%" + keywords.get(i) + "%");
			}
		}
		//clause departement
		String departement = carac.getDepartement();
		if (departement != null && !carac.getDepartement().equals("0") && carac.getLieux().size() == 0) {
			query.setParameter("pdep", departement + "%");
		}
		//clause etat
		Integer etat = carac.getEtatCast();
		if (etat != null && etat != 0) {
			query.setParameter("petat", etat);
		}
		//clause valeur
		List<Integer> valeurs = carac.getValeursCast();
		for (int i = 0; i < valeurs.size(); i++) {
			query.setParameter("pval" + i, valeurs.get(i));
		}
		//clause adresse + dist max
		if (carac.getLocalisations() != null && carac.getLocalisations().size() != 0 && carac.getRayonRecherche() != 0) {
			addParamLocalize(query, carac);
		}
		//clause categorie
		Categorie cat = carac.getCat();
		if (cat != null) {
			query.setParameter("pcat", cat.getIdCategorie());
		}
		//clause sous categorie
		Categorie sousCat = carac.getSousCat();
		if (sousCat != null) {
			query.setParameter("psscat", sousCat.getIdCategorie());
		}
		return query;
	}

	

	//methode pour contruire la query en fonction de l'objet carac
	private String constructQuery(CritereSearch carac, Integer idMembre) {
		StringBuilder requete = new StringBuilder();
		requete.append("SELECT DISTINCT p FROM Proposition p LEFT JOIN FETCH p.photos WHERE NOT EXISTS (SELECT e FROM Echange e WHERE e.dateValidation IS NOT NULL AND e.proposition = p) AND p.membre.dateRadiation IS NULL AND p.membre.dateDesinscription IS NULL AND p.dateSuppression IS NULL");
		//clause id membre
		if (idMembre != null) {
			requete.append(" AND p.membre.idMembre != :pid");
		}
		//clause intitule
		if (carac.getKeyWords().size() != 0) {
			addClauseLike(carac.getKeyWords(), requete);
		}
		//clause departement
		if (carac.getDepartement() != null && !carac.getDepartement().equals("0") && carac.getLieux().size() == 0) {
			requete.append(" AND EXISTS (SELECT loc FROM Localisation loc WHERE loc.codePostal LIKE :pdep AND p MEMBER OF loc.proposedHere)");
		}
		//clause etat
		Integer etat = carac.getEtatCast();
		if (etat != null && etat != 0) {
			requete.append(" AND p.etat.idEtat = :petat");
		}
		//clause valeur
		int nbValeurs = carac.getValeursCast().size();
		if (nbValeurs != 0) {
			requete.append(" AND p.valeur.idValeur IN (");
			for (int i = 0; i < nbValeurs; i++) {
				if (i != 0) {
					requete.append(", ");
				}
				requete.append(":pval").append(i);
			}
			requete.append(")");
		}
		
		//clause adresse + dist max
		if (carac.getLocalisations() != null && carac.getLocalisations().size() != 0 && carac.getRayonRecherche() != 0) {
			addClauseLocalize(requete, carac);
		}
		//clause categorie
		if (carac.getCat() != null) {
			requete.append(" AND p.categorie.idCategorie = :pcat");
		}
		//clause sous categorie
		if (carac.getSousCat() != null) {
			requete.append(" AND p.sousCategorie.idCategorie = :psscat");
		}
		return requete.toString();
	}

	private void addClauseLocalize(StringBuilder requete, CritereSearch carac) {
		requete.append(" AND EXISTS (SELECT loc FROM Localisation loc WHERE p MEMBER OF loc.proposedHere AND (");
		int nbLocs = carac.getLocalisations().size();
		for (int i = 0; i < nbLocs; i++) {
			if (i != 0) {
				requete.append(" OR");
			}
			requete.append(" (loc.latitude BETWEEN :pltinf").append(i).append(" AND :pltsup").append(i);
			requete.append(" AND loc.longitude BETWEEN :plginf").append(i).append(" AND :plgsup").append(i).append(")");
		}
		requete.append("))");
	}
	
	private void addParamLocalize(Query query, CritereSearch carac) {
		List<Localisation> locs = carac.getLocalisations();
		Float distance = carac.getRayonRecherche();
		Localisation loc;
		for(int i = 0; i < locs.size(); i++) {
			loc = locs.get(i);
			query.setParameter("pltinf" + i, loc.getLatitude() - distance);
			query.setParameter("pltsup" + i, loc.getLatitude() + distance);
			query.setParameter("plginf" + i, loc.getLongitude() - distance);
			query.setParameter("plgsup" + i, loc.getLongitude() + distance);
		}
	}

	private void addClauseLike(List<String> keywords, StringBuilder requete) {
		for (int i = 0; i < keywords.size(); i++) {
			if (i == 0) {
				requete.append(" AND (");
			} else {
				requete.append(" OR");
			}
			requete.append(" p.intitule LIKE :pword").append(i);
		}
		requete.append(")");
	}

	@Override
	public long getNbPropDispo() {
		final String requete = "SELECT COUNT(p.idProposition) FROM Proposition p WHERE NOT EXISTS (SELECT e FROM Echange e WHERE e.dateValidation IS NOT NULL AND e.proposition = p) AND p.membre.dateRadiation IS NULL AND p.membre.dateDesinscription IS NULL AND p.dateSuppression IS NULL";
		Query query = em.createQuery(requete);
		try {
			return (long)query.getSingleResult();
		} catch (Exception e) {
			return 0;
		}
	}

	@SuppressWarnings({ "unchecked", "unused" })
	@Override
	public List<Object[]> getAllPropsByCatMere() {
		final String req = "SELECT p.categorie, COUNT(*) FROM Proposition p GROUP BY p.categorie";
		Query query = em.createQuery(req);
		 List<Object[]> bob = query.getResultList();
		 for (Object[] objects : bob) {
			 Categorie categorie = (Categorie) objects[0];
			 Long count = (Long) objects[1];
		}
		return query.getResultList();

	}

	@SuppressWarnings({ "unchecked", "unused" })
	@Override
	public List<Object[]> getAllPropsByMois() {
		final String req = "SELECT COUNT(p.idProposition), DATE_FORMAT(p.dateAjout,'%m/%Y') FROM Proposition p GROUP BY DATE_FORMAT(p.dateAjout,'%m/%Y') ORDER BY p.dateAjout";
		Query query = em.createQuery(req);
		List<Object[]> bob = query.getResultList();
		 for (Object[] objects : bob) {
			 Long count = (Long) objects[0];
			 String mois = (String) objects[1];
		}
		return query.getResultList();
	}



	
	

}
