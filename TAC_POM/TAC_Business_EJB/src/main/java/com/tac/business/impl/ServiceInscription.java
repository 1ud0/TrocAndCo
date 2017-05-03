package com.tac.business.impl;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import com.tac.business.api.IServiceInscription;
import com.tac.data.api.IDaoCompte;
import com.tac.data.api.IDaoLocalisation;
import com.tac.data.api.IDaoMembre;
import com.tac.entity.Localisation;
import com.tac.entity.Membre;

@Remote(IServiceInscription.class)
@Stateless
public class ServiceInscription implements IServiceInscription {

	public static final String ADRESSE_BASE = "principale";
	
	@EJB
	private IDaoMembre proxyMembre;
	
	@EJB
	private IDaoLocalisation proxyLoc;
	
	@EJB
	private IDaoCompte proxyCompte;

	@Override
	public Membre addMembre(Membre membre) {
		//date d'inscription à aujourd'hui
		membre.setDateInscription(new Date());
		
		//compte membre par défaut
		membre.setCompte(proxyCompte.getCompteUser());
		
		Membre nouveauMembre = proxyMembre.addMembre(membre);
		List<Localisation> lieux = membre.getLocalisations();
		for (Localisation loc : lieux) {
			//intitule adresse par défaut
			loc.setTitreAdresse(ADRESSE_BASE);
			loc.setMembre(nouveauMembre);
			proxyLoc.addLocalisation(loc);
		}
		return nouveauMembre;
	}

	@Override
	public boolean checkPseudo(String pseudo) {
		if (proxyMembre.getByPseudo(pseudo) != null)
			return false;
		else {
			return true;
		}

	}

}
