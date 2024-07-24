package com.example.myprj.calc;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;

@Controller
/////@Primary
@Profile("dev")
public class AddCalc implements Calculator {
/////public class AddCalc extends Calculator {

	@Override
	public Integer calc(Integer x, Integer y) {
		// TODO 自動生成されたメソッド・スタブ
		return x + y;
	}

}
