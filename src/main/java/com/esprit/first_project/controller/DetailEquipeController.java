package com.esprit.first_project.controller;

import com.esprit.first_project.entities.DetailEquipe;
import com.esprit.first_project.services.IDetailEquipeServices;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
@Tag(name = "Detail Equipe Controller")
public class DetailEquipeController {
    @Autowired
    private final IDetailEquipeServices detailEquipeServices;

    @GetMapping("/DetailEquipe")
    @ResponseBody
    public List<DetailEquipe> retrieveAllDetailEquipe(){
        return detailEquipeServices.retrieveAllDetailEquipe();
    }

    @PostMapping("/addDetailEquipe")
    @ResponseBody
    public DetailEquipe addDetailEquipe(@RequestBody DetailEquipe d){
        return detailEquipeServices.addDetailEquipe(d);
    }

    @GetMapping("DetailEquipe/{id}")
    @ResponseBody
    public void addDetailEquipe(@PathVariable("id") Integer idDetailEquipe){
        detailEquipeServices.retrieveDetailEquipe(idDetailEquipe);
    }

    @GetMapping("/GetOneDetailEquipe/{idDetailE}")
    @ResponseBody
    public DetailEquipe retrieveDetailEquipe(@PathVariable("idDetailE") Integer idDetailE){
        return detailEquipeServices.retrieveDetailEquipe(idDetailE);
    }
}
