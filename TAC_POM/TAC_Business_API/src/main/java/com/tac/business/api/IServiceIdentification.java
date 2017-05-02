package com.tac.business.api;

import com.tac.entity.Membre;

public interface IServiceIdentification {

	Membre identification (String mail, String mdp);
}
