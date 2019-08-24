package javaweb1908190843;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetServlet
 */

public class GetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GetServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		ServletContext context = this.getServletContext();
//		String myName = (String)context.getAttribute("name");
		response.setContentType("gbk");
		PrintWriter out = response.getWriter();
//		out.print(myName + "<br>");
		out.println("this is GetServlet");
		request.setCharacterEncoding("gbk");
		out.println(request.getParameter("username"));
		out.println(request.getParameter("password"));
		
		String uri = request.getRequestURI();
		out.println(uri);
		System.out.println(uri);
		
		out.println(request.getMethod());
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
