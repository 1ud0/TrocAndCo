package com.tac.business.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import com.tac.business.api.IServiceInscription;
import com.tac.data.api.IDaoCompte;
import com.tac.data.api.IDaoListe;
import com.tac.data.api.IDaoLocalisation;
import com.tac.data.api.IDaoMembre;
import com.tac.entity.Liste;
import com.tac.entity.Localisation;
import com.tac.entity.Membre;

@Remote(IServiceInscription.class)
@Stateless
public class ServiceInscription implements IServiceInscription {

	public static final String DEFAULT_ADDRESS = "Adresse Principale";
	public static final String DEFAULT_AVATAR = "img/imgAvatar/avatar-default.jpg";
	public static final String DEFAULT_LIST_TITLE = "Ma liste";
	
	@EJB
	private IDaoMembre proxyMembre;
	@EJB
	private IDaoLocalisation proxyLoc;
	@EJB
	private IDaoCompte proxyCompte;
	@EJB
	private IDaoListe proxyListe;

	@Override
	public Membre addMembre(Membre membre) {
		//date d'inscription à aujourd'hui
		membre.setDateInscription(new Date());
		//compte membre par défaut
		membre.setCompte(proxyCompte.getCompteUser());
		//avatar par defaut
		membre.setAvatar(DEFAULT_AVATAR);
		
		
		
		//liste par défaut
		List<Liste> listes = new ArrayList<>();
		Liste liste = new Liste();
		liste.setDateCreation(new Date());
		liste.setTitreListe(DEFAULT_LIST_TITLE);
		listes.add(liste);
		membre.setListes(listes);
		Membre nouveauMembre = proxyMembre.addMembre(membre);
		liste.setMembre(nouveauMembre);
		proxyListe.addListe(liste);
		
		List<Localisation> lieux = membre.getLocalisations();
		for (Localisation loc : lieux) {
			//intitule adresse par défaut
			loc.setTitreAdresse(DEFAULT_ADDRESS);
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
