package com.tac.data.api;


import com.tac.entity.Localisation;
import com.tac.entity.Proposition;

public interface IDaoLocaliser {

	void addLocaliser(Proposition proposition, Localisation localisation);
	void deleteFavori(Proposition proposition, Localisation localisation);
}
