package com.example.demo.Controller;

import com.example.demo.Entities.Contrat;
import com.example.demo.Entities.Departement;
import com.example.demo.Entities.Etudiant;
import com.example.demo.Service.IEtudiantService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/etudiant")
@RequiredArgsConstructor
public class EtudiantRestController {
    @Autowired
    IEtudiantService iEtudiantService;

//http://localhost:8080/test/etudiant/all

    @GetMapping("/all")
    @ResponseBody
    public List<Etudiant> getEtudiants(){
        return iEtudiantService.retrieveAllEtudiants();
    }

    @PostMapping("/add")
    public Etudiant addEtudiant(@RequestBody Etudiant etudiant){
        return  iEtudiantService.addEtudiant(etudiant);
    }

    @PutMapping ("/update")
    public Etudiant updateEtudiant(@RequestBody Etudiant etudiant){
        return  iEtudiantService.addEtudiant(etudiant);
    }

    @GetMapping("/get/{id-etudiant}")
    public Etudiant getById(@PathVariable("id-etudiant") Integer id){
       return iEtudiantService.retrieveEtudiant(id);
    }


    @DeleteMapping("/remove/{id-etudiant}")
    public void removeEtudiant(@PathVariable("id-etudiant") Integer id){
        iEtudiantService.removeEtudiant(id);
    }



  //habtch t5dm     "status": 500
    @PutMapping(value = "/addAndAssignEtudiantToEquipeAndContract/{idContrat}/{idequipe}")
    @ResponseBody
    public void addAndAssignEtudiantToEquipeAndContract(@RequestBody Etudiant etudiant, @PathVariable("idContrat")Integer idContrat ,@PathVariable("idequipe") Integer idequipe ) {
        iEtudiantService.addAndAssignEtudiantToEquipeAndContract(etudiant,idContrat,idequipe);
    }
    @PutMapping ("/affectContratToEtudiant/{nom}/{prenom}")
    public Contrat affectContratToEtudiant(@RequestBody Contrat c, @PathVariable("nom") String nom, @PathVariable("prenom") String prenom) {
        return iEtudiantService.affectContratToEtudiant(c,nom,prenom);
    }
    @GetMapping("/list/{idDepart}")
    List<Etudiant> retrieveAllEtudiants(@PathVariable("idDepart") Integer idDepart){
        return iEtudiantService.getEtudiantsByDepartement(idDepart);
    }
  /*  @PutMapping("/update/{id}/{idEtudiant}")
    public Etudiant assignEtudiantToExperience(@PathVariable("id") Integer id , @PathVariable("idEtudiant") Integer idEtudiant){
        return  iEtudiantService.assignEtudiantToExperience(id,idEtudiant);
    }*/
}
