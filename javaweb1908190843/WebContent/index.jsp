<%@ page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page errorPage="error.jsp" isErrorPage="false"%>
<%-- <%@ include file="included.jsp"%> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>index.jsp</title>
</head>
<body>
	<!-- this page has redirect to main.jsp to test session redirect -->
	<br> index.jsp
	<br>
	<%=config.getInitParameter("initParam")%><br>
	<hr>
	<%
		pageContext.setAttribute("usrname", "lsy");
		request.setAttribute("usrname", "wzy");
		session.setAttribute("usrname", "zxh");
		application.setAttribute("usrname", "lhj");

		out.println("pageContext:" + pageContext.getAttribute("usrname"));
		out.println("request:" + request.getAttribute("usrname"));
		out.println("session:" + session.getAttribute("usrname"));
		out.println("application:" + application.getAttribute("usrname"));
	%>
	<br>
	<a href="jsp2.jsp">jsp2.jsp</a>
	<br>
	<jsp:include page="included.jsp" >
		<jsp:param name="jspParam" value="yeah~"/>
	</jsp:include>
	<hr>
	<table>
		<tr>
			<td>
				<a href="<%=response.encodeURL("main.jsp?test1=1&test2=2")%>">encode URL test</a>
			</td>
		</tr>
	</table>
	redirect encode URL:<br>
	<%
		response.sendRedirect(response.encodeRedirectURL("main.jsp"));
	%>
</body>
</html>