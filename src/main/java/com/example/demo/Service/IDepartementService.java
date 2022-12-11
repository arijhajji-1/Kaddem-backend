package com.example.demo.Service;

import com.example.demo.Entities.Departement;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IDepartementService {
    List<Departement> retrieveAllDepartements();

    Departement addDepartement (Departement d);

    Departement updateDepartement (Departement d);

    Departement retrieveDepartement (Integer idDepart);

    Departement assignEtudiantToDepartement(Integer id,Integer idDe);
    public void assignUniversiteToDepartement(Integer idUniversite, Integer idDepartement);

    void delete(Integer ifDepart);

Integer countDepartements();

}
