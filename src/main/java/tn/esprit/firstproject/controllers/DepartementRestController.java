package tn.esprit.firstproject.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.firstproject.entities.Departement;
import tn.esprit.firstproject.services.IDepartementService;

import java.util.List;

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
    @GetMapping("/all")
    public List<Departement> getAllDepartement() {
        return departementService.retrieveAllDepartements() ;
    }
    @PutMapping("/update")
    public Departement updateDepartement(@RequestBody Departement D) {
        return departementService.updateDepartement(D) ;
    }

    @GetMapping("/get/{id-departement}")
    public Departement getDepartement(@PathVariable("id-departement") Integer idDep ) {
        return departementService.retrieveDepartement(idDep) ;
    }

    @DeleteMapping("/remove/{id]")
    public void removeDepartement(@PathVariable("id") Integer id) {
        departementService.removeDepartement(id);
    }

}
