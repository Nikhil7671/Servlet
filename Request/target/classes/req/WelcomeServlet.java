import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WelcomeServlet extends HttpServlet {
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) {
		
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
		out.print("<html><body>");
		out.print("<h2> You are logged in successfully </h2>");
		out.print("</body></html>");
		
		
		
	}
	

}
