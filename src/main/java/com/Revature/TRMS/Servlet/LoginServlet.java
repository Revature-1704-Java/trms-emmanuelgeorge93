package com.Revature.TRMS.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Revature.TRMS.dao.EmployeeDao;
import com.Revature.TRMS.dao.ReimbursementDao;
import com.Revature.TRMS.impl.Employee;
import com.Revature.TRMS.impl.Reimbursement;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}// end of doGet

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// create dao and get values from web page
		EmployeeDao edao = new EmployeeDao();

		int eid = Integer.valueOf(request.getParameter("eid"));
		String passwrd = request.getParameter("passwrd");

		// try to find an employee with same eid and password
		Employee user = edao.getEmployee(eid, passwrd);
		try {
			// if found we create a session and direct to new page
			if (user != null) {
				HttpSession session = request.getSession(true);
				session.setAttribute("User", user);

				// note here a department head cannot act as a supervisor or benco to anyone
				// better login would be to allow each if to only set a flag then go to
				// ViewEmployeesServlet
				if (user.geteTYPE() == 1) {
					// this is a department head
					session.setAttribute("idflag", 1);

					RequestDispatcher rd = request.getRequestDispatcher("ViewEmployeesServlet");
					rd.include(request, response);
				} else if (user.geteTYPE() == 2) {
					// this is a supervisor
					session.setAttribute("idflag", 2);

					RequestDispatcher rd = request.getRequestDispatcher("ViewEmployeesServlet");
					rd.include(request, response);

				} else if (user.geteTYPE() == 3) {
					// this is a benco
					session.setAttribute("idflag", 3);

					RequestDispatcher rd = request.getRequestDispatcher("ViewEmployeesServlet");
					rd.include(request, response);

				} else {
					// other wise this is a standard employee
					// direct to employee view
					session.setAttribute("idflag", 4);

					RequestDispatcher rd = request.getRequestDispatcher("ViewReimbursementsServlet");
					rd.include(request, response);
				}
				// end of inner if else-if chain

				// above logic does not allow for a department head to acess the supervisor
				// functions of his direct subordinates
				// extreme case example the department head of benco could not give supervisor
				// aprrovial to his subordinate
				// same for benco approvial

			} else {
				// else we are sent back to login page to try again
				RequestDispatcher rd = request.getRequestDispatcher("Login.html");
				rd.include(request, response);
			}
			// end of outer if
		} catch (Throwable theException) {
			System.out.println(theException);
		}

	}

}
