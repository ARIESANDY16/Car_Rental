package com.MiniProject.Car_Rental_JDT7.Controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.MiniProject.Car_Rental_JDT7.Model.User;
import com.MiniProject.Car_Rental_JDT7.Service.UserService;

@Controller
public class ApplicationController {
	@Autowired
	UserService userService;

	@RequestMapping("/home")
	public String Welcome(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_HOME");
		return "homeutama";
	}
	
	@RequestMapping("/reservation")
	public String Reservation(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_HOME");
		return "reservation";
	}

	@RequestMapping("/register")
	public String registration(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_REGISTER");
		return "customerregister";
	}
	
	@RequestMapping("/forgotpassword")
	public String forgotpassword(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_REGISTER");
		return "forgotpassword";
	}

	@PostMapping("/save-user")
	public String registerUser(@ModelAttribute User user, BindingResult bindingResult,HttpServletRequest request)
		{
		userService.saveMyUser(user);
		request.setAttribute("mode", "MODE_HOME");
		return"homeutama";
	}
	@GetMapping("/show-users")
	public String showAllUsers(HttpServletRequest request) {
		request.setAttribute("users", userService.showAllUsers());
		request.setAttribute("mode", "ALL_USERS");
		return"homeutama";
		
	}
	@RequestMapping("/delete-user")
	public String deleteUser(@RequestParam int id_customer,HttpServletRequest request) {
		userService.deleteMyUser(id_customer);
		request.setAttribute("users", userService.showAllUsers());
		request.setAttribute("mode", "ALL_USERS");
		return "homeutama";
	}
	
	@RequestMapping("/edit-user")
	public String editUser(@RequestParam int id_customer, HttpServletRequest request) {
		request.setAttribute("user", userService.editUser(id_customer));
		request.setAttribute("mode", "MODE_UPDATE");
		return"homeutama";
	}	
	
	@RequestMapping("/login")
	public String login(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_LOGIN");
		return "customerlogin";
	}
	
	@RequestMapping("/login-user")
	public String loginUser(@ModelAttribute User user,HttpServletRequest request)
	{
		if(userService.findByUsernameAndPassword(user.getUsername(), user.getPassword())!=null) {
		return "homecustomer";
	}
	else {
		request.setAttribute("error", "Invalid Username or Password");
		request.setAttribute("mode", "MODE_LOGIN");
		return "homeutama";
	}
	}	
	
	@RequestMapping("/login-admin")
	public String loginAdmin(@ModelAttribute User user,HttpServletRequest request)
	{
		if(userService.findByUsernameAndPassword(user.getUsername(), user.getPassword())!=null) {
		return "homeadmin";
	}
	else {
		request.setAttribute("error", "Invalid Username or Password");
		request.setAttribute("mode", "MODE_LOGIN");
		return "homeutama";
	}
	}
}

