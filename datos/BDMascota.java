/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import objetos.objMascota;
import objetos.objusuariomasc;

/**
 *
 * @author Michelle
 */
public class BDMascota {
    private Statement s = null;
    private Connection connection = null;
    BDConexion conexion = new BDConexion();
    private ResultSet rs = null;
    public void InsertarMascota(objMascota masc) {
        try {
            connection = conexion.Conexion();
            s = connection.createStatement();   
            int z = s.executeUpdate("INSERT INTO mascota(nombre,color,tamano,sexo,edad) VALUES "
                    + "('" + masc.getNombre() + "','" + masc.getColor() + "','" + masc.getTamano() + "','"
                    + masc.getSexo()+ "','"+masc.getEdad()+"')");
            if ((z == 1)) {
                JOptionPane.showMessageDialog(null, "Se agregó el registro de manera exitosa", "Mensaje",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Error al insertar mascota", "Mensaje",
                        JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al insertar mascota", "Mensaje",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
    public void InsertarUsuarioMasc(objusuariomasc objum) {
        try {
            connection = conexion.Conexion();
            s = connection.createStatement();   
            int z = s.executeUpdate("insert into usuario_masc (id_mascota,cedula) values ("+objum.getCodigo_mas()+","+objum.getCedula()+")");
            if ((z == 1)) {
                JOptionPane.showMessageDialog(null, "Se agregó el registro de manera exitosa", "Mensaje",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Error al insertar usuario mascota", "Mensaje",
                        JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al insertar usuario mascota", "Mensaje",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
