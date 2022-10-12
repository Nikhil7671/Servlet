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
public class Servlet1 extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {

    res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        int id = Integer.parseInt(req.getParameter("id"));
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String gender = req.getParameter("gender");
        Long phone = Long.parseLong(req.getParameter("phone"));
        String city = req.getParameter("city");

        String url = "jdbc:mysql://localhost:3306/register";
        String username="root";
        String password ="Root@1234";
        String query="Insert into information (id,firstName,lastName,gender,phone,city) values(?,?,?,?,?,?)";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            Connection connection = DriverManager.getConnection(url,username,password);
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setInt(1,id);
            preparedStatement.setString(2,firstName);
            preparedStatement.setString(3,lastName);
            preparedStatement.setString(4,gender);
            preparedStatement.setLong(5,phone);
            preparedStatement.setString(6,city);

            int i = preparedStatement.executeUpdate();

            if(i>0){
                out.print("successfully updated");
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
