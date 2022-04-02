package com.MiniProject.Car_Rental_JDT7.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.MiniProject.Car_Rental_JDT7.Model.User;
import com.MiniProject.Car_Rental_JDT7.Service.UserService;

@org.springframework.web.bind.annotation.RestController



public class RestController {
	@Autowired
	private UserService userService;
	@GetMapping("/")
	public String hello() {
		return "welcomepage";
	}

	@GetMapping("/saveuser")
	public String saveUser(@RequestParam String username, @RequestParam long contactno_customer, @RequestParam String email_customer,
			@RequestParam String fullname_customer, @RequestParam String password) {
User user = new User(username,contactno_customer,email_customer,fullname_customer,password);
userService.saveMyUser(user);
		return "User Saved";
	}
}

