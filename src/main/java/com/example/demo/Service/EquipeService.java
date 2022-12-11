package com.example.demo.Service;

import com.example.demo.Entities.Contrat;
import com.example.demo.Entities.Equipe;
import com.example.demo.Entities.Etudiant;
import com.example.demo.Entities.Niveau;
import com.example.demo.Repository.IContratRepo;
import com.example.demo.Repository.IEquipeRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service("EquipeService")
@RequiredArgsConstructor
public class EquipeService implements IEquipeService{
    @Autowired
    IEquipeRepo iEquipeRepo;
    @Autowired
    IContratRepo iContratRepo;
    @Override
    public List<Equipe> retrieveAllEquipes() {
        return (List<Equipe>)iEquipeRepo.findAll();
    }

    @Override
    public Equipe addEquipe(Equipe e) {
        return iEquipeRepo.save(e);
    }

    @Override
    public Equipe updateEquipe(Equipe e) {
        return iEquipeRepo.save(e);
    }

    @Override
    public Equipe retrieveEquipe(Integer idEquipe) {
        return iEquipeRepo.findById(idEquipe).get();
    }

  /*  @Scheduled(cron = "* * * 30 * *")
    public void faireEvoluerEquipes(){
        int cptEtudiant=0;
        List<Equipe> equipes= (List<Equipe>) iEquipeRepo.findAll();
        List<Contrat> contratDepasseAn=iContratRepo.contratDepasseAn(); // afficher la liste des contrats depasse 1 an
        for (Equipe e: equipes){
            cptEtudiant=0;
            Set<Etudiant> etudiants=e.getEtudiants();
            if(etudiants.size()>=3){
                for (Etudiant etudiant:etudiants) {
                    int cptContrat=0;
                    Set<Contrat> contrats = etudiant.getContrats();
                    for (Contrat c : contrats) {

                        if (contratDepasseAn.contains(c)) {
                            cptContrat=cptContrat+1;
                        }
                    }
                    if (cptContrat>=1){
                        cptEtudiant++;
                    }
                    // if pour les 3 conditions
                }
            }
            else{
                System.out.println("nbre des etudiants < 3");
            }
            if (cptEtudiant>=3&& e.getNiveau()==Niveau.JUNIOR) {
                e.setNiveau(Niveau.SENIOR);
                iEquipeRepo.save(e);
            } else if (cptEtudiant>=3&& (e.getNiveau()==Niveau.SENIOR)) {
                e.setNiveau(Niveau.EXPERT);
                iEquipeRepo.save(e);
            }
        }

    }*/
}
