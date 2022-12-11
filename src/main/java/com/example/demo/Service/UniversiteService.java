package com.example.demo.Service;

import com.example.demo.Entities.Departement;
import com.example.demo.Entities.ImageModel;
import com.example.demo.Entities.Universite;
import com.example.demo.Repository.IDepartementRepo;
import com.example.demo.Repository.IUniversiteRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Service("UniversiteService")
@RequiredArgsConstructor
public class UniversiteService implements IUniversiteService{

   @Autowired
   IUniversiteRepo iUniversiteRepo;
    @Autowired
    IDepartementRepo iDepartementRepo;


    @Override
    public List<Universite> retrieveAllUniversites(Integer pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber,5);
        return (List<Universite>)iUniversiteRepo.findAll(pageable);
    }

    @Override
    public Universite addUniversite(Universite u) {
        return iUniversiteRepo.save(u);
    }

    @Override
    public Universite updateUniversite(Universite u) {
        return iUniversiteRepo.save(u);
    }

    @Override
    public Universite retrieveUniversite(Integer idUniversite) {
        return iUniversiteRepo.findById(idUniversite).get();
    }

    @Override
    public List<Departement> retrieveDepartementsByUniversite(Integer idUniversite) {
        return iUniversiteRepo.retrieveDepartementsByUniversite(idUniversite);
    }

    @Override
    public int getmaxid() {
        return iUniversiteRepo.getmaxId();
    }

    @Override
    public void deleteUniversite(Integer idUniversite) {
       Universite u= iUniversiteRepo.findById(idUniversite).get();
        iUniversiteRepo.delete(u);
    }

    @Override
    public List<Departement> listDepart() {

        List<Departement> listDepartaffecter = new ArrayList<>();
        List<Departement> listDepartnonaffecter = new ArrayList<>();
     List<Departement> allDepartement= (List<Departement>) iDepartementRepo.findAll();
        List<Universite> listuniv = retrieveAllUnive();
        for (Universite u : listuniv) {
           /* for (Departement d : u.getDepartements()) {
                listDepart.addAll();
            }*/
            List<Departement> l=  retrieveDepartementsByUniversite(u.getIdUniv());
            listDepartaffecter.addAll(l);

        }
        for(Departement d:allDepartement){
            if(!listDepartaffecter.contains(d)){
                listDepartnonaffecter.add(d);
            }
        }
        return listDepartnonaffecter;
    }

    @Override
    public List<Universite> retrieveAllUnive() {
        return (List<Universite>)iUniversiteRepo.findAll();
    }

    @Override
    public List<Universite> rechercheParNom(String nom) {
        return iUniversiteRepo.rechercheParNom(nom);
    }

    @Override
    public List<Universite> listUniverApartirDate(Date date) {
        return iUniversiteRepo.listUniverApartirDate(date);
    }

    @Override
    public List<ImageModel> ListImagebyIduniv(Integer id) {
        return iUniversiteRepo.ListImagebyIduniv(id);
    }

    @Override
    public void ajouterEtAffecterlisteDepart(Set<Departement> list, Integer idUniv) {
       Universite u= iUniversiteRepo.findById(idUniv).orElse(null);
       if(u!=null)
       u.setDepartements(list);
        iDepartementRepo.saveAll(list);
    }

    @Override
    public Integer countUniversites() {
        return iUniversiteRepo.countUniversites();
    }


}
