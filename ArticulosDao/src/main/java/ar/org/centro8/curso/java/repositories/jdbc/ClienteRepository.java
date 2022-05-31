package ar.org.centro8.curso.java.repositories.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import ar.org.centro8.curso.java.connectors.Connector;
import ar.org.centro8.curso.java.entities.Cliente;
import ar.org.centro8.curso.java.enums.EstadoCivil;
import ar.org.centro8.curso.java.repositories.interfaces.I_ClienteRepository;

public class ClienteRepository implements I_ClienteRepository{

    private Connection conn;

    public ClienteRepository(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void save(Cliente cliente) {
        if(cliente==null) return;
        try (PreparedStatement ps=conn.prepareStatement(
            "insert into clientes "+
                "(nombre,apellido,estado_civil,cuit,direccion,telefono,email,comentarios)"+
                " values (?,?,?,?,?,?,?,?)",
                PreparedStatement.RETURN_GENERATED_KEYS
        )){
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getApellido());
            ps.setString(3, cliente.getEstadoCivil().toString());
            ps.setString(4, cliente.getCuit());
            ps.setString(5, cliente.getDireccion());
            ps.setString(6, cliente.getTelefono());
            ps.setString(7, cliente.getEmail());
            ps.setString(8, cliente.getComentarios());
            ps.execute();
            ResultSet rs=ps.getGeneratedKeys();
            if(rs.next()) cliente.setId(rs.getInt(1));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void delete(Cliente cliente) {
        if(cliente==null) return;
        try (PreparedStatement ps=conn.prepareStatement("delete from clientes where id=?")){
            ps.setInt(1, cliente.getId());
            ps.execute();
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }

    @Override
    public List<Cliente> getAll() {
        List<Cliente>list=new ArrayList();
        try (ResultSet rs=conn.createStatement().executeQuery("select * from clientes")){
            while(rs.next()){
                list.add(
                    new Cliente(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        EstadoCivil.valueOf(rs.getString("estado_civil")),
                        rs.getString("cuit"),
                        rs.getString("direccion"),
                        rs.getString("telefono"),
                        rs.getString("email"),
                        rs.getString("comentarios")
                    )
                );
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
    
}
