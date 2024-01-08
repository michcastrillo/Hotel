package objetos;

import java.util.ArrayList;

/**
 *
 * @author yasni
 */
public class objConsultaReserva {

    private Integer id;
    private String planta;
    private String nombre;
    private String estado;
    private String mascota;

    public static ArrayList<objConsultaReserva> listaConsultaR = new ArrayList<>();

    public objConsultaReserva(Integer id, String planta, String nombre, String mascota) {
        this.id = id;
        this.planta = planta;
        this.nombre = nombre;
        this.mascota = mascota;
    }

    public objConsultaReserva(Integer id, String planta, String nombre, String estado, String mascota) {
        this.id = id;
        this.planta = planta;
        this.nombre = nombre;
        this.estado = estado;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getMascota() {
        return mascota;
    }

    public void setMascota(String mascota) {
        this.mascota = mascota;
    }

    public ArrayList<objConsultaReserva> getListaConsultaR() {
        return listaConsultaR;
    }

    public void setListaConsultaR(ArrayList<objConsultaReserva> listaConsultaR) {
        this.listaConsultaR = listaConsultaR;
    }

}
