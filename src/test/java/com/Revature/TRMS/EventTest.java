package com.Revature.TRMS;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.Revature.TRMS.impl.Event;

public class EventTest {

	Event test = new  Event(1, "test", 1);

	@Test
	public void testGetEventID() {
		assertEquals(test.getEventID(), 1);
	}

	@Test
	public void testSetEventID() {
		test.setEventID(2);
		assertEquals(test.getEventID(), 2);
	}

	@Test
	public void testGetEventName() {
		assertEquals(test.getEventName(), "test");
	}

	@Test
	public void testSetEventName() {
		test.setEventName("tester");
		assertEquals(test.getEventName(), "tester");
	}

	@Test
	public void testGetCoverage() {
		assertEquals(test.getCoverage(), 1);
	}

	@Test
	public void testSetCoverage() {
		test.setCoverage(2);
		assertEquals(test.getCoverage(), 2);
	}

}
