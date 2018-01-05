package com.Revature.TRMS.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Revature.TRMS.dao.ReimbursementDao;
import com.Revature.TRMS.impl.Reimbursement;

@WebServlet("/DepartmentStatusServlet")
public class DepartmentStatusServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int rid = Integer.parseInt(request.getParameter("rid"));
		int statusC = Integer.parseInt(request.getParameter("statusC"));
		ReimbursementDao rdao = new ReimbursementDao();

		// with values from page we change the value of departmentStatus: approve is 1
		// deny is 0
		rdao.departmentStatus(rid, statusC);

		RequestDispatcher rd = request.getRequestDispatcher("DetailsServlet");
		rd.forward(request, response);
	}

}
