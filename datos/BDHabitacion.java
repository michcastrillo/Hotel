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
import objetos.objHabitacion;
import objetos.objTableHabit;

/**
 *
 * @author Michelle
 */
public class BDHabitacion {

    private Statement s = null;
    private Connection connection = null;
    BDConexion conexion = new BDConexion();
    private ResultSet rs = null;

    public void InsertarHabitacion(objHabitacion habit) {
        try {
            connection = conexion.Conexion();
            s = connection.createStatement();
            int z = s.executeUpdate("INSERT INTO habitacion(planta,tipo,mascota,fecha_hora,estado) VALUES "
                    + "('" + habit.getPlanta() + "'," + habit.getTipo() + ",'" + habit.getMascota() + "','" + habit.getFecha_hora() + "','" + habit.getEstado() + "')");
            if ((z == 1)) {
                JOptionPane.showMessageDialog(null, "Se agregó el registro de manera exitosa", "Mensaje",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Error al insertar habitaciones", "Mensaje",
                        JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de conexión", "Mensaje",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public ArrayList<objTableHabit> cargarHabitacion() {
        try {
            connection = conexion.Conexion();
            s = connection.createStatement();
            rs = s.executeQuery("select e.id, e.planta,n.nombre,e.mascota\n"
                    + "from habitacion e, tipo_hab n\n"
                    + "where e.tipo = n.id order by e.id,n.nombre");

            while (rs.next()) {
                objTableHabit.listahabitacion.add(new objTableHabit(rs.getInt("id"), rs.getString("planta"),
                        rs.getString("nombre"), rs.getString("mascota")));
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de conexión", "Mensaje",
                    JOptionPane.ERROR_MESSAGE);
        }
        return objTableHabit.listahabitacion;
    }

    public ArrayList<Integer> cargarCodigoHabit() {
        ArrayList<Integer> listaCodigo = new ArrayList<>();
        try {
            connection = conexion.Conexion();
            s = connection.createStatement();
            rs = s.executeQuery("SELECT id FROM habitacion");
            while (rs.next()) {
                listaCodigo.add(rs.getInt("id"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de conexión", "Mensaje",
                    JOptionPane.ERROR_MESSAGE);
        }

        return listaCodigo;
    }
    public ArrayList<String> cargarestadohabitacion(int id) {
        ArrayList<String> listaestado = new ArrayList<>();
        try {
            connection = conexion.Conexion();
            s = connection.createStatement();
            rs = s.executeQuery("select estado from habitacion where id="+id);
            while (rs.next()) {
                listaestado.add(rs.getString("estado"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de conexión", "Mensaje",
                    JOptionPane.ERROR_MESSAGE);
        }

        return listaestado;
    }
    public ArrayList<objHabitacion> cargarUnaHabit(Integer codigo) {
        try {
            connection = conexion.Conexion();
            s = connection.createStatement();
            rs = s.executeQuery("SELECT id,planta,tipo,mascota FROM habitacion WHERE id = '" + codigo + "'");
            while (rs.next()) {
                objHabitacion.listahabitacion.add(new objHabitacion(rs.getInt("id"), rs.getString("planta"),
                        rs.getInt("tipo"), rs.getString("mascota")));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de conexión", "Mensaje",
                    JOptionPane.ERROR_MESSAGE);
        }
        return objHabitacion.listahabitacion;
    }

    public void modificarHabitacion(objHabitacion habitacion) {
        try {
            connection = conexion.Conexion(); //Conecta a la bd
            s = connection.createStatement();//Libreria sta
            int z = s.executeUpdate("UPDATE habitacion SET planta = '" + habitacion.getPlanta() + "' , tipo = " + habitacion.getTipo() + " , mascota = '" + habitacion.getMascota() + "' WHERE id = " + habitacion.getCodigo());
            if (z == 1) {
                JOptionPane.showMessageDialog(null, "Se modificó el registro de manera exitosa", "Mensaje",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Error al modificar los registros", "Mensaje",
                        JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de conexión al modificar", "Mensaje",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public void eliminarHabitacion(Integer codigo) {
        try {
            connection = conexion.Conexion();
            s = connection.createStatement();
            int z = s.executeUpdate("DELETE FROM habitacion WHERE id = '" + codigo + "'");
            if (z == 1) {
                JOptionPane.showMessageDialog(null, "Se eliminó el registro de manera exitosa", "Mensaje",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Error al eliminar el registro", "Mensaje",
                        JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de conexión", "Mensaje",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
