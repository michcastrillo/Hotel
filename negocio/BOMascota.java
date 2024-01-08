/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import datos.BDMascota;
import objetos.objMascota;
import objetos.objusuariomasc;

/**
 *
 * @author Michelle
 */
public class BOMascota {
    BDMascota bdmascota = new BDMascota();
    public void InsertarMascota(objMascota objm) {
        bdmascota.InsertarMascota(objm);
    }
    public void InsertarUsuarioMasc(objusuariomasc objum) {
        bdmascota.InsertarUsuarioMasc(objum);
    }
}
