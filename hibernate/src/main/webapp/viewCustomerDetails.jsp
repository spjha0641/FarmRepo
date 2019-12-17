<%@page import="com.lti.entity.Customer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View and update</title>
</head>
<body>
<%
	Customer c=(Customer) session.getAttribute("customer");
%>
<br/>
<form action="UpdateServlet" method="get">
<label>ID: </label>
<input type="text" name="cid" value="<%= c.getId() %>" readonly /></br>
<label>Name: </label>
<input type="text" name="cname" value="<%= c.getName() %>" />
 <br />
 <label>Email: </label>
 <input type="text" name="cemail" value="<%= c.getEmail() %>" />
 <br />
 <label>City: </label>
<input type="text" name="city" value="<%= c.getCity() %>" />
 <br>
 <button type="submit">Update</button>
</form>
</body>
</html>