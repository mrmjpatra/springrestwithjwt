package com.nt.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.nt.model.User;
import com.nt.service.IUserMgmtService;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private IUserMgmtService service;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user=service.findUserByName(username);
		return user;
	}

}
