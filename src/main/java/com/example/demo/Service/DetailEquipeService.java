package com.example.demo.Service;

import com.example.demo.Entities.Departement;
import com.example.demo.Entities.Etudiant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.Entities.DetailEquipe;
import com.example.demo.Repository.IDetailEquipeRepo;

import java.util.List;
@Service
public class DetailEquipeService implements IDetailEquipeService {
    IDetailEquipeRepo detailEquipeRepository ;
    @Override
    public DetailEquipe addDetailEquipe(DetailEquipe detailEquipe) {return detailEquipeRepository.save(detailEquipe);}

    @Override
    public void removeDetailEquipe(Integer idDetailEquipe) {
        detailEquipeRepository.deleteById(idDetailEquipe);
    }
    @Override
    public List<DetailEquipe> getAllDE() { return (List<DetailEquipe>) detailEquipeRepository.findAll();}

}
