package com.example.demo.Service;

import com.example.demo.Entities.Etudiant;
import com.example.demo.Entities.Experience;
import com.example.demo.Repository.IExperienceRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("ExperienceService")
@RequiredArgsConstructor
public class ExperienceService implements IExperienceService {
    @Autowired
    private IExperienceRepo ExperienceRepo;
    @Autowired
    private IEtudiantService etudiantService;
    
    @Override
    public List<Experience> retrieveAllExperiences() {

        return (List<Experience>) ExperienceRepo.findAll();
    }
    @Override
    public List<Experience> retrieveAllExperience(int pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber, 5);
        return (List<Experience>) ExperienceRepo.findAll(pageable);
    }
    @Override
    public Experience updateExperience(Integer id,Experience ce) {
    if(ExperienceRepo.findById(id).isPresent()){
        Experience toUpdateExperience =ExperienceRepo.findById(id).get();
    toUpdateExperience.setTitreDuProfil(ce.getTitreDuProfil());
    toUpdateExperience.setType(ce.getType());
    toUpdateExperience.setDateDebutExperience(ce.getDateDebutExperience());
    toUpdateExperience.setDateFinExperience(ce.getDateFinExperience());
    toUpdateExperience.setDescriptif(ce.getDescriptif());
    toUpdateExperience.setLieu(ce.getLieu());
    toUpdateExperience.setEtudiant(ce.getEtudiant());

    return ExperienceRepo.save(toUpdateExperience);

}

        return null;
    }

    @Override
    public Experience addExperience(Experience ce) {
        return ExperienceRepo.save(ce);
    }

    @Override
    public Experience retrieveExperience(Integer idExperience) {
        return ExperienceRepo.findById(idExperience).get();
    }

    @Override
    public void removeExperience(Integer idExperience) {
        ExperienceRepo.deleteById(idExperience);
    }

  /*  @Override
    public Experience assignEtudiantToExperience(Integer idExperience, Integer idDep) {
        Experience e=ExperienceRepo.findById(idExperience);

        e.getEtudiant().add(ce);
        ce.setExperience(e);
        edtREpo.save(ce);
        ExperienceRepo.save(e);
        return ce;
    }*/




    /*   @Override
       public Etudiant assignEtudiantToExperience(Integer id, Integer idEtudiant) {
           Experience ee=experienceService.retrieveExperience(id);
           Etudiant e=retrieveEtudiant(idEtudiant);
           ee.setEtudiant(e);
           experienceService.addExperience(ee);
           return e;
       }*/
  @Override
  public Experience assignEtudiantToExperience(Integer id, Integer idExpereince) {
      Etudiant e=etudiantService.retrieveEtudiant(id);
      Experience ee=retrieveExperience(idExpereince);
      ee.setEtudiant(e);
      etudiantService.addEtudiant(e);
      ExperienceRepo.save(ee);
      return ee;
  }

    @Override
    public Page<Experience> findAllByLieuContaining(String lieu , Pageable pageable) {
        return ExperienceRepo.findAllByLieuContaining(lieu,pageable);

    }


}