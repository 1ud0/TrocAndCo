package com.tac.business.api;

import java.util.List;

import com.tac.entity.Membre;
import com.tac.entity.Proposition;
import com.tac.entity.Suggestion;
import com.tac.util.CritereSearch;

public interface IServiceRecherche {

	List<Proposition> getPropositionsBidon();
	List<Proposition> getNewProps(int nombre, Membre membre);
	List<Proposition> rechercher(CritereSearch carac, Membre membre);
	List<Proposition> findSuggestion(Membre membre);
}
