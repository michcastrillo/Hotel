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
public class objTableHabit {

    private Integer codigo;
    private String planta;
    private String tipo;
    private int tipoNum;
    private String mascota;
    private Integer monto;
    public static ArrayList<objTableHabit> listahabitacion = new ArrayList<>();

    public Integer getMonto() {
        return monto;
    }

    public void setMonto(Integer monto) {
        this.monto = monto;
    }
    
    public objTableHabit(Integer codigo, String planta, String tipo, String mascota) {
        this.codigo = codigo;
        this.planta = planta;
        this.tipo = tipo;
        this.mascota = mascota;
    }
    public objTableHabit(Integer codigo, String planta, String tipo, int monto) {
        this.codigo = codigo;
        this.planta = planta;
        this.tipo = tipo;
        this.monto=monto;
    }
    public objTableHabit(Integer codigo, String planta, int tipoNum, String mascota) {
        this.codigo = codigo;
        this.planta = planta;
        this.tipoNum = tipoNum;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMascota() {
        return mascota;
    }

    public void setMascota(String mascota) {
        this.mascota = mascota;
    }

    public int getTipoNum() {
        return tipoNum;
    }

    public void setTipoNum(int tipoNum) {
        this.tipoNum = tipoNum;
    }

    public static ArrayList<objTableHabit> getListahabitacion() {
        return listahabitacion;
    }

    public static void setListahabitacion(ArrayList<objTableHabit> listahabitacion) {
        objTableHabit.listahabitacion = listahabitacion;
    }

}
