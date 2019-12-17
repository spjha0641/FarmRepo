package com.person;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lti.dao.PersonDao;
import com.lti.entity.Passport;
import com.lti.entity.Person;

class PersonPassport extends HttpServlet {
	
    public PersonPassport() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		  PersonDao dao=new PersonDao();
		  Person p=new Person();
		  
		  String name=request.getParameter("name");
		  int age= Integer.parseInt(request.getParameter("age"));
		  String passport =request.getParameter("passport");
		  LocalDate issuedate=LocalDate.parse(request.getParameter("issuedate"));
		  LocalDate expirydate=LocalDate.parse(request.getParameter("expirydate"));
		  String issueplace=request.getParameter("issueplace");
		  
		  Passport pass=new Passport();
		  p.setPersonName(name);
		  p.setPersonAge(age);
		  pass.setPassportNo(passport);
		  pass.setIssueDate(issuedate);
		  pass.setExpiryDate(expirydate);
		  pass.setPlaceOfIssue(issueplace);
		  
		  dao.addPerson(p);
		  int personId=p.getPersonId();
		dao.addPassportWithPerson(pass, personId);
		
		
		
		//	response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	

}
