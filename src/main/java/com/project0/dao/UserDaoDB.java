package com.project0.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.project0.models.User;
import com.project0.utils.ConnectionUtil;

public class UserDaoDB implements UserDao {
	
ConnectionUtil conUtil = ConnectionUtil.getConUtil();
	
	//Use Statements to talk to our database
	@Override
	public List<User> getAllUsers() {
		
		List<User> userList = new ArrayList<User>();
		
		try {
			//Make the actual connection to the db
			Connection con = conUtil.getCon();
			
			//Create a simple statement
			String sql = "SELECT * FROM users";
			
			//We need to create a statement with the sql string
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			//We have to loop through the ResultSet and create objects based off the return
			while(rs.next()) {
				userList.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7), rs.getInt(8)));
			}
			
			return userList;
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public User getUserByUsername(String username) {
		
		User user = new User();
		
		try {
			Connection con = conUtil.getCon();
			
			String sql = "SELECT * FROM users WHERE users.username = '" + username + "'";
			
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()) {
				user.setAcctnum(rs.getInt(1));
				user.setUsername(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setFirstN(rs.getString(4));
				user.setLastN(rs.getString(5));
				user.setSsn(rs.getInt(6));
				user.setEmail(rs.getString(7));
				user.setBankerid(rs.getInt(8));
			}
			
			return user;
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	//We use prepared statements to precompile the sql query and protect against SQL Injection
	
	@Override
	public void createUser(User u) throws SQLException {
		
		Connection con = conUtil.getCon();
		
		//We will still create the sql string, but with some small changes
		String sql = "INSERT INTO users(username, password, first_name, last_name, ssn, email, bankerid) values"
				+ "(?,?,?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setString(1, u.getUsername());
		ps.setString(2, u.getPassword());
		ps.setString(3, u.getFirstN());
		ps.setString(4, u.getLastN());
		ps.setInt(5, u.getSsn());
		ps.setString(6, u.getEmail());
		ps.setInt(7, u.getBankerid());
		
		ps.execute();
		
	}

	@Override
	public void updateUser(User u) {
		
		try {
			Connection con = conUtil.getCon();
			String sql = "UPDATE users SET username = ?, password = ?, first_name = ?, last_name = ?, ssn = ?, email = ?, bankerid = ?"
					+ "WHERE users.acctnum = ?";
			
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, u.getUsername());
			ps.setString(2, u.getPassword());
			ps.setString(3, u.getFirstN());
			ps.setString(4, u.getLastN());
			ps.setInt(5, u.getSsn());
			ps.setString(6, u.getEmail());
			ps.setInt(7, u.getBankerid());
			ps.setInt(8, u.getAcctnum());
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void deleteUser(User u) {

		try {
			Connection con = conUtil.getCon();
			String sql = "DELETE FROM users WHERE acctnum = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, u.getAcctnum());
			ps.execute();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		
	}

}
