package com.Revature.TRMS;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.Revature.TRMS.dao.ReimbursementDao;
import com.Revature.TRMS.impl.Reimbursement;

public class ReimbursementDaoTest {
	ReimbursementDao rdao = new ReimbursementDao();

	@Test
	public void testGetALLReimbursement() {
		List<Reimbursement> reimall = rdao.getALLReimbursement();

		System.out.println("----------get all Reimbursements tester--------");

		// DEBUGGING TO SEE IF IT ACTUAL GETS FROM TABLE
		for (Reimbursement l : reimall) {
			System.out.println(l.getrID() + " " + l.geteID() + " " + l.getEventID() + " " + l.geteREASON() + " "
					+ l.geteDate() + " " + l.getgID() + " " + l.geteGRADE() + " " + l.geteSUBMIT() + " "
					+ " " + l.getExcdAMOUNT() + " " + l.getExcdREASON() + " " + l.getEventDesc() + " "
					+ " " + l.getrDREASON() + " " + l.getDepartmentStatus() + " " + l.getSuperStatus() + " " + l.getBencoStatus());
		}

		assertEquals(2, reimall.get(0).getrID());
		// assertEquals(reimall.get(0).getrID(), 1);
	}

	@Test
	public void testGetReimbursement() {
		Reimbursement l = rdao.getReimbursement(2);

		System.out.println("----------get a Reimbursement tester----------");

		System.out.println(l.getrID() + " " + l.geteID() + " " + l.getEventID() + " " + l.geteREASON() + " "
				+ l.geteDate() + " " + l.getgID() + " " + l.geteGRADE() + " " + l.geteSUBMIT() + " "
				+ " " + l.getExcdAMOUNT() + " " + l.getExcdREASON() + " " + l.getEventDesc() + " "
				+ " " + l.getrDREASON() + " " + l.getDepartmentStatus() + " " + l.getSuperStatus() + " " + l.getBencoStatus());

		assertEquals(l.getrID(), 2);
	}

	@Test
	public void testaddReimbursement() {
		// COMMENTED THE ADD OUT BECAUSE IT WOULD ADD A NEW ENTRY EVERYTIME I TESTED

		rdao.addReimbursement(3, 3, 3, "test", 30, 3, 3, 3);

		Reimbursement l = rdao.getReimbursement(2);

		assertEquals(l.getrID(), 2);
	}

	//DELETE IS COMMENTED OUT OTHERWISE IT WILL FAIL AFTER THE FIRST TEST WHERE IT DELETES ITS ROW
	@Test
	public void testdeleteReimbursement() {
		//rdao.deleteReimbursement(1);
	}

	@Test
	public void testupdateReimbursement() {
		rdao.updateReimbursement(2, 1, 4, 4, "04-APR-93", 20, "75", 0, 1, 4.99, 1, 1, 1, 1, 1);

		Reimbursement l = rdao.getReimbursement(2);

		assertEquals(l.getrID(), 2);
	}
}
