package com.example.demo.Controller;

import com.example.demo.Entities.Contrat;
import com.example.demo.Entities.Etudiant;
import com.example.demo.Repository.IEtudiantRepo;
import com.example.demo.Service.IContratService;
import com.example.demo.Service.IEtudiantService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Date;
import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("/contrat")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class ContratRestController {
    private final IContratService iContratService;
    private final IEtudiantRepo etudiantRepo;

    private final IEtudiantService etudiantService;
    @GetMapping("/all")
    @ResponseBody
    public List<Contrat> getContrat(){
        return iContratService.retrieveAllContrats();
    }
    @PostMapping("/add")
    public Contrat addContrat(@RequestBody Contrat contrat){
        return iContratService.addContrat(contrat);
    }
    @PutMapping ("/update")
    public Contrat updateContrat(@RequestBody Contrat contrat){
        return iContratService.updateContrat(contrat);
    }
    @GetMapping("/get/{id-contrat}")
        public Contrat getById(@PathVariable("id-contrat") Integer id){
            return iContratService.retrieveContrat(id);
        }
    @DeleteMapping("/remove/{id-contrat}")
    public void removeContrat(@PathVariable("id-contrat")Integer id){
        iContratService.removeContrat(id);
    }
    @GetMapping("/nbrContratsValides/{end}/{start}")
    Integer nbContratsValides(@PathVariable("end") @DateTimeFormat(pattern = "yyyy-MM-dd")  Date end ,@PathVariable("start")@DateTimeFormat(pattern = "yyyy-MM-dd")  Date start) {
        return iContratService.nbContratsValides(end,start) ;
    }
    @GetMapping("/getChiffreAffaireEntreDeuxDate/{start}/{end}")
    float getChiffreAffaireEntreDeuxDate(@PathVariable("start")@DateTimeFormat(pattern = "yyyy-MM-dd")  Date start,@PathVariable("end") @DateTimeFormat(pattern = "yyyy-MM-dd")  Date end){
        return iContratService.getChiffreAffaireEntreDeuxDate(start,end);
    }
    @GetMapping("/contratBetween2dates/{start}/{end}")
    List<Contrat> contratBetween2dates(@PathVariable("start") @DateTimeFormat(pattern = "yyyy-MM-dd")  Date start,@PathVariable("end") @DateTimeFormat(pattern = "yyyy-MM-dd")  Date end){
        return iContratService.contratBetween2dates(start,end);
    }

    @GetMapping("/contratExp/")
    List<Contrat> contratExp(){
        return iContratService.contratExp();
    }
    @GetMapping("/contratDepasseAn/")
    List<Contrat> contratDepasseAn(){
        return iContratService.contratDepasseAn();
    }
    /*
     @DeleteMapping("/remove/{id-etudiant}")
    public void removeEtudiant(@PathVariable("id-etudiant") Integer id){
        iEtudiantService.removeEtudiant(id);
    }
     */



    // ========= Abdelaziz
    @PutMapping("/{idContrat}/{idEtudiant}")
    Contrat aasignContratToEtudiant(
            @PathVariable("idContrat") Integer idContrat,
            @PathVariable("idEtudiant") Integer idEtudiant){
        Contrat ce = iContratService.retrieveContrat(idContrat);
        Etudiant etudiant = etudiantRepo.findById(idEtudiant).orElse(null);
        return iContratService.affectContratToEtudiant(ce, etudiant.getNom(), etudiant.getPrenom());
    }
}
