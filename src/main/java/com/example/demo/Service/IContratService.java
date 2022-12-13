package com.example.demo.Service;

import com.example.demo.Entities.Contrat;

import java.util.Date;
import java.util.List;

public interface IContratService {
    List<Contrat> retrieveAllContrats();
    Contrat updateContrat (Contrat ce);
    Contrat addContrat(Contrat ce) ;
    Contrat retrieveContrat (Integer idContrat);
    void removeContrat(Integer idContrat) ;

    Integer nbContratsValides(Date startDate, Date endDate);

    Contrat affectContratToEtudiant(Contrat ce, String nomE, String prenomE);

    float getChiffreAffaireEntreDeuxDate(Date startDate, Date endDate);
    public Contrat retrieveContratByDate(Date dateDebut, Date dateFin);

    List<Contrat> contratBetween2dates(Date startDate, Date endDate);
    //String retrieveAndUpdateStatusContrat();
    String notificationContrat();
}
