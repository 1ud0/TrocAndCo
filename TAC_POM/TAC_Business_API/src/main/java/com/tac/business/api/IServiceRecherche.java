package com.tac.business.api;

import java.util.List;

import com.tac.entity.Proposition;
import com.tac.util.CritereSearch;

public interface IServiceRecherche {

	List<Proposition> getPropositionsBidon();
	List<Proposition> rechercher(CritereSearch carac);
}
