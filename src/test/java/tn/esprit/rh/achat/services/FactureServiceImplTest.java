package tn.esprit.rh.achat.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import tn.esprit.rh.achat.services.entities.Facture;
import tn.esprit.rh.achat.services.repositories.FactureRepository;
import tn.esprit.rh.achat.services.services.FactureServiceImpl;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class FactureServiceImplTest {

    @InjectMocks
    private FactureServiceImpl factureService;

    @Mock
    private FactureRepository factureRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void retrieveAllFactures() {
        // Create some sample Facture objects
        Facture facture1 = new Facture(1L, 100.0f, 200.0f, new Date(), new Date(), false, new HashSet<>(), null, new HashSet<>());
        Facture facture2 = new Facture(2L, 150.0f, 250.0f, new Date(), new Date(), false, new HashSet<>(), null, new HashSet<>());

        // Mock the behavior of factureRepository.findAll()
        Mockito.when(factureRepository.findAll()).thenReturn(Arrays.asList(facture1, facture2));

        // Call the service method
        List<Facture> factures = factureService.retrieveAllFactures();

        // Verify that the factureRepository.findAll() method was called
        Mockito.verify(factureRepository).findAll();

        // Verify that the returned list contains the expected Facture objects
        assertEquals(2, factures.size());
        assertEquals(facture1, factures.get(0));
        assertEquals(facture2, factures.get(1));
    }
    @Test
    void addFacture() {
        // Create a sample Facture object
        Facture facture = new Facture();
        facture.setIdFacture(1L); // Set an ID if needed
        facture.setMontantRemise(100.0f);
        facture.setMontantFacture(200.0f);
        facture.setDateCreationFacture(new Date());
        facture.setDateDerniereModificationFacture(new Date());
        facture.setArchivee(false);
        facture.setDetailsFacture(new HashSet<>());
        facture.setFournisseur(null);
        facture.setReglements(new HashSet<>());

        // Mock the behavior of factureRepository.save(facture)
        Mockito.when(factureRepository.save(facture)).thenReturn(facture);

        // Call the service method
        Facture addedFacture = factureService.addFacture(facture);

        // Verify that the factureRepository.save(facture) method was called
        Mockito.verify(factureRepository).save(facture);

        // Verify that the returned Facture is the same as the one we passed
        assertEquals(facture, addedFacture);
    }

    @Test
    void cancelFacture() {
        Long factureId = 1L; // Replace with a valid facture ID

        // Create a mock Facture object
        Facture facture = Mockito.mock(Facture.class);

        // Mock the behavior of factureRepository.findById() and factureRepository.save(facture)
        Mockito.when(factureRepository.findById(factureId)).thenReturn(Optional.of(facture));

        // Call the service method
        factureService.cancelFacture(factureId);

        // Verify that factureRepository.findById(factureId) was called
        Mockito.verify(factureRepository).findById(factureId);

        // Verify that facture.setArchivee(true) was called
        Mockito.verify(facture).setArchivee(true);

        // Verify that factureRepository.save(facture) was called
        Mockito.verify(factureRepository).save(facture);
    }

    @Test
    void retrieveFacture() {
    }

    @Test
    void getFacturesByFournisseur() {
    }

    @Test
    void assignOperateurToFacture() {
    }

    @Test
    void pourcentageRecouvrement() {
    }
}