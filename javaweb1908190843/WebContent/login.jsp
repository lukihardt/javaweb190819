<%@page import="sopo.cn.service.UserService"%>
<%@page import="sopo.cn.model.User"%>
<%@page import="sopo.cn.utils.CookieUtils"%>

<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>login.jsp</title>
</head>
<body>
	<%
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String expireddays = request.getParameter("expireddays");
		Cookie[] cookies = request.getCookies();
		/* out.println(username);
		out.println(password); */

		boolean login = false;
		String account = null;
		String ssid = null;

		if (cookies != null && cookies.length > 0) {
			for (Cookie c : cookies) {
				if (c.getName().equals("userKey")) {
					account = c.getValue();
					System.out.println("account:" + account);
				}

				if (c.getName().equals("ssid")) {
					ssid = c.getValue();
					System.out.println("ssid:" + ssid);
				}
			}
		}

		if (account != null && ssid != null) {
			//this place is transfer variable;
			String ussid = CookieUtils.md5EncryptSelf(username);
			System.out.println("ussid:" + ussid);
			login = ssid.equals(ussid);
			System.out.println(login);
		}

		if (!login) {
			UserService userService = new UserService();
			User user = userService.login(username, password);

			if (user != null) {
				expireddays = expireddays == null ? "" : expireddays;
				switch (expireddays) {
				case "7":
					CookieUtils.createCookie(request, response, username, 7 * 24 * 60 * 60);
					break;
				case "30":
					CookieUtils.createCookie(request, response, username, 30 * 24 * 60 * 60);
					break;
				case "99":
					CookieUtils.createCookie(request, response, username, Integer.MAX_VALUE);
					break;
				default:
					CookieUtils.createCookie(request, response, username, -1);
					break;
				}
				request.getRequestDispatcher("main.jsp").forward(request, response);
			} else {
				System.out.println("username or password is wrong!");
				request.getRequestDispatcher("checkederror.jsp").forward(request, response);
			}
		} else {
			request.getRequestDispatcher("main.jsp").forward(request, response);
		}
	%>
</body>
</html>