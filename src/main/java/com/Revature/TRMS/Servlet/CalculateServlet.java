package com.Revature.TRMS.Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Revature.TRMS.dao.EmployeeDao;
import com.Revature.TRMS.dao.ReimbursementDao;
import com.Revature.TRMS.impl.Employee;
import com.Revature.TRMS.impl.Reimbursement;

@WebServlet("/CalculateServlet")
public class CalculateServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int rid = Integer.parseInt(request.getParameter("rid"));
		ReimbursementDao rdao = new ReimbursementDao();
		EmployeeDao edao = new EmployeeDao();
		
		//get the reimbursement and employee amounts we are going to calculate with
		//as well as the amount of coverage for the event
		Reimbursement temp = rdao.getReimbursement(rid);
		Employee dude = edao.getEmployeeNopass(temp.geteID());
		double coverage = rdao.getCoverage(temp.getEventID());
		//now we can calculate reimbursment
		
		//Math is --> TotalReimburstment ($1000) – PendingReimburstments – AwardedReimburstments
		//if we deduct on the fly we can avoid putting awarded in the equation
		//note ramount is what the employee types in as the total this needs to be checked with the event type
		//for amount of coverage
		
		//amount actually covered by reimbursement system
		double covered = temp.getrAMOUNT() * (coverage/100.00);
		
		//amount remaining in employee's allowance after calculations
		double amountR = dude.getAmount() - covered;
		
		//if amount remaining in employee allowance is less than 0
		//set remaining balance as what is covered by reimbursement, balance is now zero
		if(amountR <= 0) {
			covered = dude.getAmount();
			amountR = 0;
		}
				
		edao.updateEmployee(dude.getFname(), dude.getLname(), dude.getPasswrd(), dude.getsID(), 
				dude.getdID(), dude.getBncoID(), dude.geteTYPE(), amountR, dude.geteID());
		
		rdao.updateReimbursement(temp.getrID(), temp.geteID(), temp.getEventID(), temp.geteREASON(), temp.geteDate(),
				temp.getgID(), temp.geteGRADE(), temp.getExcdAMOUNT(), temp.getExcdREASON(), covered, temp.getEventDesc(), temp.getrDREASON(), temp.getDepartmentStatus(), temp.getSuperStatus(), temp.getBencoStatus());
		
		RequestDispatcher rd = request.getRequestDispatcher("DetailsServlet");
		rd.forward(request, response);
	}//end of doPost

}
