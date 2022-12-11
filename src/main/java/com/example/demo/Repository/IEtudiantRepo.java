package com.example.demo.Repository;
import com.example.demo.Entities.Etudiant;
import com.example.demo.Entities.Departement;

import com.example.demo.Entities.Option;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IEtudiantRepo extends CrudRepository<Etudiant, Integer> {
    List<Etudiant> findByDepartement(Integer idDepart);

    @Query("select e from Etudiant e where e.nomE=?1 and e.prenomE=?2 ")
    Etudiant findEtudiantByNomPrenom(String nom,String prenom);

    //List<Etudiant> findByPrenomENotNull();
 /*   @Query("select e from Etudiant e where e.nomE=?1 and e.prenomE=?2")
    Etudiant findEtudiantByNomAndPrenom(String nom, String prenom);

    List<Etudiant> findAllByOption(Option p);
    //hedhii
    @Query("select e from Etudiant e where e.departement.nomDepart=:nomDepart")
    List<Etudiant> retrieveStudentByDepart(@Param("nomDepart") String nomDepartement);

    //wala hedhi
    @Query("select e from Etudiant e inner join e.departement.nomDepart=:nomDepart")
    List<Etudiant> byDepart(@Param("nomDepart") String nomDepartement);

    @Query("select e from Etudiant e inner join e.departement ee where ee.nomDepart = ?1")
    List<Etudiant> findEtudiantByDepartement(String nomDep);*/
    @Query("select e from Etudiant e inner join e.departement ee where ee.idDepart = ?1")
    List<Etudiant> findEtudiantByDepartement    (Integer idDepart);
}
