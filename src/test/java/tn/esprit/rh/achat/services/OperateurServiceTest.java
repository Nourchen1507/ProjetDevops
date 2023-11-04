package tn.esprit.rh.achat.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import tn.esprit.rh.achat.entities.Operateur;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
@ActiveProfiles("test")
public class OperateurServiceTest {

    @Autowired
    private IOperateurService operateurService;

    @Test
    void retrieveAllOperateurs() {
        // Testez la récupération de tous les opérateurs et vérifiez si la liste n'est pas nulle.
        List<Operateur> operateurs = operateurService.retrieveAllOperateurs();
        assertNotNull(operateurs);
        // Effectuez d'autres assertions selon votre logique métier.
    }

    @Test
    void addOperateur() {
        // Testez l'ajout d'un opérateur et vérifiez si l'opérateur est correctement enregistré.
        Operateur nouvelOperateur = new Operateur();
        nouvelOperateur.setIdOperateur(10L);
        nouvelOperateur.setNom("gtari");
        Operateur operateurEnregistre = operateurService.addOperateur(nouvelOperateur);
        assertNotNull(operateurEnregistre);
        // Effectuez d'autres assertions selon votre logique métier.
    }

//    @Test
//    void retrieveOperateur() {
//        // Testez la récupération d'un opérateur par ID.
//        Long idOperateur = 10L; // Remplacez par un ID valide.
//        Operateur operateurRecupere = operateurService.retrieveOperateur(idOperateur);
//        assertNotNull(operateurRecupere);
//        // Effectuez d'autres assertions selon votre logique métier.
//    }
//
//    @Test
//    void updateOperateur() {
//        // Testez la mise à jour d'un opérateur.
//        Long idOperateur = 10L; // Remplacez par un ID valide.
//        Operateur operateurToUpdate = operateurService.retrieveOperateur(idOperateur);
//        assertNotNull(operateurToUpdate);
//        // Modifiez les propriétés de l'opérateur si nécessaire.
//        operateurToUpdate.setNom("Nouveau Nom");
//        Operateur operateurMiseAJour = operateurService.updateOperateur(operateurToUpdate);
//        assertNotNull(operateurMiseAJour);
//        // Effectuez d'autres assertions selon votre logique métier.
//    }
//
//    @Test
//    void deleteOperateur() {
//        // Testez la suppression d'un opérateur par ID.
//        Long idOperateur = 2L; // Remplacez par un ID valide.
//        operateurService.deleteOperateur(idOperateur);
//        Operateur operateurSupprime = operateurService.retrieveOperateur(idOperateur);
//        assertNull(operateurSupprime);
//    }
}
