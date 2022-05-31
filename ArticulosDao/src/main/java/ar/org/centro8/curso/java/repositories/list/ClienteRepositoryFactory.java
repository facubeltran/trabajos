package ar.org.centro8.curso.java.repositories.list;

public class ClienteRepositoryFactory {
    private static ClienteRepository cr=new ClienteRepository();
    public static ClienteRepository getClienteRepository(){
        return cr;
    }
}
