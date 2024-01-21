package com.smart.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegisterController {
	@GetMapping("/register/regForm")
	public String regForm() {
		return "register/registerForm";
	}
}
