package tn.esprit.rh.achat.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.rh.achat.entities.CategorieProduit;

import java.util.List;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class CategorieProduitServiceTest {

    @Autowired
    private ICategorieProduitService categorieProduitService;

    @Test
    @Order(1)
    public void testRetrieveAllCategorieProduits() {
        List<CategorieProduit> listCategorieProduits = categorieProduitService.retrieveAllCategorieProduits();
        Assertions.assertEquals(3, listCategorieProduits.size());
    }






}

