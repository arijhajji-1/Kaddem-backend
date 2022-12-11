package com.example.demo.Service;

import com.example.demo.Entities.Experience;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IExperienceService {
    // ya final ya @requiredconstructor
    List<Experience> retrieveAllExperiences();
    List<Experience> retrieveAllExperience(int pageNumber);


    Experience updateExperience(Integer id, Experience ce);

    Experience addExperience(Experience ce);

    Experience retrieveExperience(Integer idExperience);

    void removeExperience(Integer idExperience);

    Experience assignEtudiantToExperience(Integer id, Integer idExpereince);

    Page<Experience> findAllByLieuContaining(String lieu, Pageable pageable);



}
