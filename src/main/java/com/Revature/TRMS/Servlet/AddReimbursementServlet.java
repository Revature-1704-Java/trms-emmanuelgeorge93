package com.Revature.TRMS.Servlet;

import java.io.IOException;

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


@WebServlet("/AddReimbursementServlet")
public class AddReimbursementServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		Employee user = (Employee) session.getAttribute("User");
		ReimbursementDao rdao = new ReimbursementDao();
		
		//employee id should not be typed in but done automatically by the program after you login
		int eid = (int) session.getAttribute("eid");
		
		//employ should provide this
		int eventid = Integer.parseInt(request.getParameter("eventid"));
		
		////employ should provide this, must change to a file path insdead of an id for an existing file
		int reason = Integer.parseInt(request.getParameter("ereason"));
		
		//employ should provide this
		String eventdate = request.getParameter("eventdate");
		
		//employ should provide this
		int gid = Integer.parseInt(request.getParameter("gid"));
		
		//employ should provide this, but not right now they have come back later or someone else can submit the grade
		int grade = Integer.parseInt(request.getParameter("grade"));
		
		//this is provided by the employee as the cost of the program then changed by benco to reflect the true amount
		double ramount = Double.parseDouble(request.getParameter("ramount"));
		
		//employ should provide this
		int eventdesc = Integer.parseInt(request.getParameter("eventdesc"));
		
		//eID, eventID, eREASON, eventDATE, gID, eGRADE, excdAMOUNT, excdREASON, rAMOUNT, eventDESC, rdREASON, departmentStatus, superStatus, bencoStatus
		
		//if all things check out we can submit to the table
		rdao.addReimbursement(eid, eventid, reason, eventdate, gid, grade, ramount, eventdesc);
		try {
			RequestDispatcher rd = request.getRequestDispatcher("AddReimbursement.html");
			rd.forward(request, response);
		} catch (Throwable theException) {
			System.out.println(theException);
		}
	}

}
