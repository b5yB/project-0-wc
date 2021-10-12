package com.project0.models;

public class Employee {
	
	private int bankerid;
	private String username;
	private String password;
	private String firstN;
	private String lastN;
	private String email;
	private int adminid;
	
	public Employee() {
		
	}
	
	//to db
	public Employee(String username, String password, String firstN, String lastN, String email, int adminid) {
		
		this.username = username;
		this.password = password;
		this.firstN = firstN;
		this.lastN = lastN;
		this.email = email;
		this.adminid = adminid;
	}
	
	//from db
	public Employee (int bankerid, String username, String password, String firstN, String lastN, String email, int adminid) {
		
		this.bankerid = bankerid;
		this.username = username;
		this.password = password;
		this.firstN = firstN;
		this.lastN = lastN;
		this.email = email;
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
	
	public int getAdminid() {
		return adminid;
	}
	public void setAdminid(int adminid) {
		this.adminid = adminid;
	}

	@Override
	public String toString() {
		return "Employee [bankerid=" + bankerid + ", username=" + username + ", password=" + password + ", firstN="
				+ firstN + ", lastN=" + lastN + ", email=" + email + ", adminid=" + adminid + "]";
	}
	
}
