package com.project0.dao;

import java.sql.SQLException;
import java.util.List;

import com.project0.models.Application;
import com.project0.models.Employee;
import com.project0.models.User;

public interface EmployeeDao {
	
	Employee getEmployeeByUsername(String username);
	
	List<Application> getApplications();
	
	void approveApplication(int appnum, String username, int bankerid) throws SQLException ;

}
