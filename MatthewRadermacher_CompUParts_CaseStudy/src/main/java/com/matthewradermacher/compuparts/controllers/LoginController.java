package com.matthewradermacher.compuparts.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.matthewradermacher.compuparts.dao.UserRepository;
import com.matthewradermacher.compuparts.entities.User;
import com.matthewradermacher.compuparts.temp.TempUser;

@Controller
public class LoginController {

	@Autowired
	UserRepository userRepo;
	
	@GetMapping("/")
	public String displayLogin(Model model) {
		model.addAttribute("formData", new TempUser());
		return "login/login.html";
	}
	
	
	@PostMapping("/login")
	public String validateLogin(TempUser tempUser, Model model) {
		
		List<User> users = userRepo.findAll();
		
		for (User u : users) {
			if (u.getUsername().equals(tempUser.getUserName())) {
				return "redirect:/home";
			}
		}
		
		return "redirect:/";
	}
}
