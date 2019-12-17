package com.lti;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lti.dao.CustomerDao;
import com.lti.entity.Customer;


public class DeleteServlet extends HttpServlet {

    public DeleteServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		String id=request.getParameter("cid");
		int cid=Integer.parseInt(id);
		
		CustomerDao dao=new CustomerDao();
		Customer c=dao.fetch(cid);
		dao.delete(c);
		
		out.println("Details are deleted...");
	
		
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}


}
