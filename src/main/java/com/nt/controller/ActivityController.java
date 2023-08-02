package com.nt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cust")
public class ActivityController {
	
	@GetMapping("/")
	public String showHome() {
		return "home";
	}
	@GetMapping("/login")
	public String showLogin() {
		return "custom_login";
	}
	@GetMapping("/add")
	public String addCustomer() {
		return "add_cust";
	}
	@GetMapping("/show")
	public String showAllDetails() {
		return "show_cust";
	}
}
