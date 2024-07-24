package com.example.myprj.form;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MyprjForm {

	private Integer id;
	
	@NotBlank
	private String question;
	
	private Boolean answer;
	
	@NotBlank
	private String author;
	
	private Boolean newQuiz;
	
}
