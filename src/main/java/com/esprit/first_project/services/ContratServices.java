package com.esprit.first_project.services;

import com.esprit.first_project.entities.*;
import com.esprit.first_project.repositories.IContratRepository;
import com.esprit.first_project.repositories.IEtudiantRepository;
import com.esprit.first_project.repositories.IUniversiteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.*;

@Service("ContratServices")
@RequiredArgsConstructor
public class ContratServices implements IContratServices{

    private final IContratRepository contratRepository;
    private final IEtudiantRepository etudiantRepository;
    private final IUniversiteRepository universiteRepository;
    @Override
    public List<Contrat> retrieveAllContrats() {
        return contratRepository.retrieveAllContrats();
    }
    @Override
    public Contrat updateContrat(Contrat ce) {
        return contratRepository.save(ce);
    }
    @Override
    public Contrat addContrat(Contrat ce) {return contratRepository.save(ce);}
    @Override
    public Contrat retrieveContrat(Integer idContrat) {
        return contratRepository.findById(idContrat).get();
    }
    @Override
    public void removeContrat(Integer idContrat) {
        contratRepository.deleteById(idContrat);
    }

    @Override
    public Contrat affectContratToEtudiant(Contrat ce, String nomE, String prenomE) {
        Etudiant e = etudiantRepository.findByNomEAndPrenomE(nomE, prenomE);
        Date date = new Date();
        List<Contrat> contrats = contratRepository.findByEtudiant_IdEtudiant(e.getIdEtudiant());
        Set<Contrat> contrats1 = new HashSet<>();

        if(contrats.size()!=0){
            for (int i=0;i<contrats.size();i++){
                if(!contrats.get(i).getDateFinContrat().before(date) && contrats.get(i).getDateDebutContrat().before(date) ){
                    //if(!contrats.get(i).getArchive())
                    contrats1.add(contrats.get(i));
                }
            }
        }

        if(contrats1.size()<5){
            ce.setEtudiant(e);
            contratRepository.save(ce);
        }

        return ce;
    }

    @Override
    public float getChiffreAffaireEntreDeuxDate(Date startDate, Date endDate) {
        List<Contrat> contrats = contratRepository.retrieveAllContrats();
        int period = (endDate.getYear()-startDate.getYear())*360+(endDate.getMonth()-startDate.getMonth())*30+
                (endDate.getDay()-startDate.getDay());
        int periodInMonth = period/30;
        long ChiffreAffaire= 0;
        for(int i=0;i<contrats.size();i++) {
                //if (!contrats.get(i).getDateDebutContrat().after(findate)|| contrats.get(i).getDateFinContrat().after(startdate)){
                    //ChiffreAffaire+=0;
                //}else{
                    switch (contrats.get(i).getSpecialite()) {
                        case IA:
                            ChiffreAffaire += periodInMonth * 300;
                            break;
                        case SECURITE:
                            ChiffreAffaire += periodInMonth * 450;
                            break;
                        case CLOUD:
                            ChiffreAffaire += periodInMonth * 400;
                            break;
                        case RESEAUX:
                            ChiffreAffaire += periodInMonth * 350;
                            break;
                        default:
                    }
                //}


            System.out.println(i+" :: ChiffreAffaire="+ChiffreAffaire+"DT");
        }
        System.out.println("stardate="+startDate);
        System.out.println("finddate="+endDate);
        System.out.println("period="+period+"Day");
        System.out.println("periodInMonth="+periodInMonth+"Month");
        System.out.println("ChiffreAffaire="+ChiffreAffaire+"DT");

        return ChiffreAffaire;
    }

    @Override
    public Integer nbContratsValides(Date startDate, Date endDate) {
        List<Contrat> contrats = contratRepository.retrieveAllContrats();
        Set<Contrat> contrats1 = new HashSet<>();
        for(int i=0;i<contrats.size();i++){
            if(contrats.get(i).getArchive()==true &&
                    ( (contrats.get(i).getDateDebutContrat().after(startDate) && contrats.get(i).getDateDebutContrat().before(endDate))
                        || (contrats.get(i).getDateFinContrat().after(startDate) && contrats.get(i).getDateFinContrat().before(endDate))
                        || (contrats.get(i).getDateDebutContrat().before(startDate) && contrats.get(i).getDateFinContrat().after(endDate))
                    )
            ){
                contrats1.add(contrats.get(i));
            }
        }
        return contrats1.size();
    }


}