package com.tac.business.api;

import com.tac.entity.Membre;

public interface IServiceAuthentificationBackOffice {
	Membre authentification(String mail, String mdp);
}
