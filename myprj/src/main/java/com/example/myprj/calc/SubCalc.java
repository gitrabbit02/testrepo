package com.example.myprj.calc;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;

@Controller
@Profile("test")
public class SubCalc implements Calculator {

	@Override
	public Integer calc(Integer x, Integer y) {
		// TODO 自動生成されたメソッド・スタブ
		return x - y;
	}

}
