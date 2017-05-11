package com.tac.business.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import com.tac.business.api.IServiceRdv;
import com.tac.data.api.IDaoRdv;
import com.tac.entity.Rdv;

@Remote(IServiceRdv.class)
@Stateless
public class ServiceRdv implements IServiceRdv {

	@EJB
	IDaoRdv proxyRdv;

	@Override
	public Rdv addRdv(Rdv rdv) {
		return proxyRdv.addRdv(rdv);
	}

	@Override
	public void deleteRdv(Rdv rdv) {
		proxyRdv.deleteRdv(rdv);

	}

	@Override
	public Rdv updateRdv(Rdv rdv) {
		return proxyRdv.updateRdv(rdv);
	}

	@Override
	public List<Rdv> getRdvByMembre(int idMembre) {
		return proxyRdv.getByMembreId(idMembre);
	}
	
	@Override
	public List<Rdv> getRdvByMembrePropositionEchange(int idMembre) {
		return proxyRdv.getByMembreIdPropositionEchange(idMembre);
	}
	
	@Override
	public List<Rdv> getByMembreIdEtMembrePropositionPasEncorePasse(int idMembre){
		return proxyRdv.getByMembreIdEtMembrePropositionPasEncorePasse(idMembre);
	}

}
