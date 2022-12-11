package com.example.demo.Repository;

import com.example.demo.Entities.Experience;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IExperienceRepo extends CrudRepository<Experience, Integer> {


    Page<Experience> findAllByLieuContaining(String lieu, Pageable pageable);
public List<Experience> findAll(Pageable pageable);
}
