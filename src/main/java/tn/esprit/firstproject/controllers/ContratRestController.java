package tn.esprit.firstproject.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tn.esprit.firstproject.entities.Contrat;
import tn.esprit.firstproject.entities.Etudiant;
import tn.esprit.firstproject.services.IContratService;
import tn.esprit.firstproject.services.IEtudiantService;
import tn.esprit.firstproject.services.PDFGeneratorService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@RequestMapping("/contrat")
public class ContratRestController {

    private final IContratService iContratService;
    private final IEtudiantService iEtudiantService;
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
    @GetMapping("nbContratsValides/{startDate}/{endDate}")
    public Integer nbContratsValides(@PathVariable("startDate")@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date startDate,
                                     @PathVariable("endDate")@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date endDate
    ) {
        return iContratService.nbContratsValides(startDate,endDate);
    }
    @GetMapping("/pagination/{number}/{page}")
    public List<Contrat> pagination(@PathVariable("number") Integer number , @PathVariable("page") Integer page){
        List<Contrat> all = iContratService.retrieveAllContrats();
        List<Contrat> newList = new ArrayList<Contrat>() ;

        int debut = 1 ;
        if (page>1) {
            debut = number*(page-1) +1  ;
        }
        int fin = debut + number -1 ;
        int count = 1 ;
        for (Contrat e : all ) {
            if ((count>=debut)&&(count<=fin)) {
                newList.add(e) ;
            }
            count++ ;
        }

        return newList ;
    }
    @PutMapping("/{idContrat}/{idEtudiant}")
    Contrat aasignContratToEtudiant(
            @PathVariable("idContrat") Integer idContrat,
            @PathVariable("idEtudiant") Integer idEtudiant){
        Contrat ce = iContratService.retrieveContrat(idContrat);
        Etudiant etudiant = iEtudiantService.getEtudiantById(idEtudiant);
        return iContratService.affectContratToEtudiant(ce, etudiant.getNom(), etudiant.getPrenom());
    }
    @GetMapping("/getChiffreAffaireEntreDeuxDate/{start}/{end}")
    float getChiffreAffaireEntreDeuxDate(@PathVariable("start")@DateTimeFormat(pattern = "yyyy-MM-dd")  Date start,@PathVariable("end") @DateTimeFormat(pattern = "yyyy-MM-dd")  Date end){
        return iContratService.getChiffreAffaireEntreDeuxDate(start,end);
    }
    @GetMapping("/contratBetween2dates/{start}/{end}")
    List<Contrat> contratBetween2dates(@PathVariable("start") @DateTimeFormat(pattern = "yyyy-MM-dd")  Date start,@PathVariable("end") @DateTimeFormat(pattern = "yyyy-MM-dd")  Date end){
        return iContratService.contratBetween2dates(start,end);
    }

@GetMapping("/notification")
    public String notificationContrat(){
        return iContratService.notificationContrat();
    }

@GetMapping("/find/{datedeb}/{datefin}")
    public Contrat retrieveContratByDate( @PathVariable("datedeb") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateDebut, @PathVariable("datefin") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateFin) {
        return iContratService.retrieveContratByDate(dateDebut, dateFin);
    }



}



