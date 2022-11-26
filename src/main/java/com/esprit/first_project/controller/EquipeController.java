package com.esprit.first_project.controller;

import com.esprit.first_project.entities.Equipe;
import com.esprit.first_project.services.IEquipeServices;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
@Tag(name = "Equipe Controller")
public class EquipeController {
    @Autowired
    private final IEquipeServices equipeServices;

    @GetMapping("/Equipe")
    @ResponseBody
    public List<Equipe> retrieveAllDetailEquipe(){
        return equipeServices.retrieveAllEquipes();
    }

    @PostMapping("/addEquipe")
    @ResponseBody
    public Equipe addEquipe(@RequestBody Equipe e){
        return equipeServices.addEquipe(e);
    }

    @PutMapping("/updateEquipe")
    @ResponseBody
    public Equipe updateEquipe(@RequestBody Equipe e){
        return equipeServices.updateEquipe(e);
    }

    @PutMapping("/affecteEquipeToDetailEquipe/{idEquipe}/{idDetailE}")
    public void affecteEquipeToDetailEquipe(@PathVariable("idEquipe") Integer idEquipe,@PathVariable("idDetailE") Integer idDetailE){
        equipeServices.affecteEquipeToDetailEquipe(idEquipe,idDetailE);
    }
    @GetMapping("Equipe/{id}")
    @ResponseBody
    public void addEquipe(@PathVariable("id") Integer idEquipe){
        equipeServices.retrieveEquipe(idEquipe);
    }
}
