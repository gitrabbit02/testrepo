package com.example.myprj.service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.myprj.entity.Myprj;
import com.example.myprj.repository.MyprjRepository;

@Service
@Transactional
//public class QuizService2 {
public class MyprjService3 implements MyprjRepository {
//////////public class QuizService3 {
	///@Autowired
	///QuizRepository quizRepository;
	
	
	
	String test8 = null;
	String test9 = null;
	
	public Myprj save(Myprj quiz){
		
		String test10 = null;
		
        /////return quizRepository.save(quiz);
		return save(quiz);
    }

	@Override
	public <S extends Myprj> Iterable<S> saveAll(Iterable<S> entities) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public Optional<Myprj> findById(Integer id) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public boolean existsById(Integer id) {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

	@Override
	public Iterable<Myprj> findAll() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public Iterable<Myprj> findAllById(Iterable<Integer> ids) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public long count() {
		// TODO 自動生成されたメソッド・スタブ
		return 0;
	}

	@Override
	public void deleteById(Integer id) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	@Override
	public void delete(Myprj entity) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	@Override
	public void deleteAllById(Iterable<? extends Integer> ids) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	@Override
	public void deleteAll(Iterable<? extends Myprj> entities) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	@Override
	public void deleteAll() {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	@Override
	public Optional<Myprj> getRandomId() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}
}
