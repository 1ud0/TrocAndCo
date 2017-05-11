package com.tac.data.api;

import java.util.List;
import com.tac.entity.Rdv;

public interface IDaoRdv {

Rdv addRdv(Rdv rdv);
Rdv updateRdv(Rdv rdv);
void deleteRdv(Rdv rdv);
List<Rdv> getByMembreId(Integer IdMembre);
List<Rdv> getByMembreIdPropositionEchange(Integer idMembre);
List<Rdv> getByMembreIdEtMembrePropositionPasEncorePasse(Integer idMembre);
}
