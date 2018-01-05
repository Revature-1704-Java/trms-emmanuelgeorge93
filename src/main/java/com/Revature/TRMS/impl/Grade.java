package com.Revature.TRMS.impl;

public class Grade {
	private int gID;
	private String gName;
	private int passMARK;

	public Grade(int gID, String gName, int passMARK) {
		super();
		this.gID = gID;
		this.gName = gName;
		this.passMARK = passMARK;
	}

	public int getgID() {
		return gID;
	}

	public void setgID(int gID) {
		this.gID = gID;
	}

	public String getgName() {
		return gName;
	}

	public void setgName(String gName) {
		this.gName = gName;
	}

	public int getPassMARK() {
		return passMARK;
	}

	public void setPassMARK(int passMARK) {
		this.passMARK = passMARK;
	}

}
