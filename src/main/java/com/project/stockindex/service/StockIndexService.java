package com.project.stockindex.service;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.stockindex.model.StockIndex;
import com.project.stockindex.repository.StockIndexRepository;


@Service
public class StockIndexService {
	
	@Autowired
    StockIndexRepository repository;
	
	public StockDetailResponse getByStockTicker(String stockTicker) {
        StockDetailResponse response = new StockDetailResponse();
        response.setStockIndexes(repository.findByStock(stockTicker));
        return response;
    }
	
	public StockIndex createStockIndex(StockIndex stockIndex) {
		return repository.save(stockIndex);
	}
	
	public void createBulk(Collection<StockIndex> stockIndexes){
		repository.saveAll(stockIndexes);
	}

}