package com.example.demo.Service;

import com.example.demo.Entities.Departement;
import com.example.demo.Entities.Etudiant;
import com.example.demo.Entities.Universite;
import com.example.demo.Repository.IDepartementRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service("DepartementService")
@RequiredArgsConstructor
public class DepartementService implements IDepartementService{
 @Autowired
  IDepartementRepo departementRepo;
    @Autowired
 EtudiantService etudiantService;
    @Autowired
    UniversiteService universiteService;
    @Override
    public List<Departement> retrieveAllDepartements() {
        return  (List<Departement>)departementRepo.findAll();
    }

    @Override
    public Departement addDepartement(Departement d) {
        return departementRepo.save(d);
    }

   @Override
    public Departement updateDepartement(Departement d) {
        return departementRepo.save(d);
    }

    @Override
    public Departement retrieveDepartement(Integer idDepart) {
        return departementRepo.findById(idDepart).get();
    }


    @Override
    public Departement assignEtudiantToDepartement(Integer id,Integer idDep) {
        Etudiant e=etudiantService.retrieveEtudiant(id);
        Departement d=retrieveDepartement(idDep);
        e.setDepartement(d);
        etudiantService.addEtudiant(e);
        return d;
    }
    @Override
    public void assignUniversiteToDepartement(Integer idUniversite, Integer idDepartement) {
        Departement d=retrieveDepartement(idDepartement);
        Universite u=universiteService.retrieveUniversite(idUniversite);
        u.getDepartements().add(d);
        universiteService.addUniversite(u);
    }

}
