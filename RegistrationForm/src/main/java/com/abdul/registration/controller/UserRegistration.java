package com.abdul.registration.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.abdul.registration.model.Registration;

@Controller
public class UserRegistration {
	
	
	@RequestMapping("/displayForm")
	public String display(Model model) {
		model.addAttribute("user",new Registration());
		initializationValues(model);
		return "userRegForm";
	}
	
	public void initializationValues(Model model) {
		List<String> gendersList = new ArrayList();
		gendersList.add("Male");
		gendersList.add("FeMale");
		model.addAttribute("genders", gendersList);
		
		List<String> rolesList = new ArrayList();
		rolesList.add("Admin");
		rolesList.add("Case Worker");
		model.addAttribute("roles",rolesList);
	}
	
	@RequestMapping(value = "/registerUser", method = RequestMethod.POST)
	public String registationCompleted(@ModelAttribute("user") Registration user, Model model) {
		model.addAttribute("msg", "Registration Successful");
		initializationValues(model);
		return "userRegForm";
	}
	

}
