package com.pluralsight.springboot.tickets;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TicketsApplication {

	public static void main(String[] args) {
		//Takes class object and uses argument string array
		SpringApplication.run(TicketsApplication.class, args);
	}

}
