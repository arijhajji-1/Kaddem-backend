package com.example.demo.Service;

import com.example.demo.Entities.Departement;
import com.example.demo.Entities.Etudiant;
import com.example.demo.Entities.Universite;
import com.example.demo.Repository.IDepartementRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
@Slf4j
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

    @Override
    public void delete(Integer idDepart) {
        departementRepo.deleteById(idDepart);
    }

    @Override
    public Integer countDepartements() {
        return departementRepo.countDepartements();
    }

    @Scheduled(cron = "*/60 * * * * * ")
    void bonjour(){
      int tailleuniv=  universiteService.countUniversites();
      int tailleDepart=this.countDepartements();
        log.info("nombre Universites ==="+tailleuniv+"*********** nombre departements ===" + tailleDepart);


    }


}
