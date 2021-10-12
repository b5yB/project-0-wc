package com.project0.dao;

import java.sql.SQLException;
import java.util.List;

import com.project0.models.Application;
import com.project0.models.User;

public interface UserDao {
	
	List<User> getAllUsers();
	
	User getUserByUsername(String username);
	
	void createApplication(Application a) throws SQLException;
	
	void updateUser(User u);
	
	void deleteUser(User u);

}
