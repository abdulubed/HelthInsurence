package com.abdul.forms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.abdul.forms.model.User;

@Controller
public class UserRegistration {
	
	 public UserRegistration() {
		System.out.println("userRegistration :: controller");
	}
	
	@RequestMapping("/displayUser")
	public String displayUser(Model model) {
		model.addAttribute("user" , new User());
		return "userReg";
	}

}
