package ar.org.centro8.curso.java.services.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import ar.org.centro8.curso.java.repositories.list.ClienteRepositoryFactory;

@WebServlet(name="likeApellido", urlPatterns = "/servicios/clientes/v1/likeApellido")
public class ClientesServiceLikeApellido extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        response
            .getWriter()
            .println(
                new Gson()
                    .toJson(
                        ClienteRepositoryFactory
                            .getClienteRepository()
                            .getLikeApellido(
                                request.getParameter("apellido")
                            )
            ));
    }
    
}
