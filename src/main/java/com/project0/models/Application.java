package com.project0.models;

public class Application {
	
	/*
	appnum int primary key generated always as identity,
	username varchar(30) not null unique,
	password varchar(30) not null,
	first_name varchar(30) not null,
	last_name varchar(30) not null,
	ssn int not null unique,
	email varchar(50) not null unique
	*/
	
	private int appnum;
	private String username;
	private String password;
	private String firstN;
	private String lastN;
	private int ssn;
	private String email;

	public Application() {
		
	}
	
	//to db
	public Application (String username, String password, String firstN, String lastN, int ssn, String email) {
		
		this.username = username;
		this.password = password;
		this.firstN = firstN;
		this.lastN = lastN;
		this.ssn = ssn;
		this.email = email;
	}
	
	//from db
	public Application (int appnum, String username, String password, String firstN, String lastN, int ssn, String email) {
		
		this.appnum = appnum;
		this.username = username;
		this.password = password;
		this.firstN = firstN;
		this.lastN = lastN;
		this.ssn = ssn;
		this.email = email;
		
	}

	public int getAppnum() {
		return appnum;
	}

	public void setAppnum(int appnum) {
		this.appnum = appnum;
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

	@Override
	public String toString() {
		return "Application [appnum=" + appnum + ", username=" + username + ", password="
				+ password + ", firstN=" + firstN + ", lastN=" + lastN + ", ssn=" + ssn + ", email=" + email + "]";
	}
	
}
