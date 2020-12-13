package com.rady.cmsshoppingcart.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/").permitAll();
		// .antMatchers("/**").hasAnyRole("USER");
		// spring expression language and allowed you to write complex quries for
		// security
//		http.authorizeRequests().antMatchers("/categor/**").access("hasRole('ROLE_USER')").antMatchers("/")
//				.access("permitAll");

	}
}
