package com.gs.monedas.models;

import jakarta.persistence.Column;

public class RequestModel {
	@Column
	private String conversionFrom;
	
	@Column
	private String conversionTo;
	
	public String getConversionFrom() {
		return conversionFrom;
	}

	public void setConversionFrom(String conversionFrom) {
		this.conversionFrom = conversionFrom;
	}
	
	public String getConversionTo() {
		return conversionTo;
	}

	public void setConversionTo(String conversionTo) {
		this.conversionTo = conversionTo;
	}
}
