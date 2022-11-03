package tn.esprit.firstproject.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.firstproject.entities.Universite;
@Repository
public interface IUniversiteRepository extends CrudRepository<Universite, Integer> {
}
