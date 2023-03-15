package com.devsuperior.dsmeta.services;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.devsuperior.dsmeta.dto.SaleMinDTO;
import com.devsuperior.dsmeta.dto.SaleReportMinDTO;
import com.devsuperior.dsmeta.dto.SaleSumaryMinDTO;
import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.repositories.SaleRepository;

@Service
public class SaleService {

	@Autowired
	private SaleRepository repository;
	
	public SaleMinDTO findById(Long id) {
		Optional<Sale> result = repository.findById(id);
		Sale entity = result.get();
		return new SaleMinDTO(entity);
	}

	public Page<SaleReportMinDTO> searchSalesReport(String ini, String end, String name, Pageable pageable) {
		LocalDate endDate = end.isBlank() ? LocalDate.now(ZoneId.systemDefault()) : LocalDate.parse(end);
		LocalDate iniDate = ini.isBlank() ? endDate.minusYears(1L) : LocalDate.parse(ini);
		
		return repository.searchSalesReport(iniDate, endDate, name, pageable);
	}

	public Page<SaleSumaryMinDTO> searchSalesSumary(String ini, String end, Pageable pageable) {
		LocalDate endDate = end.isBlank() ? LocalDate.now(ZoneId.systemDefault()) : LocalDate.parse(end);
		LocalDate iniDate = ini.isBlank() ? endDate.minusYears(1L) : LocalDate.parse(ini);
		
		return repository.searchSalesSumary(iniDate, endDate, pageable);
	}
}
