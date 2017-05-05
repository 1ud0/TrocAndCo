package com.tac.business.impl;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import com.tac.business.api.IServiceEchange;
import com.tac.data.api.IDaoEchange;
import com.tac.data.api.IDaoFavori;
import com.tac.data.api.IDaoRdv;
import com.tac.entity.Echange;
import com.tac.entity.Membre;
import com.tac.entity.Rdv;

@Remote(IServiceEchange.class)
@Stateless
public class ServiceEchange implements IServiceEchange {

	@EJB
	IDaoEchange proxyEchange;
	@EJB
	IDaoFavori proxyFavori ;
	@EJB
	IDaoRdv proxyRdv;
	
	
	@Override
	public Echange initierEchange(Echange echange) {
		echange.setDateinit(new Date());
		echange.setCodeEchange((int)(Math.random()*9000)+1000);
		echange = proxyEchange.addEchange(echange);
		return echange;
	}

	@Override
	public Echange accepterEchange(Echange echange) {
		echange.setDateAcceptation(new Date());
		echange = proxyEchange.updateEchange(echange);
		return echange;
	}

	@Override
	public Echange refuserEchange(Echange echange) {
		echange.setDateRefus(new Date());
		return echange;
	}

	@Override
	public Echange annulerEchange(Echange echange) {
		echange.setDateAnnul(new Date());
		echange = proxyEchange.updateEchange(echange);
		return echange;
	}

	@Override
	public Echange validerEchange(Echange echange) {
		echange.setDateValidation(new Date());	
		echange = proxyEchange.updateEchange(echange);
		proxyFavori.deleteAllFavori(echange.getProposition());
		return echange;
	}

	@Override
	public Rdv programmerRdv(Rdv rdv) {
		rdv = proxyRdv.addRdv(rdv);
		return rdv;
	}

	@Override
	public Echange getByNumero(Echange echange) {
		echange = proxyEchange.getByNumero(echange.getIdEchange());
		return echange;
	}

	@Override
	public List<Echange> getByMembre(Membre membre) {
		List<Echange> echangesDuMembre = proxyEchange.getByMembre(membre.getIdMembre());
		return echangesDuMembre;
	}

	@Override
	public List<Rdv> getRdvForMembre(Membre membre) {
		List<Rdv> rdvDuMembre = proxyRdv.getByMembreId(membre.getIdMembre());
		return rdvDuMembre;
	}

}
