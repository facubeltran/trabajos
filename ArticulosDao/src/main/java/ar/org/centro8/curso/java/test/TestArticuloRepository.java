package ar.org.centro8.curso.java.test;

import ar.org.centro8.curso.java.connectors.Connector;
import ar.org.centro8.curso.java.entities.Articulo;
import ar.org.centro8.curso.java.enums.Rubro;
import ar.org.centro8.curso.java.repositories.interfaces.I_ArticuloRepository;
import ar.org.centro8.curso.java.repositories.jdbc.ArticuloRepository;

public class TestArticuloRepository{
    public static void main(String[] args) {
        I_ArticuloRepository ar=  new ArticuloRepository(Connector.getConnection());
/*
        ar.save(new Articulo(
            "Leche",
            Rubro.LACTEOS,
            17,
            27,
            9,
            15,
            27
        ));

        ar.save(new Articulo(
            "Fernet",
            Rubro.BEBIDAS,
            57,
            156,
            93,
            152,
            270
        ));
        
        ar.save(new Articulo(
            "Escoba",
            Rubro.LIMPIEZA,
            45,
            65,
            34,
            43,
            76
        ));
*/
        //ar.delete(ar.getById(17));


        //ar.getAll().forEach(System.out::println);
        
        System.out.println("***********************");
        System.out.println(ar.getById(11));
        System.out.println("***********************");
        System.out.println(ar.getByRubro("PANADERIA"));
        System.out.println("***********************");
        ar.getLikeDescripcion("Co").forEach(System.out::println);
        System.out.println("***********************");
        System.out.println("***********************");
        
        ar.getAll().forEach(System.out::println);

    }
}