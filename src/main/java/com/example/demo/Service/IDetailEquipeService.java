package com.example.demo.Service;

import com.example.demo.Entities.DetailEquipe;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;




@Service

public interface IDetailEquipeService {



    public Optional<DetailEquipe> afficherDetailEquipe(Integer id);
    DetailEquipe create(DetailEquipe detailEquipe);

    List<DetailEquipe> lire();

   // DetailEquipe modifier(Integer id,DetailEquipe detailEquipe);

    String supprimer(Integer id);

    DetailEquipe retriveDetailEquipeById(Integer idEquipe);










}
