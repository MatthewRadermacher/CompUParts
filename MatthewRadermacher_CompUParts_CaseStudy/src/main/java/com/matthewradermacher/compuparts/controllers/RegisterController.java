package com.matthewradermacher.compuparts.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.matthewradermacher.compuparts.dao.UserRepository;
import com.matthewradermacher.compuparts.entities.User;

@Controller
@RequestMapping("/register")
public class RegisterController {

	@Autowired
	UserRepository userRepo;
	
	@GetMapping
	public String displayRegisterPage(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "register/register.html";
	}
	
	@PostMapping("/save")
	public String saveUser(User user, Model model) {
		userRepo.save(user);
		return "redirect:/";
	}
}
