package com.GreenStitch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.GreenStitch.exceptions.UserException;
import com.GreenStitch.model.UserDTO;
import com.GreenStitch.model.UserInfo;
import com.GreenStitch.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	// register user with given details
	
	@PostMapping("/app/sign-up")
	public ResponseEntity<UserInfo> signUpUserHandler(@Validated @RequestBody UserDTO user) throws UserException 
	{
		user.setPassword(passwordEncoder.encode(user.getPassword())); 
         
		UserInfo p = userService.registerUser(user);
		
		return new ResponseEntity<UserInfo>(p,HttpStatus.CREATED);
	}
	
	// first time user login with Email and password and got JWT token 
	
	@GetMapping("/app/sign-in")
	public ResponseEntity<UserInfo> signInHandler(Authentication auth) throws BadCredentialsException, UserException{
		
		UserInfo customer= userService.findUserByEmail(auth.getName());
		
		if(customer!=null)
		{
			 return new ResponseEntity<>(customer, HttpStatus.ACCEPTED);
		}
		
		throw new BadCredentialsException("Invalid Username or password");
		

	}
	
	// Authentication with JWT token 
	
	@GetMapping("/app/logged-in/user")
	public ResponseEntity<String> welcomeLoggedInUserHandler() throws UserException
	{
		UserInfo user =  userService.loginUser();
		
		String message = "Hello from GreenStitch";
		
		return new ResponseEntity<String>(message,HttpStatus.OK);
	}
}
