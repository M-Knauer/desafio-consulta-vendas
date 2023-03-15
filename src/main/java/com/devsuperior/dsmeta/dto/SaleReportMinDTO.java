package com.devsuperior.dsmeta.dto;

import java.time.LocalDate;

import com.devsuperior.dsmeta.entities.Sale;

public class SaleReportMinDTO extends SaleMinDTO {

	private String name;
	
	public SaleReportMinDTO(Sale entity) {
		super(entity);
		name = entity.getSeller().getName();
	}

	public SaleReportMinDTO(Long id, Double amount, LocalDate date, String name) {
		super(id, amount, date);
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
