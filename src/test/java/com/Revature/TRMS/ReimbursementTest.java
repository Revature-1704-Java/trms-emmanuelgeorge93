package com.Revature.TRMS;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.Revature.TRMS.impl.Reimbursement;

public class ReimbursementTest {
	Reimbursement test = new Reimbursement(1, 1, 1, 1, "test", 1, "test", "test", 1, 1, 1, 1, 1, 1, 1, 1);

	@Test
	public void testGetrID() {
		assertEquals(test.getrID(), 1);
	}

	@Test
	public void testSetrID() {
		test.setrID(2);
		assertEquals(test.getrID(), 2);
	}

	@Test
	public void testGetrCOST() {
		assertEquals(test.getrAMOUNT(), 1, .01);
	}

	@Test
	public void testSetrCOST() {
		test.setrAMOUNT(2);
		assertEquals(test.getrAMOUNT(), 2, .01);
	}

	@Test
	public void testGeteventDesc() {
		assertEquals(test.getEventDesc(), 1);
	}

	@Test
	public void testSeteventDesc() {
		test.setEventDesc(2);
		assertEquals(test.getEventDesc(), 2);
	}

	@Test
	public void testGetrDREASON() {
		assertEquals(test.getrDREASON(), 1);
	}

	@Test
	public void testSetrDREASON() {
		test.setrDREASON(1);
		assertEquals(test.getrDREASON(), 1);
	}

	@Test
	public void testGeteAMOUNT() {
		assertEquals(test.getExcdAMOUNT(), 1, .01);
	}

	@Test
	public void testSeteAMOUNT() {
		test.setExcdAMOUNT(1);
		assertEquals(test.getExcdAMOUNT(), 1, .01);
	}

	@Test
	public void testGeteREASON() {
		assertEquals(test.geteREASON(), 1);
	}

	@Test
	public void testSeteREASON() {
		test.seteREASON(2);
		assertEquals(test.geteREASON(), 2);
	}

	@Test
	public void testGetExcdREASON() {
		assertEquals(test.getExcdREASON(), 1);
	}

	@Test
	public void testSetExcdREASON() {
		test.setExcdREASON(2);
		assertEquals(test.getExcdREASON(), 2);
	}

	@Test
	public void testGetExcdAMOUNT() {
		assertEquals(test.getExcdAMOUNT(), 1, .01);
	}

	@Test
	public void testSetExcdAMOUNT() {
		test.setExcdAMOUNT(2);
		assertEquals(test.getExcdAMOUNT(), 2, .01);
	}

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
	public void testGeteDESC() {
		assertEquals(test.geteDate(), "test");
	}

	@Test
	public void testSeteDESC() {
		test.seteDate("tester");
		assertEquals(test.geteDate(), "tester");
	}

	@Test
	public void testGetgID() {
		assertEquals(test.getgID(), 1);
	}

	@Test
	public void testSetgID() {
		test.setgID(1);
		assertEquals(test.getgID(), 1);
	}

	@Test
	public void testGeteID() {
		assertEquals(test.geteID(), 1);
	}

	@Test
	public void testSeteID() {
		test.seteID(2);
		assertEquals(test.geteID(), 2);
	}

	@Test
	public void testGeteSUBMIT() {
		assertEquals(test.geteSUBMIT(), "test");
	}

	@Test
	public void testSeteSUBMIT() {
		test.seteSUBMIT("tester");
		assertEquals(test.geteSUBMIT(), "tester");
	}
	
	@Test
	public void testGetDepartmentStatus() {
		assertEquals(test.getDepartmentStatus(), 1);
	}

	@Test
	public void testSetDepartmentStatus() {
		test.setDepartmentStatus(2);
		assertEquals(test.getDepartmentStatus(), 2);
	}
	
	@Test
	public void testGetSuperStatus() {
		assertEquals(test.getSuperStatus(), 1);
	}

	@Test
	public void testSetSuperStatus() {
		test.setSuperStatus(2);
		assertEquals(test.getSuperStatus(), 2);
	}

	@Test
	public void testGetBencoStatus() {
		assertEquals(test.getBencoStatus(), 1);
	}

	@Test
	public void testSetBencoStatus() {
		test.setBencoStatus(2);
		assertEquals(test.getBencoStatus(), 2);
	}
}
