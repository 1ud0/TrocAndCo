package com.tac.data.impl;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.tac.data.api.IDaoEchange;
import com.tac.entity.Echange;
import com.tac.entity.Membre;
import com.tac.entity.Proposition;

@Remote(IDaoEchange.class)
@Stateless
public class DaoEchange implements IDaoEchange {

	@PersistenceContext(unitName = "TAC_Data_EJB")
	EntityManager em;

	@Override
	public Echange addEchange(Echange newChange) {
		em.persist(newChange);
		return newChange;
	}

	@Override
	public Echange updateEchange(Echange change) {
		em.merge(change);
		return change;
	}

	@Override
	public void deleteEchange(Echange changeToDelete) {
		em.remove(em.merge(changeToDelete));
	}

	@Override
	public Echange getByNumero(Integer numero) {
		final String reqGetByNum = "SELECT e FROM Echange e WHERE e.idEchange = :pnumero";
		Query queryGetByNum = em.createQuery(reqGetByNum);
		queryGetByNum.setParameter("pnumero", numero);
		Echange selectedchange = (Echange) queryGetByNum.getSingleResult();
		return selectedchange;
	}

	@Override
	public List<Echange> getByMembre(Integer idMembre) {
		List<Echange> allChanges = getByMembreChercheur(idMembre);
		for (Echange echange : getByMembreDonneur(idMembre)) {
			allChanges.add(echange);
		}
		return allChanges;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Echange> getByMembreDonneur(Integer idMembreDonneur) {
		final String reqGetByMemberId = "SELECT e FROM Echange e WHERE e.proposition.membre.idMembre= :pidMembreDonneur ORDER BY e.dateinit desc";
		Query queryGetByIdMembreDonneur = em.createQuery(reqGetByMemberId);
		queryGetByIdMembreDonneur.setParameter("pidMembreDonneur", idMembreDonneur);
		List<Echange> echangesDuDonneur = queryGetByIdMembreDonneur.getResultList();
		for(Echange echange : echangesDuDonneur){
			echange.getRdvs().size();
		}
		return echangesDuDonneur;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Echange> getByMembreDonneurDateAcceptNull(Membre membre){
		final String reqGetByMemberId = "SELECT e FROM Echange e WHERE e.proposition.membre= :MembreDonneur AND e.dateAcceptation IS NULL AND e.dateRefus IS NULL AND e.dateAnnul IS NULL";
		Query queryGetByIdMembreDonneur = em.createQuery(reqGetByMemberId);
		queryGetByIdMembreDonneur.setParameter("MembreDonneur", membre);
		return queryGetByIdMembreDonneur.getResultList(); 
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Echange> getByMembreDonneurChercheurDateAcceptNull(Integer idMembre){
        final String reqGetByMemberId = "SELECT e FROM Echange e WHERE (e.proposition.membre.idMembre= :pidMembre OR e.membre.idMembre = :pidMembre) AND e.dateValidation IS NULL AND e.dateRefus IS NULL AND e.dateAnnul IS NULL";
		Query queryGetByIdMembre = em.createQuery(reqGetByMemberId);
		queryGetByIdMembre.setParameter("pidMembre", idMembre);
		List<Echange> echanges = queryGetByIdMembre.getResultList(); 
		for (Echange echange : echanges) {
			echange.getProposition().getPhotos().size();
		}
		return echanges;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Echange> getByMembreChercheur(Integer idMembreChercheur) {
		final String reqGetByMemberId = "SELECT e FROM Echange e WHERE e.membre.idMembre= :pidMembre ORDER BY e.dateinit desc";
		Query queryGetByIdMembreChercheur = em.createQuery(reqGetByMemberId);
		queryGetByIdMembreChercheur.setParameter("pidMembre", idMembreChercheur);
		List<Echange> echangesDuChercheur = queryGetByIdMembreChercheur.getResultList();
		for(Echange echange : echangesDuChercheur){
			echange.getRdvs().size();
			echange.getProposition().getPhotos().size();
		}
		return echangesDuChercheur;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Double getNoteMoyenneMembre(Integer idMembre) {
		final String reqGetMoyNote = "SELECT e FROM Echange e WHERE (e.proposition.membre.idMembre= :pidMembre AND e.noteDonneur IS NOT NULL) OR (e.membre.idMembre = :pidMembre AND e.noteChercheur IS NOT NULL)";
		Query queryGetMoyNote = em.createQuery(reqGetMoyNote);
		queryGetMoyNote.setParameter("pidMembre", idMembre);
		List<Echange> echangesDuMembre = queryGetMoyNote.getResultList();
		Double totalNote = 0.0;
		for (Echange echange : echangesDuMembre) {
			if (echange.getMembre().getIdMembre() == idMembre) {
				totalNote = totalNote + echange.getNoteChercheur();
			} else {
				totalNote = totalNote + echange.getNoteDonneur();
			}
		}
		Double noteMoyenne;
		if (echangesDuMembre.size() == 0) {
			noteMoyenne = -1.0;
		} else {
			noteMoyenne = totalNote / (double) echangesDuMembre.size();
		}
		noteMoyenne = noteMoyenne * 10;
		noteMoyenne = (double) Math.round(noteMoyenne);
		noteMoyenne = noteMoyenne / 10;
		return noteMoyenne;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Echange> getAllEchangeFini() {
		final String req = "SELECT e FROM Echange e WHERE e.dateValidation IS NOT NULL";
		Query query = em.createQuery(req);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public int getTotalEchangeAvecNote(Integer idMembre) {
		final String reqGetMoyNote = "SELECT e FROM Echange e WHERE (e.proposition.membre.idMembre= :pidMembre AND e.noteDonneur IS NOT NULL) OR (e.membre.idMembre = :pidMembre AND e.noteChercheur IS NOT NULL)";
		Query queryGetMoyNote = em.createQuery(reqGetMoyNote);
		queryGetMoyNote.setParameter("pidMembre", idMembre);
		List<Echange> echangesDuMembre = queryGetMoyNote.getResultList();
		return echangesDuMembre.size();
	}

	@SuppressWarnings("unchecked")
	@Override
	public int[] getToutesLesNotes(int idMembre) {
		final String reqGetMoyNote = "SELECT e FROM Echange e WHERE (e.proposition.membre.idMembre= :pidMembre AND e.noteDonneur IS NOT NULL) OR (e.membre.idMembre = :pidMembre AND e.noteChercheur IS NOT NULL)";
		Query queryGetMoyNote = em.createQuery(reqGetMoyNote);
		queryGetMoyNote.setParameter("pidMembre", idMembre);
		List<Echange> echangesDuMembre = queryGetMoyNote.getResultList();
		int[] tableauNote = new int[echangesDuMembre.size()];
		int i = 0;
		for (Echange echange : echangesDuMembre) {
			if (echange.getMembre().getIdMembre() == idMembre) {
				tableauNote[i] = echange.getNoteChercheur();

			} else {
				tableauNote[i] = echange.getNoteDonneur();

			}
			i = i + 1;
		}

		return tableauNote;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Echange> getByMembreDonneurFini(Integer idMembreDonneur) {
		final String reqGetByMemberId = "SELECT e FROM Echange e WHERE e.proposition.membre.idMembre= :pidMembreDonneur AND e.noteDonneur IS NOT NULL";
		Query queryGetByIdMembreDonneur = em.createQuery(reqGetByMemberId);
		queryGetByIdMembreDonneur.setParameter("pidMembreDonneur", idMembreDonneur);
		List<Echange> echangesDuDonneur = queryGetByIdMembreDonneur.getResultList();
		return echangesDuDonneur;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Echange> getByMembreChercheurFini(Integer idMembreChercheur) {
		final String reqGetByMemberId = "SELECT e FROM Echange e WHERE e.membre.idMembre= :pidMembre AND e.noteChercheur IS NOT NULL";
		Query queryGetByIdMembreChercheur = em.createQuery(reqGetByMemberId);
		queryGetByIdMembreChercheur.setParameter("pidMembre", idMembreChercheur);
		List<Echange> echangesDuChercheur = queryGetByIdMembreChercheur.getResultList();
		return echangesDuChercheur;
	}

	@SuppressWarnings("unchecked")
	@Override
	public int getCreditEnMoins(Integer idMembre) {
		final String reqGetByMemberId = "SELECT e FROM Echange e WHERE e.membre.idMembre= :pidMembre AND e.dateValidation IS NOT NULL";
		Query queryGetByIdMembreChercheur = em.createQuery(reqGetByMemberId);
		queryGetByIdMembreChercheur.setParameter("pidMembre", idMembre);
		List<Echange> echangesDuChercheur = queryGetByIdMembreChercheur.getResultList();
		int credit = 0;
		for (Echange echange : echangesDuChercheur) {
			if (echange.getPrix() != null) {
				credit = credit - echange.getPrix();
			}
			
		}

		return credit;
	}

	@SuppressWarnings("unchecked")
	@Override
	public int getCreditEnPlus(Integer idMembre) {
		final String reqGetByMemberId = "SELECT e FROM Echange e WHERE e.proposition.membre.idMembre= :pidMembreDonneur AND e.dateValidation IS NOT NULL";
		Query queryGetByIdMembreDonneur = em.createQuery(reqGetByMemberId);
		queryGetByIdMembreDonneur.setParameter("pidMembreDonneur", idMembre);
		List<Echange> echangesDuDonneur = queryGetByIdMembreDonneur.getResultList();
		int credit = 0;
		for (Echange echange : echangesDuDonneur) {
			credit = credit + echange.getPrix();
		}

		return credit;
	}

	@Override
	public Proposition getbyEchange(Echange echange) {
		final String req = "SELECT e.proposition FROM Echange e WHERE e.idEchange = :pidEchange";
		Query query = em.createQuery(req);
		query.setParameter("pidEchange", echange.getIdEchange());
		return (Proposition) query.getSingleResult();
	}

	@Override
	public Echange getEchangeByProp(Proposition proposition) {
		final String req = "SELECT e FROM Echange e WHERE e.proposition.idProposition = :pidProposition";
		Query query = em.createQuery(req);
		query.setParameter("pidProposition", proposition.getIdProposition());
		return (Echange) query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Echange> getAll() {
		final String req = "SELECT e FROM Echange e ";
		Query query = em.createQuery(req);
		return query.getResultList();
	}

	@Override
	public long getNbEchangesFinis() {
		final String req = "SELECT COUNT(e.idEchange) FROM Echange e WHERE e.dateValidation IS NOT NULL";
		Query query = em.createQuery(req);
		try {
			return (long) query.getSingleResult();
		} catch (Exception e) {
			return 0;
		}
	}

}
