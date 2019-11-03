package com.autodesk.www;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class PlayWithBootApplication {

	public static void main(String[] args) {

		SpringApplication.run(PlayWithBootApplication.class, args);

		System.out.println("started...");
	}

}
