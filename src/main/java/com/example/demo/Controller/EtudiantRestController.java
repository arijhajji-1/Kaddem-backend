package com.example.demo.Controller;

import com.example.demo.Entities.Contrat;
import com.example.demo.Entities.Departement;
import com.example.demo.Entities.Equipe;
import com.example.demo.Entities.Etudiant;
import com.example.demo.Repository.IEtudiantRepo;
import com.example.demo.Service.EtudiantPDFExporter;
import com.example.demo.Service.IDepartementService;
import com.example.demo.Service.IEquipeService;
import com.example.demo.Service.IEtudiantService;
import com.lowagie.text.DocumentException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Tag(name="student management")
@RestController
@RequestMapping("/etudiant")
@RequiredArgsConstructor
public class EtudiantRestController {
    private final IEtudiantService iEtudiantService, etudiantService;
    private final IEquipeService equipeService;
    //couplage faibles
    //Id : @RequiredArgsConstructor
//http://localhost:8080/test/etudiant/all

    @Operation(description = "Retrieve all students ")
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

    @PutMapping ("/addparasso/{idContrat}/{idEquie}")
    public Etudiant addEtudiantparasso(@RequestBody Etudiant etudiant,@PathVariable("idContrat") Integer idContrat,@PathVariable("idEquie") Integer idEquipe){
        return  iEtudiantService.addAndAssignEtudiantToEquipeAndContract(etudiant,idContrat,idEquipe);
    }
    @PutMapping ("/affectContratToEtudiant/{nom}/{prenom}")
    public Contrat affectContratToEtudiant(@RequestBody Contrat c, @PathVariable("nom") String nom, @PathVariable("prenom") String prenom) {
        return iEtudiantService.affectContratToEtudiant(c,nom,prenom);
    }

    @GetMapping("/get/bydep/{name}")
    public List<Etudiant> getByNamedep(@PathVariable("name") String name){
        return iEtudiantService.bydepratement(name);
    }

    @GetMapping("/getEtudiantsByDepartement/{iddep}")
    public List<Etudiant> getEtudiantsByDepartement(@PathVariable("iddep") Integer iddep){
      //  Departement d=iDepartementService.retrieveDepartement(iddep);
        return iEtudiantService.getEtudiantsByDepartement(iddep);
    }




    // ======= Abdelaziz
    @GetMapping("/contratsByEtudiant/{idEtudiant}")
    public Set<Contrat> getContratsByEtudiant(@PathVariable("idEtudiant") Integer idEtudiant) {
        return etudiantService.getContratsByEtudiant(idEtudiant) ;
    }

    // ======= Added
    @GetMapping("/equipesByEtudiant/{idEtudiant}")
    public Set<Equipe> getEquipesByEtudiant(@PathVariable("idEtudiant") Integer idEtudiant) {
        return etudiantService.getEquipesByEtudiant(idEtudiant) ;
    }

    @PutMapping("/assignEquipeToEtudiant/{idEquipe}/{idEtudiant}")
    Equipe aasignContratToEtudiant(
            @PathVariable("idEquipe") Integer idEquipe,
            @PathVariable("idEtudiant") Integer idEtudiant){
        Equipe eq = equipeService.retrieveEquipe(idEquipe);
        return etudiantService.affectEquipeToEtudiant(eq, idEtudiant);
    }

    @GetMapping("/totalContratsAffectes")
    public Integer totalContratsAffectes() {
        return etudiantService.totalContratsAffectés() ;
    }

    @GetMapping("/totalEquipesAffectes")
    public Integer totalEquipesAffectes() {
        return etudiantService.totalEquipesAffectés() ;
    }

    @PutMapping("/removeContratAffecte/{idEtudiant}/{idContrat}")
    Contrat removeContratAffecte(
            @PathVariable("idEtudiant") Integer idEtudiant,
            @PathVariable("idContrat") Integer idContrat) {
        return etudiantService.RemoveContratAffecte(idEtudiant,idContrat) ;
    }

    @PutMapping("/removeEquipeAffecte/{idEtudiant}/{idEquipe}")
    Equipe removeEquipeAffecte(
            @PathVariable("idEtudiant") Integer idEtudiant,
            @PathVariable("idEquipe") Integer idEquipe) {
        return etudiantService.RemoveEquipeAffecte(idEtudiant,idEquipe) ;
    }

    @GetMapping("/etudiantsNonAffectes")
    public Set<Etudiant> etudiantsNonAffectes() {
        return etudiantService.getEtudiantsNonAffectesEquipeContrat() ;
    }


    private final IEtudiantRepo etudiantRepository;
    @GetMapping("/etudiant/export/pdf")
    public void exportToPDF(HttpServletResponse response) throws DocumentException, IOException {
        response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=users_" + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);

        List<Etudiant> listUsers = (List<Etudiant>) etudiantRepository.findAll();

        EtudiantPDFExporter exporter = new EtudiantPDFExporter(listUsers);
        exporter.export(response);

    }


}
