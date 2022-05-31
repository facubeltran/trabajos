package ar.org.centro8.curso.java.repositories.interfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import ar.org.centro8.curso.java.entities.Cliente;

public interface I_ClienteRepository {
    void save(Cliente cliente);
    void delete(Cliente cliente);
    List<Cliente>getAll();
    default Cliente getById(int id){
        return getAll()
                .stream()
                .filter(c->c.getId()==id)
                .findFirst()
                .orElse(new Cliente());
    }
    default Cliente getByCuit(String cuit){
        return getAll()
                .stream()
                .filter(c-> c.getCuit()!=null
                            && c.getCuit().equals(cuit))
                .findFirst()
                .orElse(new Cliente());
    }
    default List<Cliente>getLikeApellido(String apellido){
        if(apellido==null) return new ArrayList();
        return getAll()
                .stream()
                .filter(c-> c.getApellido()!=null 
                            && c
                                .getApellido()
                                .toLowerCase()
                                .contains(apellido.toLowerCase()))
                .collect(Collectors.toList());
    }
    default List<Cliente>getLikeCuit(String cuit){
        if(cuit==null) return new ArrayList();
        return getAll()
                .stream()
                .filter(c-> c.getCuit()!=null
                            && c
                                .getCuit()
                                .contains(cuit))           
                .collect(Collectors.toList());
    }
}
