package com.tac.business.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import com.tac.business.api.IServiceRecherche;
import com.tac.data.api.IDaoLocalisation;
import com.tac.data.api.IDaoProposition;
import com.tac.entity.Localisation;
import com.tac.entity.Membre;
import com.tac.entity.Proposition;
import com.tac.util.CritereSearch;

@Remote(IServiceRecherche.class)
@Stateless
public class ServiceRecherche implements IServiceRecherche {

	public static final String DEFAULT_DISTANCE_MAX = "10";
	public static final float DEGREE_PER_KM = 0.00898f;
	
	@EJB
	private IDaoProposition proxyProposition;
	@EJB
	private IDaoLocalisation proxyLoc;
	
	@Override
	public List<Proposition> getPropositionsBidon() {
		return proxyProposition.getNouveautes(20, null);
	}

	public List<Proposition> testseek(CritereSearch carac) {
		System.out.println("intitule : " + carac.getIntitule());
		System.out.println("cat : " + carac.getCat());
		System.out.println("souscat : " + carac.getSousCat());
		System.out.println("dep : " + carac.getDepartement());
		System.out.println("dist : " + carac.getDistanceMax());
		System.out.println("etat : " + carac.getEtat());
		for (String  elem : carac.getLieux()) {
			System.out.println("lieu : " + elem);
		}
		for (String coucou : carac.getValeurs()) {
			System.out.println("val : " + coucou);
		}
		return null;
	}

	@Override
	public List<Proposition> rechercher(CritereSearch carac, Membre membre) {
		Integer idMembre = membre == null ? null : membre.getIdMembre();
		List<Localisation> locs = new ArrayList<>();
		if (carac.getLieux().size() != 0) {
			try {
				Integer dist = Integer.parseInt(carac.getDistanceMax());
				carac.setRayonRecherche(dist * DEGREE_PER_KM);
			} catch (NumberFormatException e) {
				carac.setRayonRecherche(Integer.parseInt(DEFAULT_DISTANCE_MAX) * DEGREE_PER_KM);
			}
			//on recupère la liste des adresses de depart pour la recherche
			for (String lieu : carac.getLieux()) {
				try {
					locs.add(proxyLoc.getById(Integer.parseInt(lieu)));
				} catch (NumberFormatException e) { }
			}
		}
		carac.setLocalisations(locs);
		List<Proposition> propositions = proxyProposition.rechercher(carac, idMembre);
		return propositions;
	}

	@Override
	public List<Proposition> getNewProps(int nombre, Membre membre) {
		Integer idMembre = membre == null ? null : membre.getIdMembre();
		return proxyProposition.getNouveautes(nombre, idMembre);
	}

}
