import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PipedReader;
import java.io.PrintWriter;
import java.sql.*;
@WebServlet("/city")
public class Servlet1 extends HttpServlet{

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        String url = "jdbc:mysql://localhost:3306/school";
        String username = "root";
        String password ="Root@1234";
        String query ="Select * from student where rollno =?";

        int rollno = Integer.parseInt(req.getParameter("rollno"));

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            Connection connection = DriverManager.getConnection(url,username,password);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,rollno);
            ResultSet rs = preparedStatement.executeQuery();
            ResultSetMetaData data = rs.getMetaData();

            out.print("<table width=25% border=1>");
            out.print("<center><h1>Data</h1></center");

            while (rs.next()){
                out.print("<tr><td>"+data.getColumnName(1)+"</td>"+"<td>"+rs.getString(1)+"</td></tr>");
                out.print("<tr><td>"+data.getColumnName(2)+"</td>"+"<td>"+rs.getString(2)+"</td></tr>");
                out.print("<tr><td>"+data.getColumnName(3)+"</td>"+"<td>"+rs.getString(3)+"</td></tr>");
                out.print("<tr><td>"+data.getColumnName(4)+"</td>"+"<td>"+rs.getString(4)+"</td></tr>");
            }
            out.print("</table>");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

}
