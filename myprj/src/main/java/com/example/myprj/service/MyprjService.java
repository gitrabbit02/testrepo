package com.example.myprj.service;

import java.util.Optional;

import com.example.myprj.entity.Myprj;

public interface MyprjService {
	
	String doExecute(String test);
	
	Iterable<Myprj> selectAll();
	
    Optional<Myprj> selectOneById(Integer id);
    
    Optional<Myprj> selectOneRandomQuiz();
    
    Boolean checkQuiz(Integer id,Boolean myAnswer);
    
    void insertQuiz(Myprj quiz);
    
    void updateQuiz(Myprj quiz);
    
    void deleteQuiz(Integer id);
    
}
