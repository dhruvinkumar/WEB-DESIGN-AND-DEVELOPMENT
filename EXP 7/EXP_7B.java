import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
protected void doPost(HttpServletRequest request,
HttpServletResponse response) throws ServletException, IOException {

response.setContentType("text/html");
PrintWriter out = response.getWriter();
// Get the user entered data
String username = request.getParameter("username");
String password = request.getParameter("password");
try {
// Load the MySQL driver
Class.forName("com.mysql.jdbc.Driver");
// Connect to the MySQL database
Connection con =

DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase",
"root", "password");

// Prepare the SQL query to retrieve the username

and password

PreparedStatement ps = con.prepareStatement("SELECT

* FROM users WHERE username=? AND password=?");
ps.setString(1, username);
ps.setString(2, password);
// Execute the SQL query
ResultSet rs = ps.executeQuery();
if (rs.next()) {
// Authentication successful
out.println("<h1>Login successful!</h1>");
} else {
// Authentication failed
out.println("<h1>Invalid username or

password!</h1>");
}
} catch (Exception e) {
out.println("<h1>Error: " + e.getMessage() +

"</h1>");
}
out.close();
}
}