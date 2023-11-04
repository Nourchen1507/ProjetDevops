package tn.esprit.rh.achat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.rh.achat.entities.Reglement;
import tn.esprit.rh.achat.repositories.ReglementRepository;
import tn.esprit.rh.achat.services.ReglementServiceImpl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ReglementServiceImplTest {

    @Mock
    ReglementRepository reglementRepository;

    @InjectMocks
    ReglementServiceImpl reglementService;

    @Test
    void testAddReglement() {
        Reglement reglement = new Reglement(1L,100, 50, false);
        when(reglementRepository.save(reglement)).thenReturn(reglement);

        Reglement savedReglement = reglementService.addReglement(reglement);

        assertEquals(reglement, savedReglement);
    }

    @Test
    void testRetrieveReglement() {
        Reglement reglement = new Reglement(1L, 100, 50, false);

        when(reglementRepository.findById(1L)).thenReturn(Optional.of(reglement));

        Reglement retrievedReglement = reglementService.retrieveReglement(1L);

        assertEquals(reglement, retrievedReglement);
    }

    @Test
    void testRetrieveAllReglements() {
        Reglement reglement1 = new Reglement(1L, 100, 50, false);
        Reglement reglement2 = new Reglement(2L, 200, 100, false);

        when(reglementRepository.findAll()).thenReturn(List.of(reglement1, reglement2));

        List<Reglement> allReglements = reglementService.retrieveAllReglements();

        assertEquals(2, allReglements.size());
    }


}
