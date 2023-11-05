package tn.esprit.rh.achat.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.rh.achat.entities.Produit;
import tn.esprit.rh.achat.repositories.ProduitRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)

public class ProduitServiceImplTest {
    @Mock
    ProduitRepository produitRepository;
    @InjectMocks
    ProduitServiceImpl produitServiceImpl;
    Produit produit = new Produit(1L,"1",null,30,null,null,null,null,null);
    List<Produit> produits = new ArrayList<>();
    @BeforeEach
    public void setUp() {
        produits.add(new Produit(2L, "2", null, 40, null,null,null,null,null));
        produits.add(new Produit(3L, "3", null, 50, null,null,null,null,null));
    }
    @Test
    public void testRetrieveProduit() {
        Mockito.when(produitRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(produit));
        Produit produit1 = produitServiceImpl.retrieveProduit(2L);
        Assertions.assertNotNull(produit1);
    }

    @Test
    public void testAddProduit() {
        Mockito.when(produitRepository.save(Mockito.any(Produit.class))).thenReturn(produit);
        Produit newproduit = new Produit(4L,"4",null,60,null,null,null,null,null);
        Produit addedProduit = produitServiceImpl.addProduit(newproduit);
        Assertions.assertNotNull(addedProduit);
        Assertions.assertEquals(4L, addedProduit.getIdProduit());
    }


}
