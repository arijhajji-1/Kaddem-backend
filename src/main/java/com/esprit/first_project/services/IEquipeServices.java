package com.esprit.first_project.services;

import com.esprit.first_project.entities.Equipe;
import java.util.List;

public interface IEquipeServices {

    List<Equipe> retrieveAllEquipes();
    Equipe addEquipe(Equipe e); // ajouter l’équipe avec son détail
    Equipe updateEquipe (Equipe e);
    Equipe retrieveEquipe (Integer idEquipe);
    void affecteEquipeToDetailEquipe(Integer idEquipe, Integer idDetailE);
}
