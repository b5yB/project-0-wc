package com.project0.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.project0.models.Application;
import com.project0.models.Employee;
import com.project0.models.User;
import com.project0.utils.ConnectionUtil;

public class EmployeeDaoDB implements EmployeeDao {
	
	ConnectionUtil conUtil = ConnectionUtil.getConUtil();
	
	@Override
	public Employee getEmployeeByUsername(String username) {
		
		Employee employee = new Employee();
		
		try {
			Connection con = conUtil.getCon();
			
			String sql = "SELECT * FROM employees WHERE employees.username = '" + username + "'";
			
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()) {
				employee.setBankerid(rs.getInt(1));
				employee.setUsername(rs.getString(2));
				employee.setPassword(rs.getString(3));
				employee.setFirstN(rs.getString(4));
				employee.setLastN(rs.getString(5));
				employee.setEmail(rs.getString(6));
				employee.setAdminid(rs.getInt(7));
			}
			
			return employee;
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<Application> getApplications() {
		
		List<Application> appList = new ArrayList<Application>();
		
		try {
			//Make the actual connection to the db
			Connection con = conUtil.getCon();
			
			//Create a simple statement
			String sql = "SELECT * FROM applications";
			
			//We need to create a statement with the sql string
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			//We have to loop through the ResultSet and create objects based off the return
			while(rs.next()) {
				appList.add(new Application(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7)));
			}
			
			return appList;
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
public void approveApplication(int appnum, int bankerid) throws SQLException {
		
		Connection con = conUtil.getCon();
		
		Application app = new Application();
		
		String sql = "SELECT * FROM applications WHERE applications.appnum = '" + appnum + "'";
		
		Statement s = con.createStatement();
		ResultSet rs = s.executeQuery(sql);
		
		while(rs.next()) {
			
			app.setUsername(rs.getString(2));
			app.setPassword(rs.getString(3));
			app.setFirstN(rs.getString(4));
			app.setLastN(rs.getString(5));
			app.setSsn(rs.getInt(6));
			app.setEmail(rs.getString(7));
		}
		
		
		//We will still create the sql string, but with some small changes
		String sql2 = "INSERT INTO users(username, password, firstN, lastN, ssn, email, bankerid) values"
				+ "(?,?,?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql2);
		
		ps.setString(1, app.getUsername());
		ps.setString(2, app.getPassword());
		ps.setString(3, app.getFirstN());
		ps.setString(4, app.getLastN());
		ps.setInt(5, app.getSsn());
		ps.setString(6, app.getEmail());
		ps.setInt(7, bankerid);
		
		ps.execute();
		
		String sql3 = "DELETE FROM applications WHERE applications.appnum = '" + appnum + "'";
		
		PreparedStatement ps2 = con.prepareStatement(sql3);
		ps2.execute();
		
		
	}

}
