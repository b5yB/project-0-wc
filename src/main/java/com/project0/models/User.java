package com.project0.models;

public class User {
	
	/*
	acctnum int primary key generated always as identity,
	username varchar(30) not null unique,
	password varchar(30) not null,
	first_name varchar(30) not null,
	last_name varchar(30) not null,
	ssn int not null unique,
	email varchar(50) not null unique,
	bankerid int not null unique	
	*/
	
	private int acctnum;
	private String username;
	private String password;
	private String first_name;
	private String last_name;
	private int ssn;
	private String email;
	private int bankerid;
	
	//to db
	public User(String username, String password, String first_name, String last_name, int ssn, String email, int bankerid) {
		
		this.username = username;
		this.password = password;
		this.first_name = first_name;
		this.last_name = last_name;
		this.ssn = ssn;
		this.email = email;
		this.bankerid = bankerid;
		
	}
	
	//from db
	public User(int acctnum, String username, String password, String first_name, String last_name, int ssn, String email, int bankerid) {
		this.acctnum = acctnum;
		this.username = username;
		this.password = password;
		this.first_name = first_name;
		this.last_name = last_name;
		this.ssn = ssn;
		this.email = email;
		this.bankerid = bankerid;
	}

	public int getAcctnum() {
		return acctnum;
	}

	public void setAcctnum(int acctnum) {
		this.acctnum = acctnum;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public int getSsn() {
		return ssn;
	}

	public void setSsn(int ssn) {
		this.ssn = ssn;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getBankerid() {
		return bankerid;
	}

	public void setBankerid(int bankerid) {
		this.bankerid = bankerid;
	}

	@Override
	public String toString() {
		return "User [acctnum=" + acctnum + ", username=" + username + ", password=" + password + ", first_name="
				+ first_name + ", last_name=" + last_name + ", ssn=" + ssn + ", email=" + email + ", bankerid="
				+ bankerid + "]";
	}
	
	
	
}
