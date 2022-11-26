package com.esprit.first_project.controller;

import com.esprit.first_project.entities.Departement;
import com.esprit.first_project.services.IDepartementServices;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
@Tag(name = "Departement Controller")
public class DepartementController {
    @Autowired
    private final IDepartementServices departementServices;

    @GetMapping("/Departement")
    @ResponseBody
    public List<Departement> retrieveAllDepartements(){
        return departementServices.retrieveAllDepartements();
    }

    @PostMapping("/addDepartement")
    @ResponseBody
    public Departement addDepartement(@RequestBody Departement d){
        return departementServices.addDepartement(d);
    }

    @PutMapping("/updateDepartement")
    @ResponseBody
    public Departement updateDepartement (@RequestBody Departement d){
        return departementServices.updateDepartement(d);
    }

    @GetMapping("Departement/{id}")
    @ResponseBody
    public void addDepartement(@PathVariable("id") Integer idDepartement){
        departementServices.retrieveDepartement(idDepartement);
    }

    @PutMapping("/assignEtudiantToDepartement/{etudiantId}/{departementId}")
    public void assignEtudiantToDepartement(@PathVariable("etudiantId") Integer etudiantId,@PathVariable("departementId") Integer departementId){
        departementServices.assignEtudiantToDepartement(etudiantId,departementId);
    }

    @GetMapping("retrieveDepartementsByUniversite/{idUniversite}")
    @ResponseBody
    public long retrieveDepartementsByUniversite(@PathVariable("idUniversite") Integer idUniversite){
        return departementServices.retrieveDepartementsByUniversite(idUniversite).size();
    }
}