package com.example.demo.Repository;


import com.example.demo.Entities.Departement;
import com.example.demo.Entities.Etudiant;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface IDepartementRepo extends CrudRepository<Departement, Integer> {


    @Query("select max(idDepart) from Departement ")
    int getmaxId();
    @Query("select count (d) from Departement d")
    Integer countDepartements();

}
