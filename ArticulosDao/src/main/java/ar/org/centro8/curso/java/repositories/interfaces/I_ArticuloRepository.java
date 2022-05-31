package ar.org.centro8.curso.java.repositories.interfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import ar.org.centro8.curso.java.entities.Articulo;

public interface I_ArticuloRepository {
    void save(Articulo articulo);
    void delete(Articulo articulo);
    List<Articulo> getAll();

    default Articulo getById(int id){
        return getAll()
        .stream()
        .filter(a->a.getId()==id).findFirst()
        .orElse(new Articulo());
    }

    default List<Articulo> getByRubro(String rubro){
        return getAll()
        .stream()
        .filter(a->a.getRubro()!=null 
            && a.getRubro().toString().toLowerCase().equals(rubro.toLowerCase()))
        .collect(Collectors.toList());
    }
    
    default List<Articulo> getLikeDescripcion(String descripcion){
        if(descripcion==null) return new ArrayList();
        return getAll().stream().filter(a->a.getDescripcion()!=null && a.getDescripcion().toLowerCase().contains(descripcion.toLowerCase())).collect(Collectors.toList());
    }

}
