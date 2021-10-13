package com.project0.models;

public class User {
	
	/*
	acctnum int primary key generated always as identity,
	username varchar(30) not null unique,
	password varchar(30) not null,
	firstN varchar(30) not null,
	lastN varchar(30) not null,
	ssn int not null unique,
	email varchar(50) not null unique,
	balance numeric not null,
	bankerid int not null unique	
	*/
	
	private int acctnum;
	private String username;
	private String password;
	private String firstN;
	private String lastN;
	private int ssn;
	private String email;
	private double balance;
	private int bankerid;
	
	public User() {
		
	}
	
	//to db
	public User(String username, String password, String firstN, String lastN, int ssn, String email, double balance) {
		
		this.username = username;
		this.password = password;
		this.firstN = firstN;
		this.lastN = lastN;
		this.ssn = ssn;
		this.email = email;
		this.balance = balance;
		
	}
	
	//from db
	public User(int acctnum, String username, String password, String firstN, String lastN, int ssn, String email, double balance, int bankerid) {
		this.acctnum = acctnum;
		this.username = username;
		this.password = password;
		this.firstN = firstN;
		this.lastN = lastN;
		this.ssn = ssn;
		this.email = email;
		this.balance = balance;
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

	public String getFirstN() {
		return firstN;
	}

	public void setFirstN(String firstN) {
		this.firstN = firstN;
	}

	public String getLastN() {
		return lastN;	
	}

	public void setLastN(String lastN) {
		this.lastN = lastN;
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
	
	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public int getBankerid() {
		return bankerid;
	}

	public void setBankerid(int bankerid) {
		this.bankerid = bankerid;
	}

	@Override
	public String toString() {
		return "User [acctnum=" + acctnum + ", username=" + username + ", password=" + password + ", firstN="
				+ firstN + ", lastN=" + lastN + ", ssn=" + ssn + ", email=" + email + ", balance=" + balance + ", bankerid="
				+ bankerid + "]";
	}
	
	
	
}
