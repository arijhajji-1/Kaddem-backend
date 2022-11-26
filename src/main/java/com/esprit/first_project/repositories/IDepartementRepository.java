package com.esprit.first_project.repositories;

import com.esprit.first_project.entities.Departement;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface IDepartementRepository extends CrudRepository<Departement,Integer> {

    @Query("Select d from Departement d")
    List<Departement> retrieveAllDepartements();
}
