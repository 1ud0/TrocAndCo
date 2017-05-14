package com.tac.data.impl;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.tac.data.api.IDaoTag;
import com.tac.entity.Tag;

@Remote(IDaoTag.class)
@Stateless
public class DaoTag implements IDaoTag {
	
	@PersistenceContext(unitName = "TAC_Data_EJB")
	private EntityManager em;

	@Override
	public Tag addTag(Tag tag) {
		em.persist(tag);
		return tag;
	}

	@Override
	public Tag updateTag(Tag tag) {
		em.merge(tag);
		return tag;
	}

	@Override
	public void deleteTag(Tag tag) {
		em.remove(tag);
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Tag> getTagsByIdCat(int idCat) {
		String req = "SELECT t FROM Tag t WHERE t.categorie.idCategorie = :tid";
		Query query = em.createQuery(req);
		query.setParameter("tid", idCat);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Tag> getAllTag() {
		String req = "SELECT t FROM Tag t";
		Query query = em.createQuery(req);
		return query.getResultList();
	}



}
