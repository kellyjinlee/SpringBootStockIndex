package com.project.stockindex.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class StockIndex {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private int quarter;
	private String stock;
	private String date;
	private String open;
	private String high;
	private String low;
	private String close;
	private String volume;
	private String percentChangePrice;
	private String percentChangeVolumeOverLastWk;
	private String previousWeeksVolume;
	

	public StockIndex() {
		
	}
	
	public StockIndex(int quarter, String stock, String date, String open, String high, String low,
			String close, String volume, String percentChangePrice, String percentChangeVolumeOverLastWk, String previousWeeksVolume) {
		this.quarter = quarter;
		this.stock = stock;
		this.date = date;
		this.open = open;
		this.high = high;
		this.low = low;
		this.close = close;
		this.volume = volume;
		this.percentChangePrice = percentChangePrice;
		this.percentChangeVolumeOverLastWk = percentChangeVolumeOverLastWk;
		this.previousWeeksVolume = previousWeeksVolume;
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getQuarter() {
		return quarter;
	}
	public void setQuarter(int quarter) {
		this.quarter = quarter;
	}
	@Column(name = "stock", nullable = false)
	public String getStock() {
		return stock;
	}
	public void setStock(String stock) {
		this.stock = stock;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getOpen() {
		return open;
	}
	public void setOpen(String open) {
		this.open = open;
	}
	public String getHigh() {
		return high;
	}
	public void setHigh(String high) {
		this.high = high;
	}
	public String getLow() {
		return low;
	}
	public void setLow(String low) {
		this.low = low;
	}
	public String getClose() {
		return close;
	}
	public void setClose(String close) {
		this.close = close;
	}
	public String getVolume() {
		return volume;
	}
	public void setVolume(String volume) {
		this.volume = volume;
	}
	public String getPercentChangePrice() {
		return percentChangePrice;
	}
	public void setPercentChangePrice(String percentChangePrice) {
		this.percentChangePrice = percentChangePrice;
	}
	public String getPercentChangeVolumeOverLastWk() {
		return percentChangeVolumeOverLastWk;
	}
	public void setPercentChangeVolumeOverLastWk(String percentChangeVolumeOverLastWk) {
		this.percentChangeVolumeOverLastWk = percentChangeVolumeOverLastWk;
	}
	public String getPreviousWeeksVolume() {
		return previousWeeksVolume;
	}
	public void setPreviousWeeksVolume(String previousWeeksVolume) {
		this.previousWeeksVolume = previousWeeksVolume;
	}
	
}