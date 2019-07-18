package com.validations.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.validations.model.UserRegistration;

@Controller
public class UserRegistraionController {

	@RequestMapping(method = RequestMethod.GET, value = "/userRegistraionDisplay")
	public String userRegistationDisplay(Model model) {
		UserRegistration userRegistraion = new UserRegistration();
		model.addAttribute("userRegistraion", userRegistraion);
		return "userRegistration";
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "registration")
	public String registration(RedirectAttributes redirectAttribute, @Valid @ModelAttribute("userRegistraion") UserRegistration userRegistraion , BindingResult result) {
		if(result.hasErrors()) {
			System.out.println("errors are generated");
			return "userRegistration";
		}
		redirectAttribute.addFlashAttribute("success", "User Registraion Success");
		return "redirect:/userRegistraionDisplay";
	}
	

	/*
	 * @RequestMapping(method = RequestMethod.POST, value = "registration") public
	 * String registration(RedirectAttributes redirectAttribute,
	 * 
	 * 	@Valid @ModelAttribute("userRegistraion") UserRegistration userRegistraio n
	 *  BindingResult result)  	i (result.hasErrors()) 
	 * System.out.println("errors are generated"); 	retur
	 *  "redirect:/userRegistraionDisplay" 	
	 * 	redirectAttribute.addFlashAttribute("success", "User Registraion Success")
	 * 	return "redirect:/userRegistraionDisplay" 	
	 */
	
/*	@RequestMapping(method = RequestMethod.POST, value = "registration")
	public String registration(@Valid @ModelAttribute("userRegistraion") UserRegistration userRegistraion , BindingResult result, Model model) {
		if(result.hasErrors()) {
			System.out.println("errors are generated");
			return "userRegistration";
		}
		model.addAttribute("success", "User Registraion Success");
		return "userRegistration";
	}*/
	

}
