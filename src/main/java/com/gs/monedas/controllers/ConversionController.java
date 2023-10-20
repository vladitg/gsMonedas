package com.gs.monedas.controllers;



import org.springframework.beans.factory.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import com.gs.monedas.models.RequestModel;
import com.gs.monedas.services.ConversionService;

import java.text.ParseException;

import org.springframework.http.ResponseEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/conversion")
public class ConversionController {
	
    @Autowired
    private ConversionService conversionService;
    
    private static final Logger logger = LoggerFactory.getLogger(ConversionController.class);
    
    @PostMapping
    @PreAuthorize("hasAuthority('ROLE_USER')") 
    public String getConversion(@RequestBody RequestModel conversion) throws ParseException{
    	return this.conversionService.getConversion(conversion);
    }
}
