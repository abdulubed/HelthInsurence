package com.abdul.sample.method;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SampleMethod {
	
	public SampleMethod() {
		System.out.println("sample method object created");
	}
	
	
	@RequestMapping(value = "/greet1")
	public  String greetMessage(Model model) {
		model.addAttribute("msg", "Hello Good morning");
		return "index";
	}
	
	
	@RequestMapping(value = "/greet2")
	public @ResponseBody String  greet() {
		return "hello good morning";
	}

}
