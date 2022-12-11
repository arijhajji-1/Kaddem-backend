package com.example.demo.Service;

import com.example.demo.Entities.Contrat;
import com.example.demo.Entities.Equipe;
import com.example.demo.Entities.Etudiant;
import com.example.demo.Entities.Option;

import java.util.List;
import java.util.Set;

public interface IEtudiantService {
Etudiant addEtudiant(Etudiant e);
    void removeEtudiant(Integer idEdut);
    List<Etudiant> retrieveAllEtudiants();
    Etudiant updateEtudiant (Etudiant e);
    Etudiant retrieveEtudiant(Integer idEtudiant);
    Etudiant addAndAssignEtudiantToEquipeAndContract(Etudiant e, Integer idContrat, Integer
            idEquipe);
    Contrat affectContratToEtudiant (Contrat ce,String nomE, String prenomE);

    List<Etudiant> bydepratement(String nameDep);
    List<Etudiant> getEtudiantsByDepartement (Integer idDepartement);



    // ====== Abdelaziz

    Set<Contrat> getContratsByEtudiant(Integer idEtudiant);
    Set<Equipe> getEquipesByEtudiant(Integer idEtudiant);
    Equipe affectEquipeToEtudiant(Equipe e, Integer idEtudiant);
    Integer totalContratsAffectés() ;
    Integer totalEquipesAffectés() ;
    Contrat RemoveContratAffecte(Integer idEtudiant, Integer idContrat) ;
    Equipe RemoveEquipeAffecte(Integer idEtudiant, Integer idEquipe) ;
    void afficherNbreEtudiantsParOption() ;
    Set<Etudiant> getEtudiantsNonAffectesEquipeContrat() ;
}
