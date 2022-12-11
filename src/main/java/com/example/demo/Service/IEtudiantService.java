package com.example.demo.Service;

import com.example.demo.Entities.Contrat;
import com.example.demo.Entities.Etudiant;

import java.util.List;

public interface IEtudiantService {
Etudiant addEtudiant(Etudiant e);
    void removeEtudiant(Integer idEdut);
    List<Etudiant> retrieveAllEtudiants();
    Etudiant updateEtudiant (Etudiant e);
    Etudiant retrieveEtudiant(Integer idEtudiant);

    public Etudiant addAndAssignEtudiantToEquipeAndContract(Etudiant e, Integer idContrat,Integer idEquipe);
    Contrat affectContratToEtudiant (Contrat ce, String nomE, String prenomE);

    List<Etudiant> getEtudiantsByDepartement(Integer idDepart);


   // Etudiant assignEtudiantToExperience(Integer id, Integer idEtudiant);
}
