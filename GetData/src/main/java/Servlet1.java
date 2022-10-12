import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
@WebServlet("/get")
public class Servlet1 extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        String url= "jdbc:mysql://localhost:3306/register";
        String username = "root";
        String password ="Root@1234";
        String query ="select * from information";
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            Connection connection = DriverManager.getConnection(url,username,password);
            Statement statement = connection.createStatement();
            ResultSet sets = statement.executeQuery(query);

            while(sets.next()){
                out.print(sets.getInt(1)+sets.getString(2));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}



