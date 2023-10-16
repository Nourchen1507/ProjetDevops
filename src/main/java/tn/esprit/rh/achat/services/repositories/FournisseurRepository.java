package tn.esprit.rh.achat.services.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.rh.achat.services.entities.Fournisseur;

@Repository
public interface FournisseurRepository extends JpaRepository<Fournisseur, Long> {

}
