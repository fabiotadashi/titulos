package com.esb.titulos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.esb.titulos.controller.TituloController;

@SpringBootApplication
@ComponentScan(basePackageClasses = TituloController.class)
public class TitulosApplication {

	public static void main(String[] args) {
		SpringApplication.run(TitulosApplication.class, args);
	}
}
