package com.example.demo.Controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.example.demo.Entities.DetailEquipe;
import com.example.demo.Service.IDetailEquipeService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200",allowedHeaders = "*")
@RestController
@RequestMapping("/DetailEquipeC")
@RequiredArgsConstructor
public class DetailEquipeController {




  private final IDetailEquipeService iDetailEquipeService ;

    @PostMapping("/addDeailEquipe")
    @ResponseBody
    public void addDeailEquipe(@RequestBody DetailEquipe detailEquipe) {
        iDetailEquipeService.create(detailEquipe);
    }



    @GetMapping("/detailequipes")
    @ResponseBody
    public List<DetailEquipe> getAllDetailEquipes() {
        return iDetailEquipeService.lire();
    }

//    @GetMapping("/detaildetailequipes/{id}")
//    @ResponseBody
//    public DetailEquipe getDetailEquipeById(@PathVariable long id) {
//        return detailEquipeServiceImp.retrieveById(id);
//    }

    @DeleteMapping("/deleteDetailEquipe/{id}")
    @ResponseBody
    public void supprimerDetailEquipe(@PathVariable("id") Integer id) {
        iDetailEquipeService.supprimer(id);
    }


















    ///////////////////////////
    /*
    @PutMapping("/update/{id}")
    public DetailEquipe update(@PathVariable Long id, @RequestBody DetailEquipe detailEquipe){
        return detailEquipeServiceImp.modifier(id, detailEquipe);

    }

     */



    ////////////////////////////////////////
    /*

    @PutMapping("/modify-detailequipe/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody DetailEquipe detailequipe, @PathVariable Long id) {
        try {
            Optional<DetailEquipe> existEquipe = detailEquipeServiceImp.afficherDetailEquipe(id);
            detailequipe.setIdDetailEquipe(id);
            detailEquipeServiceImp.create(detailequipe);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

     */

}
