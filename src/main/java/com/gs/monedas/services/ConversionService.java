package com.gs.monedas.services;


import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;

import com.gs.monedas.models.ConversionModel;
import com.gs.monedas.models.RequestModel;
import com.gs.monedas.repositories.IConversionRepository;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;

@Service
public class ConversionService {
    @Autowired
    IConversionRepository conversionRepository;

    public String getConversion(RequestModel conversion) throws ParseException{
    	String pattern = "yyyy-MM-dd";
    	DateFormat df = new SimpleDateFormat(pattern);
    	Date today = Calendar.getInstance().getTime();        
    	String todayAsString = df.format(today);
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        Date date = f.parse(todayAsString);
        ConversionModel model = conversionRepository.findByCreated(date);
        DecimalFormat def = new DecimalFormat("#0.###");
        
        String response = "";
        double eurValue = model.getEur();
        double conversionFrom = 0;
        double conversionTo = 0;
        
        switch(conversion.getConversionFrom().toLowerCase()) {
        	case "eur": {
        		conversionFrom = model.getEur();
        	}break;
        	case "usd": {
        		conversionFrom = model.getUsd();
        	}break;
        	case "mxn": {
        		conversionFrom = model.getMxn();
        	}break;
        }
        
        switch(conversion.getConversionTo().toLowerCase()) {
	    	case "eur": {
	    		conversionTo = model.getEur();
	    	}break;
	    	case "usd": {
	    		conversionTo = model.getUsd();
	    	}break;
	    	case "mxn": {
	    		conversionTo = model.getMxn();
	    	}break;
	    }
        
        if(conversionFrom != 0 && conversionTo != 0) {
        	response = def.format(eurValue / conversionFrom * conversionTo) ;
        }else {
        	response = "Information not available";
        }
        
    	return response;
    }
}