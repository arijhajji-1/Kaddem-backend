package com.example.demo.Controller;

import com.example.demo.Entities.Departement;
import com.example.demo.Entities.Etudiant;
import com.example.demo.Service.IDepartementService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/dep")
@RequiredArgsConstructor
public class DepartementRestController {
    private final IDepartementService iDepartementService;
    @GetMapping("/get/{id-dep}")

    public Departement getById(@PathVariable("id-dep") Integer id){
        return iDepartementService.retrieveDepartement(id);
    }

    @PostMapping("/add")
    public Departement addDepar(@RequestBody Departement dep){
        return  iDepartementService.addDepartement(dep);
    }
    @GetMapping("/all")
    @ResponseBody
    public List<Departement> getDepart() {
        return iDepartementService.retrieveAllDepartements();
    }
    @PutMapping("/updateDepar")
    public Departement Departementupdate(@RequestBody Departement d){

        return iDepartementService.updateDepartement(d);

    }
    @PutMapping("/update/{id}/{idDep}")
    public Departement assignEtudiantToDepartement(@PathVariable("id") Integer id ,@PathVariable("idDep") Integer idDep){
        return  iDepartementService.assignEtudiantToDepartement(id,idDep);
    }

    @PutMapping("/assignUniversiteToDepartement/{idU}/{idDep}")
    public void assignUniversiteToDepartement(@PathVariable("idU") Integer idU ,@PathVariable("idDep") Integer iddep){
         iDepartementService.assignUniversiteToDepartement(idU,iddep);

    }
    @DeleteMapping("/remove/{id-depart}")
    public void removeEtudiant(@PathVariable("id-depart") Integer id){
        iDepartementService.delete(id);
    }

}
