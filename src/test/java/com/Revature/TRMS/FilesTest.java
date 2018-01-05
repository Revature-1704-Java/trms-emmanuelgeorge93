package com.Revature.TRMS;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.Revature.TRMS.impl.Files;

public class FilesTest {

	Files test = new Files(1, 1, "test", "test");

	@Test
	public void testGetfID() {
		assertEquals(test.getfID(), 1);
	}

	@Test
	public void testSetfID() {
		test.setfID(2);
		assertEquals(test.getfID(), 2);
	}

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
	public void testGetfDESC() {
		assertEquals(test.getfDESC(), "test");
	}

	@Test
	public void testSetfDESC() {
		test.setfDESC("tester");
		assertEquals(test.getfDESC(), "tester");
	}

	@Test
	public void testGetfPath() {
		assertEquals(test.getfPath(), "test");
	}

	@Test
	public void testSetfPath() {
		test.setfPath("tester");
		assertEquals(test.getfPath(), "tester");
	}

}
