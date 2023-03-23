package com.springjwtsecurity.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.springjwtsecurity.jwt.JwtFilter;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

	@Autowired
	EmployeeLoginDetailsService employeeLoginDetailsService;

	@Autowired
	JwtFilter filter;

	@Bean
	AuthenticationProvider auth() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(employeeLoginDetailsService);
		provider.setPasswordEncoder(new BCryptPasswordEncoder());
		return provider;
	}

	@Bean
	SecurityFilterChain securityfilterchain(HttpSecurity http) throws Exception {

		http.csrf().disable().cors().disable().authorizeHttpRequests()
				.requestMatchers("/api/v1/employee/auth/add", "/api/v1/employee/auth/authenticate").permitAll()
				.requestMatchers(HttpMethod.OPTIONS, "/**").permitAll().anyRequest().authenticated().and()
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
				.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);

		return http.build();

	}

	@Bean
	AuthenticationManager authmanager(AuthenticationConfiguration config) throws Exception {

		return config.getAuthenticationManager();
	}

}

//"/api/v1/employee/todos/addtodo",
//"/api/v1/employee/todos/alltodos",
//"/api/v1/admin/details-todo-employee"
