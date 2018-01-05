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

import com.Revature.TRMS.dao.ReimbursementDao;
import com.Revature.TRMS.impl.Employee;
import com.Revature.TRMS.impl.Reimbursement;

@WebServlet("/DetailsServlet")
public class DetailsServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(false);
		Reimbursement temp = (Reimbursement) session.getAttribute("thisR");
		
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
		htmlout.append("<tr><th>Reimbursement Id</th>" + "<th>Employee Id</th>" + "<th>Event Id</th></tr>" +
					   "<td>" + temp.getrID() + "</td>" + "<td>" + temp.geteID() + "</td>" + "<td>" + temp.getEventID() + "</td>" +
					   "<tr><th>Employee Reasons file Id</th>" + "<th>Event Date</th>" + "<th>Grade Format Id</th></tr>"+
					   "<td>" + temp.geteREASON() + "</td>" + "<td>" + temp.geteDate() + "</td>" + "<td>" + temp.getgID() + "</td>" +
					   "<tr><th>Employee Grade</th>" + "<th>Submition Date</th>" + "<th>Excess Amount</th></tr>" +
					   "<td>" + temp.geteGRADE() + "</td>" + "<td>" + temp.geteSUBMIT() + "</td>" +"<td>" + temp.getExcdAMOUNT() + "</td>" + 
					   "<tr><th>Reasons for Excess Id</th>" + "<th>Reimbursement Amount</th>" + "<th>Event Description Id</th></tr>" +
					   "<td>" + temp.getExcdREASON() + "</td>" + "<td>" + temp.getrAMOUNT() + "</td>" + "<td>" + temp.getEventDesc() + "</td>" +
					   "<tr><th>Reasons for Denial Id</th>" + "<th>Department Status</th>" + "<th>Supervisor Status</th>" + "<th>Benco Status</th></tr>" + 
					   "<td>" + temp.getrDREASON() + "</td>" + "<td>" + temp.getDepartmentStatus() + "</td>" +"<td>" + temp.getSuperStatus() + "</td>" + "<td>" + temp.getBencoStatus() + "</td>");
		htmlout.append("</tr>");
		htmlout.append("</table>");
		
		String updatebtn = "<form action=\"UpdateReimbursement.html\" method=\"POST\"><input type=\"submit\" value=\"Update\"></form>";
		htmlout.append(updatebtn);

		int idflag = (int)session.getAttribute("idflag");
		//Employee user = (Employee)session.getAttribute("user");
		
		if(idflag == 1) {
			String departbtn = "<form action=\"DepartmentStatusServlet\" method=\"POST\">\r\n" + 
					"  <input type=\"radio\" name=\"statusC\" value=\"1\" checked>Approve<br>\r\n" + 
					"  <input type=\"radio\" name=\"statusC\" value=\"0\">Deny<br>\r\n" + 
					"  <input type=\"hidden\" name=\"rid\" value=" + temp.getrID() +">\r\n" + 
					"  <input type=\"submit\" value=\"Department Approval\">\r\n" + 
					"</form> ";
			htmlout.append(departbtn);
		}
		
		if(idflag == 2) {
			String superbtn = "<form action=\"SuperStatusServlet\" method=\"POST\">\r\n" + 
					"  <input type=\"radio\" name=\"statusC\" value=\"1\" checked>Approve<br>\r\n" + 
					"  <input type=\"radio\" name=\"statusC\" value=\"0\">Deny<br>\r\n" + 
					"  <input type=\"hidden\" name=\"rid\" value=" + temp.getrID() +">\r\n" + 
					"  <input type=\"submit\" value=\"Supervisor Approval\">\r\n" + 
					"</form> ";
			htmlout.append(superbtn);
		}
		
		if(idflag == 3) {
			String bencobtn = "<form action=\"BencoStatusServlet\" method=\"POST\">\r\n" + 
					"  <input type=\"radio\" name=\"statusC\" value=\"1\" checked>Approve<br>\r\n" + 
					"  <input type=\"radio\" name=\"statusC\" value=\"0\">Deny<br>\r\n" + 
					"  <input type=\"hidden\" name=\"rid\" value=" + temp.getrID() +">\r\n" + 
					"  <input type=\"submit\" value=\"Benco Approval\">\r\n" + 
					"</form> ";
			htmlout.append(bencobtn);
			
			String Calbtn = "<form action=\"CalculateServlet\" method=\"POST\"><input type=\"hidden\" name=\"rid\" value=\""+ temp.getrID() +"\"/><input type=\"submit\" value=\"Calculate Reimbursement\"></form>";
			htmlout.append(Calbtn);
		}
		
		htmlout.append(html2);

		out.println(htmlout);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int rid = Integer.parseInt(request.getParameter("rid"));
		
		//find the Reimbursement and store in session
		ReimbursementDao rdao = new ReimbursementDao();
		Reimbursement thisR = rdao.getReimbursement(rid);
		HttpSession session = request.getSession(false);
		session.setAttribute("thisR", thisR);
		
		response.sendRedirect("DetailsServlet");
	}

}
