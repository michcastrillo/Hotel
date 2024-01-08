/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;

import java.util.ArrayList;

/**
 *
 * @author Michellehotel1
 */
public class objMascota {
    Integer id;
    String nombre="";
    String color="";
    String tamano="";
    String sexo="";
    String edad="";
    public static ArrayList<objMascota> listamascota = new ArrayList<>();

    public objMascota(Integer id) {
        this.id=id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public objMascota(String nombre,String color, String tamano,String sexo,String edad) {
      this.nombre = nombre;
      this.color = color;
      this.tamano = tamano;
      this.sexo=sexo;
      this.edad = edad;
    }
    public objMascota(String nombre,String color, String tamano) {
      this.nombre = nombre;
      this.color = color;
      this.tamano = tamano; //falta la foto para el reporte
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTamano() {
        return tamano;
    }

    public void setTamano(String tamano) {
        this.tamano = tamano;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public static ArrayList<objMascota> getListamascota() {
        return listamascota;
    }

    public static void setListamascota(ArrayList<objMascota> listamascota) {
        objMascota.listamascota = listamascota;
    }
    
}
