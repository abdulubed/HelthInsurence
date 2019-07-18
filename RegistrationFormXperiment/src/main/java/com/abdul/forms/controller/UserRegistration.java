package com.abdul.forms.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.abdul.forms.model.User;

@Controller
public class UserRegistration {
	
	public UserRegistration() {
		System.out.println("UserRegistration :: constructor");		
	}
	
	@RequestMapping("/displayForm")
	public String displayForm(Model model) {
		model.addAttribute("user", new User());
		initializingValues(model);
		return "UserReg";
	}
	

	public void initializingValues(Model model) {
		
		List<String> gendersList = new ArrayList();
		gendersList.add("Male");
		gendersList.add("FeMale");
		model.addAttribute("genders" , gendersList);
		
		List<String> rolesList = new ArrayList();
		rolesList.add("Admin");
		rolesList.add("Case Worker");
		model.addAttribute("roles" , rolesList);		
	}
	
	@RequestMapping("/register")
	public String registerForm(User user, Model model) {
		model.addAttribute("msg", "Registration completed");
		initializingValues(model);
		System.out.println(model);
		return "UserReg";
	}
	

}
