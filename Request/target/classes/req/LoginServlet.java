import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) {
		
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
		String userName = req.getParameter("username").trim();
		String password = req.getParameter("password").trim();
		
		// check for null and empty values
		
		if(userName==null || userName.equals("") || password==null || password.equals("")) {
			out.print("Enter both username and password  <br>");
			
			RequestDispatcher rd = req.getRequestDispatcher("/login.jsp");
			rd.include(req,res);
			
		}
		// check for valid username and password
		
		else if (userName.equals("jai") && password.equals("1234")) {
			RequestDispatcher rd = req.getRequestDispatcher("welcomeServlet");
			rd.include(req, res);
		}
		else {
			out.print("username and password are  invalid");
			RequestDispatcher rd = req.getRequestDispatcher("/login.jsp");
			rd.include(req, res);
		}
		
	}

}
