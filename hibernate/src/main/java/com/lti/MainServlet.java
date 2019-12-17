package com.lti;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lti.dao.CustomerDao;
import com.lti.entity.Customer;

public class MainServlet extends HttpServlet {

    public MainServlet() {
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("cname");
		String email=request.getParameter("cemail");
		String city=request.getParameter("city");
		
		Customer c=new Customer();
		c.setName(name);
		c.setEmail(email);
		c.setCity(city);
		
		CustomerDao cd=new CustomerDao();
		cd.store(c);
		
		response.getWriter().append("ID: "+c.getId()+"\nName: "+name+"\nEmail: "+email+"\nCity: "+city);
	}


}
