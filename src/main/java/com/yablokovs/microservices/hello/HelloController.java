package com.yablokovs.microservices.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yablokovs.microservices.model.User;
import com.yablokovs.microservices.model.UserNotFoundException;
import com.yablokovs.microservices.services.UserService;

@RestController
public class HelloController {
	@Autowired
	UserService userService;
	
	// hello
	@RequestMapping(method = RequestMethod.GET, path = "/hello")
	public String helloWorld() {
		return "Hello World";
	}

	// return JSON bean - getter is required for bean
	@GetMapping(path = "/hello-bean")
	public HelloBean helloBean(){
		System.out.println();
		return new HelloBean("helloBean");
	}
	
	@GetMapping("/get-user/{id}")
	public User getUser(@PathVariable String id){
		User user = userService.getUser(Long.parseLong(id));
		if (user == null) {
			throw new UserNotFoundException("false id = " + id);
		}
		return user;
	}
}