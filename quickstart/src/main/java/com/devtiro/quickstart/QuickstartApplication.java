package com.devtiro.quickstart;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devtiro.quickstart.config.PizzaConfig;

import lombok.extern.java.Log;



@SpringBootApplication
@Log
public class QuickstartApplication implements CommandLineRunner {

	PizzaConfig pizzaConfig;

	public QuickstartApplication(PizzaConfig pizzaConfig) {
		this.pizzaConfig = pizzaConfig;
	}
	public static void main(String[] args) {
		SpringApplication.run(QuickstartApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info( String.format("i want a %s crust pizza , with %s and %s sauce", 
		pizzaConfig.getCrust(),
		pizzaConfig.getTopping(),
		pizzaConfig.getSauce()
		));		
	}


}
