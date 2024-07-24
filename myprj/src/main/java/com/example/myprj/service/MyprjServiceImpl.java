package com.example.myprj.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.myprj.entity.Myprj;
import com.example.myprj.repository.MyprjRepository;

@Service
@Transactional
public class MyprjServiceImpl implements MyprjService {

	@Autowired
	MyprjRepository repository;
	
	
	@Override
	public Iterable<Myprj> selectAll() {
		// TODO 自動生成されたメソッド・スタブ
		return repository.findAll();
	}

	@Override
	public Optional<Myprj> selectOneById(Integer id) {
		// TODO 自動生成されたメソッド・スタブ
		return repository.findById(id);
	}

	@Override
	public Optional<Myprj> selectOneRandomQuiz() {
        // TODO 自動生成されたメソッド・スタブ
		/////Integer randId = repository.getRandomId();
		Optional<Myprj> quizOpt = repository.getRandomId();
		
		/////if(randId == null) {
		if(quizOpt == null) {
			
			return Optional.empty();
		}
		
		/////return repository.findById(randId);
		return quizOpt;
	}

	@Override
	public Boolean checkQuiz(Integer id, Boolean myAnswer) {
		// TODO 自動生成されたメソッド・スタブ
		
		Boolean check=false;
		
		Optional<Myprj> optQuiz = repository.findById(id);
		
		if(optQuiz.isPresent()) {
			Myprj quiz = optQuiz.get();
			
		
			if(quiz.getAnswer().equals(myAnswer)) {
		        check=true;	
		    }
		
		}
		
		return check;
	}

	@Override
	public void insertQuiz(Myprj quiz) {
		// TODO 自動生成されたメソッド・スタブ
		repository.save(quiz);
	}

	@Override
	public void updateQuiz(Myprj quiz) {
		// TODO 自動生成されたメソッド・スタブ
		repository.save(quiz);

	}

	@Override
	public void deleteQuiz(Integer id) {
		// TODO 自動生成されたメソッド・スタブ
		repository.deleteById(id);

	}

	@Override
	public String doExecute(String test) {
		// TODO 自動生成されたメソッド・スタブ
		test = "test";
		///return "redirect:/quiz";
		return test;
		
		
	}

}
