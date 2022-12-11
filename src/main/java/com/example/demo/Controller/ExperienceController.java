package com.example.demo.Controller;
import com.example.demo.Entities.Experience;
import com.example.demo.Service.ExportExperienceService;
import com.example.demo.Service.IExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;


@RestController
@RequestMapping("/Experience")
@CrossOrigin(origins = "*")

public class ExperienceController {
    @Autowired
    IExperienceService ExperienceService ;


    @Autowired
    private ExportExperienceService exportExperienceService;
    @PostMapping("/add")
    @ResponseBody
    public void addExperience(@RequestBody Experience ce) {
        ExperienceService.addExperience(ce) ;
    }


    @GetMapping(value = "/getAllExperience")
    @ResponseBody
    public List<Experience> getAllExperience()
    {
        return  ExperienceService.retrieveAllExperiences();

    }
    //pagination
    @GetMapping(value = "/getAllExperienceWithPagination")
    @ResponseBody
    public List<Experience> getAllExperience(@RequestParam(defaultValue = "0") int pageNumber)
    {
        return  ExperienceService.retrieveAllExperience(pageNumber);

    }

    @PutMapping ("/update/{id}")
    public Experience updateExperience(@PathVariable("id") Integer id, @RequestBody Experience ce) throws Exception {
        return  ExperienceService.updateExperience(id,ce);
    }

    @GetMapping("/get/{idExperience}")
    public Experience getById(@PathVariable("idExperience") Integer id){
        return ExperienceService.retrieveExperience(id);
    }


    @DeleteMapping("/remove/{idExperience}")
    public void removeEtudiant(@PathVariable("idExperience") Integer id){
        ExperienceService.removeExperience(id);
    }
    @PutMapping("/update/{id}/{idEtudiant}")
    public Experience assignEtudiantToExperience(@PathVariable("id") Integer id , @PathVariable("idEtudiant") Integer idEtudiant){
        return  ExperienceService.assignEtudiantToExperience(id,idEtudiant);
    }
    @GetMapping("/export/pdf")
    public ResponseEntity<InputStreamResource> exportTermsPdf(){
        List<Experience> experience = (List<Experience>) ExperienceService.retrieveAllExperiences();
        ByteArrayInputStream bais = exportExperienceService.experiencesPDFRepot(experience);
    HttpHeaders headers = new HttpHeaders();
    headers.add("Content-Disposition", "inline; filename=experiences.pdf");
   return ResponseEntity
            .ok()
            .headers(headers)
            .contentType(org.springframework.http.MediaType.APPLICATION_PDF)
            .body(new InputStreamResource(bais));
    }
    @GetMapping("/export/excel")
    public ResponseEntity<InputStreamResource> exportExperiencesExcel() throws IOException {
        List<Experience> experience = (List<Experience>) ExperienceService.retrieveAllExperiences();
        ByteArrayInputStream bais = exportExperienceService.experienceExcelReport(experience);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=experiences.xlsx");
        return ResponseEntity.ok().headers(headers).body(new InputStreamResource(bais));
    }
    //methode1 : avec Path Variable
    @GetMapping("/search/{lieu}")
    public ResponseEntity<?> searchByTitreDuProfil(@PathVariable String lieu, @PageableDefault(sort = "lieu", direction = Sort.Direction.ASC) Pageable pageable) {
       Page<Experience> experiencesPage = ExperienceService.findAllByLieuContaining(lieu, pageable);
       if (experiencesPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(experiencesPage, HttpStatus.OK);
    }
    //methode2 : avec Request Param
    @GetMapping("/search")
    public ResponseEntity<?> searchByTitreDuProfilRequest(@RequestParam("lieu") String search, @PageableDefault(sort = "lieu", direction = Sort.Direction.ASC) Pageable pageable) {
        Page<Experience> experiencesPage = ExperienceService.findAllByLieuContaining(search, pageable);
        if (experiencesPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(experiencesPage, HttpStatus.OK);
    }
}
