package ar.org.centro8.curso.java.test;

import ar.org.centro8.curso.java.connectors.Connector;
import ar.org.centro8.curso.java.entities.Cliente;
import ar.org.centro8.curso.java.enums.EstadoCivil;
import ar.org.centro8.curso.java.repositories.interfaces.I_ClienteRepository;
//import ar.org.centro8.curso.java.repositories.list.ClienteRepository;
//import ar.org.centro8.curso.java.repositories.list.ClienteRepositoryFactory;
import ar.org.centro8.curso.java.repositories.jdbc.ClienteRepository;

public class TestRepository {
    public static void main(String[] args) {
        //I_ClienteRepository cr=ClienteRepositoryFactory.getClienteRepository();
        I_ClienteRepository cr=new ClienteRepository(Connector.getConnection());
        
        cr.save(
            new Cliente(
                "ana", 
                "sosa", 
                EstadoCivil.CASADO, 
                "291", 
                "lima 222", 
                "0303456", 
                "anasosa@gmail.com", 
                "")
        );

        cr.save(
            new Cliente(
                "diego", 
                "soto", 
                EstadoCivil.CASADO, 
                "292", 
                "lima 122", 
                "0303457", 
                "diego@gmail.com", 
                "")
        );

        cr.save(
            new Cliente(
                "malena", 
                "segovia", 
                EstadoCivil.SOLTERO, 
                "293", 
                "lima 121", 
                "0303459", 
                "male@gmail.com", 
                "")
        );

        cr.save(
            new Cliente(
                "Jose", 
                "Joseito", 
                EstadoCivil.VIUDO, 
                "294", 
                "lavalle 122", 
                "5555555", 
                "jose@gmail.com", 
                "")
        );

        cr.delete(cr.getById(26));

        cr.getAll().forEach(System.out::println);
        System.out.println("************************************************");
        System.out.println(cr.getById(2));
        System.out.println("************************************************");
        System.out.println(cr.getByCuit("12347008"));
        System.out.println("************************************************");
        cr.getLikeApellido("so").forEach(System.out::println);
        System.out.println("************************************************");
        cr.getLikeCuit("456").forEach(System.out::println);
        
    }

    
}
