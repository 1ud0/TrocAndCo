package com.tac.data.impl;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.tac.data.api.IDaoPhoto;
import com.tac.entity.Photo;
import com.tac.entity.Proposition;

@Remote(IDaoPhoto.class)@Stateless
public class DaoPhoto implements IDaoPhoto {

	@PersistenceContext(unitName="TAC_Data_EJB")
	private EntityManager em;
	
	@Override
	public Photo addPhoto(Photo photo) {
		em.persist(photo);
		return photo;
	}

	@Override
	public Photo updatePhoto(Photo photo) {
		em.merge(photo);
		return photo;
	}

	@Override
	public void deletePhoto(Photo photo) {
		em.remove(em.merge(photo));
	}

	@Override
	public Photo getById(int idPhoto) {
		final String req = "SELECT p FROM Photo p WHERE p.idPhoto = :pid";
		Query query = em.createQuery(req);
		query.setParameter("pid", idPhoto);
		return (Photo) query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Photo> getByProposition(Proposition proposition) {
		final String req ="SELECT p FROM Photo p WHERE p.proposition.idProposition = :pid";
		Query query= em.createQuery(req);
		query.setParameter("pid", proposition.getIdProposition());
		return query.getResultList();
	}
}
