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
public class objReportes {
    private String nombre;
    private Integer porcentaje;
    public static ArrayList<objReportes> listareportes = new ArrayList<>();

    public objReportes(String nombre, Integer porcentaje) {
        this.nombre = nombre;
        this.porcentaje = porcentaje;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(Integer porcentaje) {
        this.porcentaje = porcentaje;
    }

    public static ArrayList<objReportes> getListareportes() {
        return listareportes;
    }

    public static void setListareportes(ArrayList<objReportes> listareportes) {
        objReportes.listareportes = listareportes;
    }
    
}
