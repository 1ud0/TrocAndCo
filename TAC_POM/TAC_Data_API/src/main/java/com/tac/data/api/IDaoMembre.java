package com.tac.data.api;

import java.util.List;

import com.tac.entity.Membre;

public interface IDaoMembre {

	Membre identifyMembre(String pseudo, String mdp);
	Membre getByPseudo (String Pseudo);
	Membre addMembre(Membre newMembre);
	Membre updateMembre (Membre membre);
	Membre getById(Integer id);
	List<Membre> getAll();
	void deleteMembre(Membre membreToDelete);
	
	
}
