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
public class objusuariomasc {
    private Integer codigo;
    private Integer codigo_mas;
    private Integer cedula;    
    public static ArrayList<objusuariomasc> listausuariomasc = new ArrayList<>();

    public objusuariomasc(Integer codigo, Integer codigo_mas, Integer cedula) {
        this.codigo = codigo;
        this.codigo_mas = codigo_mas;
        this.cedula = cedula;
    }
    public objusuariomasc(Integer codigo_mas, Integer cedula) {
        this.codigo_mas = codigo_mas;
        this.cedula = cedula;
    }
    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCodigo_mas() {
        return codigo_mas;
    }

    public void setCodigo_mas(Integer codigo_mas) {
        this.codigo_mas = codigo_mas;
    }

    public Integer getCedula() {
        return cedula;
    }

    public void setCedula(Integer cedula) {
        this.cedula = cedula;
    }

    public static ArrayList<objusuariomasc> getListausuariomasc() {
        return listausuariomasc;
    }

    public static void setListausuariomasc(ArrayList<objusuariomasc> listausuariomasc) {
        objusuariomasc.listausuariomasc = listausuariomasc;
    }
    
}
