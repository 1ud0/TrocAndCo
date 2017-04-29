package com.tac.data.impl;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.tac.data.api.IDaoMembre;
import com.tac.entity.Membre;

@Remote
@Stateless
public class DaoMembre implements IDaoMembre{

	EntityManager em;
	
	@Override
	public Membre identifyMembre(String pseudo, String mdp) {
		final String reqIdentification ="SELECT m FROM Membre m WHERE m.pseudo = :ppseudo AND m.mdp = :pmdp";
		Query queryIdentification = em.createQuery(reqIdentification);
		queryIdentification.setParameter("ppseudo", pseudo);
		queryIdentification.setParameter("pmdp",mdp);
		Membre memberIdentified = (Membre) queryIdentification.getSingleResult();
		return memberIdentified;
	}

	@Override
	public Membre getByPseudo(String Pseudo) {
		final String reqGetByPseudo = "SELECT m FROM Membre m WHERE m.pseudo = :ppseudo";
		Query queryGetByPseudo = em.createQuery(reqGetByPseudo);
		queryGetByPseudo.setParameter("ppseudo", Pseudo);
		Membre membreByPseudo = (Membre) queryGetByPseudo.getSingleResult();
		return membreByPseudo;
	}

	@Override
	public Membre addMembre(Membre newMembre) {
		em.persist(newMembre);			
		return newMembre;
	}

	@Override
	public Membre updateMembre(Membre membre) {
		em.merge(membre);
		return membre;
	}

	@Override
	public Membre getById(Integer id) {
		final String reqGetById = "SELECT m FROM Membre m WHERE m.id = :pid";
		Query queryGetById = em.createQuery(reqGetById);
		queryGetById.setParameter("pid", id);
		Membre membreById = (Membre) queryGetById.getSingleResult();
		return membreById;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Membre> getAll() {
		final String reqGetAll = "SELECT m FROM Membre m";
		Query queryGetAll = em.createQuery(reqGetAll);
		List<Membre> membres= queryGetAll.getResultList();
		return membres;
	}

	@Override
	public void deleteMembre(Membre membreToDelete) {
		//TO DO!!
		
		//final String reqDelete = "DELETE m FROM Membre m WHERE ";
	}

}
