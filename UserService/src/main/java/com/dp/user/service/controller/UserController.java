package com.dp.user.service.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dp.user.service.entities.UserEntity;
import com.dp.user.service.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	private UserService userService;
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@PostMapping
	public ResponseEntity<UserEntity> createUser(@RequestBody UserEntity user) {
	    UserEntity user1 = userService.saveUser(user);
	    return ResponseEntity.status(HttpStatus.CREATED).body(user1);
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<UserEntity> getSingleUser(@PathVariable String userId){
		UserEntity user = userService.getUser(userId);
		return ResponseEntity.ok(user);
	}
	
	@GetMapping
	public ResponseEntity<List<UserEntity>> getAllUsers(){
		List<UserEntity> allUser = userService.getAllUsers();
		return ResponseEntity.ok(allUser);
	}
	
}
