package com.example.hotel.controller;

import java.math.BigDecimal;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.hotel.model.entity.Hotel;
import com.example.hotel.service.HotelService;


@Transactional
@Controller
@RequestMapping("hotels")
public class HotelController {

	@Autowired
	private HotelService hotelService;
		
	
	@GetMapping("/search/{city}") //Consultar Hotéis por cidade
	public ResponseEntity<?> buscarHotelByCidade(@PathVariable("city") String city){		
			List<Hotel> hoteis = hotelService.buscarHotelByCidade(city);
			return ResponseEntity.ok(hoteis);
	}
	
	
	@GetMapping("/search/{city}/{district}") //Consultar Hotéis por bairro de uma cidade
	public ResponseEntity<?> buscarHotelBybairro(@PathVariable("city") String city, 
												 @PathVariable("district") String district){
		List<Hotel> hoteis = hotelService.buscarHotelBybairro(district, city);
		return ResponseEntity.ok(hoteis);
	}
	
	@GetMapping("/search/{city}/{price}/{bed}") //Consultar Hotéis por cidade, faixa de preço e total de camas
	public ResponseEntity<?> buscarHotelByCidadePrecoCama(@PathVariable("city") String city, 
													@PathVariable("price") BigDecimal price, 
													@PathVariable("bed") int bed){
		List<Hotel> hoteis = hotelService.buscarHotelByCidadePrecoCama(city, price, bed);		
		return ResponseEntity.ok(hoteis);
		
	}
}
