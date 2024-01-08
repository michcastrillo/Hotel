/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import datos.BDHabitacion;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import objetos.objHabitacion;
import objetos.objTableHabit;

/**
 *
 * @author Michelle
 */
public class BOHabitacion {

    BDHabitacion bdhabitacion = new BDHabitacion();

    public void InsertarHabitacion(objHabitacion habit) {
        bdhabitacion.InsertarHabitacion(habit);
    }

    public ArrayList<objTableHabit> cargarHabitacion() {
        ArrayList<objTableHabit> listahabitacion = bdhabitacion.cargarHabitacion();
        return listahabitacion;
    }

    public DefaultComboBoxModel cargarCodigosHabit() {
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        ArrayList<Integer> codigos = bdhabitacion.cargarCodigoHabit();
        for (Integer codigo : codigos) {
            model.addElement(codigo);
        }
        return model;
    }
    public boolean cargarestadohabitacion(int id) {
        ArrayList<String> estados = bdhabitacion.cargarestadohabitacion(id);
        boolean veri = true;
        for (int i=0;i<estados.size();i++) {
            if(estados.get(i).equals("Ocupado")){
                veri=false;
            }
        }
        return veri;
    }
    public ArrayList<objHabitacion> cargarUnaVacuna(Integer codigo) {
        ArrayList<objHabitacion> listaEstudiantes = bdhabitacion.cargarUnaHabit(codigo);
        return listaEstudiantes;
    }

    public void modificarVacuna(objHabitacion habitacion) {
        bdhabitacion.modificarHabitacion(habitacion);
    }

    public void eliminarVacuna(Integer habitacion) {
        bdhabitacion.eliminarHabitacion(habitacion);
    }

}
