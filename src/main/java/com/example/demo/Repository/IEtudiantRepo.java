package com.example.demo.Repository;
import com.example.demo.Entities.Departement;
import com.example.demo.Entities.Etudiant;
import com.example.demo.Entities.Option;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Repository

public interface IEtudiantRepo extends CrudRepository<Etudiant, Integer> {
 //List<Etudiant> findByPrenomENotNull();


    @Query("select e from Etudiant e where e.nom=?1 and e.prenom=?2 ")
    Etudiant findEtudiantByNomPrenom(String nom,String prenom);
   /*
    @Query("select e FROM  Etudiant e where  e.option = :option")
    Etudiant findEtudiantByNomPrenom(@Param("option")Option op)

    List<Etudiant> findAllByOption(Option p);
    //// hethi ::
    @Query("select e from Etudiant e where e.departement.nomDepart=:nomdep")
    List<Etudiant> retrieveStudentByDepar(@Param("nomdep") String nomDepartement);*/
    //wala hethii :::
   @Query("select e from Etudiant e inner join e.departement ee where ee.nomDepart = ?1")
   List<Etudiant> findEtudiantByDepartement(String nomDep);
/*
List<Etudiant> findEtudiantByDepartement_NomDepart(String nomDepartement);*/

    List<Etudiant> getEtudiantsByDepartement(Departement Departement);



    // ======== Abdelaziz
    @Query("select e from Etudiant e inner join e.contrats contrat where contrat.dateDebutContrat = ?1")
    List<Etudiant> findByContrat_DateDebutcontrat(Date dateDebutcontrat);

    @Query("select e from Etudiant e where e.prenom = ?1 and e.nom = ?2")
    Etudiant findEtudiantByPrenomEtNom(String prenomE, String nomE);
    @Query("select e from Etudiant e inner join e.departement ee where ee.idDepart = ?1")
    List<Etudiant> getEtudiantsByDepartement(Integer IdDep);

    @Query("select count(e) from Etudiant e where e.equipes is not empty ")
    Integer totalEquipesAffectes();

    @Query("select count(c) from Etudiant c where c.option= ?1 ")
    Integer nbreEtudiantsParOption(Option o) ;

    @Query("select c from Etudiant c where c.equipes is empty and c.contrats is empty ")
    Set<Etudiant> etudiantsNonAffectes() ;


}
