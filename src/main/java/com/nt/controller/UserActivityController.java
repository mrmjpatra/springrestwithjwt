package com.nt.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nt.config.SecuriyConfig;
import com.nt.jwt.JwtHelper;
import com.nt.model.JwtRequest;
import com.nt.model.JwtResponse;
import com.nt.model.User;
import com.nt.service.IUserMgmtService;

@RestController
public class UserActivityController {

	@Autowired
	private IUserMgmtService service;
	@Autowired
	private JwtHelper helper;
	@Autowired
	private UserDetailsService userDetailsService;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	@Autowired
	private AuthenticationManager manager;

	private Logger logger = LoggerFactory.getLogger(UserActivityController.class);

	@GetMapping("/home")
	public ResponseEntity<String> showHomepage() {
		return ResponseEntity.ok("Welcome to home page");
	}

	@PostMapping("/register")
	public ResponseEntity<String> registerUser(@RequestBody User user) {
		String msg = service.createUser(user);
		return ResponseEntity.ok(msg);
	}
	
	@GetMapping("/user")
	public ResponseEntity<String> showUsers() {
		return ResponseEntity.ok("Welcome to users page");
	}
	
	@PostMapping("/login")
	public ResponseEntity<JwtResponse> login(@RequestBody JwtRequest request) {
		doAuthenticate(request.getUserName(), request.getPassword());
		System.out.println("UserActivityController.login()");
		UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUserName());
		String token = this.helper.generateToken(userDetails);

		JwtResponse response = JwtResponse.builder().jwtToken(token).userName(userDetails.getUsername()).build();
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	private void doAuthenticate(String email, String password) {

		UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(email, password);
		try {
			manager.authenticate(authentication);

		} catch (BadCredentialsException e) {
			throw new BadCredentialsException(" Invalid Username or Password  !!");
		}

	}

	@ExceptionHandler(BadCredentialsException.class)
	public String exceptionHandler() {
		return "Credentials Invalid !!";
	}

}
