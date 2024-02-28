package com.shopping.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.shopping.project.entity.Home;
import com.shopping.project.service.HomeService;

@Controller
public class HomeController {

	@Autowired
	private HomeService homeService;

	@GetMapping("/index")
	public String index() {
		return "index";
	}

	@GetMapping("/login")
	public String login() {

		return "login";
	}

	@GetMapping("/userLogout")
	public String logout() {
		return "redirect:/login";
	}

	@GetMapping("/invalid")
	public String error() {
		return "error";
	}

	@GetMapping("/signup")
	public String SignUp(Model model, Home home) {
		model.addAttribute("admin", home);

		return "signup";
	}

	@PostMapping("/registerUser")
	public String registerUser(Home home) {

		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String password = passwordEncoder.encode(home.getPassword());
		home.setPassword(password);

		homeService.save(home);

		return "redirect:/login";
	}
}
