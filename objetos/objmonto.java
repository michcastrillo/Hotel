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
public class objmonto {
    Integer monto;
    public static ArrayList<objmonto> listamonto = new ArrayList<>();

    public objmonto(Integer monto) {
        this.monto = monto;
    }

    public Integer getMonto() {
        return monto;
    }

    public void setMonto(Integer monto) {
        this.monto = monto;
    }

    public static ArrayList<objmonto> getListamonto() {
        return listamonto;
    }

    public static void setListamonto(ArrayList<objmonto> listamonto) {
        objmonto.listamonto = listamonto;
    }
    
}
