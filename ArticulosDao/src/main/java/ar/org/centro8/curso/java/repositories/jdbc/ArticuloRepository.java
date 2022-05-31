package ar.org.centro8.curso.java.repositories.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import ar.org.centro8.curso.java.entities.Articulo;
import ar.org.centro8.curso.java.enums.Rubro;
import ar.org.centro8.curso.java.repositories.interfaces.I_ArticuloRepository;

public class ArticuloRepository implements I_ArticuloRepository {
    private Connection conn;

    

    public ArticuloRepository(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void save(Articulo articulo) {
        if(articulo==null) return;
        try (PreparedStatement ps=conn.prepareStatement(
            "insert into articulos "+
                "(descripcion,rubro,costo,precio,stock,stock_minimo,stock_maximo)"+
                "values (?,?,?,?,?,?,?)",
                PreparedStatement.RETURN_GENERATED_KEYS
        )){
            ps.setString(1, articulo.getDescripcion());
            ps.setString(2, articulo.getRubro().toString());
            ps.setDouble(3, articulo.getCosto());
            ps.setDouble(4, articulo.getPrecio());
            ps.setInt(5, articulo.getStock());
            ps.setInt(6, articulo.getStock_minimo());
            ps.setInt(7, articulo.getStock_maximo());
            ps.execute();
            ResultSet rs =ps.getGeneratedKeys();
            if(rs.next()) articulo.setId(rs.getInt(1));
        } catch (Exception e) {
             System.out.println(e);
        }
    }

    @Override
    public void delete(Articulo articulo) {
        if(articulo==null) return;
        try (PreparedStatement ps= conn.prepareStatement("delete from articulos where id=?")){
            ps.setInt(1, articulo.getId());
            ps.execute();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public List<Articulo> getAll() {
        List<Articulo> list =new ArrayList<>();
        try (ResultSet rs=conn.createStatement().executeQuery("select * from articulos")){
            while(rs.next()){
                list.add(new Articulo(
                    rs.getInt("id"),
                    rs.getString("descripcion"),
                    Rubro.valueOf(rs.getString("rubro")),
                    rs.getDouble("costo"),
                    rs.getDouble("precio"),
                    rs.getInt("stock"),
                    rs.getInt("stock_minimo"),
                    rs.getInt("stock_maximo")
                ));
            }
        } catch (Exception e) {
            System.out.println(e);
}

        return list;
    }
    
}
