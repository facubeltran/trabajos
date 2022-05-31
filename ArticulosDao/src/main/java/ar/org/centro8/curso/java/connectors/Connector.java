package ar.org.centro8.curso.java.connectors;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connector {
    private static String driver="org.mariadb.jdbc.Driver";
    
    //Localhost
    private static String url="jdbc:mariadb://localhost:3306/negocio";
    private static String user="root";
    private static String pass="";
    
    //db4free
    //private static String url="jdbc:mariadb://db4free.net:3306/negocio_2022";
    //private static String user="negocio_2022";
    //private static String pass="medrano162";
    
    private static Connection conn=null;

    private Connector(){}

    public synchronized static Connection getConnection(){
        try {
            Class.forName(driver);
            if(conn==null || conn.isClosed()){
                conn=DriverManager.getConnection(url, user, pass);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return conn;
    }
    
}
