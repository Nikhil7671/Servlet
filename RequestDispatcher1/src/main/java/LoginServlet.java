import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {

    protected  void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if(username == null || username.equals("") ||password==null || password.equals("") ){

            out.print("<h2 style=color:red> Enter username and password  </h2><br>");
            RequestDispatcher rd = req.getRequestDispatcher("/login.jsp");
            rd.include(req,res);

        } else if (username.equals("Nikhil") && password.equals("1234")) {
            RequestDispatcher rd = req.getRequestDispatcher("/WelcomeServlet");
            rd.include(req,res);

        } else  {
            out.print("<h2 style =color:red> Enter valid username and password</h2><br>");
            RequestDispatcher rd = req.getRequestDispatcher("/login.jsp");
            rd.include(req,res);

        }


    }

}
