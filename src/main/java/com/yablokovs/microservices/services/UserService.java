package com.yablokovs.microservices.services;

import java.util.List;

import com.yablokovs.microservices.model.User;

public interface UserService {
	User getUser(Long id);
	List<User> getUsers();
	User saveUser(User user);
}