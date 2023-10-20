package com.gs.monedas.repositories;

import java.util.Date;
import org.springframework.data.jpa.repository.JpaRepository;

import com.gs.monedas.models.ConversionModel;

public interface IConversionRepository extends JpaRepository<ConversionModel, Long>{
	ConversionModel findByCreated(Date date);
}