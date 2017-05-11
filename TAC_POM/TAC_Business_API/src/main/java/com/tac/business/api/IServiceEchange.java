package com.tac.business.api;

import java.util.List;

import com.tac.entity.Echange;
import com.tac.entity.Membre;
import com.tac.entity.Proposition;
import com.tac.entity.Rdv;
import com.tac.exception.NotEnoughCreditException;

public interface IServiceEchange {

	Echange initierEchange(Echange echange) throws NotEnoughCreditException;
	Echange accepterEchange (Echange echange);
	Echange refuserEchange (Echange echange);
	Echange annulerEchange (Echange echange);
	Echange validerEchange (Echange echange);
	Echange noterEchange (Echange echange);
	
	Rdv programmerRdv(Rdv rdv);
	Echange getByNumero(Echange echange);
	List<Echange> getByMembre(Membre membre);
	List<Rdv> getRdvForMembre(Membre membre);
	double getNoteMoyenne(Membre membre);
	int getTotalEchangeAvecNote(Membre membre);
	int[] getToutesLesNotes(Membre membre);
	List<Echange> getByMembreDonneurFini(Membre membre);
	List<Echange> getByMembreChercheurFini(Membre membre);
	int totalCredit(Membre membre);
	Proposition getPropByEchange(Echange echange);
	Echange getEchangeByProp(Proposition proposition);
	List<Echange> getByMembreDonneur(Integer idMembreDonneur);
	List<Echange> getByMembreChercheur(Integer idMembreChercheur);
	List<Echange> getByMembreDonneurDateAcceptNull(Integer idMembreDonneur);
}
