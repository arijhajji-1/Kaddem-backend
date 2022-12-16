package com.example.demo.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.example.demo.Entities.DetailEquipe;
import  com.example.demo.Entities.Equipe;

import java.io.ByteArrayInputStream;
import java.io.IOException;
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



///////recherche

    Page<Equipe> findAllByNomEquipeContaining(String nomEquipe, Pageable pageable);


///////pagination

    Page<Equipe> lire( Pageable pageable);



    ///////////EXCEL///////


    public  ByteArrayInputStream experienceExcelReport(List<Equipe> equipes) throws IOException;









}
