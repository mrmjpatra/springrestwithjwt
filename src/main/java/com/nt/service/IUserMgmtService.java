package com.nt.service;

import com.nt.model.User;

public interface IUserMgmtService {
	public String createUser(User user);
	public User findUserByName(String userName);
}
