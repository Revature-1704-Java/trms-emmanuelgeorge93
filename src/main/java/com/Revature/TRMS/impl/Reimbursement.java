package com.Revature.TRMS.impl;

public class Reimbursement {
	private int rID;
	private int eID;
	private int eventID;
	private int eREASON;
	private String eDate;
	private int gID;
	private String eGRADE;
	private String eSUBMIT;
	private double excdAMOUNT;
	private int excdREASON;
	private double rAMOUNT;
	private int eventDesc;
	private int rDREASON;
	private int departmentStatus;
	private int superStatus;
	private int bencoStatus;

	public Reimbursement(int rID, int eID, int eventID, int eREASON, String eDate, int gID, String eGRADE,
			String eSUBMIT, double excdAMOUNT, int excdREASON, double rAMOUNT, int eventDesc, int rDREASON,
			int departmentStatus, int superStatus, int bencoStatus) {
		super();
		this.rID = rID;
		this.eID = eID;
		this.eventID = eventID;
		this.eREASON = eREASON;
		this.eDate = eDate;
		this.gID = gID;
		this.eGRADE = eGRADE;
		this.eSUBMIT = eSUBMIT;
		this.excdAMOUNT = excdAMOUNT;
		this.excdREASON = excdREASON;
		this.rAMOUNT = rAMOUNT;
		this.eventDesc = eventDesc;
		this.rDREASON = rDREASON;
		this.departmentStatus = departmentStatus;
		this.superStatus = superStatus;
		this.bencoStatus = bencoStatus;
	}

	public int getrID() {
		return rID;
	}

	public void setrID(int rID) {
		this.rID = rID;
	}

	public int geteID() {
		return eID;
	}

	public void seteID(int eID) {
		this.eID = eID;
	}

	public int getEventID() {
		return eventID;
	}

	public void setEventID(int eventID) {
		this.eventID = eventID;
	}

	public int geteREASON() {
		return eREASON;
	}

	public void seteREASON(int eREASON) {
		this.eREASON = eREASON;
	}

	public String geteDate() {
		return eDate;
	}

	public void seteDate(String eDate) {
		this.eDate = eDate;
	}

	public int getgID() {
		return gID;
	}

	public void setgID(int gID) {
		this.gID = gID;
	}

	public String geteGRADE() {
		return eGRADE;
	}

	public void seteGRADE(String eGRADE) {
		this.eGRADE = eGRADE;
	}

	public String geteSUBMIT() {
		return eSUBMIT;
	}

	public void seteSUBMIT(String eSUBMIT) {
		this.eSUBMIT = eSUBMIT;
	}

	public double getExcdAMOUNT() {
		return excdAMOUNT;
	}

	public void setExcdAMOUNT(double excdAMOUNT) {
		this.excdAMOUNT = excdAMOUNT;
	}

	public int getExcdREASON() {
		return excdREASON;
	}

	public void setExcdREASON(int excdREASON) {
		this.excdREASON = excdREASON;
	}

	public double getrAMOUNT() {
		return rAMOUNT;
	}

	public void setrAMOUNT(double rAMOUNT) {
		this.rAMOUNT = rAMOUNT;
	}

	public int getEventDesc() {
		return eventDesc;
	}

	public void setEventDesc(int eventDesc) {
		this.eventDesc = eventDesc;
	}

	public int getrDREASON() {
		return rDREASON;
	}

	public void setrDREASON(int rDREASON) {
		this.rDREASON = rDREASON;
	}

	public int getDepartmentStatus() {
		return departmentStatus;
	}

	public void setDepartmentStatus(int departmentStatus) {
		this.departmentStatus = departmentStatus;
	}

	public int getSuperStatus() {
		return superStatus;
	}

	public void setSuperStatus(int superStatus) {
		this.superStatus = superStatus;
	}

	public int getBencoStatus() {
		return bencoStatus;
	}

	public void setBencoStatus(int bencoStatus) {
		this.bencoStatus = bencoStatus;
	}

}
