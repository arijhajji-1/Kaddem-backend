package com.example.demo.Controller;

import com.example.demo.Entities.DetailEquipe;
import com.example.demo.Entities.Etudiant;
import com.example.demo.Service.IDetailEquipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/DetailEquipe")
public class DetailEquipeController {

    @Autowired
    IDetailEquipeService iDetailEquipeService ;

    @GetMapping("/")
    public String sayHello() {
        return "Hello world" ;
    }



    @PostMapping("/add")
@ResponseBody
    public DetailEquipe addDetailEquipe(@RequestBody DetailEquipe detailEquipe) {
       return iDetailEquipeService.addDetailEquipe(detailEquipe);
    }




    @GetMapping("/DetailEquipes")
    public List<DetailEquipe> getAllDE() {
        return  iDetailEquipeService.getAllDE();
    }


}
