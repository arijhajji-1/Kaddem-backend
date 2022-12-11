package com.example.demo.Controller;

import com.example.demo.Entities.Equipe;
import com.example.demo.Entities.Etudiant;
import com.example.demo.Service.IEquipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Equipes")
public class EquipeController {
    @Autowired
    IEquipeService equipeService;

    @GetMapping("/")
    public String sayHello() {
        return "Hello world" ;
    }
    @PostMapping(value = "/add")
    @ResponseBody
    public void  addProducts(    @RequestBody Equipe p) {
        equipeService.addEquipe(p) ;
    }


    @GetMapping(value = "/getAllEquipes")
    @ResponseBody
    public List<Equipe> getAllEquipes() {
        return   equipeService.retrieveAllEquipes();
    }





    @GetMapping(value = "/retrieveById/{id}")
    @ResponseBody
    public Equipe  getAllEquipes(@PathVariable("id") Integer id) {
        return   equipeService.retrieveEquipe(id);
    }


}
