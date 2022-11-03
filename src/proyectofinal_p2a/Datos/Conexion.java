/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectofinal_p2a.Datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Jesus Alberto
 */
public class Conexion {
    private Connection connection;
    private static final String JDBC_URL = "jdbc:sqlite:C:\\Users\\Jesus Alberto\\AppData\\Roaming\\DBeaverData\\workspace6\\.metadata\\sample-database-sqlite-1\\Chinook.db";
    private static final String JDBC_USER = "";
    private static final String JDBC_PASS = "";
    private static final String DRIVER = "org.sqlite.JDBC";
    
    public static void ConexionSQLite() throws SQLException{    
    try{
    Class.forName (DRIVER);
    }catch(Exception e){
      System.err.println("Ocurrio un error en la conexion"+ e.getMessage());
      
    }
    }
    public static Connection getConnection() throws SQLException {
        ConexionSQLite();
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS);
    }
    
    public static void close(ResultSet rs){
        try {
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
    
    public static void close(PreparedStatement stmt){
        try {
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
    
    public static void close(Connection conn){
        try {
            conn.close();
        } catch (SQLException ex) {
           ex.printStackTrace(System.out);
        }
    }
//    Connection c = null;
//    try {
//      Class.forName ("org.sqlite.JDBC");
//      c = (Connection) DriverManager.getConnection ( "jdbc:sqlite:C:\\Users\\Jesus Alberto\\AppData\\Roaming\\DBeaverData\\workspace6\\.metadata\\sample-database-sqlite-1\\Chinook.db");
//      //c = close ();
//    } catch (SQLException e) {
//      System.err.println ("Error al conectar a la base de datos"+ e.getMessage ());
//      System.exit (0);
//    }
//    System.out.println ( "Abierto base de datos correctamente");   
}
