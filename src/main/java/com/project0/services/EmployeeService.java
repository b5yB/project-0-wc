package com.project0.services;

import com.project0.dao.EmployeeDao;
import com.project0.dao.UserDao;
import com.project0.exceptions.InvalidCredentialsException;
import com.project0.exceptions.UserDoesNotExistException;
import com.project0.exceptions.UsernameAlreadyExistsException;
import com.project0.logging.Logging;
import com.project0.models.Employee;
import com.project0.models.User;

public class EmployeeService {
	
	private EmployeeDao eDao;
	
	public EmployeeService(EmployeDao e) {
		this.eDao = e;
	}
	
	public Employee signIn(String username, String password) throws UserDoesNotExistException, InvalidCredentialsException{
		
		Employee e = eDao.getEmployeeByUsername(username);
		
		if(e.getbankerid() == 0) {
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
