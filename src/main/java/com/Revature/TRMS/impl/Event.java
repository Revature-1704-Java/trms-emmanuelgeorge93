package com.Revature.TRMS.impl;

public class Event {
	private int eventID;
	private String eventName;
	private int coverage;
	
	public Event(int eventID, String eventName, int coverage) {
		super();
		this.eventID = eventID;
		this.eventName = eventName;
		this.coverage = coverage;
	}

	public int getEventID() {
		return eventID;
	}

	public void setEventID(int eventID) {
		this.eventID = eventID;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public int getCoverage() {
		return coverage;
	}

	public void setCoverage(int coverage) {
		this.coverage = coverage;
	}

}
