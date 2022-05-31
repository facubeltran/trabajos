package ar.org.centro8.curso.java.services.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import ar.org.centro8.curso.java.connectors.Connector;
import ar.org.centro8.curso.java.repositories.interfaces.I_ClienteRepository;
import ar.org.centro8.curso.java.repositories.jdbc.ClienteRepository;
import ar.org.centro8.curso.java.repositories.list.ClienteRepositoryFactory;

@WebServlet(name="all", urlPatterns = "/servicios/clientes/v1/all")
public class ClientesServiceAll extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        
        //I_ClienteRepository cr= ClienteRepositoryFactory.getClienteRepository();
        //PrintWriter out=response.getWriter();
        //Gson gson=new Gson();
        //String textoGson=gson.toJson(cr.getAll());
        //out.println(textoGson);

        response
            .getWriter()
            .println(
                new Gson()
                    .toJson(
                        new ClienteRepository(Connector.getConnection())
                            .getAll()
            ));

    }
    
}
