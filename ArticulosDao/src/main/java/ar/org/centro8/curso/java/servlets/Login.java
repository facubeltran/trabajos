package ar.org.centro8.curso.java.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name="login", urlPatterns = "/login")
public class Login extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("/logout.html");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // User: root pass: 123
        String user=request.getParameter("user");
        String pass=request.getParameter("pass");
        HttpSession session=request.getSession();
        if(user.equals("root") && pass.equals("123")){
            session.setAttribute("login", true);
            session.setAttribute("name", "root");
            response.sendRedirect("/welcome.jsp");
        }else{
            session.setAttribute("login", false);
            session.setAttribute("name", null);
            response.sendRedirect("/logout.html");
        }
    }

    //Tema pendiente
    //Padron DAO
    //Api Servlet
    

    
    
}
