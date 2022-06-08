package com.example.hotel.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.hotel.model.entity.Reserva;

public interface ReservaRepository extends JpaRepository<Reserva, Long>{

	@Query("select r from Reserva r where r.id = :id")
	Reserva findByReserva(Long id);

}

