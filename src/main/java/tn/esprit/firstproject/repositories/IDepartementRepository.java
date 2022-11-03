package tn.esprit.firstproject.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.firstproject.entities.Departement;

@Repository
public interface IDepartementRepository extends CrudRepository<Departement, Integer> {
}
