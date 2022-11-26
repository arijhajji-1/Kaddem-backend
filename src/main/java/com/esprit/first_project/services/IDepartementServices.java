package com.esprit.first_project.services;

import com.esprit.first_project.entities.Departement;
import java.util.List;

public interface IDepartementServices {

    List<Departement> retrieveAllDepartements();
    Departement addDepartement (Departement d);
    Departement updateDepartement (Departement d);
    Departement retrieveDepartement (Integer idDepart);
    void assignEtudiantToDepartement(Integer etudiantId, Integer departementId);
    List<Departement> retrieveDepartementsByUniversite(Integer idUniversite);
}