package com.esb.titulos.model;

import java.time.LocalDate;

import com.esb.titulos.util.LocalDateDeserializer;
import com.esb.titulos.util.LocalDateSerializer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class Titulo {

	@JsonIgnore
	private String clube;
	
	private String nome;
	
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonSerialize(using = LocalDateSerializer.class)
	private LocalDate data;

	public Titulo(String clube, String titulo, LocalDate data) {
		super();
		this.clube = clube;
		this.nome = titulo;
		this.data = data;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	public String getClube() {
		return clube;
	}
	public void setClube(String clube) {
		this.clube = clube;
	}
	
	
	
}
