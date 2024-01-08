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
public class objReservas {
    private String cedula;
    private Integer usuario_hab;
    private Integer usuario_masc;
    private String cantidad;
    private Integer monto;
    private String ingreso;
    private String salida;
    private String reserva;
    public static ArrayList<objReservas> listareservas = new ArrayList<>();

    public objReservas(String cedula, Integer usuario_hab, Integer usuario_masc, String cantidad, Integer monto, String ingreso, String salida, String reserva) {
        this.cedula = cedula;
        this.usuario_hab = usuario_hab;
        this.usuario_masc = usuario_masc;
        this.cantidad = cantidad;
        this.monto = monto;
        this.ingreso = ingreso;
        this.salida = salida;
        this.reserva = reserva;
    }
    public objReservas(String cedula, Integer usuario_hab, String cantidad, Integer monto, String ingreso, String salida, String reserva) {
        this.cedula = cedula;
        this.usuario_hab = usuario_hab;
        this.cantidad = cantidad;
        this.monto = monto;
        this.ingreso = ingreso;
        this.salida = salida;
        this.reserva = reserva;
    }
    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public Integer getUsuario_hab() {
        return usuario_hab;
    }

    public void setUsuario_hab(Integer usuario_hab) {
        this.usuario_hab = usuario_hab;
    }

    public Integer getUsuario_masc() {
        return usuario_masc;
    }

    public void setUsuario_masc(Integer usuario_masc) {
        this.usuario_masc = usuario_masc;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getMonto() {
        return monto;
    }

    public void setMonto(Integer monto) {
        this.monto = monto;
    }

    public String getIngreso() {
        return ingreso;
    }

    public void setIngreso(String ingreso) {
        this.ingreso = ingreso;
    }

    public String getSalida() {
        return salida;
    }

    public void setSalida(String salida) {
        this.salida = salida;
    }

    public String getReserva() {
        return reserva;
    }

    public void setReserva(String reserva) {
        this.reserva = reserva;
    }

    public static ArrayList<objReservas> getListareservas() {
        return listareservas;
    }

    public static void setListareservas(ArrayList<objReservas> listareservas) {
        objReservas.listareservas = listareservas;
    }

    
     
}
