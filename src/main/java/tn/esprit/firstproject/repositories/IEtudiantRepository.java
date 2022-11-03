package tn.esprit.firstproject.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.firstproject.entities.Etudiant;

import java.util.Date;
import java.util.List;

@Repository
public interface IEtudiantRepository extends CrudRepository<Etudiant, Integer> {
    List<Etudiant> findByPrenomNotNull() ;

    @Query("select e from Etudiant e inner join e.contrats contrat where contrat.dateDebutContrat = ?1")
    List<Etudiant> findByContrat_DateDebutcontrat(Date dateDebutcontrat);

}
