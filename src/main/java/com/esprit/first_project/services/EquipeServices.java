package com.esprit.first_project.services;

import com.esprit.first_project.entities.DetailEquipe;
import com.esprit.first_project.entities.Equipe;
import com.esprit.first_project.repositories.IEquipeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service("EquipeServices")
@RequiredArgsConstructor
public class EquipeServices implements IEquipeServices{
    @Autowired
    private final IEquipeRepository equipeRepository;
    private final IDetailEquipeServices detailEquipeServices;

    @Override
    public List<Equipe> retrieveAllEquipes() {
        return equipeRepository.retrieveAllEquipes();
    }
    @Override
    public Equipe addEquipe(Equipe e) {
        return equipeRepository.save(e);
    }
    @Override
    public Equipe updateEquipe(Equipe e) {
        return equipeRepository.save(e);
    }
    @Override
    public Equipe retrieveEquipe(Integer idEquipe) {
        return equipeRepository.findById(idEquipe).get();
    }
    @Override
    public void affecteEquipeToDetailEquipe(Integer idEquipe, Integer idDetailE){
        DetailEquipe dE=detailEquipeServices.retrieveDetailEquipe(idDetailE);
        Equipe eq=retrieveEquipe(idEquipe);
        dE.setEquipe(eq);//affecter departement au etudiant objet
        detailEquipeServices.updateDetailEquipe(dE);//sauvgarder l'objet
    }
   }
