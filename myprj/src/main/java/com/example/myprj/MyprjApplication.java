package com.example.myprj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.myprj.service.MyprjService;

@SpringBootApplication
public class MyprjApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyprjApplication.class, args);
	}

	@Autowired
	MyprjService service;
		

}
