package com.Revature.TRMS.impl;

public class Files {
	private int fID;
	private int rID;
	private String fDESC;
	private String fPath;
	
	public Files(int fID, int rID, String fDESC, String fPath) {
		super();
		this.fID = fID;
		this.rID = rID;
		this.fDESC = fDESC;
		this.fPath = fPath;
	}

	public int getfID() {
		return fID;
	}

	public void setfID(int fID) {
		this.fID = fID;
	}

	public int getrID() {
		return rID;
	}

	public void setrID(int rID) {
		this.rID = rID;
	}

	public String getfDESC() {
		return fDESC;
	}

	public void setfDESC(String fDESC) {
		this.fDESC = fDESC;
	}

	public String getfPath() {
		return fPath;
	}

	public void setfPath(String fPath) {
		this.fPath = fPath;
	}

}
