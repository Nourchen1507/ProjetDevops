package tn.esprit.rh.achat.services.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.rh.achat.services.entities.CategorieProduit;

@Repository
public interface CategorieProduitRepository extends JpaRepository<CategorieProduit, Long>{

}
