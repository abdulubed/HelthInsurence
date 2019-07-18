package com.abdul.forms.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.abdul.forms.model.User;
import com.abdul.forms.properties.AppProperties;

@Controller
public class UserRegistration {
	
	@Autowired
	private AppProperties properties;
	
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
		
		Map map =properties.getProperties();		
		Object map1 = map.get("regSuccess");	
		model.addAttribute("success", map1);
		initializingValues(model);
		System.out.println(model);
		return "UserReg";
	}
	
	@RequestMapping("/test")
	public String jqueryTesting(Model model) {
		model.addAttribute("user", new User());
		initializingValues(model);
		return "tesging";
	}
	

}
