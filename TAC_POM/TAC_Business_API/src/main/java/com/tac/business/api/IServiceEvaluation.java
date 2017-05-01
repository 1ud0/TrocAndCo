package com.tac.business.api;

import java.util.List;
import com.tac.entity.Echange;
import com.tac.entity.Membre;

public interface IServiceEvaluation {
Echange evalDonneur(Echange echange);
Echange evalChercheur(Echange echange);
List<Echange> getEvalRecues(Membre membre);
List<Echange> getEvalDonnees(Membre membre);
Double getNoteMoyenneMembre(Membre membre);
}
