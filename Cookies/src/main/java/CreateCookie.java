import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class CreateCookie extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

        res.setContentType("html/text");
        PrintWriter out = res.getWriter();

        String username = req.getParameter("username").trim();
        String password = req.getParameter("password").trim();

        if(username==null || password==null || username.equals("") || password.equals("")){

            out.print("Enter both username and password");
            RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
            rd.include(req,res);

        }
        if(username.equals("jai") && password.equals("1234")){
            out.print("You are logged in successfully");

            Cookie cookie1 = new Cookie("username", username);
            Cookie cookie2 = new Cookie("password", password);

            res.addCookie(cookie1);
            res.addCookie(cookie2);

            out.print("<h2> Cookies are created click on Accept cookies to accept cookies</h2>");
            out.print("<form action='GetCookies' method='post'>");
            out.print("<input type='submit' value='AcceptCookies'>");
            out.print("</form");
            out.close();

        }
        else{
            out.print("<h2>Enter valid username and password</h2>");
            RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
            rd.include(req,res);
        }

    }

}
