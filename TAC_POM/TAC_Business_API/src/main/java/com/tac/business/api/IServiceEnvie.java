package com.tac.business.api;

import java.util.List;

import com.tac.entity.Envie;
import com.tac.entity.Liste;
import com.tac.entity.Membre;

public interface IServiceEnvie {
	
	Envie addEnvie(Envie envie);
	void deleteEnvie(Envie envie);
	Envie getEnvie(int idEnvie);
	List<Envie> getByList(Liste liste);
	List<Envie> getByMembre(Membre membre);

}
