package com.example.hotel.model.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.hotel.model.entity.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Long>{

	
	@Query("select h from Hotel h where h.endereco.cidade.nome like :city%")
	List<Hotel> findByCidade(String city);

	
	@Query("select h from Hotel h where h.endereco.bairro like :district% AND h.endereco.cidade.nome like :city%")
	List<Hotel> findByBairro(String district, String city);


	@Query("select distinct h from Hotel h  "
			+ "join h.quartos q "
			+ "where h.endereco.cidade.nome like :city% AND q.preco like :price  AND q.totalCama like :bed")
	List<Hotel> findByCidadePrecoCama(String city, BigDecimal price, int bed);

}
