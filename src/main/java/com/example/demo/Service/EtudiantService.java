package com.example.demo.Service;

import com.example.demo.Entities.*;
import com.example.demo.Repository.IContratRepo;
import com.example.demo.Repository.IDepartementRepo;
import com.example.demo.Repository.IEquipeRepo;
import com.example.demo.Repository.IEtudiantRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
@Service("EtudiantService")
@RequiredArgsConstructor
public class EtudiantService implements IEtudiantService {
    @Autowired
    IEtudiantRepo edtREpo;
    @Autowired

    IDepartementRepo idepartementRepository ;
    @Autowired
    IContratRepo contratRepository;
    @Autowired
    IEquipeRepo equipeRespository;
   /* @Autowired
    ExperienceService experienceService;*/
    public Etudiant addEtudiant(Etudiant e) {
       return edtREpo.save(e);

    }

    @Override
    public void removeEtudiant(Integer idEdut) {
    edtREpo.deleteById(idEdut);
    }

    @Override
    public List<Etudiant> retrieveAllEtudiants() {

        return (List<Etudiant>) edtREpo.findAll();
    }

    @Override
    public Etudiant updateEtudiant(Etudiant e) {
        return edtREpo.save(e);
    }

    @Override
    public Etudiant retrieveEtudiant(Integer idEtudiant) {
        return edtREpo.findById(idEtudiant).orElse(null);
    }

    @Override
    public List<Etudiant> getEtudiantsByDepartement(Integer idDepart) {return edtREpo.findEtudiantByDepartement(idDepart);}

    @Transactional
    public Etudiant addAndAssignEtudiantToEquipeAndContract(Etudiant e, Integer idContrat, Integer idEquipe) {
        Contrat contrat = contratRepository.findById(idContrat).get();
        Equipe equipe = equipeRespository.findById(idEquipe).get();
        e.getContrats().add(contrat);
        e.getEquipes().add(equipe);
        // contrat.setEtudiant(e);
        edtREpo.save(e);
        //etudiantRepository.save(contrat);
        System.out.println(e.getContrats());

        return e ;

    }
    @Override
    public Contrat affectContratToEtudiant(Contrat ce, String nomE, String prenomE) {
        Etudiant e=edtREpo.findEtudiantByNomPrenom(nomE,prenomE);

        e.getContrats().add(ce);
        ce.setEtudiant(e);
        contratRepository.save(ce);
        edtREpo.save(e);
        return ce;
    }

 /*   @Override
    public Etudiant assignEtudiantToExperience(Integer id, Integer idEtudiant) {
        Experience ee=experienceService.retrieveExperience(id);
        Etudiant e=retrieveEtudiant(idEtudiant);
        ee.setEtudiant(e);
        experienceService.addExperience(ee);
        return e;
    }*/

}
