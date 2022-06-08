package com.example.hotel.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.hotel.model.entity.Quarto;

public interface QuartoRepository extends JpaRepository<Quarto, Long>{

	@Query("select q from Quarto q where q.id = :id")
	Quarto findByIdBuscarQuarto(Long id);

}
