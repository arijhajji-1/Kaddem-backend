package com.example.demo.Service;

import org.springframework.stereotype.Service;
import com.example.demo.Entities.DetailEquipe;
import  com.example.demo.Entities.Equipe;

import java.util.List;
@Service
public interface IEquipeService {
    List<Equipe> retrieveAllEquipes();
    Equipe addEquipe(Equipe e) ;
    Equipe updateEquipe (Equipe e);

    Equipe retrieveEquipe (Integer idEquipe);


////////

    Equipe updateByIdEquipe(Equipe e,Integer ideq);
    DetailEquipe retriveEquipeById(Integer idEquipe);



    String supprimer(Integer id);

    void assignEquipeToDetail(Integer equipeId, DetailEquipe detail);

///////





}
