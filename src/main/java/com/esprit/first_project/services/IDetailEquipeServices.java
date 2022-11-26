package com.esprit.first_project.services;

import com.esprit.first_project.entities.DetailEquipe;
import java.util.List;

public interface IDetailEquipeServices {

    List<DetailEquipe> retrieveAllDetailEquipe();
    DetailEquipe addDetailEquipe(DetailEquipe detailEquipe);
    DetailEquipe updateDetailEquipe(DetailEquipe detailEquipe);
    DetailEquipe  retrieveDetailEquipe(Integer idDetailEquipe);
}
