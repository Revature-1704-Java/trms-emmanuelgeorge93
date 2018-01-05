package com.Revature.TRMS;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.Revature.TRMS.impl.EmployeeType;

public class EmployeeTypeTest {

	EmployeeType test = new EmployeeType(1, "test");

	@Test
	public void testGeteTYPEID() {
		assertEquals(test.geteTYPEID(), 1);
	}

	@Test
	public void testSeteTYPEID() {
		test.seteTYPEID(2);
		assertEquals(test.geteTYPEID(), 2);
	}

	@Test
	public void testGettNAME() {
		assertEquals(test.gettNAME(), "test");
	}

	@Test
	public void testSettNAME() {
		test.settNAME("tester");
		assertEquals(test.gettNAME(), "tester");
	}

}
