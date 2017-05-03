package com.tac.data.impl;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.tac.data.api.IDaoMembre;
import com.tac.entity.Membre;

@Remote(IDaoMembre.class)
@Stateless
public class DaoMembre implements IDaoMembre{

	@PersistenceContext(unitName="TAC_Data_EJB")
	EntityManager em;
	
	@Override
	public Membre identifyMembre(String mail, String mdp) {
		final String reqIdentification ="SELECT m FROM Membre m WHERE m.mail = :pmail AND m.password = :pmdp";
		Query queryIdentification = em.createQuery(reqIdentification);
		queryIdentification.setParameter("pmail", mail);
		queryIdentification.setParameter("pmdp",mdp);
		Membre memberIdentified = null;		
		try{
			memberIdentified = (Membre) queryIdentification.getSingleResult();
		}catch (Exception e){
			
		}
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
		final String reqGetById = "SELECT m FROM Membre m WHERE m.idMembre = :pid";
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
		em.remove(em.merge(membreToDelete));
	}

	@Override
	public Membre checkMdp(String mdp, Integer idMembre) {
		final String req = "SELECT m from Membre m WHERE m.password = :pmdp AND m.idMembre = :pidMembre";
		Query query = em.createQuery(req);
		query.setParameter("pmdp", mdp);
		query.setParameter("pidMembre", idMembre);
		Membre membreChecked = (Membre) query.getSingleResult();
		return membreChecked;
	}

}
