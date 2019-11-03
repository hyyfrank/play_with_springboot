package com.autodesk.www;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@MapperScan("com.autodesk.www.dao")
public class PlayWithBootApplication {

	public static void main(String[] args) {

		SpringApplication.run(PlayWithBootApplication.class, args);

		System.out.println("started...");
	}

}
