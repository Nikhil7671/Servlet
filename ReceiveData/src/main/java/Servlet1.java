import com.mysql.jdbc.Driver;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
@WebServlet("/data")
public class Servlet1 extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        int id = Integer.parseInt(req.getParameter("id"));

        String url = "jdbc:mysql://localhost:3306/register";
        String username = "root";
        String password = "Root@1234";
        String query = "Select * from information where id = ?";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url,username,password);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,id);
            ResultSet set = preparedStatement.executeQuery();
            ResultSetMetaData data = set.getMetaData();


            out.print("<table width = 25%  border=1>");
            out.print("<center> <h1> Data </h1> </center> ");

            while(set.next()){

                out.print("<tr><td>"+data.getColumnName(1)+"</td>"+"<td>"+set.getInt(1)+"</td></tr>");
                out.print("<tr><td>"+data.getColumnName(2)+"</td>"+"<td>"+set.getString(2)+"</td></tr>");
                out.print("<tr><td>"+data.getColumnName(3)+"</td>"+"<td>"+set.getString(3)+"</td></tr>");

            }
            out.print("</table>");
            connection.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
