package com.example.demo.Repository;


import com.example.demo.Entities.Departement;
import org.springframework.data.repository.CrudRepository;

public interface IDepartementRepo extends CrudRepository<Departement, Integer> {
}
