package negocio;

import datos.BDUsuario;
import java.util.ArrayList;
import objetos.objUsuario;

/**
 *
 * @author yasni
 */
public class BOUsuario {

    BDUsuario bdusuarios = new BDUsuario();

    public boolean validadCedulaLogin(String cedula, String contra) {
        boolean vali = false;
        ArrayList<objUsuario> datos = bdusuarios.cargarDatosLogin();
        for (int i = 0; i < datos.size(); i++) {
            if ((cedula.equals(datos.get(i).getCedula()) && (contra.equals(datos.get(i).getContrasena())))) {
                vali = true;
            }
        }
        return vali;
    }
    public boolean vericedu(String cedula) {
        boolean veri = false;
        ArrayList<String> cedulas = bdusuarios.vericedubd(cedula);
        for(int i=0;i<cedulas.size();i++){
            if(cedula.equals(cedulas.get(i))){
                veri=true;
            }
        }
        return veri;
    }
    public void InsertarUsuario(objUsuario usuario) {
        bdusuarios.InsertarUsuario(usuario);
    }

}
