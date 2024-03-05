package com.shopping.project.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.shopping.project.entity.Admin;
import com.shopping.project.service.AdminService;

@Controller
public class AdminController {

	@Autowired
	private AdminService adminService;

	@ModelAttribute
	public void commonValue(Principal principal, Model model) {
		if (principal != null) {
			String login_user = principal.getName();
			model.addAttribute("login_user", login_user);

			model.addAttribute("login_user_detail", adminService.findUserData(login_user));
		}

	}

	@GetMapping("/AdminSignup")
	public String AdminSignup(Model model, Admin admin) {
		model.addAttribute("admin", admin);
		return "admin/AdminSignup";
	}

	@GetMapping("/admin/DataTable")
	public String AdminDataTable() {
		return "admin/adminTable";
	}

	@PostMapping("/admin/register")
	public String registerUser(Admin admin) {

		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String password = passwordEncoder.encode(admin.getPassword());
		admin.setPassword(password);

		adminService.save(admin);

		return "redirect:/admin/DataTable";
	}

}
