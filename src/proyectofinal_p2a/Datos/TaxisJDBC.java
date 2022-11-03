/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectofinal_p2a.Datos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import proyectofinal_p2a.Dominio.Taxis;

/**
 *
 * @author Jesus Alberto
 */
public class TaxisJDBC {

    private Connection conexionTransaccional;


    private static final String SQL_SELECT = "SELECT id, placa, marca, modelo, color, piloto, telefono FROM tb_taxis";
    private static final String SQL_INSERT = "INSERT INTO tb_taxis(placa, marca, modelo, color, piloto, telefono) VALUES(?, ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE tb_taxis SET placa=?, marca=?, modelo=?, color=?, piloto=?, telefono=? WHERE id = ?";
    private static final String SQL_DELETE = "DELETE FROM tb_taxis WHERE id=?";

    public TaxisJDBC() {

    }

    public TaxisJDBC(Connection conexionTransaccional) {
        this.conexionTransaccional = conexionTransaccional;
    }

    public List<Taxis> select() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Taxis taxi = null;
        List<Taxis> taxis = new ArrayList<Taxis>();

        try {
            
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String placa = rs.getString("placa");
                String marca = rs.getString("marca");
                String modelo = rs.getString("modelo");
                String color = rs.getString("color");
                String piloto = rs.getString("piloto");
                String telefono = rs.getString("telefono");

                taxi = new Taxis();
                taxi.setId(id);
                taxi.setPlaca(placa);
                taxi.setMarca(marca);
                taxi.setModelo(modelo);
                taxi.setColor(color);
                taxi.setPiloto(piloto);
                taxi.setTelefono(telefono);
                
                taxis.add(taxi);

            }
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            if (this.conexionTransaccional == null) {
                Conexion.close(conn);
            }

        }

        return taxis;
    }

    public int insert(Taxis taxi) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, taxi.getPlaca());
            stmt.setString(2, taxi.getMarca());
            stmt.setString(3, taxi.getModelo());
            stmt.setString(4, taxi.getColor());
            stmt.setString(5, taxi.getPiloto());
            stmt.setString(6, taxi.getTelefono());

            System.out.println("ejecutando query:" + SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados:" + rows);
        } finally {
            Conexion.close(stmt);
            if (this.conexionTransaccional == null) {
                Conexion.close(conn);
            }
        }

        return rows;
    }

    public int update(Taxis taxi) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            
            stmt.setString(1, taxi.getPlaca());
            stmt.setString(2, taxi.getMarca());
            stmt.setString(3, taxi.getModelo());
            stmt.setString(4, taxi.getColor());
            stmt.setString(5, taxi.getPiloto());
            stmt.setString(6, taxi.getTelefono());

            rows = stmt.executeUpdate();
            System.out.println("Registros actualizado:" + rows);

        } finally {
            Conexion.close(stmt);
            if (this.conexionTransaccional == null) {
                Conexion.close(conn);
            }
        }

        return rows;
    }

    public int delete(Taxis taxi) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, taxi.getId());
            rows = stmt.executeUpdate();
            System.out.println("Registros eliminados:" + rows);
        } finally {
            Conexion.close(stmt);
            if (this.conexionTransaccional == null) {
                Conexion.close(conn);
            }
        }

        return rows;
    }

}
