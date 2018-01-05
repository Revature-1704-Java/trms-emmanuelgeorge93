package com.Revature.TRMS;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.Revature.TRMS.impl.Grade;

public class GradeTest {

	Grade test = new Grade(1, "test", 1);

	@Test
	public void testGetgID() {
		assertEquals(test.getgID(), 1);
	}

	@Test
	public void testSetgID() {
		test.setgID(2);
		assertEquals(test.getgID(), 2);
	}

	@Test
	public void testGetgName() {

		assertEquals(test.getgName(), "test");
	}

	@Test
	public void testSetgName() {
		test.setgName("tester");
		assertEquals(test.getgName(), "tester");
	}

	@Test
	public void testGetPassMARK() {
		assertEquals(test.getPassMARK(), 1);
	}

	@Test
	public void testSetPassMARK() {
		test.setPassMARK(2);
		assertEquals(test.getPassMARK(), 2);
	}

}
