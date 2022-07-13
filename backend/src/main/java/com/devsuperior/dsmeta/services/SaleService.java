package com.devsuperior.dsmeta.services;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.repositories.SaleRepository;

@Service //componente do sistema
public class SaleService {
	
	@Autowired
	private SaleRepository repsitory;
	
	public Page<Sale> findSale(String minDate,String maxDate, Pageable pageable) {
		LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());//cria uma data com o dia de hoje.
		
		LocalDate min = minDate.equals("") ? today.minusDays(365) : LocalDate.parse(minDate);//se a data n for informada pega de 1 ano atrás
		LocalDate max = maxDate.equals("") ? today : LocalDate.parse(maxDate);//se tiver vazio pega a data de hj, se n converte.
		
		return repsitory.findSales(min, max, pageable);
	}

}
