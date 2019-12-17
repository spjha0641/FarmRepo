package com.emp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lti.dao.EmployeeDao;
import com.lti.entity.Employee;


public class FetchAllEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public FetchAllEmployee() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();

		EmployeeDao dao=new EmployeeDao();
		List<Employee> list = dao.fetchAll();
		
		out.println("<html><body><table border=1>");
		out.println("<tr><th>Id</th><th>Name</th><th>Salary</th><th>DOJ</th>");
		for(Employee e: list) { 
			out.println("<td>"+e.getEmpno()+"</td></tr>");  
			out.println("<tr><td>"+e.getName()+"</td>"); 
			  out.println("<td>"+e.getSalary()+"</td>"); 
			  out.println("<td>"+e.getDateOfJoining()+"</td>");
			   
		  }		 
		out.println("</table></body></html>");
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}


}
