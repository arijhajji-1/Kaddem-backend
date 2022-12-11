package com.example.demo.Repository;


import com.example.demo.Entities.Contrat;
import com.example.demo.Entities.Departement;
import com.example.demo.Entities.ImageModel;
import com.example.demo.Entities.Universite;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository

public interface IUniversiteRepo extends CrudRepository<Universite, Integer> {

    @Query("select e.departements from Universite e where e.idUniv=?1")
    List<Departement> retrieveDepartementsByUniversite(int idUni);
    @Query("select max(idUniv) from Universite ")
    int getmaxId();

   public List<Universite> findAll(Pageable pageable);

   @Query("select u from  Universite  u where u.nomUniv=?1")
    List<Universite> rechercheParNom(String nom);
   /*
    @Query("select c from Contrat c where   c.dateDebutContrat>=?1 and c.dateFinContrat<=?2")
    List<Contrat> contratBetween2dates(Date startDate, Date endDate);*/

    @Query("select u from Universite u where u.DateAjout<=?1")
    List<Universite> listUniverApartirDate(Date date);

 @Query("select u.images from Universite u where u.idUniv=?1")
    List<ImageModel> ListImagebyIduniv(Integer id);

@Query("select count(u) from Universite u")
 Integer countUniversites();

}
