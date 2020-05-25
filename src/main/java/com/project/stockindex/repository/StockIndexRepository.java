package com.project.stockindex.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.stockindex.model.StockIndex;

@Repository
public interface StockIndexRepository extends JpaRepository<StockIndex, Long>{
	public List<StockIndex> findByStock(String stock);

}
