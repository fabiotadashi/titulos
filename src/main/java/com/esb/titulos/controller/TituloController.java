package com.esb.titulos.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.esb.titulos.model.Titulo;

@RestController
public class TituloController {

	private static List<Titulo> list;

	public TituloController() {
		inicializarDados();
	}

	@RequestMapping("titulos")
	public List<Titulo> getTitulos(@RequestParam(value = "clube", required = true) String clube,
			@RequestParam(value = "data_inicio", required = true) String dataInicio,
			@RequestParam(value = "data_fim", required = true) String dataFim) {
		return buscarTitulos(clube, LocalDate.parse(dataInicio), LocalDate.parse(dataFim));
	}

	private List<Titulo> buscarTitulos(String clube, LocalDate dataInicio, LocalDate dataFim) {
		return list
				.stream().filter(t -> t.getClube().toLowerCase().equals(clube.toLowerCase())
						&& t.getData().isAfter(dataInicio) && t.getData().isBefore(dataFim))
				.collect(Collectors.toList());
	}

	private void inicializarDados() {
		list = new ArrayList<>();
		list.add(new Titulo("Corinthians", "Brasileiro", LocalDate.parse("2017-06-01")));
		list.add(new Titulo("Corinthians", "Paulista", LocalDate.parse("2017-02-01")));
		list.add(new Titulo("Corinthians", "Libertadores", LocalDate.parse("2012-06-01")));

		list.add(new Titulo("Santos", "Paulista", LocalDate.parse("2016-06-01")));
		list.add(new Titulo("Santos", "Paulista", LocalDate.parse("2015-02-01")));
		list.add(new Titulo("Santos", "Libertadores", LocalDate.parse("2011-06-01")));

		list.add(new Titulo("Sao paulo", "Brasileiro", LocalDate.parse("2008-06-01")));
		list.add(new Titulo("Sao paulo", "Brasileiro", LocalDate.parse("2007-02-01")));
	}

}