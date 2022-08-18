package com.ays.springboot_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ays.springboot_app.dao.User;
import com.ays.springboot_app.dao.UserDetails;
import com.ays.springboot_app.service.LoginService;

@RestController 
public class LoginController {
	
	@Autowired
	LoginService loginService;

	@PostMapping(value="login")
	public UserDetails doLogin(@RequestBody User user) {
		User userD = loginService.doLogin(user);
		UserDetails userDetails;
		if(userD.getLoginMsg().contains("Login success")) {
			userDetails = loginService.getUserDetails(userD);
			System.out.println("User Details : "+userDetails.toString());
		}else {
			userDetails = new UserDetails();
			userDetails.setMessage(userD.getLoginMsg());
		}
		return userDetails;
	}
	
}
