package com.tac.data.api;

import java.util.List;

import com.tac.entity.Envie;
import com.tac.entity.Liste;
import com.tac.entity.Membre;

public interface IDaoEnvie {
	
	Envie addEnvie(Envie envie);
	void deleteEnvie(Envie envie);
	Envie getById(int idEnvie);
	List<Envie> getByListe(Liste liste);
	List<Envie> getByMembre(Membre membre);

}
