package com.esprit.first_project.services;

import com.esprit.first_project.entities.Departement;
import com.esprit.first_project.entities.Etudiant;
import com.esprit.first_project.entities.Universite;
import com.esprit.first_project.repositories.IDepartementRepository;
import com.esprit.first_project.repositories.IEtudiantRepository;
import com.esprit.first_project.repositories.IUniversiteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service("DepartementServices")
@RequiredArgsConstructor
public class DepartementServices implements IDepartementServices{

    private final IDepartementRepository departementRepository;
    private final IEtudiantRepository etudiantRepository;
    private final IUniversiteRepository universiteRepository;
    @Override
    public List<Departement> retrieveAllDepartements() {
        return departementRepository.retrieveAllDepartements();
    }
    @Override
    public Departement addDepartement(Departement d) {
        return departementRepository.save(d);
    }
    @Override
    public Departement updateDepartement(Departement d) {
        return departementRepository.save(d);
    }
    @Override
    public Departement retrieveDepartement(Integer idDepart) {
        return departementRepository.findById(idDepart).get();
    }
    @Override
    public void assignEtudiantToDepartement(Integer etudiantId,Integer departementId) {
        Etudiant e=etudiantRepository.findById(etudiantId).orElse(null);
        Departement d=departementRepository.findById(departementId).orElse(null);
        e.setDepartement(d);//affecter departement au etudiant objet
        etudiantRepository.save(e);//sauvgarder l'objet
    }
    @Override
    public List<Departement> retrieveDepartementsByUniversite(Integer idUniversite) {
        Universite u = universiteRepository.findById(idUniversite).get();
        List departements = Arrays.asList(u.getDepartement().toArray());
        return departements;
    }
}