package tn.esprit.rh.achat.service;



import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.rh.achat.entities.CategorieProduit;
import tn.esprit.rh.achat.services.ICategorieProduitService;

import javax.swing.text.DefaultEditorKit;
import java.util.List;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class CategorieProduitsServiceImplTest {

    @Autowired
    ICategorieProduitService Cp;

    @Test
    @Order(1)
public void testRetrieveAllCategorie(){

        List<CategorieProduit> categorieProduitList = Cp.retrieveAllCategorieProduits();
        Assertions.assertEquals(0,categorieProduitList.size());
    }

}
