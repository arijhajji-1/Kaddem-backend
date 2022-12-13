package tn.esprit.firstproject.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.firstproject.entities.Contrat;

import javax.swing.text.StyledEditorKit;
import java.util.Date;
import java.util.List;

@Repository
public interface IContratRepository extends CrudRepository<Contrat, Integer> {
    @Query("select count (c) from Contrat c where c.dateDebutContrat >= ?1 and c.dateFinContrat <= ?2 and c.archive=true")
    Integer nbContratsValides(Date startDate, Date endDate);
    @Query("select  SUM(c.montantContrat) from Contrat c where c.dateFinContrat<=?2 and c.dateDebutContrat>=?1")
    float getChiffreAffaireEntreDeuxDate(Date startDate, Date endDate);

    @Query("select c from Contrat c where   c.dateDebutContrat>=?1 and c.dateFinContrat<=?2")
    List<Contrat> contratBetween2dates(Date startDate, Date endDate);

    @Query("select DATEDIFF(c.dateFinContrat,current_date) from Contrat c where c.idContrat = ?1")
    Integer DateDiffContrat(Integer idContrat);
    @Query("select c from Contrat c where c.dateFinContrat = current_date")
    List<Contrat> finContrat();
    //find contrat by date debut contrat and date fin contrat
    @Query("select c from Contrat c where c.dateDebutContrat = ?1 and c.dateFinContrat = ?2")
    Contrat findContratByDateDebutContratAndDateFinContrat(Date dateDebut, Date dateFin);
}
