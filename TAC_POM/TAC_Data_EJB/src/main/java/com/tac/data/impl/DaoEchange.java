package com.tac.data.impl;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.tac.data.api.IDaoEchange;
import com.tac.entity.Echange;

@Remote(IDaoEchange.class)
@Stateless
public class DaoEchange implements IDaoEchange{

	@PersistenceContext(unitName="TAC_Data_EJB")
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
		final String reqGetByNum ="SELECT e FROM Echange WHERE e.idEchange = :pnumero";
		Query queryGetByNum = em.createQuery(reqGetByNum);
		queryGetByNum.setParameter("pnumero", numero);
		Echange Selectedchange = (Echange) queryGetByNum.getSingleResult();
		return Selectedchange;
	}

	@Override
	public List<Echange> getByMembre(Integer idMembre) {
		List<Echange> allChanges = getByMembreChercheur(idMembre);
		for(Echange echange: getByMembreDonneur(idMembre)){
			allChanges.add(echange);
		}
		return allChanges;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Echange> getByMembreDonneur(Integer idMembreDonneur) {
		final String reqGetByMemberId="SELECT e FROM Echange WHERE e.proposition.membre.idMembre= :pidMembreDonneur";
		Query queryGetByIdMembreDonneur = em.createQuery(reqGetByMemberId);
		queryGetByIdMembreDonneur.setParameter("pidMembreDonneur", idMembreDonneur);
		List<Echange> echangesDuDonneur = queryGetByIdMembreDonneur.getResultList();
		return echangesDuDonneur;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Echange> getByMembreChercheur(Integer idMembreChercheur) {
		final String reqGetByMemberId="SELECT e FROM Echange WHERE e.membre.idMembre= :pidMembre";
		Query queryGetByIdMembreChercheur = em.createQuery(reqGetByMemberId);
		queryGetByIdMembreChercheur.setParameter("pidMembre", idMembreChercheur);
		List<Echange> echangesDuChercheur = queryGetByIdMembreChercheur.getResultList();
		return echangesDuChercheur;
	}

	@Override
	public Double getNoteMoyenneMembre(Integer idMembre) {
		// TO DO!!
	return null;
	}

	
}
