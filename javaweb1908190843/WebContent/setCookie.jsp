<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>setCookie.jsp</title>
</head>
<body>
	<%
		Cookie[] cookies = request.getCookies();
		if (cookies != null && cookies.length > 0) {
			for (Cookie c : cookies) {
				System.out.println("cookies's name: " + c.getName() + ", cookie's value: " + c.getValue() + "<br/>");
				response.getWriter().println("cookies's name: " + c.getName() + ", cookie's value: " + c.getValue() + "<br/>");
			}
		} else{
			Cookie cookie = new Cookie("init", "lsy");
			cookie.setMaxAge(-18);
			response.addCookie(cookie);
		}
	%>
</body>
</html>