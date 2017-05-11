package com.tac.data.api;

import java.util.List;

import com.tac.entity.Membre;
import com.tac.entity.Proposition;

public interface IDaoFavori {

	Proposition addFavori(Proposition proposition, Membre membre);
	void deleteFavori(Proposition proposition, Membre membre);
	void deleteAllFavori(Proposition proposition);
	List<Proposition> getFavorisByMembre(Membre membre);
	boolean isAlreadyFavorite(Proposition proposition, Membre membre);
}
