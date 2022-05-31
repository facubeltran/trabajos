package ar.org.centro8.curso.java.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.time.LocalTime;

import ar.org.centro8.curso.java.connectors.Connector;

public class TestConnection {
    public static void main(String[] args) {

        try{
            System.out.println(LocalTime.now());
            Connection con=Connector.getConnection();
            System.out.println(LocalTime.now());
            ResultSet rs=con.createStatement().executeQuery("select version()");
            if(rs.next()) System.out.println(rs.getString(1));
            System.out.println(LocalTime.now());
        }catch(Exception e){
            System.out.println("No se pudo conectar!");
            System.out.println(e);
        }
    }
}
