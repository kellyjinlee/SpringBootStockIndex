package com.project.stockindex.controller;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.project.stockindex.model.StockIndex;
import com.project.stockindex.service.StockDetailResponse;
import com.project.stockindex.service.StockIndexService;

@RestController
public class StockIndexController {
	
	@Autowired
	private StockIndexService stockIndexService;
	
	// Find by Stock Ticker
	@GetMapping("/stockindexes/{stockTicker}")
	public StockDetailResponse getByStockTicker(@PathVariable String stockTicker) {
        return stockIndexService.getByStockTicker(stockTicker);
    }
	
	// Create
	@PostMapping("/stockindexes")
	public StockIndex createStockIndex(@RequestBody StockIndex stockIndex) {
		return stockIndexService.createStockIndex(stockIndex);
	}
	
	// Bulk Create
	@PostMapping("/stockindexes/all")
    public void createBulk(@RequestBody Collection<StockIndex> stockIndexes) {
       stockIndexService.createBulk(stockIndexes);
    }

}