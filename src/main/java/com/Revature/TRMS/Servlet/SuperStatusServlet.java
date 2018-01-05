package com.Revature.TRMS.Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Revature.TRMS.dao.ReimbursementDao;

@WebServlet("/SuperStatusServlet")
public class SuperStatusServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		int rid = Integer.parseInt(request.getParameter("rid"));
		int statusC = Integer.parseInt(request.getParameter("statusC"));
		ReimbursementDao rdao = new ReimbursementDao();
		
		//with values from page we change the value of SuperStatus: approve is 1 deny is 0
		rdao.superStatus(rid, statusC);
		
		RequestDispatcher rd = request.getRequestDispatcher("DetailsServlet");
		rd.forward(request, response);
	}

}
