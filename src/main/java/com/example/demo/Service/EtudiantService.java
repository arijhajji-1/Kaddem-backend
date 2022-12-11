package com.example.demo.Service;

import com.example.demo.Entities.*;
import com.example.demo.Repository.IContratRepo;
import com.example.demo.Repository.IDepartementRepo;
import com.example.demo.Repository.IEquipeRepository;
import com.example.demo.Repository.IEtudiantRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Slf4j
@Service("EtudiantService")
@RequiredArgsConstructor
public class EtudiantService implements IEtudiantService {
    @Autowired
    IEtudiantRepo edtREpo, etudiantRepository;
    @Autowired
    IContratRepo iContratRepo, contratRepository;
    @Autowired
    IEquipeRepository iEquipeRepo, equipeRepository;
    @Autowired
    IDepartementRepo iDepartementRepo;
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
    public Etudiant addAndAssignEtudiantToEquipeAndContract(Etudiant e, Integer idContrat, Integer idEquipe) {

        Contrat c= iContratRepo.findById(idContrat).orElse(null);
        Equipe ep=iEquipeRepo.findById(idEquipe).orElse(null);
        System.out.println(ep);
        edtREpo.save(e);
       //affectaion avec contrat
            c.setEtudiant(e);
            iContratRepo.save(c);

        //affectation avec equipe
        e.getEquipes().add(ep);
            edtREpo.save(e);

        return e;
    }

    @Override
    public Contrat affectContratToEtudiant(Contrat ce, String nomE, String prenomE) {
       Etudiant e=edtREpo.findEtudiantByNomPrenom(nomE,prenomE);
       
       e.getContrats().add(ce);
       ce.setEtudiant(e);
        iContratRepo.save(ce);
        edtREpo.save(e);
       return ce;
    }


    @Override
    public List<Etudiant> bydepratement(String nameDep) {
        return edtREpo.findEtudiantByDepartement(nameDep);
    }

    @Override
    public List<Etudiant> getEtudiantsByDepartement(Integer idDepartement) {
        Departement d=iDepartementRepo.findById(idDepartement).orElse(null);
        return edtREpo.getEtudiantsByDepartement(d);
    }






    // ============= Abdelaziz
    @Override
    public Set<Contrat> getContratsByEtudiant(Integer idEtudiant) {
        Etudiant e =  etudiantRepository.findById(idEtudiant).orElseGet(null) ;
        return  e.getContrats();
    }

    @Override
    public Set<Equipe> getEquipesByEtudiant(Integer idEtudiant) {
        Etudiant e =  etudiantRepository.findById(idEtudiant).orElseGet(null) ;
        return  e.getEquipes();
    }

    @Override
    public Equipe affectEquipeToEtudiant(Equipe eq, Integer idEtudiant) {
        Etudiant e = etudiantRepository.findById(idEtudiant).orElse(null) ;

        e.getEquipes().add(eq);
        etudiantRepository.save(e);
        return eq ;
    }

    @Override
    public Integer totalContratsAffectés() {
        return contratRepository.totalContratsAffectes() ;
    }

    @Override
    public Integer totalEquipesAffectés() {
        return etudiantRepository.totalEquipesAffectes() ;
    }

    @Override
    public Contrat RemoveContratAffecte(Integer idEtudiant, Integer idContrat) {
        Etudiant e = etudiantRepository.findById(idEtudiant).orElse(null) ;
        Contrat c = contratRepository.findById(idContrat).orElse(null) ;

        e.getContrats().remove(c) ;
        c.setEtudiant(null);
        contratRepository.save(c);
        etudiantRepository.save(e);
        return c ;
    }

    @Override
    public Equipe RemoveEquipeAffecte(Integer idEtudiant, Integer idEquipe) {
        Etudiant e = etudiantRepository.findById(idEtudiant).orElse(null) ;
        Equipe eq = equipeRepository.findById(idEquipe).orElse(null) ;

        e.getEquipes().remove(eq);
        etudiantRepository.save(e);
        return eq ;
    }

    @Override
    @Scheduled(cron = "*/20 * * * * *" )
    public void afficherNbreEtudiantsParOption() {
        for (Option o : Option.values()) {
            System.out.println("======== OPTION "+o+" ===========\n" );
            System.out.println("Nbre : "+etudiantRepository.nbreEtudiantsParOption(o) );
        }
    }

    @Override
    public Set<Etudiant> getEtudiantsNonAffectesEquipeContrat() {
        return etudiantRepository.etudiantsNonAffectes() ;
    }


}
