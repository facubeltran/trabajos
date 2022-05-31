package ar.org.centro8.curso.java.repositories.list;

import java.util.ArrayList;
import java.util.List;

import ar.org.centro8.curso.java.entities.Cliente;
import ar.org.centro8.curso.java.repositories.interfaces.I_ClienteRepository;

public class ClienteRepository implements I_ClienteRepository{

    private List<Cliente>list=new ArrayList();

    @Override
    public void delete(Cliente cliente) {
        list.remove(cliente);
    }

    @Override
    public List<Cliente> getAll() {
        return list;
    }

    @Override
    public void save(Cliente cliente) {
        list.add(cliente);
    }
    
}
