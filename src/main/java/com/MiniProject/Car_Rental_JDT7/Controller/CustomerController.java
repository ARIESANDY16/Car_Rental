package com.MiniProject.Car_Rental_JDT7.Controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.MiniProject.Car_Rental_JDT7.Service.UserService;

@Controller
public class CustomerController {
	@Autowired
	UserService userService;

	@RequestMapping("/homecustomer")
	public String Product(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_HOME");
		return "homecustomer";
	}
}
