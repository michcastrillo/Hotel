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
import objetos.objFechas;
import objetos.objMascota;
import objetos.objReservas;
import objetos.objTableHabit;

/**
 *
 * @author Michelle
 */
public class BDReservas {

    private Statement s = null;
    private Connection connection = null;
    BDConexion conexion = new BDConexion();
    private ResultSet rs = null;
    public ArrayList<Integer> idsmascotas() {
        ArrayList<Integer> listaids = new ArrayList<>();
        try {
            connection = conexion.Conexion();
            s = connection.createStatement();
            rs = s.executeQuery("select id from mascota order by id DESC limit 1");
            while (rs.next()) {
                listaids.add(rs.getInt("id"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de conexión", "Mensaje",
                    JOptionPane.ERROR_MESSAGE);
        }

        return listaids;
    }
    public void ModificarEstado(String id) {
        try {
            connection = conexion.Conexion();
            s = connection.createStatement();
            int z = s.executeUpdate("UPDATE habitacion SET estado = 'Ocupado' where id = "+id);
            if ((z == 1)) {
                 System.out.println("Se modificó la habitación de manera exitosa");
            } else {
                JOptionPane.showMessageDialog(null, "Error al modificar el registro de vacunas", "Mensaje",
                        JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de conexión", "Mensaje",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
//    public ArrayList<objTableHabit> permitidoM() {
//        try {
//            connection = conexion.Conexion();
//            s = connection.createStatement();
//            rs = s.executeQuery("select e.id,e.planta,n.nombre,e.mascota from habitacion e,tipo_hab n "
//                    + "where e.tipo = n.id and e.estado = 'Disponible' and e.mascota = 'Permitido'  "
//                    + "and n.nombre = 'Junior' limit 1 ");
//
//            while (rs.next()) {
//                objTableHabit.listahabitacion.add(new objTableHabit(rs.getInt("id"), rs.getString("planta"),
//                        rs.getString("nombre"), rs.getString("mascota")));
//            }
//
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Error de conexión", "Mensaje",
//                    JOptionPane.ERROR_MESSAGE);
//        }
//        return objTableHabit.listahabitacion;
//    }

//    public ArrayList<objTableHabit> Hdisponibles() {
//        try {
//            connection = conexion.Conexion();
//            s = connection.createStatement();
//            rs = s.executeQuery("select e.id,e.planta,n.nombre,e.mascota from habitacion e,tipo_hab n "
//                    + "where e.tipo = n.id and e.estado = 'Disponible'  "
//                    + "and n.nombre = 'Junior' limit 1");
//
//            while (rs.next()) {
//                objTableHabit.listahabitacion.add(new objTableHabit(rs.getInt("id"), rs.getString("planta"),
//                        rs.getString("nombre"), rs.getString("mascota")));
//            }
//
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Error de conexión", "Mensaje",
//                    JOptionPane.ERROR_MESSAGE);
//        }
//        return objTableHabit.listahabitacion;
//    }

    public void InsertarUsuario_hab(String cedula, String id_hab) {
        try {
            connection = conexion.Conexion();
            s = connection.createStatement();
            int z = s.executeUpdate("INSERT INTO usuario_hab(cedula, id_hab) VALUES "
                    + "('" + cedula + "','" + id_hab + "')");
            if ((z == 1)) {       
                System.out.println("Se agregó el registro usuario-habitacion de manera exitosa");
            } else {
                JOptionPane.showMessageDialog(null, "Error al insertar habitaciones", "Mensaje",
                        JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception e) {
            System.out.println("Error al insertar usuario habitación");
        }
    }

    public void InsertarReservacm(objReservas reserva) {
        try {
            connection = conexion.Conexion();
            s = connection.createStatement();
            int z = s.executeUpdate("INSERT INTO historial(cedula,usuario_hab,usuario_masc,cantidad,monto,ingreso,salida,reserva) VALUES "
                        + "('" + reserva.getCedula() + "'," + reserva.getUsuario_hab() + "," + reserva.getUsuario_masc() + ",'" + reserva.getCantidad()
                        + "'," + reserva.getMonto() + ",'" + reserva.getIngreso() + "','" + reserva.getSalida() + "','" + reserva.getReserva() + "')");

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
    public void InsertarReservasm(objReservas reserva) {
        try {
            connection = conexion.Conexion();
            s = connection.createStatement();
            int z = s.executeUpdate("INSERT INTO historial(cedula,usuario_hab,cantidad,monto,ingreso,salida,reserva) VALUES "
                        + "('" + reserva.getCedula() + "'," + reserva.getUsuario_hab() + ",'" + reserva.getCantidad() + "',"
                        + reserva.getMonto() + ",'" + reserva.getIngreso() + "','" + reserva.getSalida() + "','" + reserva.getReserva() + "')");
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
    public ArrayList<Integer> cargarCodigoUsuarioHab(String id) {
        ArrayList<Integer> listaCodigoHab = new ArrayList<>();
        try {
            connection = conexion.Conexion();
            s = connection.createStatement();
            rs = s.executeQuery("SELECT id FROM usuario_hab where id_hab = '"+id+"'");
            while (rs.next()) {
                listaCodigoHab.add(rs.getInt("id"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de conexión", "Mensaje",
                    JOptionPane.ERROR_MESSAGE);
        }

        return listaCodigoHab;
    }
    public ArrayList<Integer> cargarCodigoUsuarioMas(String cedula) {
        ArrayList<Integer> listaCodigoMas = new ArrayList<>();
        try {
            connection = conexion.Conexion();
            s = connection.createStatement();
            rs = s.executeQuery("SELECT id FROM usuario_masc where cedula = '"+cedula+"'");
            while (rs.next()) {
                listaCodigoMas.add(rs.getInt("id"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de conexión", "Mensaje",
                    JOptionPane.ERROR_MESSAGE);
        }

        return listaCodigoMas;
    }
//    public ArrayList<objFechas> fechasDisponibles(String Fecha1, String Fecha2) {
//        ArrayList<objFechas> datos = new ArrayList<>();
//        try {
//            connection = conexion.Conexion();
//            s = connection.createStatement();
//            rs = s.executeQuery("SELECT id, planta, tipo,mascota FROM habitacion WHERE  fecha_hora BETWEEN '" + Fecha1 + "' AND '" + Fecha2 + "' ");
//            while (rs.next()) {
//                datos.add(new objFechas(rs.getInt("id"),rs.getString("planta"), rs.getInt("tipo"), rs.getString("mascota")));
//            }
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Error de conexión", "Mensaje", JOptionPane.ERROR_MESSAGE);
//        }
//        return datos;
//    }
    
}
