package com.tac.data.api;

import java.util.List;

import com.tac.entity.Envie;

public interface IDaoEnvie {
	
	Envie addEnvie(Envie envie);
	void deleteEnvie(Envie envie);
	Envie getById(int idEnvie);
	List<Envie> getByListeId(int idListe);

}
