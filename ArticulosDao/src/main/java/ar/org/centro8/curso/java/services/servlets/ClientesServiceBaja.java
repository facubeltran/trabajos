package ar.org.centro8.curso.java.services.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.tagext.TryCatchFinally;

import ar.org.centro8.curso.java.connectors.Connector;
import ar.org.centro8.curso.java.repositories.interfaces.I_ClienteRepository;
import ar.org.centro8.curso.java.repositories.jdbc.ClienteRepository;
import ar.org.centro8.curso.java.repositories.list.ClienteRepositoryFactory;

@WebServlet(name="baja", urlPatterns = "/servicios/clientes/v1/baja")
public class ClientesServiceBaja extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().println("false");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out=response.getWriter();
        try {
            I_ClienteRepository cr= new ClienteRepository(Connector.getConnection());
            cr.delete(cr.getById(Integer.parseInt(request.getParameter("id"))));
            out.println("true");
        } catch (Exception e) {
            out.println("false");
        }
    }
    
}
