package com.esprit.first_project.services;

import com.esprit.first_project.entities.Departement;
import com.esprit.first_project.entities.Universite;
import com.esprit.first_project.repositories.IDepartementRepository;
import com.esprit.first_project.repositories.IUniversiteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service("UniversiteServices")
@RequiredArgsConstructor
public class UniversiteServices implements IUniversiteServices{

    private final IUniversiteRepository universiteRepository;
    private final IDepartementRepository departementRepository;
    @Override
    public List<Universite> retrieveAllUniversites() {
        return universiteRepository.retrieveAllUniversites();
    }
    @Override
    public Universite addUniversite(Universite u) {
        return universiteRepository.save(u);
    }
    @Override
    public Universite updateUniversite(Universite u) {
        return universiteRepository.save(u);
    }
    @Override
    public Universite retrieveUniversite(Integer idUniversite) {
        return universiteRepository.findById(idUniversite).get();
    }
    @Override
    public void assignUniversiteToDepartement(Integer idUniversite, Integer idDepartement){
        Departement d = departementRepository.findById(idDepartement).orElse(null);
        Universite u = universiteRepository.findById(idUniversite).orElse(null);
        Set<Departement> departements = new HashSet<>();
        departements.add(d);
        u.setDepartement(departements);
        universiteRepository.save(u);

    }
}
