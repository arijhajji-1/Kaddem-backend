package com.example.demo.Service;

import com.example.demo.Entities.Contrat;

import java.util.Date;
import java.util.List;

public interface IContratService {
    List<Contrat> retrieveAllContrats();

    Contrat updateContrat (Contrat ce);

    Contrat addContrat (Contrat ce);

    Contrat retrieveContrat (Integer idContrat);

    void removeContrat(Integer idContrat);

    Integer nbContratsValides(Date endDate, Date startDate);
     float getChiffreAffaireEntreDeuxDate(Date startDate, Date endDate);
    List<Contrat> contratBetween2dates(Date startDate, Date endDate);
List<Contrat> contratExp();
    List<Contrat> contratDepasseAn();


// ======= Abdelaziz
    Contrat affectContratToEtudiant(Contrat ce, String nomE, String prenomE);
}
