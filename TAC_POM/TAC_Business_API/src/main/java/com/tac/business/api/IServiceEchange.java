package com.tac.business.api;

import java.util.List;

import com.tac.entity.Echange;
import com.tac.entity.Membre;
import com.tac.entity.Proposition;
import com.tac.entity.Rdv;

public interface IServiceEchange {

	Echange initierEchange(Echange echange);
	Echange accepterEchange (Echange echange);
	Echange refuserEchange (Echange echange);
	Echange annulerEchange (Echange echange);
	Echange validerEchange (Echange echange);
	Rdv programmerRdv(Rdv rdv);
	Echange getByNumero(Echange echange);
	List<Echange> getByMembre(Membre membre);
	List<Rdv> getRdvForMembre(Membre membre);
	Proposition getPropByEchange(Echange echange);
}
