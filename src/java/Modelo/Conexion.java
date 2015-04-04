package Modelo;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Statement;

public class Conexion {
    
     
    private static String SERVER="jdbc:oracle:thin:@localhost:1521:XE";
    private static String USER="SAH";
    private static String PASS="123456";
    
    public static Connection getConexion(){
        Connection con =null;
        try {
            Driver driver=(Driver)Class.forName("oracle.jdbc.OracleDriver").newInstance();
            DriverManager.registerDriver(driver);
            con=DriverManager.getConnection(SERVER,USER,PASS);
        } catch (Exception e) {
            System.err.println("No hay conexion");
        }
          return con;
    }     
    
}
