
import java.io.*;
import java.sql.*;
import java.util.Objects;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
//
//@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;
    HttpSession session;
    /*public void init() {
        session = null;
    }*/

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException {
//        response.setContentType("text");

        PrintWriter out = response.getWriter();
        // out.print(session);
        String UID = request.getParameter("name");
        String password =  request.getParameter("password");
        try {
            Connection con= DriverManager.getConnection("jdbc:mysql://root:12345678@localhost:3306/db");

            PreparedStatement stmt=con.prepareStatement("SELECT PASSWORD from Auth_tab where USERNAME=?");
            stmt.setString(1,UID);
            ResultSet rs=stmt.executeQuery();

//            out.write("Hello World");
            while(rs.next()){
                if(Objects.equals(rs.getString("PASSWORD"), password)){
                    session=request.getSession();
                    RequestDispatcher rd=request.getRequestDispatcher("LoggedServlet");
                    rd.forward(request,response);
                }

                else{
                    out.println("Either username or password is invalid please try again");
                }
            }



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        // Hello
//        PrintWriter out = response.getWriter();
//        out.println("<html><body>");
//        out.println("<h1>" + message + "</h1>");
//        out.println("</body></html>");

    }

    public void destroy() {
    }
}