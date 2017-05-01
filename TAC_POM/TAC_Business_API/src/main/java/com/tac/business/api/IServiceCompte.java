package com.tac.business.api;

import com.tac.entity.Membre;

public interface IServiceCompte {
Membre majDonnees(Membre membre);
boolean checkPassword(String mdp, Integer idMembre);
		
}
