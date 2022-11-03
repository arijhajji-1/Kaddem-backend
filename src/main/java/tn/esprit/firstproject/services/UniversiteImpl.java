package tn.esprit.firstproject.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.firstproject.entities.Universite;
import tn.esprit.firstproject.repositories.IUniversiteRepository;

import java.util.List;

@Service
public class UniversiteImpl implements IUniversiteService{
    @Autowired
    IUniversiteRepository universiteRepository ;

    @Override
    public List<Universite> retrieveAllUniversites() {
        return (List<Universite>) universiteRepository.findAll();
    }

    @Override
    public Universite addUniversite(Universite universite) {

        return universiteRepository.save(universite) ;
    }

    @Override
    public Universite updateUniversite(Universite u) {
        return universiteRepository.save(u) ;
    }

    @Override
    public Universite retrieveUniversite(Integer idUniversite) {
        return universiteRepository.findById(idUniversite).get() ;
    }

}
