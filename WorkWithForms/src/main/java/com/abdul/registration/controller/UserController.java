package com.abdul.registration.controller;

import org.apache.tomcat.jni.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
	
	public  UserController() {
		System.out.println("user controller object created");
	}
	
	@RequestMapping("/displayForm")
	public String displayForm(Model model) {
		model.addAttribute("user" , new User());
		return "userRegForm";
	}
	
	

}
