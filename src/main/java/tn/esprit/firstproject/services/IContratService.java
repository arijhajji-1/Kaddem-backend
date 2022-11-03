package tn.esprit.firstproject.services;

import org.springframework.stereotype.Service;
import tn.esprit.firstproject.entities.Contrat;

import java.util.List;

@Service
public interface IContratService {
    List<Contrat> retrieveAllContrats();
    Contrat updateContrat (Contrat ce);
    Contrat addContrat(Contrat ce) ;
    Contrat retrieveContrat (Integer idContrat);
    void removeContrat(Integer idContrat) ;
}
