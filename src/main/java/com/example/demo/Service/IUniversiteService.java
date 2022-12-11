package com.example.demo.Service;

import com.example.demo.Entities.Departement;
import com.example.demo.Entities.ImageModel;
import com.example.demo.Entities.Universite;

import java.util.Date;
import java.util.List;
import java.util.Set;

public interface IUniversiteService {
    List<Universite> retrieveAllUniversites(Integer pageNumber);

    Universite addUniversite (Universite u);

    Universite updateUniversite (Universite u);

    Universite retrieveUniversite (Integer idUniversite);
    public List<Departement> retrieveDepartementsByUniversite(Integer idUniversite);
    int getmaxid();
    void deleteUniversite(Integer idUniversite);
    List<Departement> listDepart();
    List<Universite> retrieveAllUnive();

    List<Universite> rechercheParNom(String nom);
    List<Universite> listUniverApartirDate(Date date);
    List<ImageModel> ListImagebyIduniv(Integer id);
    void ajouterEtAffecterlisteDepart(Set<Departement> list, Integer idUniv);
   Integer countUniversites();
}
