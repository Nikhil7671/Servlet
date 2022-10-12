import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/getData")
public class Servlet1 extends HttpServlet {
// here we are finding data of the particular person using their id
    public  void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        int id = Integer.parseInt(req.getParameter("id"));
        String url = "jdbc:mysql://localhost:3306/register";
        String username = "root";
        String password = "Root@1234";
        String query = "select * from information where id= ?";



        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        Connection connection;

        try {
            connection = DriverManager.getConnection(url, username, password);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            ResultSetMetaData resultSetMetaData = rs.getMetaData();
            out.print("<table width = 25% border=1>");
            out.print("<center><h1>Result</h1></center>");

            while (rs.next()) {


                out.print("<tr>"+"<td>"+resultSetMetaData.getColumnName(1)+"</td>"+"<td>"+rs.getString(1)+"</td></tr>");
                out.print("<tr>"+"<td>"+resultSetMetaData.getColumnName(2)+"</td>"+"<td>"+rs.getString(2)+"</td></tr>");
                out.print("<tr>"+"<td>"+resultSetMetaData.getColumnName(3)+"</td>"+"<td>"+rs.getString(3)+"</td></tr>");
                out.print("<tr>"+"<td>"+resultSetMetaData.getColumnName(4)+"</td>"+"<td>"+rs.getString(4)+"</td></tr>");
                out.print("<tr>"+"<td>"+resultSetMetaData.getColumnName(5)+"</td>"+"<td>"+rs.getString(5)+"</td></tr>");
                out.print("<tr>"+"<td>"+resultSetMetaData.getColumnName(6)+"</td>"+"<td>"+rs.getString(6)+"</td></tr>");

            }
            
            out.print("</table>");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        try {
            connection.close();

        }
        catch (SQLException e) {

            throw new RuntimeException(e);
        }
    }
}