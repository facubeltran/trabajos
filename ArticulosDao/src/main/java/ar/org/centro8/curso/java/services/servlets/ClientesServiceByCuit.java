package ar.org.centro8.curso.java.services.servlets;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import ar.org.centro8.curso.java.connectors.Connector;
import ar.org.centro8.curso.java.repositories.jdbc.ClienteRepository;
import ar.org.centro8.curso.java.repositories.list.ClienteRepositoryFactory;

@WebServlet(name="byCuit", urlPatterns = "/servicios/clientes/v1/byCuit")
public class ClientesServiceByCuit extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws SecurityException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        response
            .getWriter()
            .println(
                new Gson()
                    .toJson(
                        new ClienteRepository(Connector.getConnection())
                            .getByCuit(
                                request.getParameter("cuit")
                            )
            ));
    }
}
