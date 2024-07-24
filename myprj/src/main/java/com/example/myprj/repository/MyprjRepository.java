package com.example.myprj.repository;

import java.util.Optional;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.myprj.entity.Myprj;

/////public interface QuizRepository extends CrudRepository<Quiz,Integer> {
public interface MyprjRepository extends CrudRepository<Myprj,Integer> {

	/////@Query("SELECT id FROM quiz ORDER BY RANDOM() limit 1")
	@Query("SELECT * FROM quiz WHERE id = 10")
	/////Integer getRandomId();
	Optional<Myprj> getRandomId();
	
}
