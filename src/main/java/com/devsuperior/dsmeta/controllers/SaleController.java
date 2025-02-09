package com.devsuperior.dsmeta.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dsmeta.dto.SaleMinDTO;
import com.devsuperior.dsmeta.dto.SaleReportMinDTO;
import com.devsuperior.dsmeta.dto.SaleSumaryMinDTO;
import com.devsuperior.dsmeta.services.SaleService;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {

	@Autowired
	private SaleService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<SaleMinDTO> findById(@PathVariable Long id) {
		SaleMinDTO dto = service.findById(id);
		return ResponseEntity.ok(dto);
	}

	@GetMapping(value = "/report")
	public ResponseEntity<Page<SaleReportMinDTO>> getReport(
			@RequestParam(name = "minDate", defaultValue = "") String ini, 
			@RequestParam(name = "maxDate", defaultValue = "") String end,
			@RequestParam(defaultValue = "") String name,
			Pageable pageable) {
		
		return ResponseEntity.ok().body(service.searchSalesReport(ini, end, name, pageable));
	}

	@GetMapping(value = "/summary")
	public ResponseEntity<Page<SaleSumaryMinDTO>> getSummary(
			@RequestParam(name = "minDate", defaultValue = "") String ini, 
			@RequestParam(name = "maxDate", defaultValue = "") String end,
			Pageable pageable) {
		
		return ResponseEntity.ok().body(service.searchSalesSumary(ini, end, pageable));
	}
}
