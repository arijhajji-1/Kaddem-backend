package com.example.demo.Service;

import com.example.demo.Entities.Contrat;
import com.example.demo.Entities.Etudiant;
import com.example.demo.Entities.Notification;
import com.example.demo.Entities.Specialite;
import com.example.demo.Repository.IContratRepo;
import com.example.demo.Repository.IEtudiantRepo;
import com.example.demo.Repository.INotificationRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service("ContratService")
@RequiredArgsConstructor
public class ContratService implements IContratService{
    @Autowired
    private final IContratRepo contratRepository;
    @Autowired
    private final IEtudiantRepo etudiantRepository;
    @Autowired
    private final INotificationRepo notifRepository;

    @Override
    public List<Contrat> retrieveAllContrats() {
        return (List<Contrat>) contratRepository.findAll();
    }

    @Override
    public Contrat updateContrat(Contrat ce) {
        return contratRepository.save(ce);
    }

    @Override
    public Contrat addContrat(Contrat ce) {
        return contratRepository.save(ce);
    }

    @Override
    public Contrat retrieveContrat(Integer idContrat) {
        return contratRepository.findById(idContrat).orElse(null);
    }

    @Override
    public void removeContrat(Integer idContrat) {
        contratRepository.deleteById(idContrat);
    }

    @Override
    public Integer nbContratsValides(Date startDate, Date endDate) {
        List<Contrat> contrats = (List<Contrat>) contratRepository.findAll();
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


    //recherche contrat par date
    public Contrat retrieveContratByDate(Date dateDebut, Date dateFin) {
        return contratRepository.findContratByDateDebutContratAndDateFinContrat(dateDebut, dateFin);
    }

    @Override
    public float getChiffreAffaireEntreDeuxDate(Date startDate, Date endDate) {
        List<Contrat> listContrat = contratRepository.contratBetween2dates(startDate, endDate);
        System.out.println(listContrat);
        float chiffre = 0;
        for (Contrat c : listContrat) {
            if (c.getSpecialite().equals(Specialite.IA)) {
                chiffre = chiffre + 300;
            } else if (c.getSpecialite().equals(Specialite.RESEAUX)) {
                chiffre = chiffre + 350;
            } else if (c.getSpecialite().equals(Specialite.CLOUD)) {
                chiffre = chiffre + 400;
            } else if (c.getSpecialite().equals(Specialite.SECURITY)) {
                chiffre = chiffre + 450;
            }
        }
        return chiffre;
    }

    @Override
    public List<Contrat> contratBetween2dates(Date startDate, Date endDate) {
        return contratRepository.contratBetween2dates(startDate, endDate);
    }

    @Override
    // @Scheduled(cron = "0 */5 * * * *")
    @Scheduled(cron = "0 0 20 * * ?") // every day at 12:00
    //@Scheduled(fixedRate = 5000)
    public String notificationContrat() {
        String result = "";
        List<Contrat> listContrat = (List<Contrat>) contratRepository.findAll();
        for (Contrat c : listContrat) {
            if (contratRepository.finContrat() != null) {
                notifRepository.save(new Notification("fin contrat", c.getEtudiant()));
                result = "notification envoyée";
            }
        }
        return result;
    }

    /* public String retrieveAndUpdateStatusContrat()
      {
          List<Contrat> contrats = (List<Contrat>) contratRepository.findAll();
          List<Contrat> contratRenouv = null ;
          String result="\n============================================================================= \n" ;
          result=result + "Les contrats dont la date fin est prévue dans les prochaines 15 jours sont : \n" ;
          for (Contrat c : contrats) {
              int period = contratRepository.DateDiffContrat(c.getIdContrat()) ; // calcul difference jours
              if (period<=15) {
                  result = result+"Contrat id : "+c.getIdContrat()+"\n" ;
                  result = result+"Jours Restant : "+ period +"\n" ;
                  result = result+"Date Fin : "+c.getDateFinContrat()+"\n" ;
                  result = result+"Specialite : "+c.getSpecialite()+"\n" ;
                  result = result+"Etudiant Concerné : "+c.getEtudiant().getNom()+"\n" ;
              }
              if (period<=0) {
                  c.setArchive(true);
                  contratRepository.save(c) ;
              }
          }

          System.out.println(result);
          return result;
      }*/
    @Override
    public Contrat affectContratToEtudiant(Contrat ce, String nomE, String prenomE) {
        Etudiant e = etudiantRepository.findEtudiantByPrenomEtNom(prenomE,nomE) ;

        e.getContrats().add(ce);
        ce.setEtudiant(e);
        contratRepository.save(ce);
        etudiantRepository.save(e);
        return ce ;
    }

}
