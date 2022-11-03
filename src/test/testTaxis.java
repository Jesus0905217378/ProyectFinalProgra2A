/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import proyectofinal_p2a.Datos.Conexion;
import proyectofinal_p2a.Dominio.Taxis;
import java.sql.SQLException;
import java.sql.*;
import proyectofinal_p2a.Datos.TaxisJDBC;

/**
 *
 * @author Jesus Alberto
 */
public class testTaxis {
    public static void main(String[] args) {
             Connection conexion = null;
        try {
            conexion = Conexion.getConnection();
            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);
            }

            TaxisJDBC taxiJdbc = new TaxisJDBC(conexion);
            
            Taxis nuevoTaxi = new Taxis();
            String placanew="C126XXX",marcanew="Toyota",modelonew="2017",colornew="Rojo",pilotonew="Andres",telnew="12345678"; 
            nuevoTaxi.setPlaca(placanew);
            nuevoTaxi.setMarca(marcanew);
            nuevoTaxi.setModelo(modelonew);
            nuevoTaxi.setColor(colornew);
            nuevoTaxi.setPiloto(pilotonew);
            nuevoTaxi.setTelefono(telnew);
            taxiJdbc.insert(nuevoTaxi);
            
            
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
      
