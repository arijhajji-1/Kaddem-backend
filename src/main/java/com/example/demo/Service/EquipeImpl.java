package com.example.demo.Service;

import com.example.demo.Entities.DetailEquipe;
import com.example.demo.Entities.Equipe;
import com.example.demo.Repository.IEquipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class EquipeImpl implements IEquipeService{
    @Autowired
    IEquipeRepository equipeRepository ;


    @Override
    public List<Equipe> retrieveAllEquipes() {
        return (List<Equipe>) equipeRepository.findAll();
    }

    @Override
    public Equipe addEquipe(Equipe equipe) {

        //equipe.setLogo("../../assets/"+equipe.getLogo().substring(12));

       // = "../../assets/"+equipe.getLogo().substr(12);


        return equipeRepository.save(equipe);
    }

    @Override
    public Equipe updateEquipe(Equipe e) {
        return equipeRepository.save(e);
    }

    @Override
    public Equipe retrieveEquipe(Integer idEquipe) {
        return equipeRepository.findById(idEquipe).get() ;
    }

    @Override
    public Equipe updateByIdEquipe(Equipe e, Integer ideq) {
        e.setIdEquipe(ideq);
        return equipeRepository.save(e);


    }


    ////////////////////
    @Override
    public DetailEquipe retriveEquipeById(Integer idEquipe) {
        return equipeRepository.findById(idEquipe).get().getDetaileq();
    }

    @Override
    public String supprimer(Integer id) {
        equipeRepository.deleteById(id);
        return "equipe supprimé";
    }



    @Override
    public void assignEquipeToDetail(Integer equipeId, DetailEquipe detail) {
        Equipe e = equipeRepository.findById(equipeId).get();
        e.setDetaileq(detail);
        equipeRepository.save(e);
    }


    ////////////////////


}
