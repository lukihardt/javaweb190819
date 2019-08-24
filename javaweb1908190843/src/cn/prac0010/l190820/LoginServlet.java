package cn.prac0010.l190820;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String usrname = request.getParameter("username");
		String pwd = request.getParameter("password");
//		System.out.println(usrname);
//		response.getWriter().println(usrname);
		String dbusr = this.getServletContext().getInitParameter("username");
		String dbpwd = this.getServletContext().getInitParameter("password");
		
		System.out.println(usrname);
		System.out.println(pwd);
		System.out.println(dbusr);
		System.out.println(dbpwd);
		
		if( usrname.equals(dbusr) && pwd.equals(dbpwd)) {
			response.getWriter().println("login success!");
		}
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
