/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import proyectofinal_p2a.Datos.Conexion;
import proyectofinal_p2a.Dominio.Usuario;
import java.sql.SQLException;
import java.sql.*;
import proyectofinal_p2a.Datos.UsuarioJDBC;

/**
 *
 * @author Jesus Alberto
 */
public class test {
    public static void main(String[] args) {

        Connection conexion = null;
        try {
            conexion = Conexion.getConnection();
            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);
            }

            UsuarioJDBC usuarioJdbc = new UsuarioJDBC(conexion);

            Usuario cambioUsuario = new Usuario();
            int UserId =2;
            String userCambio="Mateo",passCambio ="54321";
            cambioUsuario.setId_usuario(UserId);
            cambioUsuario.setUsername(userCambio);
            cambioUsuario.setPassword(passCambio);
            usuarioJdbc.update(cambioUsuario);

//            Usuario nuevoUsuario = new Usuario();
//            String usernew="",passnew=""; 
//            nuevoUsuario.setUsername(usernew);
//            nuevoUsuario.setPassword(passnew);
//            usuarioJdbc.insert(nuevoUsuario);
            
//            Usuario eliminarUsuario = new Usuario();
//            String userDelete="", passDelete="";
//            eliminarUsuario.setUsername(userDelete);
//            eliminarUsuario.setPassword(passDelete);
//            usuarioJdbc.delete(eliminarUsuario);

            
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
