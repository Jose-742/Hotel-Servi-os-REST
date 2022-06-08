package com.example.hotel.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.hotel.model.entity.Hotel;
import com.example.hotel.model.repository.HotelRepository;

@Repository
public class HotelService {

	@Autowired
	private HotelRepository repository;
	
	public List<Hotel> buscarHotelByCidade(String city) {//Buscando Hotéis por cidade
		return repository.findByCidade(city);
	}


	public List<Hotel> buscarHotelBybairro(String district, String city) {	//Buscando Hotéis por bairro de uma cidade
		return repository.findByBairro(district, city);
	}


	public List<Hotel> buscarHotelByCidadePrecoCama(String city, BigDecimal price, int bed) { //Buscando Hotéis por Cidade, preço e total de camas
		return repository.findByCidadePrecoCama(city, price, bed);
	}

}
