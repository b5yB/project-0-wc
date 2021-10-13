package com.project0.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.project0.models.Application;
import com.project0.models.User;
import com.project0.utils.ConnectionUtil;

public class UserDaoDB implements UserDao {
	
ConnectionUtil conUtil = ConnectionUtil.getConUtil();
	
	@Override
	public List<User> getAllUsers() {
		
		List<User> userList = new ArrayList<User>();
		
		try {
	
			Connection con = conUtil.getCon();
			
			String sql = "SELECT * FROM users";
			
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()) {
				userList.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7), rs.getInt(8), rs.getInt(9)));
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
				user.setBalance(rs.getInt(8));
				user.setBankerid(rs.getInt(9));
			}
			
			return user;
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public void createApplication(Application a) throws SQLException {
		
		Connection con = conUtil.getCon();
		
		String sql = "INSERT INTO applications(username, password, firstN, lastN, ssn, email, openingBalance) values"
				+ "(?,?,?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setString(1, a.getUsername());
		ps.setString(2, a.getPassword());
		ps.setString(3, a.getFirstN());
		ps.setString(4, a.getLastN());
		ps.setInt(5, a.getSsn());
		ps.setString(6, a.getEmail());
		ps.setDouble(7, a.getOpeningBalance());
		
		ps.execute();
		
	}
	
	@Override
	public void makeDeposit(double balance, int acctnum, double deposit) throws SQLException {
			
			Connection con = conUtil.getCon();
			
			String sql = "UPDATE users SET balance = balance + ?"  + "WHERE users.acctnum = ?";
			
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setDouble(1, deposit);
			ps.setInt(2, acctnum);
			
			ps.execute();
			
	}
	
	@Override
	public void makeWithdrawal(double balance, int acctnum, double withdrawal) throws SQLException {
		
		Connection con = conUtil.getCon();
		
		String sql = "UPDATE users SET balance = balance - ?"  + "WHERE users.acctnum = ?";
		
		PreparedStatement ps = con.prepareStatement(sql);

		ps.setDouble(1, withdrawal);
		ps.setInt(2, acctnum);
		
		ps.execute();
		
	}

	@Override
	public void transfer(double balance, int acctnum, int recievingAcctnum, double transfer) throws SQLException {
		Connection con = conUtil.getCon();
		
		String sql = "UPDATE users SET balance = balance - ?"  + "WHERE users.acctnum = ?";
		
		PreparedStatement ps = con.prepareStatement(sql);

		ps.setDouble(1, transfer);
		ps.setInt(2, acctnum);
		
		ps.execute();
	
		String sql2 = "UPDATE users SET balance = balance + ?"  + "WHERE users.acctnum = ?";
		
		PreparedStatement ps2 = con.prepareStatement(sql2);

		ps2.setDouble(1, transfer);
		ps2.setInt(2, recievingAcctnum);
		
		ps2.execute();
		
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
