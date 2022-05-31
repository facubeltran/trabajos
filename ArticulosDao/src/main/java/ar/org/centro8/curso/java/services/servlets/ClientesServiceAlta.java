package ar.org.centro8.curso.java.services.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.org.centro8.curso.java.connectors.Connector;
import ar.org.centro8.curso.java.entities.Cliente;
import ar.org.centro8.curso.java.enums.EstadoCivil;
import ar.org.centro8.curso.java.repositories.interfaces.I_ClienteRepository;
import ar.org.centro8.curso.java.repositories.jdbc.ClienteRepository;
import ar.org.centro8.curso.java.repositories.list.ClienteRepositoryFactory;

@WebServlet(name="alta", urlPatterns = "/servicios/clientes/v1/alta")
public class ClientesServiceAlta extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out=response.getWriter();
        out.println("0");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Permisos cors
        response.addHeader("Access-Control-Allow-Origin", "*"); //se puede conectar todo el mundo!
        //response.addHeader("Access-Control-Allow-Origin", "192.168.0.1");
        response.addHeader("Access-Control-Max-Age", "1728000");
        PrintWriter out=response.getWriter();
        try {
            String nombre=request.getParameter("nombre");
            String apellido=request.getParameter("apellido");
            EstadoCivil estadoCivil= EstadoCivil.valueOf(request.getParameter("estadoCivil"));
            String cuit=request.getParameter("cuit");
            String direccion=request.getParameter("direccion");
            String telefono=request.getParameter("telefono");
            String email=request.getParameter("email");
            String comentarios=request.getParameter("comentarios");

            I_ClienteRepository cr= new ClienteRepository(Connector.getConnection());

            Cliente cliente=new Cliente(
                                        nombre, 
                                        apellido, 
                                        estadoCivil, 
                                        cuit, 
                                        direccion, 
                                        telefono, 
                                        email, 
                                        comentarios);
            cr.save(cliente);
            out.println(cliente.getId());
        } catch (Exception e) {
            out.println("0");
            System.out.println("**************************************");
            System.out.println(e);
            System.out.println("**************************************");
        }
    }
    
}
