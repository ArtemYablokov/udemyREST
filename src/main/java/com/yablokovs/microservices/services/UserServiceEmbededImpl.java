package com.yablokovs.microservices.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.yablokovs.microservices.model.User;


@Component
public class UserServiceEmbededImpl implements UserService{
	
	private static List<User> users = new  ArrayList<>();
	
	private static long userId = 3L;
	
	static {
		users.add(new User(1L, "name1", LocalDate.now()));
		users.add(new User(2L, "name2", LocalDate.now()));
		users.add(new User(3L, "name3", LocalDate.now()));
	}

	@Override
	public User getUser(Long id) {
		// TODO Auto-generated method stub
		for(User user : users) {
			if(user.getId() == id)
				return user;
		}
		return null;
	}

	@Override
	public List<User> getUsers() {
		return users;
	}

	@Override
	public User saveUser(User user) {
		if(user.getId() == null) {
			user.setId(++userId);
		}
		users.add(user);
		return user;
	}
  
}
