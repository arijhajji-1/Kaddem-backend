package com.example.demo.Service;

import com.example.demo.Entities.DetailEquipe;

import java.util.List;

public interface IDetailEquipeService {
    DetailEquipe addDetailEquipe(DetailEquipe detailEquipe) ;

    void removeDetailEquipe(Integer idDetailEquipe) ;
    public List<DetailEquipe> getAllDE();
}
