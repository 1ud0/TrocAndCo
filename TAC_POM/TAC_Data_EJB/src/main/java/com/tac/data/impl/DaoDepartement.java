package com.tac.data.impl;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.tac.data.api.IDaoDepartement;
import com.tac.entity.Departement;

@Remote(IDaoDepartement.class)
@Stateless
public class DaoDepartement implements IDaoDepartement{

	@PersistenceContext(unitName="TAC_Data_EJB")
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Departement> getAllDept() {
		String req="SELECT d FROM Departement d";
		Query query = em.createQuery(req);
		return query.getResultList();
	}

}
