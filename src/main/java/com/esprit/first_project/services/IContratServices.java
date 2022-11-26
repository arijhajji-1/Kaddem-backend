package com.esprit.first_project.services;

import com.esprit.first_project.entities.Contrat;
import java.util.Date;
import java.util.List;

public interface IContratServices {

    List<Contrat> retrieveAllContrats();
    Contrat updateContrat (Contrat ce);
    Contrat addContrat (Contrat ce);
    Contrat retrieveContrat (Integer idContrat);
    void removeContrat(Integer idContrat);
    Contrat affectContratToEtudiant (Contrat ce, String nomE,String prenomE);
    float getChiffreAffaireEntreDeuxDate(Date startDate, Date endDate);
    Integer nbContratsValides(Date startDate, Date endDate);
}
