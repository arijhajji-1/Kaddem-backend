package com.example.demo.Controller;

import com.example.demo.Entities.Departement;
import com.example.demo.Entities.Etudiant;
import com.example.demo.Entities.ImageModel;
import com.example.demo.Entities.Universite;
import com.example.demo.Repository.IDepartementRepo;
import com.example.demo.Service.IDepartementService;
import com.example.demo.Service.IUniversiteService;
import com.example.demo.Service.UniversiteService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.criteria.CriteriaBuilder;
import java.awt.*;
import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@RequestMapping("/univer")
@RequiredArgsConstructor

public class UniversiteRestController {
    @Autowired
    private  final IUniversiteService iUniversiteService;

    @GetMapping("/all")
    @ResponseBody
    public List<Universite> getAllUni(@RequestParam(defaultValue = "0") int pageNumber){

        return iUniversiteService.retrieveAllUniversites(pageNumber);
    }
    @GetMapping("/maxid")
    @ResponseBody
    public int getmaxid(){
        return iUniversiteService.getmaxid();
    }

    @PostMapping("/add")
    public Universite addUniversite(@RequestBody Universite universite){
        LocalDate todaysDate = LocalDate.now();
        //System.out.println(todaysDate);
        ZoneId defaultZoneId = ZoneId.systemDefault();
        Date date = Date.from(todaysDate.atStartOfDay(defaultZoneId).toInstant());
        universite.setDateAjout( date);
        return iUniversiteService.addUniversite(universite);
    }
   // @PostMapping(value = {"/addWithImage"}, consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
   @RequestMapping(value = "/addWithImage", method = RequestMethod.POST, consumes = {"multipart/form-data"})

   public Universite addWithImage (@RequestPart("universite") Universite universite,
                                    @RequestPart("imageFile")MultipartFile[] file){
        try{
           // Set<ImageModel> images= uploadImage
            Set<ImageModel> images=uploadImage(file);
            universite.setImages(images);
            LocalDate todaysDate = LocalDate.now();
            //System.out.println(todaysDate);
            ZoneId defaultZoneId = ZoneId.systemDefault();
            Date date = Date.from(todaysDate.atStartOfDay(defaultZoneId).toInstant());
            universite.setDateAjout( date);
           return iUniversiteService.addUniversite(universite);
        }catch(Exception e){
        System.out.println(e.getMessage());
            return null;
        }

    }

    public Set<ImageModel>  uploadImage(MultipartFile[] multipartFiles)throws IOException {
        Set<ImageModel> imageModels=new HashSet<>();
        for(MultipartFile file:multipartFiles){
            ImageModel imageModel=new ImageModel(
                    file.getOriginalFilename(),
                    file.getContentType(),
                    file.getBytes()
            );
            imageModels.add(imageModel);
        }
        return imageModels;
    }
    @PutMapping ("/update")
    public Universite updateUni(@RequestBody Universite universite){
        return iUniversiteService.updateUniversite(universite);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteUniv(@PathVariable("id") Integer id){
        iUniversiteService.deleteUniversite(id);
    }
    @GetMapping("/get/{id-uni}")
    public Universite getById(@PathVariable("id-uni")Integer id){
        return iUniversiteService.retrieveUniversite(id);

    }
@GetMapping("/retrieveDepartementsByUniversite/{idUni}")
    public List<Departement> retrieveDepartementsByUniversite(@PathVariable("idUni") Integer idUni){
       // System.out.println(iUniversiteService.retrieveDepartementsByUniversite(idUni));
        return  iUniversiteService.retrieveDepartementsByUniversite(idUni);

}
@GetMapping("/listdepart")
    public List<Departement> listDepartement(){
    return  iUniversiteService.listDepart();
}
@GetMapping("/rechercheParNom/{nom}")
    List<Universite> rechercheParNom(@PathVariable("nom") String nom){
        return iUniversiteService.rechercheParNom(nom);
}
@GetMapping("/listUniverApartirDate/{date}")
    List<Universite> listUniverApartirDate(@PathVariable("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date){
        return iUniversiteService.listUniverApartirDate(date);
}
@GetMapping("/ListImagebyIduniv/{id}")
    List<ImageModel> ListImagebyIduniv(@PathVariable("id") Integer id){
        return iUniversiteService.ListImagebyIduniv(id);
}

@PostMapping("/ajouterEtAffecterlisteDepart/{idUniv}")
    void ajouterEtAffecterlisteDepart(@RequestBody Set<Departement> list,@PathVariable("idUniv") Integer idUniv){

        iUniversiteService.ajouterEtAffecterlisteDepart(list,idUniv);
}
}

