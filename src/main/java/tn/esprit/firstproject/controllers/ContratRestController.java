package tn.esprit.firstproject.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.firstproject.services.IContratService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/contrat")
public class ContratRestController {
    private  final IContratService contratService ;
     
}
