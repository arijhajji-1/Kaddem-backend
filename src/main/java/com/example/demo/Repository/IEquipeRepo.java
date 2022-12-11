package com.example.demo.Repository;

import com.example.demo.Entities.Equipe;

import org.springframework.data.repository.CrudRepository;

public interface IEquipeRepo extends CrudRepository<Equipe, Integer> {
}
