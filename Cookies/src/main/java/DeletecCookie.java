import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class DeletecCookie extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        try {
            Cookie[] cookie = req.getCookies();
            out.print("deleted cookies are");
            for (Cookie cookie1:cookie){
                cookie1.setMaxAge(0);
                out.print("cookie:"+ cookie1.getName());
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }

    }
}
