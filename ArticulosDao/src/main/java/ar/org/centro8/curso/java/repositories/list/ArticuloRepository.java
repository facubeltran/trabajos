package ar.org.centro8.curso.java.repositories.list;

import java.util.ArrayList;
import java.util.List;

import ar.org.centro8.curso.java.entities.Articulo;
import ar.org.centro8.curso.java.repositories.interfaces.I_ArticuloRepository;

public class ArticuloRepository implements I_ArticuloRepository{

    private List<Articulo>list=new ArrayList<>();

    @Override
    public void delete(Articulo articulo) {
        list.remove(articulo);
    }

    @Override
    public List<Articulo> getAll() {
        return list;
    }

    @Override
    public void save(Articulo articulo) {
        list.add(articulo);
    }
    
}
