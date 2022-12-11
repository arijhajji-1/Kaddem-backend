package com.example.demo.Service;

import com.example.demo.Entities.Contrat;
import com.example.demo.Entities.Specialite;
import com.example.demo.Repository.IContratRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service("ContratService")
@RequiredArgsConstructor
public class ContratService implements IContratService{
   @Autowired
    private IContratRepo contratRepo;
   // ya final ya @requiredconstructor
    @Override
    public List<Contrat> retrieveAllContrats() {
        return (List<Contrat>)contratRepo.findAll();
    }

    @Override
    public Contrat updateContrat(Contrat ce) {return contratRepo.save(ce);}

    @Override
    public Contrat addContrat(Contrat ce) {
        return contratRepo.save(ce);
    }

    @Override
    public Contrat retrieveContrat(Integer idContrat) {
        return contratRepo.findById(idContrat).get();
    }

    @Override
    public void removeContrat(Integer idContrat) {
        contratRepo.deleteById(idContrat);
    }

    @Override
    public float getChiffreAffaireEntreDeuxDate(Date startDate, Date endDate) {
        List<Contrat> listContrat=contratRepo.contratBetween2dates(startDate,endDate);
        System.out.println(listContrat);
        float chiffre=0;
        for( Contrat c:listContrat){
            if(c.getSpecialite().equals(Specialite.IA)){
                chiffre=chiffre+300;
            }
            else if (c.getSpecialite().equals(Specialite.RESEAUX)){
                chiffre=chiffre+350;
            }
            else if(c.getSpecialite().equals(Specialite.CLOUD)){
                chiffre=chiffre+400;
            }
            else if (c.getSpecialite().equals(Specialite.SECURITY)){
                chiffre=chiffre+450;
            }
        }
        return chiffre;
    }
    @Override
    public List<Contrat> contratBetween2dates(Date startDate, Date endDate) {
        return  contratRepo.contratBetween2dates(startDate,endDate);
    }
    @Override
    public Integer nbContratsValides(Date endDate, Date startDate) {
        return contratRepo.countContratByDateDebutContratAfterAndDateFinContratBefore(endDate,startDate);
    }
    @Override
    public List<Contrat> contratExp() {

        return contratRepo.dateExpi();

    }

    @Override
    public List<Contrat> contratDepasseAn()
    {
        return contratRepo.contratDepasseAn();
    }

/*Nous souhaitons créer un service schedulé permettant d’avertir le responsable de la prévue pour les 15 prochains jours afin de contrat de l’étudiant concerné.

Créer un service nous permettant d’afficher 13h en respectant la signature suivante :
String retrieveStatusContrat();
NB: Pour des raisons de test, vous pouvez modifier l’horaire selon l’heure affiché sur
votre machine. Le message sera affiché simplement sur console.
.*/

    @Scheduled(cron = "*/60 * * * * * ")
    public String retrieveStatusContrat()
    {
        List<Contrat> contrats=contratRepo.dateExpi();
        String string = "les contrats concernés tous les 15 jours :";
        for (Contrat c : contrats){
            string=string+"contrat id :"+c.getIdContrat()+"\n";
            string=string+"contrat date fin :"+c.getDateFinContrat()+"\n";
            string=string+"contrat debut date "+c.getDateDebutContrat()+"\n";
            string =string+"specialité"+c.getSpecialite()+"\n";

        }
        System.out.println(string);
        return string;
    }
}
