import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PipedReader;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/data")
public class Servlet extends HttpServlet {

    public  void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        int rollNo = Integer.parseInt(req.getParameter("rollNo"));

        String url = "jdbc:mysql://localhost:3306/school";
        String username = "root";
        String password ="Root@1234";
        String query ="select * from student where rollNo=?";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            Connection connection = DriverManager.getConnection(url,username,password);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,rollNo);
            ResultSet resultSet = preparedStatement.executeQuery();
            ResultSetMetaData data = resultSet.getMetaData();

            out.print("<table width=25% border=1>");
            out.print("<h1> Student Data </h1>");

            while (resultSet.next()) {
                out.print("<tr><th>" + data.getColumnName(1) + "</th>" + "<th>" + data.getColumnName(2)
                        + "</th>" + "<th>" + data.getColumnName(3) + "</th>" + "<th>" + data.getColumnName(4) + "</th></tr>");
                out.print("<tr><td><center>" + resultSet.getString(1) + "</td></center>" + "<td><center>" + resultSet.getString(2) + "</td></center>"
                        + "<td><center>" + resultSet.getString(3) + "</td></center>" + "<td><center>" + resultSet.getString(4) + "</td></center></tr>");

            }

            out.print("</table>");

            connection.close();

        } catch (SQLException e) {

            throw new RuntimeException(e);
        }


    }

}
