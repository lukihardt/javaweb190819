package javaweb1908190843;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletTest
 */
@WebServlet("/ServletTest")
public class ServletTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public ServletTest() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("UTF-8");
		PrintWriter out = response.getWriter();
		
		ServletContext context = this.getServletContext();
		String usrname = context.getInitParameter("username");
		String pwd = context.getInitParameter("password");
		out.print(usrname + "@" + pwd);
		out.println("");
		System.out.println(usrname + "@" + pwd);
		
		ServletConfig sconfig = this.getServletConfig();
		String sName = sconfig.getServletName();
		out.println(sName);
		System.out.println(sName);
		
		//ServletConfig sconfig1 = getServletConfig();
    	//String initName = this.getInitParameter("stInit");
//		ServletConfig sc = getServletConfig();
//		String initName = sc.getInitParameter("stInit");
//		out.println(initName);
//		System.out.println(initName);
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		out.println("");
		
		out.println("----------------------------------------------------");
		out.println("request:"+request.getAttribute("usrname"));
		out.println("session:"+request.getSession().getAttribute("usrname"));
		out.println("application:"+request.getServletContext().getAttribute("usrname"));
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
