package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootJpaApplication {

	public static void main(String[] args) {
		System.out.println("啟動 SpringBoot");
		SpringApplication.run(SpringBootJpaApplication.class, args);
	    System.out.println("啟動成功");
	}

}
