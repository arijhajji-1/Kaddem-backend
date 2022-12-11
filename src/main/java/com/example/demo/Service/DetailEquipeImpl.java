package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.Entities.DetailEquipe;
import com.example.demo.Repository.IDetailEquipeRepository;

import java.util.List;
import java.util.Optional;



@Service
public class DetailEquipeImpl implements IDetailEquipeService{

    @Autowired
    IDetailEquipeRepository detailEquipeRepository;

    @Override
    public Optional<DetailEquipe> afficherDetailEquipe(Integer id) {

        DetailEquipe equipe = detailEquipeRepository.findById(id).orElseThrow(() -> new RuntimeException(
                        "detail with Id" + id + " does not exist"
                )
        );
        return detailEquipeRepository.findById(id);
    }

    @Override
    public DetailEquipe create(DetailEquipe detailEquipe) {
        return detailEquipeRepository.save(detailEquipe);
    }

    @Override
    public List<DetailEquipe> lire() {
        return (List<DetailEquipe>) detailEquipeRepository.findAll();
    }


    /*
    @Override
    public DetailEquipe modifier(Long id, DetailEquipe detailEquipe) {
        return detailEquipeRepository.findById(id).map( d ->
        {
            d.setSalle(d.getSalle());
            d.setThematique(d.getThematique());
            d.setEquipe(d.getEquipe());
            return detailEquipeRepository.save(d);
        }).orElseThrow(()-> new RuntimeException("detail equipe non trouvé"));
    }

     */


    @Override
    public String supprimer(Integer id) {
        detailEquipeRepository.deleteById(id);
        return "detail equipe supprimé";    }



    @Override
    public DetailEquipe retriveDetailEquipeById(Integer idEquipe) {
        return detailEquipeRepository.findById(idEquipe).get();
    }

}
