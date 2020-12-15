package com.rady.cmsshoppingcart.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.rady.cmsshoppingcart.models.AdminRepository;
import com.rady.cmsshoppingcart.models.UserRepository;
import com.rady.cmsshoppingcart.models.data.Admin;
import com.rady.cmsshoppingcart.models.data.User;

@Service
public class userRepositoryUserDetailsService implements UserDetailsService {
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private AdminRepository adminRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepo.findByUsername(username);
		Admin admin = adminRepo.findByUsername(username);
		if (user != null) {
			return user;
		}
		if (admin != null) {
			return admin;
		}
		throw new UsernameNotFoundException("User" + username + "not found");

	}

}
