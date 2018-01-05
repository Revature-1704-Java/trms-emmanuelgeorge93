package com.Revature.TRMS.impl;

public class EmployeeType {
	private int eTYPEID;
	private String tNAME;

	public EmployeeType(int eTYPEID, String tNAME) {
		super();
		this.eTYPEID = eTYPEID;
		this.tNAME = tNAME;
	}

	public int geteTYPEID() {
		return eTYPEID;
	}

	public void seteTYPEID(int eTYPEID) {
		this.eTYPEID = eTYPEID;
	}

	public String gettNAME() {
		return tNAME;
	}

	public void settNAME(String tNAME) {
		this.tNAME = tNAME;
	}

}
