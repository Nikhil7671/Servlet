import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class InitParam extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {

        res.setContentType("html/text");
        PrintWriter out = res.getWriter();

        ServletConfig config = getServletConfig();

        String user = config.getInitParameter("user");
        out.print("<h1> Application User : "+ user+"</h1>");
        out.close();

    }

}
