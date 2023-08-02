package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.nt.model.User;
import com.nt.repo.UserRepository;

@Service
public class UserMgmtService implements IUserMgmtService {
	@Autowired
	private UserRepository repo;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	public String createUser(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return repo.save(user).getUsername()+"is created";
	}
	
	@Override
	public User findUserByName(String userName) {
		return repo.findById(userName).get();
	}

}
