package com.example.hotel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.hotel.model.entity.Cliente;
import com.example.hotel.model.entity.Quarto;
import com.example.hotel.model.entity.Reserva;
import com.example.hotel.model.repository.ClienteRepository;
import com.example.hotel.model.repository.QuartoRepository;
import com.example.hotel.model.repository.ReservaRepository;

@Repository
public class ReservaService {

	@Autowired
	private ReservaRepository repositoryReserva;
	
	@Autowired
	private ClienteRepository repositoryCliente;
	
	@Autowired
	private QuartoRepository repositoryQuarto;
	
	public void save(Reserva reserva) { //Salvando reserva no banco	
		repositoryReserva.save(reserva);
	}
	
	public void update(Reserva newReserva) {//Atualizando reserva do banco	
		repositoryReserva.save(newReserva);
	}
	
	public void delete(Reserva reserva) {//Deletando reserva do banco
		repositoryReserva.delete(reserva);
	}
	
	public List<Reserva> list(){//Listando as Reservas
		return repositoryReserva.findAll();
	}
	
	public Reserva reserva(Long id) {//retornado reserva
		Reserva reserva = repositoryReserva.findByReserva(id); 
		return reserva;
	}
	
	public Reserva idParaObjeto(Reserva reserva) { //ids para objetos completos
		Cliente cliente  = repositoryCliente.findByBuscarCliente(reserva.getCliente().getId());	
		Quarto quarto = repositoryQuarto.findByIdBuscarQuarto(reserva.getQuarto().getId());		
		reserva.setCliente(cliente);
		reserva.setQuarto(quarto);
		return reserva;
	}
	
}
