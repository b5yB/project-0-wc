package com.project0.services;

import java.sql.SQLException;

import com.project0.dao.UserDao;
import com.project0.exceptions.InvalidCredentialsException;
import com.project0.exceptions.UserDoesNotExistException;
import com.project0.exceptions.UsernameAlreadyExistsException;
import com.project0.logging.Logging;
import com.project0.models.User;

public class UserService {
	
	private UserDao uDao;
	
	public UserService(UserDao u) {
		this.uDao = u;
	}
	
	public User apply(String username, String password, String firstN, String lastN, Integer ssn, String email) throws UsernameAlreadyExistsException {
		
		User u = new User(username, password, firstN, lastN, ssn, email);
		
		try {
			uDao.createUser(u);
			Logging.logger.info("New user was registered");
		} catch (SQLException e) {
			Logging.logger.warn("Username created that already exists in the database");
			throw new UsernameAlreadyExistsException();
		}
		
		return u;
	}
	
	public User signIn(String username, String password) throws UserDoesNotExistException, InvalidCredentialsException{
		
		User u = uDao.getUserByUsername(username);
		
		if(u.getAcctnum() == 0) {
			Logging.logger.warn("User tried logging in that does not exist");
			throw new UserDoesNotExistException();
		}
		else if(!u.getPassword().equals(password)) {
			Logging.logger.warn("User tried to login with invalid credentials");
			throw new InvalidCredentialsException();
		}
		else {
			Logging.logger.info("User was logged in");
			return u;
		}
		
	}

}
