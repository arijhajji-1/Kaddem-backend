package com.example.demo.Service;

import com.example.demo.Entities.Departement;
import com.example.demo.Entities.Universite;

import java.util.List;

public interface IUniversiteService {
    List<Universite> retrieveAllUniversites();

    Universite addUniversite (Universite u);

    Universite updateUniversite (Universite u);

    Universite retrieveUniversite (Integer idUniversite);

    public List<Departement> retrieveDepartementsByUniversite(Integer idUniversite);

}
