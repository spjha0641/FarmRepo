package com.emp;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lti.dao.CustomerDao;
import com.lti.dao.EmployeeDao;
import com.lti.entity.Customer;
import com.lti.entity.Employee;

public class InsertEmpServlet extends HttpServlet {
	
    public InsertEmpServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name=request.getParameter("ename");
		double salary=Double.parseDouble(request.getParameter("esal"));
		LocalDate doj=LocalDate.parse(request.getParameter("edoj"));
	
		Employee emp=new Employee();
		emp.setName(name);
	
		
		EmployeeDao ed=new EmployeeDao();
		ed.addEmployee(emp);
		
		
		response.getWriter().append("Name: "+name+"\nSalary: "+salary+"\nDate of Joining: "+doj);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}



}
