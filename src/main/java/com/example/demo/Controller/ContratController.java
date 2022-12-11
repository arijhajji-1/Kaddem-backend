package com.example.demo.Controller;
import com.example.demo.Entities.Contrat;
import com.example.demo.Entities.Etudiant;
import com.example.demo.Service.IContratService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Date;


@RestController
@RequestMapping("/contrat")
public class ContratController {
    @Autowired
    IContratService contratService ;
    @PostMapping("/add")
    @ResponseBody
    public void addContrat(@RequestBody Contrat ce) {
        contratService.addContrat(ce) ;
    }


    @GetMapping(value = "/getAllContrat")
    @ResponseBody
    public List<Contrat> getAllContrat() {
        return  contratService.retrieveAllContrats();
    }

    @PutMapping ("/update")
    public Contrat updateContrat(@RequestBody Contrat ce){
        return  contratService.addContrat(ce);
    }

    @GetMapping("/get/{idContrat}")
    public Contrat getById(@PathVariable("idContrat") Integer id){
        return contratService.retrieveContrat(id);
    }


    @DeleteMapping("/remove/{idContrat}")
    public void removeEtudiant(@PathVariable("idContrat") Integer id){
        contratService.removeContrat(id);
    }

    @GetMapping("/getChiffreAffaireEntreDeuxDate/{start}/{end}")
    float getChiffreAffaireEntreDeuxDate(@PathVariable("start")@DateTimeFormat(pattern = "yyyy-MM-dd")  Date start,@PathVariable("end") @DateTimeFormat(pattern = "yyyy-MM-dd")  Date end){
        return contratService.getChiffreAffaireEntreDeuxDate(start,end);
    }
    @GetMapping("/contratBetween2dates/{start}/{end}")
    List<Contrat> contratBetween2dates(@PathVariable("start") @DateTimeFormat(pattern = "yyyy-MM-dd")  Date start, @PathVariable("end") @DateTimeFormat(pattern = "yyyy-MM-dd")  Date end){
        return contratService.contratBetween2dates(start,end);
    }
    @GetMapping("/nbrContratsValides/{end}/{start}")
    Integer nbContratsValides(@PathVariable("end") @DateTimeFormat(pattern = "yyyy-MM-dd")  Date end ,@PathVariable("start")@DateTimeFormat(pattern = "yyyy-MM-dd")  Date start) {
        return contratService.nbContratsValides(end,start) ;
    }
    @GetMapping("/contratExp/")
    List<Contrat> contratExp(){
        return contratService.contratExp();
    }
    @GetMapping("/contratDepasseAn/")
    List<Contrat> contratDepasseAn(){
        return contratService.contratDepasseAn();
    }
}
