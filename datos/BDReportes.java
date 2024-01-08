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
import objetos.objMascota;
import objetos.objReportes;
import objetos.objTableHabit;
import objetos.objUsuario;

/**
 *
 * @author Michelle
 */
public class BDReportes {
    private Statement s = null;
    private Connection connection = null;
    BDConexion conexion = new BDConexion();
    private ResultSet rs = null;
    public ArrayList<objReportes> cargarDatosreporte3(String date1, String date2) {
        try {
            connection = conexion.Conexion();
            s = connection.createStatement();
            rs = s.executeQuery("SELECT e.genero, (COUNT(u.id) * 100)/(SELECT COUNT(u.id) FROM historial u) AS Porcentaje\n" 
            +"FROM usuarios e, historial u\n" 
            +"where e.cedula = u.cedula and u.ingreso between '"+date1+"' and '"+date2+"' and u.salida between '"+date1+"' and '"+date2+"'\n" 
            +"group by e.genero");
            while (rs.next()) {
                objReportes.listareportes.add(new objReportes(rs.getString("genero"),rs.getInt("porcentaje")));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de conexión al cargar habitacion reporte 3", "Mensaje",
                    JOptionPane.ERROR_MESSAGE);
        }

        return objReportes.listareportes;
    }
    public ArrayList<objReportes> cargarDatosreporte2() {
        try {
            connection = conexion.Conexion();
            s = connection.createStatement();
            rs = s.executeQuery("SELECT e.planta, (COUNT(u.id) * 100)/(SELECT COUNT(u.id) FROM historial u) AS Porcentaje\n" 
            +"FROM habitacion e, historial u, usuario_hab l\n" 
            +"where e.id = l.id_hab and l.id = u.usuario_hab\n" 
            +"group by e.planta");
            while (rs.next()) {
                objReportes.listareportes.add(new objReportes(rs.getString("planta"),rs.getInt("porcentaje")));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de conexión al cargar habitacion reporte 2", "Mensaje",
                    JOptionPane.ERROR_MESSAGE);
        }

        return objReportes.listareportes;
    }
    public ArrayList<objTableHabit> cargarDatosreporte4(String date1, String date2) {
        try {
            connection = conexion.Conexion();
            s = connection.createStatement();
            rs = s.executeQuery("select e.id, e.planta,n.nombre, e.mascota \n"
            +"from habitacion e, tipo_hab n, historial u\n" 
            +"where  e.tipo = n.id and e.estado  ='Disponible' \n" 
            +"union\n" 
            +"select e.id, e.planta,n.nombre, e.mascota \n" 
            +"from habitacion e, tipo_hab n, historial u, usuario_hab l\n" 
            +"where e.tipo = n.id and e.id = l.id_hab and l.id = u.usuario_hab\n" 
            +"and '"+date1 +"' not between u.ingreso and u.salida and '"+ date2+"' not between u.ingreso and u.salida ");
            while (rs.next()) {
                objTableHabit.listahabitacion.add(new objTableHabit(rs.getInt("id"), rs.getString("planta"), rs.getString("nombre"),rs.getString("mascota")));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de conexión al cargar habitacion reporte 4", "Mensaje",
                    JOptionPane.ERROR_MESSAGE);
        }

        return objTableHabit.listahabitacion;
    }
    public ArrayList<String> cargarCedulas() {
        ArrayList<String> listaCodigo = new ArrayList<>();
        try {
            connection = conexion.Conexion();
            s = connection.createStatement();
            rs = s.executeQuery("SELECT cedula FROM usuarios except select cedula from usuarios where cedula = '1';");
            while (rs.next()) {
                listaCodigo.add(rs.getString("cedula"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de conexión", "Mensaje",
                    JOptionPane.ERROR_MESSAGE);
        }

        return listaCodigo;
    }
    public ArrayList<objUsuario> cargarDatosUsuario(String cedula) {
        try {
            connection = conexion.Conexion();
            s = connection.createStatement();
            rs = s.executeQuery("SELECT nombre,genero,fecha_nac FROM usuarios where cedula='"+cedula+"'");
            while (rs.next()) {
                objUsuario.listausuarios.add(new objUsuario(rs.getString("nombre"), rs.getString("genero"), rs.getString("fecha_nac")));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de conexión", "Mensaje",
                    JOptionPane.ERROR_MESSAGE);
        }

        return objUsuario.listausuarios;
    }
    public ArrayList<objTableHabit> cargarDatosHabitacion(String cedula) {
        try {
            connection = conexion.Conexion();
            s = connection.createStatement();
            rs = s.executeQuery("select e.id, e.planta,n.nombre,i.monto from habitacion e, historial i, usuario_hab u, tipo_hab n where e.id = u.id_hab and i.usuario_hab = u.id and e.tipo = n.id and i.cedula = '"+cedula+"'");
            while (rs.next()) {
                objTableHabit.listahabitacion.add(new objTableHabit(rs.getInt("id"), rs.getString("planta"), rs.getString("nombre"),rs.getInt("monto")));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de conexión al cargar habitacion reporte 1", "Mensaje",
                    JOptionPane.ERROR_MESSAGE);
        }

        return objTableHabit.listahabitacion;
    }
    public ArrayList<objMascota> cargarDatosMascota(String cedula) {
        try {
            connection = conexion.Conexion();
            s = connection.createStatement();
            rs = s.executeQuery("select w.nombre,w.color,w.tamano from mascota w, usuario_masc s, usuarios u where s.id_mascota = w.id and s.cedula = u.cedula and s.cedula ='"+cedula+"'");
            while (rs.next()) {//falta traer la foto
                objMascota.listamascota.add(new objMascota(rs.getString("nombre"), rs.getString("color"), rs.getString("tamano")));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de conexión al cargar mascotas reportes", "Mensaje",
                    JOptionPane.ERROR_MESSAGE);
        }

        return objMascota.listamascota;
    }
}
