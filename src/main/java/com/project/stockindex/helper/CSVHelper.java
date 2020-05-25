package com.project.stockindex.helper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;

import com.project.stockindex.model.StockIndex;

public class CSVHelper {

	public static String TYPE = "text/csv";
	static String[] HEADERs = { "quarter", "stock", "date", "open", "high", "low", "close", "volume", 
			"percent_change_price", "percent_change_volume_over_last_wk", "previous_weeks_volume", 
			"next_weeks_open", "next_weeks_close", "percent_change_next_weeks_price", "days_to_next_dividend", 
			"percent_return_next_dividend" };

	public static boolean hasCSVFormat(MultipartFile file) {

		if (!TYPE.equals(file.getContentType())) {
			return false;
		}

		return true;
	}
		
	public static List<StockIndex> csvToStockIndex(InputStream is) {
		
	    try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
	        CSVParser csvParser = new CSVParser(fileReader,
	            CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {
	    	List<StockIndex> stockIndexes = new ArrayList<StockIndex>();
	    	Iterable<CSVRecord> csvRecords = csvParser.getRecords();

	    	for (CSVRecord csvRecord : csvRecords) {
	    		StockIndex stockIndex = new StockIndex(
	              Integer.parseInt(csvRecord.get("quarter")),
	              csvRecord.get("stock"),
	              csvRecord.get("date"),
	              csvRecord.get("open"),
	              csvRecord.get("high"),
	              csvRecord.get("low"),
	              csvRecord.get("close"),
	              csvRecord.get("volume"),
	              csvRecord.get("percent_change_price"), 
	              csvRecord.get("percent_change_volume_over_last_wk"),
	              csvRecord.get("previous_weeks_volume")
	            );
	    		stockIndexes.add(stockIndex);
	    	}
	    	return stockIndexes;
	    } catch (IOException e) {
	    	throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
	    }
	}
}
