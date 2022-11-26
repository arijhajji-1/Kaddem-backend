package com.esprit.first_project.controller;

import com.esprit.first_project.entities.Universite;
import com.esprit.first_project.services.IUniversiteServices;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
@Tag(name = "Universite Controller")
public class UniversiteController {
    @Autowired
    private final IUniversiteServices universiteServices;

    @GetMapping("/Universite")
    @ResponseBody
    public List<Universite> retrieveAllUniversite(){
        return universiteServices.retrieveAllUniversites();
    }

    @PostMapping("/addUniversite")
    @ResponseBody
    public Universite addUniversite(@RequestBody Universite u){
        return universiteServices.addUniversite(u);
    }

    @GetMapping("Universite/{id}")
    @ResponseBody
    public void addUniversite(@PathVariable("id") Integer idUniversite){
        universiteServices.retrieveUniversite(idUniversite);
    }
    @PutMapping("/updateUniversite")
    @ResponseBody
    public Universite updateUniversite (Universite u){
        return universiteServices.updateUniversite(u);
    }

    @PutMapping("/assignUniversiteToDepartement/{idUniversite}/{idDepartement}")
    @ResponseBody
    public void assignUniversiteToDepartement(@PathVariable("idUniversite") Integer idUniversite,@PathVariable("idDepartement") Integer idDepartement){
        universiteServices.assignUniversiteToDepartement(idUniversite,idDepartement);
    }

}
