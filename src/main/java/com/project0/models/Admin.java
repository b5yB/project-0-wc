package com.project0.models;

public class Admin {
	
	/*
	adminid int primary key generated always as identity,
	bankerid int not null unique,
	username varchar(30) not null unique,
	password varchar(30) not null,
	firstN varchar(30) not null,
	lastN varchar(30) not null,
	email varchar(50) not null unique
	*/
	
	private int adminid;
	private int bankerid;
	private String username;
	private String password;
	private String firstN;
	private String lastN;
	private String email;

	public Admin() {
		
	}
	
	//to db
	public Admin (int bankerid, String username, String password, String firstN, String lastN, String email) {
		
		this.bankerid = bankerid;
		this.username = username;
		this.password = password;
		this.firstN = firstN;
		this.lastN = lastN;
		this.email = email;
	}
	
	//from db
	public Admin (int adminid, int bankerid, String username, String password, String firstN, String lastN, String email) {
		
		this.adminid = adminid;
		this.bankerid = bankerid;
		this.username = username;
		this.password = password;
		this.firstN = firstN;
		this.lastN = lastN;
		this.email = email;
		
	}

	public int getAdminid() {
		return adminid;
	}

	public void setAdminid(int adminid) {
		this.adminid = adminid;
	}

	public int getBankerid() {
		return bankerid;
	}

	public void setBankerid(int bankerid) {
		this.bankerid = bankerid;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Admin [adminid=" + adminid + ", bankerid=" + bankerid + ", username=" + username + ", password="
				+ password + ", firstN=" + firstN + ", lastN=" + lastN + ", email=" + email + "]";
	}
	
}
