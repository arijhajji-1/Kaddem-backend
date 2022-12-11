package com.example.demo.Controller;

import com.example.demo.Entities.Departement;
import com.example.demo.Entities.Universite;
import com.example.demo.Service.IUniversiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Univ")
public class UniversiteController {
    @Autowired
    IUniversiteService iUniversiteService ;



    @PostMapping(value = "/add")
    @ResponseBody
    public void  addUniversity(   @RequestBody Universite u) {
        iUniversiteService.addUniversite(u);
    }


    @GetMapping(value = "/get")
    @ResponseBody
    public List<Universite> getAllUniversites() {
        return iUniversiteService.retrieveAllUniversites();
    }


   /* @PutMapping("/assignUniversiteToDepartement/{idUniversite}/{idDepartement}")
    public void assignUniversiteToDepartement(@RequestParam Integer idUniversite, @RequestParam Integer idDepartement) {
        iUniversiteService.assignUniversiteToDepartement(idUniversite, idDepartement);
    }*/



    @GetMapping("/retrieveDepartementsByUniversite/{idUni}")
    public List<Departement> retrieveDepartementsByUniversite(@PathVariable("idUni") Integer idUni){
        return  iUniversiteService.retrieveDepartementsByUniversite(idUni);

    }

}
