package com.example.demo.Controller;

import com.example.demo.Entities.DetailEquipe;
import com.example.demo.Entities.Equipe;
import com.example.demo.Service.IDetailEquipeService;
import com.example.demo.Service.IEquipeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/equipe")
//@CrossOrigin(origins = "http://localhost:4200",allowedHeaders = "*")
@CrossOrigin(origins = "*")
public class EquipeRestController {
    private final IEquipeService iEquipeService;


    private final IDetailEquipeService iDetailEquipeService;


    @GetMapping("/all")
    @ResponseBody
    public List<Equipe> getAllEquipes(){
        return  iEquipeService.retrieveAllEquipes();
    }
    @PostMapping("/add")
    public Equipe addEquipe(@RequestBody Equipe equipe){
        return  iEquipeService.addEquipe(equipe);
    }



    @PutMapping("/update")
    public Equipe updateEquipe(@RequestBody Equipe equipe){
        return iEquipeService.updateEquipe(equipe);
    }



    @PutMapping("/updateById/{ideq}")
    public Equipe updateByIdEquipe(@RequestBody Equipe equipe,
                                   @PathVariable("ideq") Integer ideq
                                   ){
        return iEquipeService.updateByIdEquipe(equipe,ideq);
    }








    @GetMapping("/getequipe/{id-equipe}")
    public Equipe getById(@PathVariable("id-equipe") Integer id){
        return iEquipeService.retrieveEquipe(id);
    }



    @DeleteMapping("/deleteEquipe/{id}")
    @ResponseBody
    public void removeDetailEquipe(@PathVariable("id") Integer idEquipe ){
       // detailEquipeService.removeDetailEquipe(idEquipe);
        iEquipeService.supprimer(idEquipe);
    }


    /**
     *
     * @param detailEquipe  ajouter et affecter details equipe to equipe
     * @param id
     */

    @PutMapping("addDetails/{id}")
    public void saveDetailsTeam(
            @Valid @RequestBody DetailEquipe detailEquipe, @PathVariable Integer id)
    {
        //detailEquipeService.create(detailEquipe);
        iDetailEquipeService.create(detailEquipe);

       // equipeService.assignEquipeToDetail(id,detailEquipe);
        iEquipeService.assignEquipeToDetail(id,detailEquipe);


    }













}
