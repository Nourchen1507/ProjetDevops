package tn.esprit.rh.achat.services;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.rh.achat.services.entities.Fournisseur;
import tn.esprit.rh.achat.services.services.IFournisseurService;

import java.util.List;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class FournisseurServiceImplTest {
    @Autowired
    IFournisseurService fs;
    @Test
    @Order(1)
    public void testRetrieveAllFournisseurs() {
        List<Fournisseur> fournisseurList = fs.retrieveAllFournisseurs();
        Assertions.assertEquals(0, fournisseurList.size());
    }
}
