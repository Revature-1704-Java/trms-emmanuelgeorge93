package com.Revature.TRMS.Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Revature.TRMS.dao.ReimbursementDao;
import com.Revature.TRMS.impl.Reimbursement;

@WebServlet("/DeleteReimbursementServlet")
public class DeleteReimbursementServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int rid = Integer.parseInt(request.getParameter("rid"));

		// find the Reimbursement and store in session
		ReimbursementDao rdao = new ReimbursementDao();
		rdao.deleteReimbursement(rid);

		RequestDispatcher rd = request.getRequestDispatcher("Home.html");
		rd.include(request, response);
	}

}
