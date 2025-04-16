import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class EmployeeServlet extends HttpServlet {
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    String empId = request.getParameter("empId");
    try {
      Class.forName("com.mysql.jdbc.Driver");
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/yourdb", "root", "password");
      Statement stmt = con.createStatement();
      ResultSet rs;
      if (empId != null && !empId.isEmpty()) {
        rs = stmt.executeQuery("SELECT * FROM employees WHERE id=" + empId);
      } else {
        rs = stmt.executeQuery("SELECT * FROM employees");
      }
      out.println("<table border='1'><tr><th>ID</th><th>Name</th><th>Position</th></tr>");
      while (rs.next()) {
        out.println("<tr><td>" + rs.getInt("id") + "</td><td>" + rs.getString("name") + "</td><td>" + rs.getString("position") + "</td></tr>");
      }
      out.println("</table>");
      con.close();
    } catch (Exception e) {
      out.println("Error: " + e.getMessage());
    }
  }
}
