package com.tac.data.impl;

import java.util.List;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import com.tac.data.api.IDaoRdv;
import com.tac.entity.Rdv;

@Remote(IDaoRdv.class)
@Stateless
public class DaoRdv implements IDaoRdv{
	
	@PersistenceContext(unitName = "TAC_Data_EJB")
	private EntityManager em;

	@Override
	public Rdv addRdv(Rdv rdv) {
		em.persist(rdv);
		return rdv;
	}

	@Override
	public Rdv updateRdv(Rdv rdv) {
		em.merge(rdv);
		return rdv;
	}

	@Override
	public void deleteRdv(Rdv rdv) {
		em.remove(em.merge(rdv));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Rdv> getByMembreId(Integer IdMembre) {
		/*final String req = "SELECT r FROM Rdv r LEFT JOIN IdEchange"
				+ " LEFT JOIN IdMembre"
				+ " WHERE r.idRDV like :pidRdv";*/
		
		final String req = "SELECT r FROM Rdv  WHERE r.echange.membre.idMembre = :pidMembre";
		Query query = em.createQuery(req).setParameter("pidMembre", IdMembre);
		return query.getResultList();
		
	}

}
