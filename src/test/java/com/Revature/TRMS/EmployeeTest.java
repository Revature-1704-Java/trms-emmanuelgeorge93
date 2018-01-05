package com.Revature.TRMS;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.Revature.TRMS.impl.Employee;

public class EmployeeTest {

	Employee test = new Employee(1, "test", "test", "test", 1, 1, 1, 1, 1000.00);

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
	public void testGetFname() {
		assertEquals(test.getFname(), "test");
	}

	@Test
	public void testSetFname() {
		test.setFname("tester");
		assertEquals(test.getFname(), "tester");
	}

	@Test
	public void testGetLname() {
		assertEquals(test.getLname(), "test");
	}

	@Test
	public void testSetLname() {
		test.setLname("tester");
		assertEquals(test.getLname(), "tester");
	}

	@Test
	public void testGetPasswrd() {
		assertEquals(test.getPasswrd(), "test");
	}

	@Test
	public void testSetPasswrd() {
		test.setPasswrd("tester");
		assertEquals(test.getPasswrd(), "tester");
	}

	@Test
	public void testGetsID() {
		assertEquals(test.getsID(), 1);
	}

	@Test
	public void testSetsID() {
		test.setsID(2);
		assertEquals(test.getsID(), 2);
	}

	@Test
	public void testGetdID() {
		assertEquals(test.getdID(), 1);
	}

	@Test
	public void testSetdID() {
		test.setdID(2);
		assertEquals(test.getdID(), 2);
	}

	@Test
	public void testGetBNCOID() {
		assertEquals(test.getBncoID(), 1);
	}

	@Test
	public void testSetBNCOID() {
		test.setBncoID(2);
		assertEquals(test.getBncoID(), 2);
	}

	@Test
	public void testGeteTYPE() {
		assertEquals(test.geteTYPE(), 1);
	}

	@Test
	public void testSeteTYPE() {
		test.seteTYPE(2);
		assertEquals(test.geteTYPE(), 2);
	}

	@Test
	public void testGetAMOUNT() {
		assertEquals(test.getAmount(), 1000.00, .001);
	}

	@Test
	public void testSetAMOUNT() {
		test.setAmount(2.5);
		assertEquals(test.getAmount(), 2.5, .001);
	}

}
