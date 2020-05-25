package com.project.stockindex.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.project.stockindex.helper.CSVHelper;
import com.project.stockindex.model.StockIndex;
import com.project.stockindex.repository.StockIndexRepository;

@Service
public class CSVService {
	
    @Autowired
    StockIndexRepository repository;

    public ResponseEntity<?> save(MultipartFile file) {
    	Map<String, Object> response = new HashMap<>();
    	if (CSVHelper.hasCSVFormat(file)) {
    		try {
        		List<StockIndex> indexes = CSVHelper.csvToStockIndex(file.getInputStream());
        		repository.saveAll(indexes);
        		response.put("message", "Uploaded the file successfully: " + file.getOriginalFilename());
    		    return ResponseEntity.status(HttpStatus.OK).body(response);
        	} catch (IOException e) {
        		response.put("message", "Could not upload the file: " + file.getOriginalFilename() + "!");
    		    return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(response);
        	}
    	}

    	response.put("message", "Please upload a csv file!");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
}