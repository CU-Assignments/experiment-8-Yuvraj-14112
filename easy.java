import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class LoginServlet extends HttpServlet {
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    String user = request.getParameter("username");
    String pass = request.getParameter("password");
    if ("admin".equals(user) && "admin123".equals(pass)) {
      out.println("<h1>Welcome, " + user + "!</h1>");
    } else {
      out.println("<h1>Login Failed</h1>");
    }
  }
}
