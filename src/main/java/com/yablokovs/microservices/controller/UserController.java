package com.yablokovs.microservices.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.yablokovs.microservices.model.User;
import com.yablokovs.microservices.services.UserService;

@RestController
public class UserController {
	@Autowired
	UserService userService;
	
	@GetMapping(path = "/users")
	public List<User> getUsers(){
		return userService.getUsers();
	}
	
	@GetMapping("/users/{id}")
	public User getUsers(@PathVariable String id){
		return userService.getUser(Long.parseLong(id));
	}
	
	@PostMapping("/users")
	public ResponseEntity<Object> saveUser(@RequestBody User user){
		User savedUser = userService.saveUser(user);
		// добавление функционала чтобы метод возвращал статус 201
				
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedUser.getId()).toUri();
		
		// в header ответа будет находиться URI созданного пользователя
		return ResponseEntity.created(location).build();
	}
	
}