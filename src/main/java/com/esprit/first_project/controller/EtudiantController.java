package com.esprit.first_project.controller;

import com.esprit.first_project.entities.Etudiant;
import com.esprit.first_project.services.IEtudiantServices;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
@Tag(name = "Etudiant Controller")
public class EtudiantController {

    private final IEtudiantServices etudiantServices;

    @GetMapping("/Etudiant")
    @ResponseBody
    public List<Etudiant> retrieveAllEtudiant(){
        return etudiantServices.retrieveAllEtudiants();
    }

    @PostMapping("/addEtudiant")
    @ResponseBody
    public Etudiant addEtudiant(@RequestBody Etudiant e){
        return etudiantServices.addEtudiant(e);
    }

    @PutMapping("/affectEtudiantTOContrat/{idEtud}/{idContrat}")
    public void affectEtudiantToContrat(@PathVariable("idEtud") Integer idEtud,@PathVariable("idContrat") Integer idContrat){
        etudiantServices.AffectEtudiantToContrat(idEtud,idContrat);
    }
    @GetMapping("Etudiant/{id}")
    @ResponseBody
    public void addEtudiant(@PathVariable("id") Integer idEtudiant){
        etudiantServices.retrieveEtudiant(idEtudiant);
    }

    @DeleteMapping("/deleteEtudiant/{idEtudiant}")
    @ResponseBody
    public void removeEtudiant(Integer idEtudiant){
        etudiantServices.removeEtudiant(idEtudiant);
    }

    @PutMapping("/addAndAssignEtudiantToEquipeAndContract/{idContrat}/{idEquipe}")
    public Etudiant addAndAssignEtudiantToEquipeAndContract(@RequestBody Etudiant e,@PathVariable("idContrat") Integer idContrat,@PathVariable("idEquipe") Integer idEquipe){
        return etudiantServices.addAndAssignEtudiantToEquipeAndContract(e,idContrat,idEquipe);
    }
    @GetMapping("/getEtudiantsByDepartement/{idDepartement}")
    public List<Etudiant> getEtudiantsByDepartement(@PathVariable("idDepartement") Integer idDepartement) {
        return etudiantServices.getEtudiantsByDepartement(idDepartement);
    }
}