package tn.jobgate.rh.achat.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.jobgate.rh.achat.entities.Operateur;


@Repository
public interface OperateurRepository extends CrudRepository<Operateur, Long> {

}
