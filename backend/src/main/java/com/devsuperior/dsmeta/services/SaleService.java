package com.devsuperior.dsmeta.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.repositories.SaleRepository;

@Service //componente do sistema
public class SaleService {
	
	@Autowired
	private SaleRepository repsitory;
	
	public List<Sale> findSale() {
		return repsitory.findAll();
	}

}
