package com.esprit.first_project.repositories;

import com.esprit.first_project.entities.Etudiant;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface IEtudiantRepository extends CrudRepository<Etudiant,Integer> {

    @Query("select e from Etudiant e ")
    List<Etudiant> retrieveAllEtudiants();

    @Query("select e from Etudiant e where e.nomE = ?1 and e.prenomE = ?2")
    Etudiant findByNomEAndPrenomE(String nomE, String prenomE);

    @Query("select e from Etudiant e where e.departement.idDepart = ?1")
    List<Etudiant> findByDepartement_IdDepart(Integer idDepart);




}