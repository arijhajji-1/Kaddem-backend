package com.esprit.first_project.services;

import com.esprit.first_project.entities.Contrat;
import com.esprit.first_project.entities.Departement;
import com.esprit.first_project.entities.Equipe;
import com.esprit.first_project.entities.Etudiant;
import com.esprit.first_project.repositories.IContratRepository;
import com.esprit.first_project.repositories.IDepartementRepository;
import com.esprit.first_project.repositories.IEquipeRepository;
import com.esprit.first_project.repositories.IEtudiantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service("EtudiantServices")
@RequiredArgsConstructor
public class EtudiantServices implements IEtudiantServices{

    private final IEtudiantRepository etudiantRepository;
    private final IContratRepository contratRepository;
    private final IEquipeRepository equipeRepository;
    private final IDepartementRepository departementRepository;
    @Override
    public List<Etudiant> retrieveAllEtudiants() {
        return etudiantRepository.retrieveAllEtudiants();
    }
    @Override
    public Etudiant addEtudiant(Etudiant e) {
        return etudiantRepository.save(e);
    }
    @Override
    public Etudiant updateEtudiant(Etudiant e) {
        return etudiantRepository.save(e);
    }
    @Override
    public Etudiant retrieveEtudiant(Integer idEtudiant) {return etudiantRepository.findById(idEtudiant).get();}
    @Override
    public void removeEtudiant(Integer idEtudiant) {
        etudiantRepository.deleteById(idEtudiant);
    }

    @Override
    public void AffectEtudiantToContrat(Integer idEtud, Integer idContrat) {
        Etudiant e = retrieveEtudiant(idEtud);
        Contrat c = contratRepository.findById(idContrat).orElse(null);
        c.setEtudiant(e);
        contratRepository.save(c);
    }

    @Override
    @Transactional
    public Etudiant addAndAssignEtudiantToEquipeAndContract(Etudiant e, Integer idContrat, Integer idEquipe) {
        System.out.println("addAndAssignEtudiantToEquipeAndContract");
        Contrat contrat = contratRepository.findById(idContrat).orElse(null);
        Equipe equipe = equipeRepository.findById(idEquipe).orElse(null);

        contrat.setEtudiant(e);
        contratRepository.save(contrat);
        e = etudiantRepository.save(e);

        Set<Equipe> equipes = new HashSet<>();
        equipes.add(equipe);
        e.setEquipe(equipes);
        System.out.println(e.getEquipe().size());

        e = etudiantRepository.save(e);
        return e ;
    }

    @Override
    public List<Etudiant> getEtudiantsByDepartement(Integer idDepartement) {
        Departement d = departementRepository.findById(idDepartement).get();
        return etudiantRepository.findByDepartement_IdDepart(idDepartement);
    }

}
