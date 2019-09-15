package com.example.core;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.core.model.Conexion;





@SpringBootApplication
public class CursoSpringApplication implements CommandLineRunner {
	
	@Autowired
	@Qualifier(value = "beanConexion")
	public Conexion conexion;

	public static void main(String[] args) {
		SpringApplication.run(CursoSpringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(conexion.getBd());
		
	}


	
	
}
