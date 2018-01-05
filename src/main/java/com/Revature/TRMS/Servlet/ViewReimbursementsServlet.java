package com.Revature.TRMS.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Revature.TRMS.dao.ReimbursementDao;
import com.Revature.TRMS.impl.Employee;
import com.Revature.TRMS.impl.Reimbursement;

@WebServlet("/ViewReimbursementsServlet")
public class ViewReimbursementsServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		ReimbursementDao rdao = new ReimbursementDao();
		HttpSession session = request.getSession(false);
		
		int eid = Integer.parseInt(request.getParameter("eid"));
		List<Reimbursement> rpile = rdao.getALLforOneReimbursement(eid);
		session.setAttribute("eid", eid);
		
		String html1 ="<!DOCTYPE html>\r\n" + 
				"<html>\r\n" + 
				"  <head>\r\n" + 
				"    <meta charset=\"utf-8\">\r\n" + 
				"    <meta name=\"viewport\" content=\"width=device-width\">\r\n" + 
				"    <title>TRMS | Login</title>\r\n" + 
				"    <meta name=\"author\" content=\"Emmanuel\">\r\n" + 
				"    <link rel=\"stylesheet\" href=\"Trms.css\">\r\n" + 
				"  </head>\r\n" + 
				"  <body>\r\n" + 
				"    <header>\r\n" + 
				"      <div class=\"container\">\r\n" + 
				"        <div id=\"branding\">\r\n" + 
				"          <h1>\r\n" + 
				"            <span class=\"highlight\">\r\n" + 
				"              TRMS\r\n" + 
				"            </span>\r\n" + 
				"          </h1>\r\n" + 
				"        </div>\r\n" + 
				"\r\n" + 
				"        <nav>\r\n" + 
				"          <ul>\r\n" + 
				"            <li>\r\n" + 
				"              <a href=\"Home.html\">Home</a>\r\n" + 
				"            </li>\r\n" + 
				"            <li>\r\n" + 
				"              <a href=\"Login.html\">Login</a>\r\n" + 
				"            </li>\r\n" + 
				"            <li>\r\n" + 
				"              <a href=\"Home.html\">About</a>\r\n" + 
				"            </li>\r\n" + 
				"          </ul>\r\n" + 
				"        </nav>\r\n" + 
				"      </div>\r\n" + 
				"    </header>\r\n" + 
				"\r\n" + 
				"    <section id=\"showcase\">\r\n" + 
				"      <div class=\"container\">";
		
		
		String html2 = "	  </div>\r\n" + 
				"	</section>\r\n" + 
				"\r\n" + 
				"    <section id=\"newsletter\">\r\n" + 
				"      <div class=\"container\">\r\n" + 
				"      \r\n" + 
				"      </div>\r\n" + 
				"    </section>\r\n" + 
				"\r\n" + 
				"    <footer>\r\n" + 
				"      <p>TRMS, Copyright &copy; 2017</p>\r\n" + 
				"    </footer>\r\n" + 
				"  </body>\r\n" + 
				"</html>";
		
		StringBuilder htmlout = new StringBuilder();
		
		htmlout.append(html1);
		
		
		
		htmlout.append("<table border=1>");
		htmlout.append("<tr><th>Reimbursement Id</th>" + 
				   "<th>Event Date</th>" + 
			       "<th>Reimbursement Amount</th>" +
			       "<th>Grade</th></tr>");
		for (Reimbursement temp : rpile) {
			htmlout.append("<tr>");
			for (int col = 0; col < 1; col++) {
				htmlout.append("<td>" + temp.getrID() + "</td>" + "<td>" + temp.geteDate() + "</td>" + "<td>" 
						+ temp.getrAMOUNT() + "</td>" + "<td>" + temp.geteGRADE() + "</td>" 
						+ "<td>" + "<form action=\"DetailsServlet\" method=\"POST\"><input type=\"hidden\" name=\"rid\" value=\""+ temp.getrID() +"\"/><input type=\"submit\" value=\"Details\"></form>" + "</td>"
						+ "<td>" + "<form action=\"DeleteReimbursementServlet\" method=\"POST\"><input type=\"hidden\" name=\"rid\" value=\""+ temp.getrID() +"\"/><input type=\"submit\" value=\"Delete\"></form>" + "</td>");
			}
			htmlout.append("</tr>");
		}
		htmlout.append("</table>");
		
		String addbtn = "<form action=\"AddReimbursement.html\" method=\"POST\"><input type=\"hidden\" name=\"rid\" value=\"" + eid +"\"/><input type=\"submit\" value=\"File Reimbursement\"></form>";
		
		htmlout.append(addbtn);
		
		htmlout.append(html2);
		
		out.println(htmlout);
	}

}
