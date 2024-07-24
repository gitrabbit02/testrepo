package com.example.myprj.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.myprj.calc.Calculator;
import com.example.myprj.calc.SubCalc;
import com.example.myprj.entity.Myprj;
import com.example.myprj.form.MyprjForm;
import com.example.myprj.service.MyprjService;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/quest")
public class MyprjController {
	
	
	@Autowired
	MyprjService service;
	
	@Autowired
	Calculator calclator;
	
	
	@ModelAttribute
	public MyprjForm setUpForm() {
		
		MyprjForm form  = new MyprjForm();
		
		form.setAnswer(true);
		
		return form;
		
	}
	
	
	@GetMapping
	public Map<String, String> showList(MyprjForm quizForm,Model model) {
		quizForm.setNewQuiz(true);
		
		Iterable<Myprj> list = service.selectAll();
		model.addAttribute("list", list);
		model.addAttribute("title", "登録用フォーム");
		
		Map<String, String> rtndata = new HashMap<>();
		rtndata.put("tittle", "getdata");
		return rtndata;
		
		
	}
	
	@RequestMapping("/insert")
	public Map<String, String> insert(@Validated MyprjForm quizForm,BindingResult bindingResult,
			Model model,RedirectAttributes redirectAttributes) {
				
		Myprj quiz = new Myprj();
		quiz.setQuestion(quizForm.getQuestion());
		quiz.setAnswer(quizForm.getAnswer());
		quiz.setAuthor(quizForm.getAuthor());
	
		calclator.calc(8, 5);
		
		
		Calculator calculator = new SubCalc();
		
		
		SubCalc subCalc = new SubCalc();

		String test = service.doExecute("002");
		
		
		if(!bindingResult.hasErrors()) {
			
			service.insertQuiz(quiz);
			redirectAttributes.addFlashAttribute("complete", "登録が完了しました");
			
			return showList(quizForm,model);
			
		}else {
			return showList(quizForm,model);
		}
		
	}
	
	@GetMapping("/{id}")
	public String showUpdate(MyprjForm quizForm,@PathVariable Integer id,Model model) {
		
		Optional<Myprj> quizOpt = service.selectOneById(id);
		
		Optional<MyprjForm> quizFormOpt = quizOpt.map(t-> makeQuizForm(t));
		
		if(quizFormOpt.isPresent()) {
			
			quizForm = quizFormOpt.get();
		}
		
		makeUpdateModel(quizForm,model);
		
		return "crud";
		
	}
	
	private void makeUpdateModel(MyprjForm quizForm,Model model) {
		
		model.addAttribute("id",quizForm.getId());
		quizForm.setNewQuiz(false);
		model.addAttribute("quizForm",quizForm);
		model.addAttribute("title","更新用フォーム");
		
	}
	
	@PostMapping("/update")
	public String update(@Validated MyprjForm quizForm,BindingResult result
			,Model model,RedirectAttributes redirectAttributes) {
		
		Myprj quiz = makeQuiz(quizForm);
		
		if(!result.hasErrors()) {
			
			redirectAttributes.addFlashAttribute("complete", "更新が完了しました");
			
			
			return "redirect:/quiz/"+quiz.getId();
			
		}else {
			
			makeUpdateModel(quizForm,model);
			
			return "crud";
			
		}
	}
	
	private Myprj makeQuiz(MyprjForm quizForm) {
		
		Myprj quiz = new Myprj();
		quiz.setId(quizForm.getId());
		quiz.setQuestion(quizForm.getQuestion());
		quiz.setAnswer(quizForm.getAnswer());
		quiz.setAuthor(quizForm.getAuthor());
		return quiz;
		
	}
	
	private MyprjForm makeQuizForm(Myprj quiz) {
		
		MyprjForm form = new MyprjForm();
		
		form.setId(quiz.getId());
		form.setQuestion(quiz.getQuestion());
		form.setAnswer(quiz.getAnswer());
		form.setAuthor(quiz.getAuthor());
		form.setNewQuiz(false);
		
		return form;
		
		
	}
	
	@PostMapping("/delete")
	public String delete(
			@RequestParam("id") String id,
			Model model,
			RedirectAttributes redirectAttributes) {
		
		redirectAttributes.addFlashAttribute("delcomplete","削除が完了しました");
		
		return "redirect:/quiz";
		
	}
	
	@GetMapping("/play")
	public String showQuiz(MyprjForm quizForm,Model model) {
		
		Optional<Myprj> quizOpt = service.selectOneRandomQuiz();
		
		if(quizOpt.isPresent()) {
			
			Optional<MyprjForm> quizFormOpt = quizOpt.map(t->makeQuizForm(t));
            quizForm = quizFormOpt.get();
         	
		}else {
			
			model.addAttribute("msg","問題がありません");
			return "play";
			
		}
		
		model.addAttribute("quizForm",quizForm);
		return "play";
		
	}
	
	@PostMapping("/check")
    public String checkQuiz(MyprjForm quizForm,@RequestParam Boolean answer,Model model) {
    	
    	
    	return "answer";
    	
    }
	
}
