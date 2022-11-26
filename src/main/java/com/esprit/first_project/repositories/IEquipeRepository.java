package com.esprit.first_project.repositories;

import com.esprit.first_project.entities.Equipe;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface IEquipeRepository extends CrudRepository<Equipe, Integer> {

    @Query("Select eq from Equipe eq")
    List<Equipe> retrieveAllEquipes();
}
