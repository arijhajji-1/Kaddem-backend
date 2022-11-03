package tn.esprit.firstproject.services;

import org.springframework.stereotype.Service;
import tn.esprit.firstproject.entities.Universite;

import java.util.List;

@Service
public interface IUniversiteService {
    List<Universite> retrieveAllUniversites();
    Universite addUniversite(Universite u) ;
    Universite updateUniversite (Universite u);
    Universite retrieveUniversite (Integer idUniversite);
}
