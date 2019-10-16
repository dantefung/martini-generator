package com.dantefung;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.dantefung.dao")
public class MartiniApplication {

	public static void main(String[] args) {
		SpringApplication.run(MartiniApplication.class, args);
	}
}
