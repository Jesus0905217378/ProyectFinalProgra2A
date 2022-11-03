/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import proyectofinal_p2a.Datos.Conexion;
import proyectofinal_p2a.Dominio.Buses;
import java.sql.SQLException;
import java.sql.*;
import proyectofinal_p2a.Datos.BusesJDBC;
/**
 *
 * @author Jesus Alberto
 */
public class testBuses {
    public static void main(String[] args) {
             Connection conexion = null;
        try {
            conexion = Conexion.getConnection();
            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);
            }

            BusesJDBC busJdbc = new BusesJDBC(conexion);
            
            Buses nuevoBus = new Buses();
            String placanew="C358XXX",marcanew="Hyundai",modelonew="2015",colornew="Blanco",pilotonew="Joel",telnew="24321122"; 
            nuevoBus.setPlaca(placanew);
            nuevoBus.setMarca(marcanew);
            nuevoBus.setModelo(modelonew);
            nuevoBus.setColor(colornew);
            nuevoBus.setPiloto(pilotonew);
            nuevoBus.setTelefono(telnew);
            busJdbc.insert(nuevoBus);
            
            
            conexion.commit();
            System.out.println("Se ha hecho commit de la transaccion");
             } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("Entramos al rollback");
            try {
                conexion.rollback();
            }catch(SQLException ex1) {
                ex1.printStackTrace(System.out);
            }
        }
    }
}
