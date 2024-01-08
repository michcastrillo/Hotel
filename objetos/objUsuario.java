package objetos;

import java.util.ArrayList;

/**
 *
 * @author yasnihotel1
 */
public class objUsuario {

    private String cedula;
    private String nombre;
    private String genero;
    private String correo;
    private String fecha_nac;
    private String edad;
    private String contrasena;
    public static ArrayList<objUsuario> listausuarios = new ArrayList<>();

    public objUsuario(String cedula, String nombre, String genero, String correo, String fecha_nac, String edad, String contrasena) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.genero = genero;
        this.correo = correo;
        this.fecha_nac = fecha_nac;
        this.edad = edad;
        this.contrasena = contrasena;
    }

    public objUsuario(String cedula, String contrasena) {
        this.cedula = cedula;
        this.contrasena = contrasena;
    }
    public objUsuario(String nombre, String genero, String fecha_nac) {
        this.nombre = nombre;
        this.genero  = genero;
        this.fecha_nac=fecha_nac;
    }
    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(String fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public static ArrayList<objUsuario> getListausuarios() {
        return listausuarios;
    }

    public static void setListausuarios(ArrayList<objUsuario> listausuarios) {
        objUsuario.listausuarios = listausuarios;
    }

}
