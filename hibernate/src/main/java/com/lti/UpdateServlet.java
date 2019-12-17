package com.lti;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lti.dao.CustomerDao;
import com.lti.entity.Customer;

public class UpdateServlet extends HttpServlet {
   
    public UpdateServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String id=request.getParameter("cid");
		int cid=Integer.parseInt(id);
		String name=request.getParameter("cname");
		String email=request.getParameter("cemail");
		String city=request.getParameter("city");
		
		CustomerDao dao=new CustomerDao();
		Customer c=dao.fetch(cid);
		c.setName(name);
		c.setEmail(email);
		c.setCity(city);
		dao.update(c);
		
		out.println("New Updated Details are...");
		out.println("Name: "+c.getName());
		out.println("Email: "+c.getEmail());
		out.println("City: "+c.getCity());
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
