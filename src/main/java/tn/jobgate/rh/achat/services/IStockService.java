package tn.jobgate.rh.achat.services;

import tn.jobgate.rh.achat.entities.Stock;

import java.util.List;

public interface IStockService {

	List<Stock> retrieveAllStocks();

	Stock addStock(Stock s);

	void deleteStock(Long id);

	Stock updateStock(Stock u);

	Stock retrieveStock(Long id);

	String retrieveStatusStock();
}
