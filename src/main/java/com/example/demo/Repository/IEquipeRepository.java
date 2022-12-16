package com.example.demo.Repository;

import com.example.demo.Entities.Equipe;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEquipeRepository extends CrudRepository<Equipe, Integer> {

    Page<Equipe> findAllByNomEquipeContaining(String nomEquipe, Pageable pageable);


    Page<Equipe> findAll(Pageable pageable);


}
