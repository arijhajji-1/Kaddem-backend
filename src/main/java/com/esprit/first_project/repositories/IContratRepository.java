package com.esprit.first_project.repositories;

import com.esprit.first_project.entities.Contrat;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface IContratRepository extends CrudRepository<Contrat,Integer> {

    @Query("Select c from Contrat c")
    List<Contrat> retrieveAllContrats();

    @Query("select c from Contrat c where c.etudiant.idEtudiant = ?1")
    List<Contrat> findByEtudiant_IdEtudiant(Integer idEtudiant);

}