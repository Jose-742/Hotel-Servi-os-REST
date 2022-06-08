package com.example.hotel.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Quarto implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "Número do quarto é Obrigatório.")
	private int numeroQuarto;
	
	@NotNull(message = "Número do andar é Obrigatório.")
	private int andar;
	
	@NotNull(message = "Total das camas é Obrigatório.")
	private int totalCama;
	
	@NotNull(message = "Preço é Obrigatório.")
	private BigDecimal preco;
	
	@NotNull(message = "O Status do quarto é Obrigatório.")
	private boolean statusQuarto;
	
	@ManyToOne
	@JoinColumn(name="id_hotel_fk")
	@JsonBackReference  //Relacionamento bidirecional 
	private Hotel hotel;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getNumeroQuarto() {
		return numeroQuarto;
	}

	public void setNumeroQuarto(int numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}

	public int getAndar() {
		return andar;
	}

	public void setAndar(int andar) {
		this.andar = andar;
	}

	public int getTotalCama() {
		return totalCama;
	}

	public void setTotalCama(int totalCama) {
		this.totalCama = totalCama;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public boolean isStatusQuarto() {
		return statusQuarto;
	}

	public void setStatusQuarto(boolean statusQuarto) {
		this.statusQuarto = statusQuarto;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
}
