package tn.esprit.rh.achat.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.rh.achat.entities.Stock;
import tn.esprit.rh.achat.repositories.StockRepository;
import tn.esprit.rh.achat.services.StockServiceImpl;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class StockServiceImplTest {

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
        Stock stock1 = new Stock("Stock 1", 100, 10);
        Stock stock2 = new Stock("Stock 2", 150, 15);

        when(stockRepository.findAll()).thenReturn(Arrays.asList(stock1, stock2));

        List<Stock> stocks = stockService.retrieveAllStocks();

        verify(stockRepository).findAll();

        assertEquals(2, stocks.size());
        assertEquals(stock1, stocks.get(0));
        assertEquals(stock2, stocks.get(1));
    }

    @Test
    void testAddStock() {
        Stock stock = new Stock("New Stock", 200, 20);

        when(stockRepository.save(stock)).thenReturn(stock);

        Stock addedStock = stockService.addStock(stock);

        verify(stockRepository).save(stock);

        assertEquals(stock, addedStock);
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
        Stock stock = new Stock("Stock 1", 100, 10);

        when(stockRepository.save(stock)).thenReturn(stock);

        Stock updatedStock = stockService.updateStock(stock);


        verify(stockRepository, times(1)).save(stock);
        assertEquals(stock, updatedStock);
    }
}

