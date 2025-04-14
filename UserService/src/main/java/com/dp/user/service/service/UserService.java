package com.dp.user.service.service;

import java.util.List;

import com.dp.user.service.entities.UserEntity;

public interface UserService  {
	
	UserEntity saveUser(UserEntity user);
	
	List<UserEntity> getAllUsers();
	
	UserEntity getUser(String userId);
	
}
