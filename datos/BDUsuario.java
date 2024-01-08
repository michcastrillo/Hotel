/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import objetos.objUsuario;

/**
 *
 * @author yasni
 */
public class BDUsuario {

    private Statement s = null;
    private Connection connection = null;
    BDConexion conexion = new BDConexion();
    private ResultSet rs = null;
    public void InsertarUsuario(objUsuario usuario) {
        try {
            connection = conexion.Conexion();
            s = connection.createStatement();
            int z = s.executeUpdate("INSERT INTO usuarios(cedula,nombre,genero,correo,fecha_nac,edad,contrasena) VALUES "
                    + "('" +usuario.getCedula() + "', '" + usuario.getNombre() + "', '"+usuario.getGenero()+"', '"
                    +usuario.getCorreo()+"','"+usuario.getFecha_nac()+"','"+usuario.getEdad()+"','"+usuario.getContrasena()+"')");
            if ((z == 1)) {
                JOptionPane.showMessageDialog(null, "Se agregó el registro de manera exitosa", "Mensaje",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Error al insertar los registros", "Mensaje",
                        JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de conexión", "Mensaje",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
    public ArrayList<String> vericedubd(String cedula) {
        ArrayList<String> cedulas = new ArrayList<>();
        try {
            connection = conexion.Conexion();
            s = connection.createStatement();
            rs = s.executeQuery("SELECT cedula FROM usuarios WHERE cedula = '" + cedula + "'");
            while (rs.next()) {
                cedulas.add(rs.getString("cedula"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de conexión en verficar cedulas", "Mensaje",
                    JOptionPane.ERROR_MESSAGE);
        }

        return cedulas;
    }
        public ArrayList<objUsuario> cargarDatosLogin() {
        try {
            connection = conexion.Conexion();
            s = connection.createStatement();
            rs = s.executeQuery("SELECT cedula, contrasena FROM usuarios");
            while (rs.next()) {
                objUsuario.listausuarios.add(new objUsuario(rs.getString("cedula"), rs.getString("contrasena")));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de conexión", "Mensaje",
                    JOptionPane.ERROR_MESSAGE);
        }

        return objUsuario.listausuarios;
    }

}
