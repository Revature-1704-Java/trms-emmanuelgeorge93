package com.Revature.TRMS;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.Revature.TRMS.dao.EmployeeDao;
import com.Revature.TRMS.impl.Employee;

public class EmployeeDaoTest {
	EmployeeDao edao = new EmployeeDao();

	@Test
	public void testGetALLEmployee() {
		List<Employee> ppl = edao.getALLEmployee();

		System.out.println("----------get all Employees tester--------");

		// DEBUGGING TO SEE IF IT ACTUAL GETS FROM TABLE
		for (Employee l : ppl) {
			System.out.println(l.geteID() + " " + l.getFname() + " " + l.getLname() + " " + l.getPasswrd() + " "
					+ l.getsID() + " " + l.getdID() + " " + l.geteTYPE());
		}

		assertEquals(ppl.get(0).geteID(), 1);
	}

	@Test
	public void testGetEmployee() {
		Employee l = edao.getEmployee(1, "test");

		System.out.println("----------get an Employee tester----------");

		System.out.println(l.geteID() + " " + l.getFname() + " " + l.getLname() + " " + l.getPasswrd() + " "
				+ l.getsID() + " " + l.getdID() + " " + l.geteTYPE());

		assertEquals(l.geteID(), 1);
	}

	@Test
	public void testaddEmployee() {
		// COMMENTED THE ADD OUT BECAUSE IT WOULD ADD A NEW ENTRY EVERYTIME I TESTED

		/*
		 * edao.addEmployee("add", "add", "add", 1, 1, 1, 4, 1000.00);
		 * 
		 * Employee l = edao.getEmployee(13, "add"); assertEquals(l.geteID(), 13);
		 */
	}

	@Test
	public void testdeleteEmployee() {
		// edao.deleteEmployee(13);
	}

	@Test
	public void testupdateEmployee() {
		edao.updateEmployee("test", "test", "test", 1, 1, 1, 1, 1000.00, 1);

		Employee l = edao.getEmployee(1, "test");
		assertEquals(l.getFname(), "test");
	}

}
