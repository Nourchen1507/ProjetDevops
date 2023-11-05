package tn.esprit.rh.achat.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.rh.achat.entities.Operateur;
import tn.esprit.rh.achat.repositories.OperateurRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class OperateurServiceImplTest {

    @Mock
    OperateurRepository operateurRepository;

    @InjectMocks
    OperateurServiceImpl operateurServiceImpl;

    Operateur operateur = new Operateur(1L, "Nom", "Prenom", "Password", null);

    List<Operateur> operateurs = new ArrayList<>();

    @BeforeEach
    public void setUp() {
        operateurs.add(new Operateur(2L, "Nom2", "Prenom2", "Password2", null));
        operateurs.add(new Operateur(3L, "Nom3", "Prenom3", "Password3", null));
    }

    @Test
    public void testRetrieveOperateur() {
        Mockito.when(operateurRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(operateur));
        Operateur operateur1 = operateurServiceImpl.retrieveOperateur(2L);
        Assertions.assertNotNull(operateur1);
    }

    @Test
    public void testAddOperateur() {
        Mockito.when(operateurRepository.save(Mockito.any(Operateur.class))).thenReturn(operateur);
        Operateur newOperateur = new Operateur(4L, "NewNom", "NewPrenom", "NewPassword", null);
        Operateur addedOperateur = operateurServiceImpl.addOperateur(newOperateur);
        Assertions.assertNotNull(addedOperateur);
        Assertions.assertEquals(4L, addedOperateur.getIdOperateur());
    }

    @Test
    public void testDeleteOperateur() {
        Mockito.doNothing().when(operateurRepository).deleteById(Mockito.anyLong());
        operateurServiceImpl.deleteOperateur(3L);
        Mockito.verify(operateurRepository, Mockito.times(1)).deleteById(3L);
    }

    @Test
    public void testUpdateOperateur() {
        Mockito.when(operateurRepository.save(Mockito.any(Operateur.class))).thenReturn(operateur);
        Operateur updatedOperateur = new Operateur(1L, "UpdatedNom", "UpdatedPrenom", "UpdatedPassword", null);
        Operateur result = operateurServiceImpl.updateOperateur(updatedOperateur);
        Assertions.assertEquals("UpdatedNom", result.getNom());
        Assertions.assertEquals("UpdatedPrenom", result.getPrenom());
        Assertions.assertEquals("UpdatedPassword", result.getPassword());
    }



}
