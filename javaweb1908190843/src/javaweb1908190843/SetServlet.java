package javaweb1908190843;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SetServlet
 */
//@WebServlet("/SetServlet.do")
public class SetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SetServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ServletContext context = this.getServletContext();
		// context.setAttribute("name", "GreenStyle");

//		String sUsrname = (String) request.getParameter("username");
//		response.getWriter().println(sUsrname);
		
		request.setCharacterEncoding("gbk");
		response.setCharacterEncoding("gbk");
//		String username = request.getParameter("username");
//		String password = request.getParameter("password");
//		response.sendRedirect("/javaweb1908190843/GetServlet?username=" + username + "&password=" + password);

		RequestDispatcher rd = request.getRequestDispatcher("/GetServlet");
		rd.forward(request, response);

		response.getWriter().println("this is SetServlet");
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
