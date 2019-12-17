package com.lti;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lti.dao.CustomerDao;
import com.lti.entity.Customer;

public class FetchAll extends HttpServlet {
	
    public FetchAll() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();

		CustomerDao dao=new CustomerDao();
		List<Customer> list = dao.fetchAll();
		
		out.println("<html><body><table border=1>");
		out.println("<tr><th>Id</th><th>Name</th><th>Email</th><th>City</th>");
		for(Customer c: list) { 
			  out.println("<tr><td>"+c.getId()+"</td>"); 
			  out.println("<td>"+c.getName()+"</td>"); 
			  out.println("<td>"+c.getEmail()+"</td>");
			  out.println("<td>"+c.getCity()+"</td></tr>"); 
		  }		 
		out.println("</table></body></html>");
	}

}
