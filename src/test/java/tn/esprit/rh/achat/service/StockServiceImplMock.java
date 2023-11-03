package tn.esprit.rh.achat.service;



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.rh.achat.entities.Stock;
import tn.esprit.rh.achat.repositories.StockRepository;
import tn.esprit.rh.achat.services.StockServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;
import tn.esprit.rh.achat.entities.Stock;
import tn.esprit.rh.achat.repositories.StockRepository;
import tn.esprit.rh.achat.services.StockServiceImpl;

@SpringBootTest
@ExtendWith(MockitoExtension.class)


public class StockServiceImplMock {

    @InjectMocks

    private StockServiceImpl stockService;

    @Mock
    private StockRepository stockRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    void testRetrieveAllStocks() {
        List<Stock> stocks = new ArrayList<>();
        stocks.add(new Stock("Stock 1", 100, 10));
        stocks.add(new Stock("Stock 2", 150, 15));

        when(stockRepository.findAll()).thenReturn(stocks);

        List<Stock> retrievedStocks = stockService.retrieveAllStocks();

        verify(stockRepository).findAll();

        assertEquals(2, retrievedStocks.size());
        assertEquals(stocks.get(0), retrievedStocks.get(0));
        assertEquals(stocks.get(1), retrievedStocks.get(1));
    }

    @Test
    void testAddStock() {
        Stock stockToSave = new Stock("New Stock", 200, 20);

        when(stockRepository.save(stockToSave)).thenReturn(stockToSave);

        Stock addedStock = stockService.addStock(stockToSave);

        verify(stockRepository).save(stockToSave);

        assertEquals(stockToSave, addedStock);
    }

    @Test
    void testDeleteStock() {
        Long stockId = 1L;

        doNothing().when(stockRepository).deleteById(stockId);

        stockService.deleteStock(stockId);

        verify(stockRepository, times(1)).deleteById(stockId);
    }

    @Test
    void testUpdateStock() {
        Stock stockToUpdate = new Stock("Stock 1", 100, 10);

        when(stockRepository.save(stockToUpdate)).thenReturn(stockToUpdate);

        Stock updatedStock = stockService.updateStock(stockToUpdate);

        verify(stockRepository, times(1)).save(stockToUpdate);

        assertEquals(stockToUpdate, updatedStock);
    }

    @Test
    void testRetrieveStock() {
        Long stockId = 12345678L;
        Stock stock = new Stock("Stock 1", 100, 10);

        when(stockRepository.findById(stockId)).thenReturn(Optional.of(stock));

        Stock retrievedStock = stockService.retrieveStock(stockId);

        verify(stockRepository).findById(stockId);

        assertNotNull(retrievedStock);
    }

}
