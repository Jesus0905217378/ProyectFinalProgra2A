/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectofinal_p2a.Datos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import proyectofinal_p2a.Dominio.Buses;
//import proyectofinal_p2a.Dominio.Taxis;
/**
 *
 * @author Jesus Alberto
 */
public class BusesJDBC {
    private Connection conexionTransaccional;


    private static final String SQL_SELECT = "SELECT id, placa, marca, modelo, color, piloto, telefono FROM tb_buses";
    private static final String SQL_INSERT = "INSERT INTO tb_buses(placa, marca, modelo, color, piloto, telefono) VALUES(?, ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE tb_buses SET placa=?, marca=?, modelo=?, color=?, piloto=?, telefono=? WHERE id = ?";
    private static final String SQL_DELETE = "DELETE FROM tb_buses WHERE id=?";

    public BusesJDBC() {

    }

    public BusesJDBC(Connection conexionTransaccional) {
        this.conexionTransaccional = conexionTransaccional;
    }

    public List<Buses> select() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Buses bus = null;
        List<Buses> buses = new ArrayList<Buses>();

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

                bus = new Buses();
                bus.setId(id);
                bus.setPlaca(placa);
                bus.setMarca(marca);
                bus.setModelo(modelo);
                bus.setColor(color);
                bus.setPiloto(piloto);
                bus.setTelefono(telefono);
                
                buses.add(bus);

            }
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            if (this.conexionTransaccional == null) {
                Conexion.close(conn);
            }

        }

        return buses;
    }

    public int insert(Buses bus) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, bus.getPlaca());
            stmt.setString(2, bus.getMarca());
            stmt.setString(3, bus.getModelo());
            stmt.setString(4, bus.getColor());
            stmt.setString(5, bus.getPiloto());
            stmt.setString(6, bus.getTelefono());

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

    public int update(Buses bus) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            
            stmt.setString(1, bus.getPlaca());
            stmt.setString(2, bus.getMarca());
            stmt.setString(3, bus.getModelo());
            stmt.setString(4, bus.getColor());
            stmt.setString(5, bus.getPiloto());
            stmt.setString(6, bus.getTelefono());

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

    public int delete(Buses bus) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, bus.getId());
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
