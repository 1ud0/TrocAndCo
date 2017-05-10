package com.tac.data.impl;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.tac.data.api.IDaoCategorie;
import com.tac.entity.Categorie;

@Remote(IDaoCategorie.class)
@Stateless
public class DaoCategorie implements IDaoCategorie{
	@PersistenceContext(unitName = "TAC_Data_EJB")
	private EntityManager em;
	
	@Override
	public Categorie addCategorie(Categorie newCategorie) {
		em.persist(newCategorie);
		return newCategorie;
	}

	@Override
	public Categorie updateCategorie(Categorie categorie) {
		em.merge(categorie);
		return categorie;
	}

	@Override
	public void deleteCategorie(Categorie categorieToDelete) {
		em.remove(em.merge(categorieToDelete));
		
	}

	@Override
	public Categorie getById(Integer idcategorie) {
		final String req ="SELECT c FROM Categorie c WHERE c.idCategorie = :pid";
		Query query = em.createQuery(req);
		query.setParameter("pid", idcategorie);
		Categorie retour=(Categorie)query.getSingleResult();
		return retour;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Categorie> getCategorieMere() {
		final String req ="SELECT c FROM Categorie c WHERE c.categorieMere is NULL";
		Query query = em.createQuery(req);
		
		return query.getResultList();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Categorie> getCategorieFille(Integer IdMere) {
		final String req = "SELECT c FROM Categorie c WHERE c.categorieMere.idCategorie = :pid";
		Query query = em.createQuery(req);
		query.setParameter("pid", IdMere);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Categorie> getAllCategorieFilles() {
		final String req = "SELECT c FROM Categorie c WHERE c.categorieMere.idCategorie is NOT NULL";
		Query query = em.createQuery(req);
		return query.getResultList();
	}

}
