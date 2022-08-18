package com.ays.springboot_app.service;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.ays.springboot_app.dao.User;
import com.ays.springboot_app.dao.UserDetails;

@Service
public class LoginServiceImpl implements LoginService {

	@Override
	public User doLogin(User user) {
		// TODO Auto-generated method stub
		User lUser =  new User();
		if(!StringUtils.hasText(user.getUsername())) {
			lUser.setLoginMsg("username is empty");
			return lUser;
		}
		else if(!StringUtils.hasText(user.getPassword())) {
			lUser.setLoginMsg("Password is empty");
			return lUser;
		}
		
		//HardCoded values for testing later next Demo app we will implement h2 DB for DB operation got authentication
		if(user.getUsername().equals("jack")&&user.getPassword().equals("Jack$123")) 
			lUser.setLoginMsg("Login success for "+user.getUsername());
		else
			lUser.setLoginMsg("Bad credentails incorrect username or password for "+user.getUsername());
		
		return lUser;
	}

	@Override
	public UserDetails getUserDetails(User user) {
		UserDetails userDetails = new UserDetails();
		userDetails.setUsername(userDetails.getUsername());
		userDetails.setName("Jack Broad");
		userDetails.setAge("27");
		userDetails.setGender("M");
		userDetails.setEmail("jack@testmail.com");
		userDetails.setAddress("Street no. 55, Dream city, New Earth, Indiga, 8767564");
		return userDetails;
	}

}
