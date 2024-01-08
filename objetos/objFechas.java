/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;

import java.util.ArrayList;

/**
 *
 * @author yasni
 */
public class objFechas {
    
    private Integer id;
    private String planta;
    private int tipo;
    private String mascota;
    
    public static ArrayList<objFechas> listaFechas = new ArrayList<>();

    public objFechas(Integer id, String planta, int tipo, String mascota) {
        this.id = id;
        this.planta = planta;
        this.tipo = tipo;
        this.mascota = mascota;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlanta() {
        return planta;
    }

    public void setPlanta(String planta) {
        this.planta = planta;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getMascota() {
        return mascota;
    }

    public void setMascota(String mascota) {
        this.mascota = mascota;
    }

    public static ArrayList<objFechas> getListaFechas() {
        return listaFechas;
    }

    public static void setListaFechas(ArrayList<objFechas> listaFechas) {
        objFechas.listaFechas = listaFechas;
    }
    
    
    
    
}
