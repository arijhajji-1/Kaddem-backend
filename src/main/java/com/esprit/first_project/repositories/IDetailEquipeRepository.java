package com.esprit.first_project.repositories;

import com.esprit.first_project.entities.DetailEquipe;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface IDetailEquipeRepository extends CrudRepository<DetailEquipe, Integer> {

    @Query("Select dE from DetailEquipe dE")
    List<DetailEquipe> retrieveAllDetailEquipe();
}