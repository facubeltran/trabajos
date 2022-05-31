package ar.org.centro8.curso.java.clase02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan(basePackages = "ar.org.centro8.curso.java")
public class Clase02Application {

	public static void main(String[] args) {
		SpringApplication.run(Clase02Application.class, args);

		//Punto de entrada.

		System.out.println("Hola Mundo Maven Springboot Tomcat!!");

	}

}
