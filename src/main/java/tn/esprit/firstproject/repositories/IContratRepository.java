package tn.esprit.firstproject.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.firstproject.entities.Contrat;
@Repository
public interface IContratRepository extends CrudRepository<Contrat, Integer> {
}
