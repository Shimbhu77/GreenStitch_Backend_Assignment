package com.GreenStitch.service;

import com.GreenStitch.exceptions.UserException;
import com.GreenStitch.model.UserDTO;
import com.GreenStitch.model.UserInfo;

public interface UserService {

	public UserInfo registerUser(UserDTO user) throws UserException;
	public UserInfo loginUser()  throws UserException;
	public UserInfo findUserByEmail(String email)  throws UserException;
}
