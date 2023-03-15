package com.devsuperior.dsmeta.repositories;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.dsmeta.dto.SaleReportMinDTO;
import com.devsuperior.dsmeta.dto.SaleSumaryMinDTO;
import com.devsuperior.dsmeta.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long> {

	@Query("SELECT new com.devsuperior.dsmeta.dto.SaleReportMinDTO(obj.id, obj.amount, obj.date, obj.seller.name) "
			+ "FROM Sale obj "
			+ "WHERE obj.date BETWEEN :ini AND :end AND UPPER(obj.seller.name) LIKE UPPER(CONCAT('%', :name, '%'))")
	Page<SaleReportMinDTO> searchSalesReport(LocalDate ini, LocalDate end, String name, Pageable pageable);
	
	@Query("SELECT new com.devsuperior.dsmeta.dto.SaleSumaryMinDTO(obj.seller.name, SUM(obj.amount)) "
			+ "FROM Sale obj "
			+ "WHERE obj.date BETWEEN :ini AND :end "
			+ "GROUP BY obj.seller.name")
	Page<SaleSumaryMinDTO> searchSalesSumary(LocalDate ini, LocalDate end, Pageable pageable);
}
