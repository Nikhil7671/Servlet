import com.mysql.cj.exceptions.DataReadException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
@WebServlet("/insert")
public class Servlet extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {

        res.setContentType("html/text");
        PrintWriter out = res.getWriter();

        int id = Integer.parseInt(req.getParameter("id"));
        String empName = req.getParameter("empName");
        String depart = req.getParameter("depart");
        String city = req.getParameter("city");

        String url = "jdbc:mysql://localhost:3306/school";
        String username ="root";
        String password="Root@1234";
        String query = "Insert into employee(id, empName, depart, city) values(?,?,?,?)";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            Connection connection = DriverManager.getConnection(url,username,password);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,id);
            preparedStatement.setString(2,empName);
            preparedStatement.setString(3,depart);
            preparedStatement.setString(4,city);
            int i = preparedStatement.executeUpdate();
            if(i>0){
                out.print("successfully Updated");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
