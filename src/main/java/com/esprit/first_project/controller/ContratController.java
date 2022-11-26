package com.esprit.first_project.controller;

import com.esprit.first_project.entities.Contrat;
import com.esprit.first_project.services.IContratServices;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Tag(name = "Contrat Controller")
public class ContratController {

    @Autowired
    private final IContratServices contratServices;

    @GetMapping("/Contrat")
    @ResponseBody
    public List<Contrat> retrieveAllContrats(){
        return contratServices.retrieveAllContrats();
    }

    @PutMapping("/updateContrat")
    @ResponseBody
    public Contrat updateContrat (@RequestBody Contrat ce){
            return contratServices.updateContrat(ce);
    }

    @PostMapping("/addContrat")
    @ResponseBody
    public Contrat addContrat(@RequestBody Contrat c){
    return contratServices.addContrat(c);
    }

    @GetMapping("/getContratById/{id}")
    @ResponseBody
    public Contrat retrieveContrat (@PathVariable("id") Integer id){
        return contratServices.retrieveContrat(id);
    }

    @DeleteMapping("deleteContrat/{id}")
    @ResponseBody
    public void addContrat(@PathVariable("id") Integer id){
        contratServices.removeContrat(id);
    }

    @PutMapping("/affectContratToEtudiant/{nomE}/{prenomE}")
    @ResponseBody
    public void affectContratToEtudiant(@RequestBody Contrat ce,@PathVariable("nomE")  String nomE,@PathVariable("prenomE") String prenomE) {
        contratServices.affectContratToEtudiant(ce,nomE,prenomE);
    }

    @GetMapping("/getChiffreAffaireEntreDeuxDate/{startDate}/{endDate}")
    @ResponseBody
    public float getChiffreAffaireEntreDeuxDate(@PathVariable("startDate")@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date startDate,
                                                @PathVariable("endDate")@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date endDate
    ) {
        return contratServices.getChiffreAffaireEntreDeuxDate(startDate, endDate);
    }

    @GetMapping("nbContratsValides/{startDate}/{endDate}")
    public Integer nbContratsValides(@PathVariable("startDate")@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date startDate,
                                     @PathVariable("endDate")@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date endDate
    ) {
        return contratServices.nbContratsValides(startDate,endDate);
    }

}
