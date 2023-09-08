package com.GreenStitch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.GreenStitch.model.UserInfo;

@Repository
public interface UserRepository  extends JpaRepository<UserInfo, Integer>{

	UserInfo findByEmail(String username);
   
}
