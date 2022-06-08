package com.example.hotel.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.hotel.model.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

	@Query("select c from Cliente c where c.id = :id")
	Cliente findByBuscarCliente(Long id);

}
