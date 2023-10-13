package com.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

	@GetMapping("/authenticate")
	public String authenticate( ModelMap model) {
		return "authenticated";
	}
	
	
	
	@GetMapping({"/","/welcome"})
	public String home(  ModelMap model ) {
		return "welcome";
	}
}
