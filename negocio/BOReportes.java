/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import datos.BDReportes;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import objetos.objMascota;
import objetos.objReportes;
import objetos.objTableHabit;
import objetos.objUsuario;

/**
 *
 * @author Michelle
 */
public class BOReportes {
    BDReportes bdreportes = new BDReportes();
    public DefaultComboBoxModel cargarCedulas() {
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        ArrayList<String> cedulas = bdreportes.cargarCedulas();
        for (String cedula : cedulas) {
            model.addElement(cedula);
        }
        return model;
    }
    public ArrayList<objReportes> cargarReporte2() {
        ArrayList<objReportes> listaDatosPlanta = bdreportes.cargarDatosreporte2();
        return listaDatosPlanta;
    }
    public ArrayList<objReportes> cargarReporte3(String date1, String date2) {
        ArrayList<objReportes> listaDatosGenero = bdreportes.cargarDatosreporte3(date1, date2);
        return listaDatosGenero;
    }
    public ArrayList<objTableHabit> cargarReporte4(String date1, String date2) {
        ArrayList<objTableHabit> listaDatosHabi = bdreportes.cargarDatosreporte4(date1, date2);
        return listaDatosHabi;
    }
    public ArrayList<objUsuario> cargarDatosUsuario(String cedula) {
        ArrayList<objUsuario> listaDatosUsuario = bdreportes.cargarDatosUsuario(cedula);
        return listaDatosUsuario;
    }
    public ArrayList<objTableHabit> cargarDatosHabitacion(String cedula) {
        ArrayList<objTableHabit> listaDatosHab = bdreportes.cargarDatosHabitacion(cedula);
        return listaDatosHab;
    }
    public ArrayList<objMascota> cargarDatosMascota(String cedula) {
        ArrayList<objMascota> listaDatosMasc = bdreportes.cargarDatosMascota(cedula);
        return listaDatosMasc;
    }

}
