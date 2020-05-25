package com.project.stockindex.service;

import java.util.Collection;

import com.project.stockindex.model.StockIndex;

public class StockDetailResponse {
	private Collection<StockIndex> stockIndexes;

    public Collection<StockIndex> getStockIndexes() {
        return stockIndexes;
    }

    public void setStockIndexes(Collection<StockIndex> stockIndexes) {
        this.stockIndexes = stockIndexes;
    }

}
