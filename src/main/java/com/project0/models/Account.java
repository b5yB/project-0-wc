package com.project0.models;

public class Account {
	
	/*
	acctid int primary key generated always as identity,
	useracctnum int references users(acctnum) not null unique,
	firstN varchar(30) not null,
	lastN varchar(30) not null,
	balance int not null,
	bankerid int not null unique
	*/
	
	private int acctid;
	private int userAcctNum;
	private String firstN;
	private String lastN;
	private double balance;
	private int bankerid;
	
	public Account() {
		
	}
	
	//to DB
	public Account(int userAcctNum, String firstN, String lastN, double balance, int bankerid) {
		
		this.userAcctNum = userAcctNum;
		this.firstN = firstN;
		this.lastN = lastN;
		this.balance = balance;
		this.bankerid = bankerid;
		
	}
	
	//from DB
	public Account(int acctid, int userAcctNum, String firstN, String lastN, double balance, int bankerid) {
		
		this.acctid = acctid;
		this.userAcctNum = userAcctNum;
		this.firstN = firstN;
		this.lastN = lastN;
		this.balance = balance;
		this.bankerid = bankerid;
		
	}

	public int getAcctid() {
		return acctid;
	}

	public void setAcctid(int acctid) {
		this.acctid = acctid;
	}

	public int getUserAcctNum() {
		return userAcctNum;
	}

	public void setUserAcctNum(int userAcctNum) {
		this.userAcctNum = userAcctNum;
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
		return "Account [acctid=" + acctid + ", userAcctNum=" + userAcctNum + ", firstN=" + firstN + ", lastN=" + lastN
				+ ", balance=" + balance + ", bankerid=" + bankerid + "]";
	}
	
	
	
}
