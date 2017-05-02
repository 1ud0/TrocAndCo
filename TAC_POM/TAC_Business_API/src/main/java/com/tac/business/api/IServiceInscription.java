package com.tac.business.api;

import com.tac.entity.Membre;

public interface IServiceInscription {
	
	Membre addMembre(Membre membre);
	boolean checkPseudo(String pseudo);
	

}
