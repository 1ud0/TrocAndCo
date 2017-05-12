package com.tac.business.impl;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import com.tac.business.api.IServiceEchange;
import com.tac.data.api.IDaoEchange;
import com.tac.data.api.IDaoFavori;
import com.tac.data.api.IDaoProposition;
import com.tac.data.api.IDaoRdv;
import com.tac.entity.Echange;
import com.tac.entity.Membre;
import com.tac.entity.Proposition;
import com.tac.entity.Rdv;
import com.tac.exception.NotEnoughCreditException;

@Remote(IServiceEchange.class)
@Stateless
public class ServiceEchange implements IServiceEchange {

	@EJB
	IDaoEchange proxyEchange;
	@EJB
	IDaoFavori proxyFavori ;
	@EJB
	IDaoRdv proxyRdv;
	@EJB
	IDaoProposition proxyProposition;
	
	
	@Override
	public Echange initierEchange(Echange echange) throws NotEnoughCreditException{
		if (echange.getPrix()>totalCredit(echange.getMembre())){
			throw new NotEnoughCreditException("pas assez de crédit");
		} else {
			echange.setDateinit(new Date());
			echange.setCodeEchange((int)(Math.random()*9000)+1000);
			echange = proxyEchange.addEchange(echange);
			return echange;
		}	
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
		echange = proxyEchange.updateEchange(echange);
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

	@Override
	public double getNoteMoyenne(Membre membre) {
		return proxyEchange.getNoteMoyenneMembre(membre.getIdMembre());
		
	}

	@Override
	public int getTotalEchangeAvecNote(Membre membre) {
		return proxyEchange.getTotalEchangeAvecNote(membre.getIdMembre());
	}

	@Override
	public int[] getToutesLesNotes(Membre membre) {
		return proxyEchange.getToutesLesNotes(membre.getIdMembre());
	}

	@Override
	public List<Echange> getByMembreDonneurFini(Membre membre) {
		return proxyEchange.getByMembreDonneurFini(membre.getIdMembre());
	}

	@Override
	public List<Echange> getByMembreChercheurFini(Membre membre) {
		return proxyEchange.getByMembreChercheurFini(membre.getIdMembre());
	}

	@Override
	public int totalCredit(Membre membre) {
		int totalCredit = proxyEchange.getCreditEnPlus(membre.getIdMembre())+proxyEchange.getCreditEnMoins(membre.getIdMembre());
		if(!proxyProposition.getByMembre(membre.getIdMembre()).isEmpty()){
			totalCredit=totalCredit+5;
		}
		return totalCredit;
	}
	public Proposition getPropByEchange(Echange echange) {
		
		return proxyEchange.getbyEchange(echange);
	}

	@Override
	public Echange getEchangeByProp(Proposition proposition) {
		
		return proxyEchange.getEchangeByProp(proposition);
	}

	@Override
	public List<Echange> getByMembreDonneur(Integer idMembreDonneur) {

		return proxyEchange.getByMembreDonneur(idMembreDonneur);
	}
	
	@Override
	public List<Echange> getByMembreDonneurDateAcceptNull(Membre membre) {

		return proxyEchange.getByMembreDonneurDateAcceptNull(membre);
	}

	@Override
	public List<Echange> getByMembreDonneurChercheurDateAcceptNull(Integer idMembre) {

		return proxyEchange.getByMembreDonneurChercheurDateAcceptNull(idMembre);
	}
	
	@Override
	public List<Echange> getByMembreChercheur(Integer idMembreChercheur) {

		return proxyEchange.getByMembreChercheur(idMembreChercheur);
	}

	@Override
	public Echange noterEchange(Echange echange) {
		return proxyEchange.updateEchange(echange);
	}



}
