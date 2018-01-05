package com.Revature.TRMS.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Revature.TRMS.dao.ReimbursementDao;
import com.Revature.TRMS.impl.Reimbursement;

/**
 * Servlet implementation class UpdateReimbursementServlet
 */
@WebServlet("/UpdateReimbursementServlet")
public class UpdateReimbursementServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//get session and store thisR (the reimbursement) in temp
		HttpSession session = request.getSession(false);
		Reimbursement temp = (Reimbursement) session.getAttribute("thisR");
		
		ReimbursementDao rdao = new ReimbursementDao();
		
		//employee id should not be typed in but done automatically by the program after you login
		int eid = Integer.valueOf(request.getParameter("eid"));
		
		//employ should provide this
		int eventid = Integer.valueOf(request.getParameter("eventid"));
		
		////employ should provide this, must change to a file path insdead of an id for an existing file
		int reason = Integer.valueOf(request.getParameter("ereason"));
		
		//employ should provide this
		String eventdate = request.getParameter("eventdate");
		
		//employ should provide this
		int gid = Integer.valueOf(request.getParameter("gid"));
		
		//employ should provide this, but not right now they have come back later or someone else can submit the grade
		String grade = request.getParameter("grade");
		
		//this should not be provided by the employee, but by benco
		double excdamount = Double.valueOf(request.getParameter("excdamount"));
		
		//same as above
		int excdreason = Integer.valueOf(request.getParameter("excdreason"));
		
		//this is provided by the employee as the cost of the program then changed by benco to reflect the true amount
		double ramount = Double.valueOf(request.getParameter("ramount"));
		
		//employ should provide this
		int eventdesc = Integer.valueOf(request.getParameter("eventdesc"));
		
		//reason to deny should be provided by anyone that denies the reimbursement
		int rdreason = Integer.valueOf(request.getParameter("rdreason"));
		
		int departmentStatus = Integer.valueOf(request.getParameter("departmentStatus"));
				
		int superStatus = Integer.valueOf(request.getParameter("superStatus"));
				
		int bencoStatus = Integer.valueOf(request.getParameter("bencoStatus"));
		
		//update reimbursement with new values
		rdao.updateReimbursement(temp.getrID(), eid, eventid, reason, eventdate, gid, grade, excdamount, excdreason, ramount, eventdesc, rdreason, departmentStatus, superStatus, bencoStatus);
		
		//get the updated entry from table
		temp = rdao.getReimbursement(temp.getrID());
		
		//store value in session
		session.setAttribute("thisR", temp);
		
		response.sendRedirect("DetailsServlet");
	}

}
