package tn.esprit.rh.achat.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.rh.achat.services.entities.DetailFacture;
import tn.esprit.rh.achat.services.entities.Facture;
import tn.esprit.rh.achat.services.entities.Fournisseur;
import tn.esprit.rh.achat.services.entities.Reglement;
import tn.esprit.rh.achat.services.repositories.FactureRepository;
import tn.esprit.rh.achat.services.services.FactureServiceImpl;

import java.util.*;

@ExtendWith(MockitoExtension.class)
public class FactureServiceImpMock {
    @Mock
    FactureRepository factureRepository;

    @InjectMocks
    FactureServiceImpl factureService;
    Fournisseur f;
    private Set<DetailFacture> detailsFacture;
    private Set<Reglement> reglements;
    Facture facture = new Facture(12345678L, 60, 134, new Date(), new Date(), true, detailsFacture, f, reglements);
    Facture factureTosave = new Facture(12345678L, 60, 134, new Date(), new Date(), true, detailsFacture, f, reglements);

    List<Facture> listFactures = new ArrayList<Facture>() {
        {
            add(new Facture(128L, 20, 164, new Date(), new Date(), true, detailsFacture, f, reglements));
        }
    };

    @Test
    public void testRetriveFacture(){
        Mockito.when(factureRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(facture));
        Facture facture1 = factureService.retrieveFacture(12345678L);
        Assertions.assertNotNull(facture1);
    }

    @Test
    public void testRetrieveAllFacture(){
        Mockito.when(factureRepository.findAll()).thenReturn(listFactures);
        List<Facture> listFactures = factureService.retrieveAllFactures();
        Assertions.assertEquals(1, listFactures.size());
    }
    @Test
    public void testCancelFacture() {
        // Prepare a Facture object and a factureId
        Facture facture = new Facture(5678L, 10, 140, new Date(), new Date(), true, detailsFacture, f, reglements);
        Long factureId = 1L;

        // Define the behavior for the mocked repository
        Mockito.when(factureRepository.findById((factureId))).thenReturn(Optional.of(facture));

        // Call the cancelFacture method
        factureService.cancelFacture(factureId);
        Mockito.verify(factureRepository).findById((factureId));
        Mockito.verify(factureRepository).save((facture));

    }

    @Test
    public void testAddFacture() {
        // Prepare a Facture object to save

        // Define the behavior for the mocked repository when saving
        Mockito.when(factureRepository.save((factureTosave))).thenReturn(factureTosave);

        // Call the addFacture method
        Facture savedFacture = factureService.addFacture(factureTosave);

        Mockito.verify(factureRepository).save((factureTosave));
        // Assertions to check if the returned Facture matches the expected one
        Assertions.assertEquals(factureTosave, savedFacture);


    }

}
