import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class GetCookies extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {

        res.setContentType("html/text");
        PrintWriter out = res.getWriter();

        try {
            Cookie cookie[] = req.getCookies();
            for(Cookie cookie1:cookie){
                out.print("cookie name : "+ cookie1.getName());
                out.print("cookie value: "+ cookie1.getValue());
            }
            out.print("click on below button to delete cookies");
            out.print("<form action='DeleteCookie' method='post'>");
            out.print("input type='submit' value='DeleteCookies'>  ");
            out.print("</form>");
            out.close();
        }
        catch (Exception e){
           e.printStackTrace();
        }


    }
}
