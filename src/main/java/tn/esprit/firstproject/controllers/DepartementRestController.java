package tn.esprit.firstproject.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.firstproject.entities.Departement;
import tn.esprit.firstproject.services.IDepartementService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/dep")
public class DepartementRestController {
    private final IDepartementService departementService ;

    @PostMapping("/add")
    public Departement addDepartement(@RequestBody Departement dep) {
        return departementService.addDepartement(dep) ;
    }

    @PutMapping("/update/{idDep}/{idEtud}")
    public Departement affecterDepartement(@PathVariable("idDep") Integer idDep, @PathVariable("idEtud") Integer idEtudiant) {
        return departementService.affecterEtudiant(idDep, idEtudiant) ;
    }
}