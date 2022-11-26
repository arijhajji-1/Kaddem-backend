package com.esprit.first_project.services;

import com.esprit.first_project.entities.Etudiant;
import java.util.List;

public interface IEtudiantServices {
    List<Etudiant> retrieveAllEtudiants();
    Etudiant addEtudiant (Etudiant e);
    Etudiant updateEtudiant (Etudiant e);
    Etudiant retrieveEtudiant(Integer idEtudiant);
    void removeEtudiant(Integer idEtudiant);
    void AffectEtudiantToContrat(Integer idEtud, Integer idContrat);
    Etudiant addAndAssignEtudiantToEquipeAndContract(Etudiant e, Integer idContrat, Integer idEquipe);
    List<Etudiant> getEtudiantsByDepartement (Integer idDepartement);
}
