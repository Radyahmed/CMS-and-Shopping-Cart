package com.rady.cmsshoppingcart.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rady.cmsshoppingcart.models.UserRepository;
import com.rady.cmsshoppingcart.models.data.User;

@Controller
@RequestMapping("/register")
public class RegistrationController {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@GetMapping
	public String register(User user) {
		return "register";
	}

}
