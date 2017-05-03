package com.tac.data.api;

import com.tac.entity.Compte;

public interface IDaoCompte {

	Compte getCompteUser();
	Compte getCompteAdmin();
}
