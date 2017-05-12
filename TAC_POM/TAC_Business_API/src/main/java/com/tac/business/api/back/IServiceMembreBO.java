package com.tac.business.api.back;

import java.util.List;

import com.tac.entity.Membre;

public interface IServiceMembreBO {


	Membre updateMembre (Membre membre);
	List<Membre> getAllActif();
	List<Membre> getAllRadie();
	Membre getIdMembre(int IdMembre);
	Membre getMembre(Membre membre);

}
