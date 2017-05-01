package com.tac.business.api;

import com.tac.entity.Valeur;

public interface IServiceValeur {
	Valeur addValeur(Valeur valeur);
	Valeur updateValeur(Valeur valeur);
	void deleteValeur(Valeur valeur);
	Valeur getById(int idValeur);
}
