import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class AttendanceServlet extends HttpServlet {
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    String studentId = request.getParameter("studentId");
    String date = request.getParameter("date");
    String status = request.getParameter("status");
    try {
      Class.forName("com.mysql.jdbc.Driver");
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/yourdb", "root", "password");
      PreparedStatement ps = con.prepareStatement("INSERT INTO attendance(student_id, date, status) VALUES (?, ?, ?)");
      ps.setString(1, studentId);
      ps.setString(2, date);
      ps.setString(3, status);
      ps.executeUpdate();
      out.println("<h2>Attendance recorded successfully.</h2>");
      con.close();
    } catch (Exception e) {
      out.println("Error: " + e.getMessage());
    }
  }
}
