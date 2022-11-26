package com.esprit.first_project.services;

import com.esprit.first_project.entities.DetailEquipe;
import com.esprit.first_project.repositories.IDetailEquipeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service("DetailEquipeServices")
@RequiredArgsConstructor
public class DetailEquipeServices implements IDetailEquipeServices{
    @Autowired
    private final IDetailEquipeRepository detailEquipeRepository;

    @Override
    public List<DetailEquipe> retrieveAllDetailEquipe() {
        return detailEquipeRepository.retrieveAllDetailEquipe();
    }
    @Override
    public DetailEquipe addDetailEquipe(DetailEquipe detailEquipe) {
        return detailEquipeRepository.save(detailEquipe);
    }
    @Override
    public DetailEquipe updateDetailEquipe(DetailEquipe detailEquipe) {
        return detailEquipeRepository.save(detailEquipe);
    }
    @Override
    public DetailEquipe retrieveDetailEquipe(Integer idDetailEquipe) {
        return detailEquipeRepository.findById(idDetailEquipe).get();
    }
}
