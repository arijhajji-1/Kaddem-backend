package com.esprit.first_project.services;

import com.esprit.first_project.entities.Universite;

import java.util.List;

public interface IUniversiteServices {

    List<Universite> retrieveAllUniversites();
    Universite addUniversite (Universite u);
    Universite updateUniversite (Universite u);
    Universite retrieveUniversite (Integer idUniversite);
    void assignUniversiteToDepartement(Integer idUniversite, Integer idDepartement);
}
