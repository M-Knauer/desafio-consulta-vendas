package com.devsuperior.dsmeta.dto;

public class SaleSumaryMinDTO {

	private String name;
	private Double total;
	
	public SaleSumaryMinDTO() {
		
	}
	
	public SaleSumaryMinDTO(String name, Double total) {
		this.name = name;
		this.total = total;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}
		
}
