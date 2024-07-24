package com.example.myprj.entity;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Myprj {

	@Id
	private Integer id;
	private String question;
	private Boolean answer;
	private String author;
	
}
