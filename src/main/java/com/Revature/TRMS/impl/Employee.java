package com.Revature.TRMS.impl;

public class Employee {
	private int eID;
	private String fname;
	private String lname;
	private String passwrd;
	private int sID;
	private int dID;
	private int bncoID;
	private int eTYPE;
	private double amount;

	public int getBncoID() {
		return bncoID;
	}

	public void setBncoID(int bncoID) {
		this.bncoID = bncoID;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double d) {
		this.amount = d;
	}

	public int geteID() {
		return eID;
	}

	public void seteID(int eID) {
		this.eID = eID;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getPasswrd() {
		return passwrd;
	}

	public void setPasswrd(String passwrd) {
		this.passwrd = passwrd;
	}

	public int getsID() {
		return sID;
	}

	public void setsID(int sID) {
		this.sID = sID;
	}

	public int getdID() {
		return dID;
	}

	public void setdID(int dID) {
		this.dID = dID;
	}

	public int geteTYPE() {
		return eTYPE;
	}

	public void seteTYPE(int eTYPE) {
		this.eTYPE = eTYPE;
	}

	public Employee(int eID, String fname, String lname, String passwrd, int sID, int dID, int bncoID, int eTYPE,
			double amount) {
		super();
		this.eID = eID;
		this.fname = fname;
		this.lname = lname;
		this.passwrd = passwrd;
		this.sID = sID;
		this.dID = dID;
		this.bncoID = bncoID;
		this.eTYPE = eTYPE;
		this.amount = amount;
	}
	
	
	public Employee() {
		eID = 0;
		fname = "N/A";
		lname = "N/A";
		passwrd = "N/A";
		sID = 0;
		dID = 0;
		bncoID = 0;
		eTYPE = 0;
		amount = 0;
	}
}
