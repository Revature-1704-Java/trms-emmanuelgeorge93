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

import com.Revature.TRMS.dao.EmployeeDao;
import com.Revature.TRMS.dao.ReimbursementDao;
import com.Revature.TRMS.impl.Employee;
import com.Revature.TRMS.impl.Reimbursement;

@WebServlet("/ViewEmployeesServlet")
public class ViewEmployeesServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		EmployeeDao edao = new EmployeeDao();
		HttpSession session = request.getSession(false);
		Employee user = (Employee) session.getAttribute("User");
		int idflag = (int) session.getAttribute("idflag");
		
		List<Employee> elist = null;
		
		//if only one flag we can never know if someone has multiple roles
		//adding elist.add(edao.getEmployee(user.geteID(), user.getPasswrd()));
		//would allow a benco department head complete use of all tools on site
		//IGNORE FOR NOW
		if (idflag == 1) {
			elist = edao.getEmployeesByDid(user.geteID());
		}
		else if (idflag == 2) {
			elist = edao.getEmployeesBySuperid(user.geteID());
			elist.add(edao.getEmployee(user.geteID(), user.getPasswrd()));
		}
		else if (idflag == 3) {
			elist = edao.getEmployeesByBencoid(user.geteID());
			elist.add(edao.getEmployee(user.geteID(), user.getPasswrd()));
		}
			
		
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
		htmlout.append("<tr><th>Employee Id</th>" + 
				   "<th>First Name</th>" + 
			       "<th>Last Name</th>" +
			       "<th>Password</th>" +
			       "<th>Supervisor Id</th>"+
			       "<th>Department Head ID</th>" +
			       "<th>Benco Id</th></tr>");
		for (Employee temp : elist) {
			htmlout.append("<tr>");
			for (int col = 0; col < 1; col++) {
				htmlout.append("<td>" + temp.geteID() + "</td>" + "<td>" + temp.getFname() + "</td>" + "<td>" 
						+ temp.getLname() + "</td>" + "<td>" + temp.getPasswrd() + "</td>" + "<td>" 
						+ temp.getsID() + "</td>" + "<td>" + temp.getdID() + "</td>" + "<td>" + temp.getBncoID() + "</td>" + "<td>"
						+ "<form action=\"ViewReimbursementsServlet\" method=\"POST\"><input type=\"hidden\" name=\"eid\" value=\""+ temp.geteID() +"\"/><input type=\"submit\" value=\"Details\"></form>" + "</td>");
			}
			htmlout.append("</tr>");
		}
		htmlout.append("</table>");
		
		htmlout.append(html2);
		
		out.println(htmlout);
	}

}
