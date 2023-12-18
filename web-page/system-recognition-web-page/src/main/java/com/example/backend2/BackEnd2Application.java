package com.example.backend2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.backend2.entities.Clases;
import com.example.backend2.entities.Profesores;
import com.example.backend2.repository.ClaseRepository;
import com.example.backend2.repository.ProfesorRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
@SpringBootApplication
public class BackEnd2Application {

	public static void main(String[] args) {
		SpringApplication.run(BackEnd2Application.class, args);
	}

}
