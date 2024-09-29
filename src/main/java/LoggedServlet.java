
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.annotation.*;

@WebServlet(name = "LoggedServlet", value = "/greetings")
public class LoggedServlet extends HttpServlet {
    HttpSession session;
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        session=request.getSession();
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        String username=request.getParameter("name");
        out.print("<h1>Hello "+username+"</h1>");
        out.print("<p> Date:"+java.time.LocalDate.now()+"<p>");
        out.print("<p> Time:"+java.time.LocalTime.now()+"<p>");
        RequestDispatcher rd=request.getRequestDispatcher("logout.html");
        rd.include(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        session.invalidate();
        response.sendRedirect("login.html");
    }
}
