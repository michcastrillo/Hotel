/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;

import java.util.ArrayList;

/**
 *
 * @author Michelle
 */
public class objHabitacion {

    private Integer codigo;
    private String planta;
    private Integer tipo;
    private String mascota;
    private String fecha_hora;
    private String estado;
    public static ArrayList<objHabitacion> listahabitacion = new ArrayList<>();

    public objHabitacion(String planta, Integer tipo, String mascota, String fecha_hora, String estado) {
        this.planta = planta;
        this.tipo = tipo;
        this.mascota = mascota;
        this.fecha_hora = fecha_hora;
        this.estado = estado;
    }

    public objHabitacion(Integer codigo, String planta, Integer tipo, String mascota, String fecha_hora, String estado) {
        this.codigo = codigo;
        this.planta = planta;
        this.tipo = tipo;
        this.mascota = mascota;
        this.fecha_hora = fecha_hora;
        this.estado = estado;
    }
    

    public objHabitacion(Integer codigo, String planta, Integer tipo, String mascota) {
        this.codigo = codigo;
        this.planta = planta;
        this.tipo = tipo;
        this.mascota = mascota;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getPlanta() {
        return planta;
    }

    public void setPlanta(String planta) {
        this.planta = planta;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public String getMascota() {
        return mascota;
    }

    public void setMascota(String mascota) {
        this.mascota = mascota;
    }

    public String getFecha_hora() {
        return fecha_hora;
    }

    public void setFecha_hora(String fecha_hora) {
        this.fecha_hora = fecha_hora;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public static ArrayList<objHabitacion> getListahabitacion() {
        return listahabitacion;
    }

    public static void setListahabitacion(ArrayList<objHabitacion> listahabitacion) {
        objHabitacion.listahabitacion = listahabitacion;
    }

}
