package com.example.hotel.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.hotel.model.entity.Reserva;
import com.example.hotel.service.ReservaService;

@Transactional
@Controller
@RequestMapping("reservations")
public class ReservaController {

	@Autowired
	private ReservaService service;
		
	
	@PostMapping
	public ResponseEntity<?> save(@Valid @RequestBody Reserva reserva, BindingResult result){
		Reserva reservaSalvar = service.idParaObjeto(reserva);
		if(reserva.getCliente() == null || reserva.getQuarto() == null) {
			return ResponseEntity.notFound().build();//Nao encontrada 404
		}		
		service.save(reservaSalvar);
		return ResponseEntity.ok().build();
	}
	
	@PutMapping
	public ResponseEntity<?> update(@Valid @RequestBody Reserva newReserva, BindingResult result){
		
		Reserva reserva = service.idParaObjeto(newReserva);
		if(reserva.getCliente() == null || reserva.getQuarto() == null) {
			return ResponseEntity.notFound().build();//Nao encontrada 404
		}
		service.update(reserva);	
		return ResponseEntity.ok().build();
	}
	
	@GetMapping
	public ResponseEntity<?> list(){
		return ResponseEntity.ok(service.list());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id){		
		Reserva reserva = service.reserva(id);
		if(reserva == null) {
			return ResponseEntity.notFound().build();//Nao encontrada 404
		}
		service.delete(reserva); 		
		return ResponseEntity.ok().build();
	}
}
