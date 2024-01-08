/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import datos.BDReservas;
import java.util.ArrayList;
import objetos.objFechas;
import objetos.objReservas;
import objetos.objTableHabit;

/**
 *
 * @author Michelle
 */
public class BOReservas {
    BDReservas bdreservas = new BDReservas();
    public Integer ids(){
        int ids = 0;
        ArrayList<Integer> listas= bdreservas.idsmascotas();
        for (Integer lista : listas) {
            ids = lista;
        }
        return ids;
    }
//    public ArrayList<objTableHabit> permitidoM() {
//        ArrayList<objTableHabit> listahabitacion = bdreservas.permitidoM();
//        return listahabitacion;
//    }
//    public ArrayList<objTableHabit> Hdisponibles() {
//        ArrayList<objTableHabit> listahabitacion = bdreservas.Hdisponibles();
//        return listahabitacion;
//    }
    public void InsertarUsuario_hab(String cedula, String id_hab) {
        bdreservas.InsertarUsuario_hab(cedula, id_hab);
    }
    public void InsertarReservacm(objReservas reserva) {
        bdreservas.InsertarReservacm(reserva);
    }
    public void InsertarReservasm(objReservas reserva) {
        bdreservas.InsertarReservasm(reserva);
    }
    public void ModificarEstado(String id) {
         bdreservas.ModificarEstado(id);
    }
    public Integer cargarCodigoUsuarioHab(String id) {
        int ids =0;
        ArrayList<Integer>  codigos=  bdreservas.cargarCodigoUsuarioHab(id);  
        for (Integer codigo : codigos) {
            ids = codigo;
        }
        return ids;
    }
    public Integer cargarCodigoUsuarioMas(String cedula){
        int ids =0;
        ArrayList<Integer> codigos=  bdreservas.cargarCodigoUsuarioMas(cedula);  
        for (Integer codigo : codigos) {
            ids = codigo;
        }
        return ids;
    }
//    public ArrayList<objFechas> cargarDatos(String Fecha1, String Fecha2) { 
//        ArrayList<objFechas> listaDatos = bdreservas.fechasDisponibles(Fecha1, Fecha2);
//        return listaDatos;
//    }
}
