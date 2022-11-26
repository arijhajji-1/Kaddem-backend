package com.esprit.first_project.repositories;

import com.esprit.first_project.entities.Universite;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface IUniversiteRepository extends CrudRepository<Universite, Integer> {

    @Query("Select u from Universite u")
    public List<Universite> retrieveAllUniversites();

}
