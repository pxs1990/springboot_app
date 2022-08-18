package com.ays.springboot_app.service;

import com.ays.springboot_app.dao.User;
import com.ays.springboot_app.dao.UserDetails;

public interface LoginService {

	public User doLogin(User user);
	public UserDetails getUserDetails(User user);
	
}
