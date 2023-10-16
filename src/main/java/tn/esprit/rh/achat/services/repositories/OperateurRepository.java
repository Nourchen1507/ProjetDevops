package tn.esprit.rh.achat.services.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.rh.achat.services.entities.Operateur;

@Repository
public interface OperateurRepository extends CrudRepository<Operateur, Long> {

}
