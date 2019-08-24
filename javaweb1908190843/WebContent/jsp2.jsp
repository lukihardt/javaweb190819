<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>jsp2.jsp</title>
</head>
<body>
	<%
		out.println("pageContext:" + pageContext.getAttribute("usrname"));
		out.println("request:" + request.getAttribute("usrname"));
		out.println("session:" + session.getAttribute("usrname"));
		out.println("application:" + application.getAttribute("usrname"));
	%>
</body>
</html>