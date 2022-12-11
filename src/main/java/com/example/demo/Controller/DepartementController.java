package com.example.demo.Controller;

import com.example.demo.Entities.Departement;
import com.example.demo.Entities.Etudiant;
import com.example.demo.Service.IDepartementService;
import com.example.demo.Service.IEtudiantService;
import com.example.demo.Service.IUniversiteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dep")
@RequiredArgsConstructor
public class DepartementController {
    IDepartementService departementService;

    IUniversiteService universiteService;
    @GetMapping("/all")
    @ResponseBody
    public List<Departement> getDepart() {
        return iDepartementService.retrieveAllDepartements();
    }
    @GetMapping("/get/{id-dep}")

    public Departement getById(@PathVariable("id-dep") Integer id){
        return iDepartementService.retrieveDepartement(id);
    }
    private final IDepartementService iDepartementService;
    @PostMapping("/add")
    public Departement addDepar(@RequestBody Departement dep){
        return  iDepartementService.addDepartement(dep);
    }

    @PutMapping ("/update")
    public Departement updateDepartement(@RequestBody Departement dep){
        return  iDepartementService.addDepartement(dep);
    }



    //affecter un étudiant à un département=>assignEtudiantToDepartement
    @PutMapping("/update/{id}/{idDep}")
    public Departement assignEtudiantToDepartement(@PathVariable("id") Integer id ,@PathVariable("idDep") Integer idDep){
        return  iDepartementService.assignEtudiantToDepartement(id,idDep);
    }
    @PutMapping("/assignUniversiteToDepartement/{idU}/{idDep}")
    public void assignUniversiteToDepartement(@PathVariable("idU") Integer idU ,@PathVariable("idDep") Integer iddep){
        iDepartementService.assignUniversiteToDepartement(idU,iddep);

    }

}
