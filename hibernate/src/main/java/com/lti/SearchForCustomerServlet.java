package com.lti;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lti.dao.CustomerDao;
import com.lti.entity.Customer;


public class SearchForCustomerServlet extends HttpServlet {
	
    public SearchForCustomerServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("cid");
		int cid=Integer.parseInt(id);
		CustomerDao dao=new CustomerDao();
		Customer c= dao.fetch(cid);
		
		HttpSession session = request.getSession();
		session.setAttribute("customer", c);
		
		response.sendRedirect("viewCustomerDetails.jsp");
	}

}
