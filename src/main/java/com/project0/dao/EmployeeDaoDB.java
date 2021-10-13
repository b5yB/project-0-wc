package com.project0.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.project0.models.Account;
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
				appList.add(new Application(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7), rs.getDouble(8)));
			}
			
			return appList;
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
public void approveApplication(int appnum, String username, int bankerid) throws SQLException {
		
		Connection con = conUtil.getCon();
		
		Application app = new Application();
		Account acc = new Account();
		
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
			app.setOpeningBalance(rs.getDouble(8));
		}
		
		
		//We will still create the sql string, but with some small changes
		String sql2 = "INSERT INTO users(username, password, firstN, lastN, ssn, email, balance, bankerid) values"
				+ "(?,?,?,?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql2);
		
		ps.setString(1, app.getUsername());
		ps.setString(2, app.getPassword());
		ps.setString(3, app.getFirstN());
		ps.setString(4, app.getLastN());
		ps.setInt(5, app.getSsn());
		ps.setString(6, app.getEmail());
		ps.setDouble(7, app.getOpeningBalance());
		ps.setInt(8, bankerid);
		
		ps.execute();
		
		/*
		create table if not exists accounts (
				acctid int primary key generated always as identity,
				useracctnum int references users(acctnum) not null unique,
				firstN varchar(30) not null,
				lastN varchar(30) not null,
				balance int not null,
				bankerid int not null unique	
			);
		*/
		
		/*
		String sql3 = "SELECT * FROM users WHERE users.username = '" + username + "'";
			
		Statement s2 = con.createStatement();
		ResultSet rs2 = s2.executeQuery(sql3);
			
		while(rs2.next()) {
				
			acc.setUserAcctNum(rs2.getInt(1));
			acc.setFirstN(rs2.getString(4));
			acc.setLastN(rs2.getString(5));
			acc.setBankerid(rs2.getInt(8));
		}
		
		String sql4 = "INSERT INTO accounts(userAcctNum, firstN, lastN, balance, bankerid) values"
				+ "(?,?,?,?,?)";
		PreparedStatement ps2 = con.prepareStatement(sql4);
		
		ps2.setInt(1, acc.getUserAcctNum());
		ps2.setString(2, acc.getFirstN());
		ps2.setString(3, acc.getLastN());
		ps2.setDouble(4, app.getOpeningBalance());
		ps2.setInt(5, bankerid);
		
		ps2.execute();
		*/
		
		String sql5 = "DELETE FROM applications WHERE applications.appnum = '" + appnum + "'";
		PreparedStatement ps3 = con.prepareStatement(sql5);
		ps3.execute();
		
		
	}

}
