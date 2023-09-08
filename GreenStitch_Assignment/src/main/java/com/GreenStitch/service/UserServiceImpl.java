package com.GreenStitch.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.GreenStitch.exceptions.UserException;
import com.GreenStitch.model.UserDTO;
import com.GreenStitch.model.UserInfo;
import com.GreenStitch.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;

	@Override
	public UserInfo registerUser(UserDTO user) throws UserException {
 
		UserInfo findUser = userRepo.findByEmail(user.getEmail());
		
		if(findUser!=null)
		{
			throw new UserException(" user already exists with this email : "+user.getEmail());
		}
		
		UserInfo newUser = new UserInfo();
		
		newUser.setEmail(user.getEmail());
        newUser.setFullName(user.getFullName());
        newUser.setPassword(user.getPassword());
        newUser.setRole(user.getRole());
		
		 
		return userRepo.save(newUser);
	}

	@Override
	public UserInfo loginUser() {
			
		SecurityContext sc  = SecurityContextHolder.getContext();
		
		Authentication auth  = sc.getAuthentication();
		
		String userName = auth.getName();
		
		UserInfo user = userRepo.findByEmail(userName);
		
		return user;
		
	}

	@Override
	public UserInfo findUserByEmail(String email) throws UserException {
		
		UserInfo user = userRepo.findByEmail(email);
		
		if(user==null)
		{
			throw new UserException("No user found with this email : "+email);
		}
		
		return user;
	}
	
}
