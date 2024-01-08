package negocio;

import datos.BDReservaPrueba;
import java.util.ArrayList;
import objetos.objConsultaReserva;

/**
 *
 * @author yasni
 */
public class BOReservaPrueba {

    BDReservaPrueba bdreserva = new BDReservaPrueba();

    public String comprobarMascota(int idHab) { //1 Junior con acceso a mascota   
        String acceso = bdreserva.consultaMascota(idHab);
        return acceso;

    }

    public ArrayList<objConsultaReserva> JuniorMascota1(String fecha1, String fecha2) { //1 Junior con acceso a mascota
        ArrayList<objConsultaReserva> listaDatos = new ArrayList<>();
        //int tama = listaDatos.size();
        ArrayList<objConsultaReserva> listaGeneral = bdreserva.consultaJunior1(fecha1, fecha2);
        for (int i = 0; i < listaGeneral.size(); i++) {
            if (listaGeneral.get(i).getMascota().equals("Permitido")) {
                listaDatos.add(new objConsultaReserva(listaGeneral.get(i).getId(), listaGeneral.get(i).getPlanta(), listaGeneral.get(i).getNombre(), listaGeneral.get(i).getMascota()));
                break;
            }
        }
        return listaDatos;

    }

    public ArrayList<objConsultaReserva> JuniorSinMascota1(String fecha1, String fecha2) { //1 Junior sin acceso a mascota
        ArrayList<objConsultaReserva> listaDatos = new ArrayList<>();
        //int tama = listaDatos.size();
        ArrayList<objConsultaReserva> listaGeneral = bdreserva.consultaJunior1(fecha1, fecha2);
        for (int i = 0; i < listaGeneral.size(); i++) {
            if (listaGeneral.get(i).getMascota().equals("Prohibido")) {
                listaDatos.add(new objConsultaReserva(listaGeneral.get(i).getId(), listaGeneral.get(i).getPlanta(),
                        listaGeneral.get(i).getNombre(), listaGeneral.get(i).getMascota()));
                break;
            }
        }
        return listaDatos;

    }

    public ArrayList<objConsultaReserva> JuniorMascota2(String fecha1, String fecha2) { //1 Junior con mascota y 1 Junior sin mascota
        ArrayList<objConsultaReserva> listaDatos = new ArrayList<>();
        ArrayList<objConsultaReserva> listaGeneral = bdreserva.consultaJunior1(fecha1, fecha2);
        if (listaDatos.isEmpty()) {
            for (int i = 0; i < listaGeneral.size(); i++) {
                int tama = listaDatos.size();
                if ((listaGeneral.get(i).getMascota().equals("Permitido") || listaGeneral.get(i).getMascota().equals("Prohibido")) && tama == 0) {
                    listaDatos.add(new objConsultaReserva(listaGeneral.get(i).getId(), listaGeneral.get(i).getPlanta(),
                            listaGeneral.get(i).getNombre(), listaGeneral.get(i).getMascota()));
                } else if (tama == 1 && listaDatos.get(0).getMascota().equals("Prohibido")) {
                    if (listaGeneral.get(i).getMascota().equals("Permitido")) {
                        listaDatos.add(new objConsultaReserva(listaGeneral.get(i).getId(), listaGeneral.get(i).getPlanta(),
                                listaGeneral.get(i).getNombre(), listaGeneral.get(i).getMascota()));
                        //break;
                    }
                } else if (tama == 1 && listaDatos.get(0).getMascota().equals("Permitido")) {
                    if (listaGeneral.get(i).getMascota().equals("Prohibido")) {
                        listaDatos.add(new objConsultaReserva(listaGeneral.get(i).getId(), listaGeneral.get(i).getPlanta(),
                                listaGeneral.get(i).getNombre(), listaGeneral.get(i).getMascota()));
                        //break;
                    }
                }
            }
        }
        return listaDatos;
    }

    public ArrayList<objConsultaReserva> JuniorMascota3(String fecha1, String fecha2) { //1 Junior con mascota y 2 Junior sin mascota
        ArrayList<objConsultaReserva> listaDatos = new ArrayList<>();
        ArrayList<objConsultaReserva> listaGeneral = bdreserva.consultaJunior1(fecha1, fecha2);
        if (listaDatos.isEmpty()) {
            for (int i = 0; i < listaGeneral.size(); i++) {
                int tama = listaDatos.size();
                if ((listaGeneral.get(i).getMascota().equals("Permitido") || listaGeneral.get(i).getMascota().equals("Prohibido")) && tama == 0) {
                    listaDatos.add(new objConsultaReserva(listaGeneral.get(i).getId(), listaGeneral.get(i).getPlanta(),
                            listaGeneral.get(i).getNombre(), listaGeneral.get(i).getMascota()));
                } else if (tama == 1 && listaDatos.get(0).getMascota().equals("Prohibido")) {
                    if (listaGeneral.get(i).getMascota().equals("Permitido")) {
                        listaDatos.add(new objConsultaReserva(listaGeneral.get(i).getId(), listaGeneral.get(i).getPlanta(),
                                listaGeneral.get(i).getNombre(), listaGeneral.get(i).getMascota()));
                        //break;
                    }
                } else if (tama == 1 && listaDatos.get(0).getMascota().equals("Permitido")) {
                    if (listaGeneral.get(i).getMascota().equals("Prohibido")) {
                        listaDatos.add(new objConsultaReserva(listaGeneral.get(i).getId(), listaGeneral.get(i).getPlanta(),
                                listaGeneral.get(i).getNombre(), listaGeneral.get(i).getMascota()));
                        //break;
                    }
                } else if (tama == 2 && ((listaDatos.get(0).getMascota().equals("Prohibido") && listaDatos.get(1).getMascota().equals("Permitido"))
                        || (listaDatos.get(0).getMascota().equals("Permitido") && listaDatos.get(1).getMascota().equals("Prohibido")))) {
                    if (listaGeneral.get(i).getMascota().equals("Prohibido")) {
                        listaDatos.add(new objConsultaReserva(listaGeneral.get(i).getId(), listaGeneral.get(i).getPlanta(),
                                listaGeneral.get(i).getNombre(), listaGeneral.get(i).getMascota()));
                        //break;
                    }
                } else if (tama == 2 && (listaDatos.get(0).getMascota().equals("Prohibido") && listaDatos.get(1).getMascota().equals("Prohibido"))) {
                    if (listaGeneral.get(i).getMascota().equals("Permitido")) {
                        listaDatos.add(new objConsultaReserva(listaGeneral.get(i).getId(), listaGeneral.get(i).getPlanta(),
                                listaGeneral.get(i).getNombre(), listaGeneral.get(i).getMascota()));
                        //break;
                    }
                }
            }
        }
        return listaDatos;
    }

    public ArrayList<objConsultaReserva> a1(String fecha1, String fecha2) { //estan Junior
        ArrayList<objConsultaReserva> listaDatos = new ArrayList<>();
        ArrayList<objConsultaReserva> listaGeneral = bdreserva.consultaEstandarJunior(fecha1, fecha2);
        if (listaDatos.isEmpty()) {
            for (int i = 0; i < listaGeneral.size(); i++) {
                int tama = listaDatos.size();
                if ((listaGeneral.get(i).getNombre().equals("Junior") || listaGeneral.get(i).getNombre().equals("Estandar"))
                        && (listaGeneral.get(i).getMascota().equals("Permitido") || listaGeneral.get(i).getMascota().equals("Prohibido")) && (tama == 0)) {
                    listaDatos.add(new objConsultaReserva(listaGeneral.get(i).getId(), listaGeneral.get(i).getPlanta(),
                            listaGeneral.get(i).getNombre(), listaGeneral.get(i).getMascota()));
                } else if (listaDatos.get(0).getNombre().equals("Junior") && listaDatos.get(0).getMascota().equals("Permitido")) {
                    if ((listaGeneral.get(i).getNombre().equals("Estandar") && listaGeneral.get(i).getMascota().equals("Prohibido")) && (tama == 1)) {
                        listaDatos.add(new objConsultaReserva(listaGeneral.get(i).getId(), listaGeneral.get(i).getPlanta(),
                                listaGeneral.get(i).getNombre(), listaGeneral.get(i).getMascota()));
                    }
                } else if (listaDatos.get(0).getNombre().equals("Junior") && listaDatos.get(0).getMascota().equals("Prohibido")) {
                    if ((listaGeneral.get(i).getNombre().equals("Estandar") && listaGeneral.get(i).getMascota().equals("Permitido")) && (tama == 1)) {
                        listaDatos.add(new objConsultaReserva(listaGeneral.get(i).getId(), listaGeneral.get(i).getPlanta(),
                                listaGeneral.get(i).getNombre(), listaGeneral.get(i).getMascota()));
                    }
                } else if (listaDatos.get(0).getNombre().equals("Estandar") && listaDatos.get(0).getMascota().equals("Permitido")) {
                    if ((listaGeneral.get(i).getNombre().equals("Junior") && listaGeneral.get(i).getMascota().equals("Prohibido")) && (tama == 1)) {
                        listaDatos.add(new objConsultaReserva(listaGeneral.get(i).getId(), listaGeneral.get(i).getPlanta(),
                                listaGeneral.get(i).getNombre(), listaGeneral.get(i).getMascota()));
                    }
                } else if (listaDatos.get(0).getNombre().equals("Estandar") && listaDatos.get(0).getMascota().equals("Prohibido")) {
                    if ((listaGeneral.get(i).getNombre().equals("Junior") && listaGeneral.get(i).getMascota().equals("Permitido")) && (tama == 1)) {
                        listaDatos.add(new objConsultaReserva(listaGeneral.get(i).getId(), listaGeneral.get(i).getPlanta(),
                                listaGeneral.get(i).getNombre(), listaGeneral.get(i).getMascota()));
                    }
                }
            }
        }
        return listaDatos;
    }

    public ArrayList<objConsultaReserva> JuniorSinMascota2(String fecha1, String fecha2) { //2 Junior sin acceso a mascota
        ArrayList<objConsultaReserva> listaDatos = new ArrayList<>();
        //int tama = listaDatos.size();
        ArrayList<objConsultaReserva> listaGeneral = bdreserva.consultaJunior1(fecha1, fecha2);
        for (int i = 0; i < listaGeneral.size(); i++) {
            int tama = listaDatos.size();
            if (listaGeneral.get(i).getMascota().equals("Prohibido") && listaGeneral.get(i).getNombre().equals("Junior") && tama < 2) {
                listaDatos.add(new objConsultaReserva(listaGeneral.get(i).getId(), listaGeneral.get(i).getPlanta(),
                        listaGeneral.get(i).getNombre(), listaGeneral.get(i).getMascota()));
            }
        }
        return listaDatos;
    }

    public ArrayList<objConsultaReserva> JuniorSinMascota3(String fecha1, String fecha2) { //2 Junior sin acceso a mascota
        ArrayList<objConsultaReserva> listaDatos = new ArrayList<>();
        //int tama = listaDatos.size();
        ArrayList<objConsultaReserva> listaGeneral = bdreserva.consultaJunior1(fecha1, fecha2);
        for (int i = 0; i < listaGeneral.size(); i++) {
            int tama = listaDatos.size();
            if (listaGeneral.get(i).getMascota().equals("Prohibido") && listaGeneral.get(i).getNombre().equals("Junior") && tama < 3) {
                listaDatos.add(new objConsultaReserva(listaGeneral.get(i).getId(), listaGeneral.get(i).getPlanta(),
                        listaGeneral.get(i).getNombre(), listaGeneral.get(i).getMascota()));
            }
        }
        return listaDatos;
    }

    public ArrayList<objConsultaReserva> EstadarMascota1(String fecha1, String fecha2) { //1 Estandar con mascota
        ArrayList<objConsultaReserva> listaDatos = new ArrayList<>();
        //int tama = listaDatos.size();
        ArrayList<objConsultaReserva> listaGeneral = bdreserva.consultaEstandar(fecha1, fecha2);
        int tama = listaDatos.size();
        for (int i = 0; i < listaGeneral.size(); i++) {
            if (listaGeneral.get(i).getMascota().equals("Permitido") && tama == 0) {
                listaDatos.add(new objConsultaReserva(listaGeneral.get(i).getId(), listaGeneral.get(i).getPlanta(),
                        listaGeneral.get(i).getNombre(), listaGeneral.get(i).getMascota()));
                break;
            }
        }
        return listaDatos;

    }

    public ArrayList<objConsultaReserva> EstadarSinMascota1(String fecha1, String fecha2) { //1 Estandar sin mascota
        ArrayList<objConsultaReserva> listaDatos = new ArrayList<>();
        //int tama = listaDatos.size();
        ArrayList<objConsultaReserva> listaGeneral = bdreserva.consultaEstandar(fecha1, fecha2);
        for (int i = 0; i < listaGeneral.size(); i++) {
            if (listaGeneral.get(i).getMascota().equals("Prohibido")) {
                listaDatos.add(new objConsultaReserva(listaGeneral.get(i).getId(), listaGeneral.get(i).getPlanta(),
                        listaGeneral.get(i).getNombre(), listaGeneral.get(i).getMascota()));
                break;
            }
        }
        return listaDatos;

    }

    public ArrayList<objConsultaReserva> EstadarMascota2(String fecha1, String fecha2) { //1 Junior con mascota y 1 Junior sin mascota
        ArrayList<objConsultaReserva> listaDatos = new ArrayList<>();
        ArrayList<objConsultaReserva> listaGeneral = bdreserva.consultaEstandar(fecha1, fecha2);
        if (listaDatos.isEmpty()) {
            for (int i = 0; i < listaGeneral.size(); i++) {
                int tama = listaDatos.size();
                if ((listaGeneral.get(i).getMascota().equals("Permitido") || listaGeneral.get(i).getMascota().equals("Prohibido")) && tama == 0) {
                    listaDatos.add(new objConsultaReserva(listaGeneral.get(i).getId(), listaGeneral.get(i).getPlanta(),
                            listaGeneral.get(i).getNombre(), listaGeneral.get(i).getMascota()));
                } else if (tama == 1 && listaDatos.get(0).getMascota().equals("Prohibido")) {
                    if (listaGeneral.get(i).getMascota().equals("Permitido")) {
                        listaDatos.add(new objConsultaReserva(listaGeneral.get(i).getId(), listaGeneral.get(i).getPlanta(),
                                listaGeneral.get(i).getNombre(), listaGeneral.get(i).getMascota()));
                        //break;
                    }
                } else if (tama == 1 && listaDatos.get(0).getMascota().equals("Permitido")) {
                    if (listaGeneral.get(i).getMascota().equals("Prohibido")) {
                        listaDatos.add(new objConsultaReserva(listaGeneral.get(i).getId(), listaGeneral.get(i).getPlanta(),
                                listaGeneral.get(i).getNombre(), listaGeneral.get(i).getMascota()));
                        //break;
                    }
                }
            }
        }
        return listaDatos;
    }

    public ArrayList<objConsultaReserva> EstadarSinMascota2(String fecha1, String fecha2) { //2 Junior sin acceso a mascota
        ArrayList<objConsultaReserva> listaDatos = new ArrayList<>();
        //int tama = listaDatos.size();
        ArrayList<objConsultaReserva> listaGeneral = bdreserva.consultaEstandar(fecha1, fecha2);
        for (int i = 0; i < listaGeneral.size(); i++) {
            int tama = listaDatos.size();
            if (listaGeneral.get(i).getMascota().equals("Prohibido") && listaGeneral.get(i).getNombre().equals("Estandar") && tama < 2) {
                listaDatos.add(new objConsultaReserva(listaGeneral.get(i).getId(), listaGeneral.get(i).getPlanta(),
                        listaGeneral.get(i).getNombre(), listaGeneral.get(i).getMascota()));
            }
        }
        return listaDatos;
    }

    public ArrayList<objConsultaReserva> EstanJuniMascota(String fecha1, String fecha2) { //1 Junior con mascota y 1 Estandar sin mascota O 1 Estandar con mascota y 1 Junior sin mascota
        ArrayList<objConsultaReserva> listaDatos = new ArrayList<>();
        ArrayList<objConsultaReserva> listaGeneral = bdreserva.consultaEstandarJunior(fecha1, fecha2);
        if (listaDatos.isEmpty()) {
            for (int i = 0; i < listaGeneral.size(); i++) {
                int tama = listaDatos.size();
                if ((listaGeneral.get(i).getNombre().equals("Junior") || listaGeneral.get(i).getNombre().equals("Estandar"))
                        && (listaGeneral.get(i).getMascota().equals("Permitido") || listaGeneral.get(i).getMascota().equals("Prohibido")) && (tama == 0)) {
                    listaDatos.add(new objConsultaReserva(listaGeneral.get(i).getId(), listaGeneral.get(i).getPlanta(),
                            listaGeneral.get(i).getNombre(), listaGeneral.get(i).getMascota()));
                } else if (listaDatos.get(0).getNombre().equals("Junior") && listaDatos.get(0).getMascota().equals("Permitido")) {
                    if ((listaGeneral.get(i).getNombre().equals("Estandar") && listaGeneral.get(i).getMascota().equals("Prohibido")) && (tama == 1)) {
                        listaDatos.add(new objConsultaReserva(listaGeneral.get(i).getId(), listaGeneral.get(i).getPlanta(),
                                listaGeneral.get(i).getNombre(), listaGeneral.get(i).getMascota()));
                    }
                } else if (listaDatos.get(0).getNombre().equals("Junior") && listaDatos.get(0).getMascota().equals("Prohibido")) {
                    if ((listaGeneral.get(i).getNombre().equals("Estandar") && listaGeneral.get(i).getMascota().equals("Permitido")) && (tama == 1)) {
                        listaDatos.add(new objConsultaReserva(listaGeneral.get(i).getId(), listaGeneral.get(i).getPlanta(),
                                listaGeneral.get(i).getNombre(), listaGeneral.get(i).getMascota()));
                    }
                } else if (listaDatos.get(0).getNombre().equals("Estandar") && listaDatos.get(0).getMascota().equals("Permitido")) {
                    if ((listaGeneral.get(i).getNombre().equals("Junior") && listaGeneral.get(i).getMascota().equals("Prohibido")) && (tama == 1)) {
                        listaDatos.add(new objConsultaReserva(listaGeneral.get(i).getId(), listaGeneral.get(i).getPlanta(),
                                listaGeneral.get(i).getNombre(), listaGeneral.get(i).getMascota()));
                    }
                } else if (listaDatos.get(0).getNombre().equals("Estandar") && listaDatos.get(0).getMascota().equals("Prohibido")) {
                    if ((listaGeneral.get(i).getNombre().equals("Junior") && listaGeneral.get(i).getMascota().equals("Permitido")) && (tama == 1)) {
                        listaDatos.add(new objConsultaReserva(listaGeneral.get(i).getId(), listaGeneral.get(i).getPlanta(),
                                listaGeneral.get(i).getNombre(), listaGeneral.get(i).getMascota()));
                    }
                }
            }
        }
        return listaDatos;
    }

    public ArrayList<objConsultaReserva> EstanJuniSinMascota(String fecha1, String fecha2) { // 1 Junior y 1 Estandar sin mascota
        ArrayList<objConsultaReserva> listaDatos = new ArrayList<>();
        ArrayList<objConsultaReserva> listaGeneral = bdreserva.consultaEstandarJunior(fecha1, fecha2);
        if (listaDatos.isEmpty()) {
            for (int i = 0; i < listaGeneral.size(); i++) {
                int tama = listaDatos.size();
                if ((listaGeneral.get(i).getNombre().equals("Junior") || listaGeneral.get(i).getNombre().equals("Estandar"))
                        && (listaGeneral.get(i).getMascota().equals("Prohibido")) && (tama == 0)) {
                    listaDatos.add(new objConsultaReserva(listaGeneral.get(i).getId(), listaGeneral.get(i).getPlanta(),
                            listaGeneral.get(i).getNombre(), listaGeneral.get(i).getMascota()));
                }
                if (!listaDatos.isEmpty()) {
                    if (listaDatos.get(0).getNombre().equals("Junior") && listaDatos.get(0).getMascota().equals("Prohibido")) {
                        if ((listaGeneral.get(i).getNombre().equals("Estandar") && listaGeneral.get(i).getMascota().equals("Prohibido")) && (tama == 1)) {
                            listaDatos.add(new objConsultaReserva(listaGeneral.get(i).getId(), listaGeneral.get(i).getPlanta(),
                                    listaGeneral.get(i).getNombre(), listaGeneral.get(i).getMascota()));
                        }
                    } else if (listaDatos.get(0).getNombre().equals("Estandar") && listaDatos.get(0).getMascota().equals("Prohibido")) {
                        if ((listaGeneral.get(i).getNombre().equals("Junior") && listaGeneral.get(i).getMascota().equals("Prohibido")) && (tama == 1)) {
                            listaDatos.add(new objConsultaReserva(listaGeneral.get(i).getId(), listaGeneral.get(i).getPlanta(),
                                    listaGeneral.get(i).getNombre(), listaGeneral.get(i).getMascota()));
                        }
                    }
                }
            }
        }
        return listaDatos;
    }

    public ArrayList<objConsultaReserva> superiorMascota(String fecha1, String fecha2) {// 1 Superior con mascota
        ArrayList<objConsultaReserva> listaDatos = new ArrayList<>();
        ArrayList<objConsultaReserva> listaGeneral = bdreserva.consultaSuperior(fecha1, fecha2);
        if (listaDatos.isEmpty()) {
            for (int i = 0; i < listaGeneral.size(); i++) {
                int tama = listaDatos.size();
                if ((listaGeneral.get(i).getNombre().equals("Superior") && listaGeneral.get(i).getMascota().equals("Permitido")) && (tama == 0)) {
                    listaDatos.add(new objConsultaReserva(listaGeneral.get(i).getId(), listaGeneral.get(i).getPlanta(),
                            listaGeneral.get(i).getNombre(), listaGeneral.get(i).getMascota()));
                    break;
                }
            }
        }
        return listaDatos;
    }

    public ArrayList<objConsultaReserva> superiorSinMascota1(String fecha1, String fecha2) {// 1 Superior sin mascota
        ArrayList<objConsultaReserva> listaDatos = new ArrayList<>();
        ArrayList<objConsultaReserva> listaGeneral = bdreserva.consultaSuperior(fecha1, fecha2);
        for (int i = 0; i < listaGeneral.size(); i++) {
            int tama = listaDatos.size();
            if ((listaGeneral.get(i).getNombre().equals("Superior") && listaGeneral.get(i).getMascota().equals("Prohibido")) && (tama == 0)) {
                listaDatos.add(new objConsultaReserva(listaGeneral.get(i).getId(), listaGeneral.get(i).getPlanta(),
                        listaGeneral.get(i).getNombre(), listaGeneral.get(i).getMascota()));
                break;
            }
        }
        return listaDatos;
    }

    public ArrayList<objConsultaReserva> SuperJuniMascota(String fecha1, String fecha2) { //1 Superior con mascota y 1 Junior sin mascota O 1 Junior con mascota y 1 Superior sin mascota
        ArrayList<objConsultaReserva> listaDatos = new ArrayList<>();
        ArrayList<objConsultaReserva> listaGeneral = bdreserva.consultaSuperiorJunior(fecha1, fecha2);
        if (listaDatos.isEmpty()) {
            for (int i = 0; i < listaGeneral.size(); i++) {
                int tama = listaDatos.size();
                if ((listaGeneral.get(i).getNombre().equals("Junior") || listaGeneral.get(i).getNombre().equals("Superior"))
                        && (listaGeneral.get(i).getMascota().equals("Permitido") || listaGeneral.get(i).getMascota().equals("Prohibido")) && (tama == 0)) {
                    listaDatos.add(new objConsultaReserva(listaGeneral.get(i).getId(), listaGeneral.get(i).getPlanta(),
                            listaGeneral.get(i).getNombre(), listaGeneral.get(i).getMascota()));
                } else if (listaDatos.get(0).getNombre().equals("Junior") && listaDatos.get(0).getMascota().equals("Permitido")) {
                    if ((listaGeneral.get(i).getNombre().equals("Superior") && listaGeneral.get(i).getMascota().equals("Prohibido")) && (tama == 1)) {
                        listaDatos.add(new objConsultaReserva(listaGeneral.get(i).getId(), listaGeneral.get(i).getPlanta(),
                                listaGeneral.get(i).getNombre(), listaGeneral.get(i).getMascota()));
                    }
                } else if (listaDatos.get(0).getNombre().equals("Junior") && listaDatos.get(0).getMascota().equals("Prohibido")) {
                    if ((listaGeneral.get(i).getNombre().equals("Superior") && listaGeneral.get(i).getMascota().equals("Permitido")) && (tama == 1)) {
                        listaDatos.add(new objConsultaReserva(listaGeneral.get(i).getId(), listaGeneral.get(i).getPlanta(),
                                listaGeneral.get(i).getNombre(), listaGeneral.get(i).getMascota()));
                    }
                } else if (listaDatos.get(0).getNombre().equals("Superior") && listaDatos.get(0).getMascota().equals("Permitido")) {
                    if ((listaGeneral.get(i).getNombre().equals("Junior") && listaGeneral.get(i).getMascota().equals("Prohibido")) && (tama == 1)) {
                        listaDatos.add(new objConsultaReserva(listaGeneral.get(i).getId(), listaGeneral.get(i).getPlanta(),
                                listaGeneral.get(i).getNombre(), listaGeneral.get(i).getMascota()));
                    }
                } else if (listaDatos.get(0).getNombre().equals("Superior") && listaDatos.get(0).getMascota().equals("Prohibido")) {
                    if ((listaGeneral.get(i).getNombre().equals("Junior") && listaGeneral.get(i).getMascota().equals("Permitido")) && (tama == 1)) {
                        listaDatos.add(new objConsultaReserva(listaGeneral.get(i).getId(), listaGeneral.get(i).getPlanta(),
                                listaGeneral.get(i).getNombre(), listaGeneral.get(i).getMascota()));
                    }
                }
            }
        }
        return listaDatos;
    }

    public ArrayList<objConsultaReserva> SuperJuniSinMascota(String fecha1, String fecha2) { // 1 Junior y 1 Estandar sin mascota
        ArrayList<objConsultaReserva> listaDatos = new ArrayList<>();
        ArrayList<objConsultaReserva> listaGeneral = bdreserva.consultaSuperiorJunior(fecha1, fecha2);
        if (listaDatos.isEmpty()) {
            for (int i = 0; i < listaGeneral.size(); i++) {
                int tama = listaDatos.size();
                if ((listaGeneral.get(i).getNombre().equals("Junior") || listaGeneral.get(i).getNombre().equals("Superior"))
                        && (listaGeneral.get(i).getMascota().equals("Prohibido")) && (tama == 0)) {
                    listaDatos.add(new objConsultaReserva(listaGeneral.get(i).getId(), listaGeneral.get(i).getPlanta(),
                            listaGeneral.get(i).getNombre(), listaGeneral.get(i).getMascota()));
                }
                if (!listaDatos.isEmpty()) {
                    if (listaDatos.get(0).getNombre().equals("Junior") && listaDatos.get(0).getMascota().equals("Prohibido")) {
                        if ((listaGeneral.get(i).getNombre().equals("Superior") && listaGeneral.get(i).getMascota().equals("Prohibido")) && (tama == 1)) {
                            listaDatos.add(new objConsultaReserva(listaGeneral.get(i).getId(), listaGeneral.get(i).getPlanta(),
                                    listaGeneral.get(i).getNombre(), listaGeneral.get(i).getMascota()));
                        }
                    } else if (listaDatos.get(0).getNombre().equals("Superior") && listaDatos.get(0).getMascota().equals("Prohibido")) {
                        if ((listaGeneral.get(i).getNombre().equals("Junior") && listaGeneral.get(i).getMascota().equals("Prohibido")) && (tama == 1)) {
                            listaDatos.add(new objConsultaReserva(listaGeneral.get(i).getId(), listaGeneral.get(i).getPlanta(),
                                    listaGeneral.get(i).getNombre(), listaGeneral.get(i).getMascota()));
                        }
                    }
                }
            }
        }
        return listaDatos;
    }

    public ArrayList<objConsultaReserva> EstanSuperMascota(String fecha1, String fecha2) { //1 Junior con mascota y 1 Estandar sin mascota O 1 Estandar con mascota y 1 Junior sin mascota
        ArrayList<objConsultaReserva> listaDatos = new ArrayList<>();
        ArrayList<objConsultaReserva> listaGeneral = bdreserva.consultaEstandarJunior(fecha1, fecha2);
        if (listaDatos.isEmpty()) {
            for (int i = 0; i < listaGeneral.size(); i++) {
                int tama = listaDatos.size();
                if ((listaGeneral.get(i).getNombre().equals("Superior") || listaGeneral.get(i).getNombre().equals("Estandar"))
                        && (listaGeneral.get(i).getMascota().equals("Permitido") || listaGeneral.get(i).getMascota().equals("Prohibido")) && (tama == 0)) {
                    listaDatos.add(new objConsultaReserva(listaGeneral.get(i).getId(), listaGeneral.get(i).getPlanta(),
                            listaGeneral.get(i).getNombre(), listaGeneral.get(i).getMascota()));
                } else if (listaDatos.get(0).getNombre().equals("Superior") && listaDatos.get(0).getMascota().equals("Permitido")) {
                    if ((listaGeneral.get(i).getNombre().equals("Estandar") && listaGeneral.get(i).getMascota().equals("Prohibido")) && (tama == 1)) {
                        listaDatos.add(new objConsultaReserva(listaGeneral.get(i).getId(), listaGeneral.get(i).getPlanta(),
                                listaGeneral.get(i).getNombre(), listaGeneral.get(i).getMascota()));
                    }
                } else if (listaDatos.get(0).getNombre().equals("Superior") && listaDatos.get(0).getMascota().equals("Prohibido")) {
                    if ((listaGeneral.get(i).getNombre().equals("Estandar") && listaGeneral.get(i).getMascota().equals("Permitido")) && (tama == 1)) {
                        listaDatos.add(new objConsultaReserva(listaGeneral.get(i).getId(), listaGeneral.get(i).getPlanta(),
                                listaGeneral.get(i).getNombre(), listaGeneral.get(i).getMascota()));
                    }
                } else if (listaDatos.get(0).getNombre().equals("Estandar") && listaDatos.get(0).getMascota().equals("Permitido")) {
                    if ((listaGeneral.get(i).getNombre().equals("Superior") && listaGeneral.get(i).getMascota().equals("Prohibido")) && (tama == 1)) {
                        listaDatos.add(new objConsultaReserva(listaGeneral.get(i).getId(), listaGeneral.get(i).getPlanta(),
                                listaGeneral.get(i).getNombre(), listaGeneral.get(i).getMascota()));
                    }
                } else if (listaDatos.get(0).getNombre().equals("Estandar") && listaDatos.get(0).getMascota().equals("Prohibido")) {
                    if ((listaGeneral.get(i).getNombre().equals("Superior") && listaGeneral.get(i).getMascota().equals("Permitido")) && (tama == 1)) {
                        listaDatos.add(new objConsultaReserva(listaGeneral.get(i).getId(), listaGeneral.get(i).getPlanta(),
                                listaGeneral.get(i).getNombre(), listaGeneral.get(i).getMascota()));
                    }
                }
            }
        }
        return listaDatos;
    }

    public ArrayList<objConsultaReserva> EstanSuperSinMascota(String fecha1, String fecha2) { // 1 Junior y 1 Estandar sin mascota
        ArrayList<objConsultaReserva> listaDatos = new ArrayList<>();
        ArrayList<objConsultaReserva> listaGeneral = bdreserva.consultaEstandarJunior(fecha1, fecha2);
        if (listaDatos.isEmpty()) {
            for (int i = 0; i < listaGeneral.size(); i++) {
                int tama = listaDatos.size();
                if ((listaGeneral.get(i).getNombre().equals("Superior") || listaGeneral.get(i).getNombre().equals("Estandar"))
                        && (listaGeneral.get(i).getMascota().equals("Prohibido")) && (tama == 0)) {
                    listaDatos.add(new objConsultaReserva(listaGeneral.get(i).getId(), listaGeneral.get(i).getPlanta(),
                            listaGeneral.get(i).getNombre(), listaGeneral.get(i).getMascota()));
                }
                if (!listaDatos.isEmpty()) {
                    if (listaDatos.get(0).getNombre().equals("Superior") && listaDatos.get(0).getMascota().equals("Prohibido")) {
                        if ((listaGeneral.get(i).getNombre().equals("Estandar") && listaGeneral.get(i).getMascota().equals("Prohibido")) && (tama == 1)) {
                            listaDatos.add(new objConsultaReserva(listaGeneral.get(i).getId(), listaGeneral.get(i).getPlanta(),
                                    listaGeneral.get(i).getNombre(), listaGeneral.get(i).getMascota()));
                        }
                    } else if (listaDatos.get(0).getNombre().equals("Estandar") && listaDatos.get(0).getMascota().equals("Prohibido")) {
                        if ((listaGeneral.get(i).getNombre().equals("Superior") && listaGeneral.get(i).getMascota().equals("Prohibido")) && (tama == 1)) {
                            listaDatos.add(new objConsultaReserva(listaGeneral.get(i).getId(), listaGeneral.get(i).getPlanta(),
                                    listaGeneral.get(i).getNombre(), listaGeneral.get(i).getMascota()));
                        }
                    }
                }
            }
        }
        return listaDatos;
    }

    public ArrayList<objConsultaReserva> Estan2Juni1Mascota(String fecha1, String fecha2) { //1 Junior con mascota y 1 Estandar sin mascota O 1 Estandar con mascota y 1 Junior sin mascota
        ArrayList<objConsultaReserva> listaDatos = new ArrayList<>();
        ArrayList<objConsultaReserva> listaGeneral = bdreserva.consultaEstandarJunior(fecha1, fecha2);
        if (listaDatos.isEmpty()) {
            for (int i = 0; i < listaGeneral.size(); i++) {
                int tama = listaDatos.size();
                //4,6
                if ((listaGeneral.get(i).getNombre().equals("Junior") && listaGeneral.get(i).getMascota().equals("Prohibido")) && (tama == 0)) {
                    listaDatos.add(new objConsultaReserva(listaGeneral.get(i).getId(), listaGeneral.get(i).getPlanta(),
                            listaGeneral.get(i).getNombre(), listaGeneral.get(i).getMascota()));
                } //7
                else if ((listaGeneral.get(i).getNombre().equals("Junior") && listaGeneral.get(i).getMascota().equals("Permitido")) && (tama == 0)) {
                    listaDatos.add(new objConsultaReserva(listaGeneral.get(i).getId(), listaGeneral.get(i).getPlanta(),
                            listaGeneral.get(i).getNombre(), listaGeneral.get(i).getMascota()));
                }//1,2
                else if ((listaGeneral.get(i).getNombre().equals("Estandar") && listaGeneral.get(i).getMascota().equals("Permitido")) && (tama == 0)) {
                    listaDatos.add(new objConsultaReserva(listaGeneral.get(i).getId(), listaGeneral.get(i).getPlanta(),
                            listaGeneral.get(i).getNombre(), listaGeneral.get(i).getMascota()));
                } //3,5,8,9
                else if ((listaGeneral.get(i).getNombre().equals("Estandar") && listaGeneral.get(i).getMascota().equals("Prohibido")) && (tama == 0)) {
                    listaDatos.add(new objConsultaReserva(listaGeneral.get(i).getId(), listaGeneral.get(i).getPlanta(),
                            listaGeneral.get(i).getNombre(), listaGeneral.get(i).getMascota()));
                } else if (listaDatos.size() == 1) { //------------
                    //1
                    if (listaDatos.get(0).getNombre().equals("Estandar") && listaDatos.get(0).getMascota().equals("Permitido")) {
                        if ((listaGeneral.get(i).getNombre().equals("Estandar") && listaGeneral.get(i).getMascota().equals("Prohibido")) && (tama == 1)) {
                            listaDatos.add(new objConsultaReserva(listaGeneral.get(i).getId(), listaGeneral.get(i).getPlanta(),
                                    listaGeneral.get(i).getNombre(), listaGeneral.get(i).getMascota()));
                        }
                    } //3
                    else if (listaDatos.get(0).getNombre().equals("Estandar") && listaDatos.get(0).getMascota().equals("Prohibido")) {
                        if ((listaGeneral.get(i).getNombre().equals("Estandar") && listaGeneral.get(i).getMascota().equals("Permitido")) && (tama == 1)) {
                            listaDatos.add(new objConsultaReserva(listaGeneral.get(i).getId(), listaGeneral.get(i).getPlanta(),
                                    listaGeneral.get(i).getNombre(), listaGeneral.get(i).getMascota()));
                        }
                    } //8
                    else if (listaDatos.get(0).getNombre().equals("Estandar") && listaDatos.get(0).getMascota().equals("Prohibido")) {
                        if ((listaGeneral.get(i).getNombre().equals("Junior") && listaGeneral.get(i).getMascota().equals("Permitido")) && (tama == 1)) {
                            listaDatos.add(new objConsultaReserva(listaGeneral.get(i).getId(), listaGeneral.get(i).getPlanta(),
                                    listaGeneral.get(i).getNombre(), listaGeneral.get(i).getMascota()));
                        }
                    } //7
                    else if (listaDatos.get(0).getNombre().equals("Junior") && listaDatos.get(0).getMascota().equals("Permitido")) {
                        if ((listaGeneral.get(i).getNombre().equals("Estandar") && listaGeneral.get(i).getMascota().equals("Prohibido")) && (tama == 1)) {
                            listaDatos.add(new objConsultaReserva(listaGeneral.get(i).getId(), listaGeneral.get(i).getPlanta(),
                                    listaGeneral.get(i).getNombre(), listaGeneral.get(i).getMascota()));
                        }
                    } //4
                    else if (listaDatos.get(0).getNombre().equals("Junior") && listaDatos.get(0).getMascota().equals("Prohibido")) {
                        if ((listaGeneral.get(i).getNombre().equals("Estandar") && listaGeneral.get(i).getMascota().equals("Permitido")) && (tama == 1)) {
                            listaDatos.add(new objConsultaReserva(listaGeneral.get(i).getId(), listaGeneral.get(i).getPlanta(),
                                    listaGeneral.get(i).getNombre(), listaGeneral.get(i).getMascota()));
                        }
                    } //2,5
                    else if (listaDatos.get(0).getNombre().equals("Estandar") && listaDatos.get(0).getMascota().equals("Permitido")) {
                        if ((listaGeneral.get(i).getNombre().equals("Junior") && listaGeneral.get(i).getMascota().equals("Prohibido")) && (tama == 1)) {
                            listaDatos.add(new objConsultaReserva(listaGeneral.get(i).getId(), listaGeneral.get(i).getPlanta(),
                                    listaGeneral.get(i).getNombre(), listaGeneral.get(i).getMascota()));
                        }
                    } //9
                    else if (listaDatos.get(0).getNombre().equals("Estandar") && listaDatos.get(0).getMascota().equals("Prohibido")) {
                        if ((listaGeneral.get(i).getNombre().equals("Estandar") && listaGeneral.get(i).getMascota().equals("Prohibido")) && (tama == 1)) {
                            listaDatos.add(new objConsultaReserva(listaGeneral.get(i).getId(), listaGeneral.get(i).getPlanta(),
                                    listaGeneral.get(i).getNombre(), listaGeneral.get(i).getMascota()));
                        }
                    }//6
                    else if (listaDatos.get(0).getNombre().equals("Junior") && listaDatos.get(0).getMascota().equals("Prohibido")) {
                        if ((listaGeneral.get(i).getNombre().equals("Estandar") && listaGeneral.get(i).getMascota().equals("Prohibido")) && (tama == 1)) {
                            listaDatos.add(new objConsultaReserva(listaGeneral.get(i).getId(), listaGeneral.get(i).getPlanta(),
                                    listaGeneral.get(i).getNombre(), listaGeneral.get(i).getMascota()));
                        }
                    }
                } else if (listaDatos.size() == 2) {//-------------
                    //3
                    if (listaDatos.get(1).getNombre().equals("Estandar") && listaDatos.get(1).getMascota().equals("Permitido")) {
                        if ((listaGeneral.get(i).getNombre().equals("Junior") && listaGeneral.get(i).getMascota().equals("Prohibido")) && (tama == 2)) {
                            listaDatos.add(new objConsultaReserva(listaGeneral.get(i).getId(), listaGeneral.get(i).getPlanta(),
                                    listaGeneral.get(i).getNombre(), listaGeneral.get(i).getMascota()));
                        }
                    } //7
                    else if (listaDatos.get(1).getNombre().equals("Estandar") && listaDatos.get(1).getMascota().equals("Prohibido")) {
                        if ((listaGeneral.get(i).getNombre().equals("Estandar") && listaGeneral.get(i).getMascota().equals("Prohibido")) && (tama == 2)) {
                            listaDatos.add(new objConsultaReserva(listaGeneral.get(i).getId(), listaGeneral.get(i).getPlanta(),
                                    listaGeneral.get(i).getNombre(), listaGeneral.get(i).getMascota()));
                        }
                    } //1
                    else if (listaDatos.get(1).getNombre().equals("Estandar") && listaDatos.get(1).getMascota().equals("Prohibido")) {
                        if ((listaGeneral.get(i).getNombre().equals("Junior") && listaGeneral.get(i).getMascota().equals("Prohibido")) && (tama == 2)) {
                            listaDatos.add(new objConsultaReserva(listaGeneral.get(i).getId(), listaGeneral.get(i).getPlanta(),
                                    listaGeneral.get(i).getNombre(), listaGeneral.get(i).getMascota()));
                        }
                    } //2
                    else if (listaDatos.get(1).getNombre().equals("Junior") && listaDatos.get(1).getMascota().equals("Prohibido")) {
                        if ((listaGeneral.get(i).getNombre().equals("Estandar") && listaGeneral.get(i).getMascota().equals("Prohibido")) && (tama == 2)) {
                            listaDatos.add(new objConsultaReserva(listaGeneral.get(i).getId(), listaGeneral.get(i).getPlanta(),
                                    listaGeneral.get(i).getNombre(), listaGeneral.get(i).getMascota()));
                        }
                    } //4
                    else if (listaDatos.get(1).getNombre().equals("Estandar") && listaDatos.get(1).getMascota().equals("Permitido")) {
                        if ((listaGeneral.get(i).getNombre().equals("Estandar") && listaGeneral.get(i).getMascota().equals("Prohibido")) && (tama == 2)) {
                            listaDatos.add(new objConsultaReserva(listaGeneral.get(i).getId(), listaGeneral.get(i).getPlanta(),
                                    listaGeneral.get(i).getNombre(), listaGeneral.get(i).getMascota()));
                        }
                    } //5
                    else if (listaDatos.get(1).getNombre().equals("Junior") && listaDatos.get(1).getMascota().equals("Prohibido")) {
                        if ((listaGeneral.get(i).getNombre().equals("Estandar") && listaGeneral.get(i).getMascota().equals("Permitido")) && (tama == 2)) {
                            listaDatos.add(new objConsultaReserva(listaGeneral.get(i).getId(), listaGeneral.get(i).getPlanta(),
                                    listaGeneral.get(i).getNombre(), listaGeneral.get(i).getMascota()));
                        }
                    } //6
                    else if (listaDatos.get(1).getNombre().equals("Estandar") && listaDatos.get(1).getMascota().equals("Prohibido")) {
                        if ((listaGeneral.get(i).getNombre().equals("Estandar") && listaGeneral.get(i).getMascota().equals("Permitido")) && (tama == 2)) {
                            listaDatos.add(new objConsultaReserva(listaGeneral.get(i).getId(), listaGeneral.get(i).getPlanta(),
                                    listaGeneral.get(i).getNombre(), listaGeneral.get(i).getMascota()));
                        }
                    } //8
                    else if (listaDatos.get(1).getNombre().equals("Junior") && listaDatos.get(1).getMascota().equals("Permitido")) {
                        if ((listaGeneral.get(i).getNombre().equals("Estandar") && listaGeneral.get(i).getMascota().equals("Prohibido")) && (tama == 2)) {
                            listaDatos.add(new objConsultaReserva(listaGeneral.get(i).getId(), listaGeneral.get(i).getPlanta(),
                                    listaGeneral.get(i).getNombre(), listaGeneral.get(i).getMascota()));
                        }
                    } //9
                    else if (listaDatos.get(1).getNombre().equals("Estandar") && listaDatos.get(1).getMascota().equals("Prohibido")) {
                        if ((listaGeneral.get(i).getNombre().equals("Junior") && listaGeneral.get(i).getMascota().equals("Permitido")) && (tama == 2)) {
                            listaDatos.add(new objConsultaReserva(listaGeneral.get(i).getId(), listaGeneral.get(i).getPlanta(),
                                    listaGeneral.get(i).getNombre(), listaGeneral.get(i).getMascota()));
                        }
                    }
                }
            }
        }
        return listaDatos;
    }

    public ArrayList<objConsultaReserva> Estan2Juni1SinMascota(String fecha1, String fecha2) { //1 Junior con mascota y 1 Estandar sin mascota O 1 Estandar con mascota y 1 Junior sin mascota
        ArrayList<objConsultaReserva> listaDatos = new ArrayList<>();
        ArrayList<objConsultaReserva> listaGeneral = bdreserva.consultaEstandarJunior(fecha1, fecha2);
        if (listaDatos.isEmpty()) {
            for (int i = 0; i < listaGeneral.size(); i++) {
                int tama = listaDatos.size();
                if (listaDatos.isEmpty()) {
                    //3
                    if ((listaGeneral.get(i).getNombre().equals("Junior") && listaGeneral.get(i).getMascota().equals("Prohibido")) && (tama == 0)) {
                        listaDatos.add(new objConsultaReserva(listaGeneral.get(i).getId(), listaGeneral.get(i).getPlanta(),
                                listaGeneral.get(i).getNombre(), listaGeneral.get(i).getMascota()));
                    }//1,2
                    else if ((listaGeneral.get(i).getNombre().equals("Estandar") && listaGeneral.get(i).getMascota().equals("Prohibido")) && (tama == 0)) {
                        listaDatos.add(new objConsultaReserva(listaGeneral.get(i).getId(), listaGeneral.get(i).getPlanta(),
                                listaGeneral.get(i).getNombre(), listaGeneral.get(i).getMascota()));
                    }
                } else if (listaDatos.size() == 1) { //------------
                    //1
                    if (listaDatos.get(0).getNombre().equals("Estandar") && listaDatos.get(0).getMascota().equals("Prohibido")) {
                        if ((listaGeneral.get(i).getNombre().equals("Estandar") && listaGeneral.get(i).getMascota().equals("Prohibido")) && (tama == 1)) {
                            listaDatos.add(new objConsultaReserva(listaGeneral.get(i).getId(), listaGeneral.get(i).getPlanta(),
                                    listaGeneral.get(i).getNombre(), listaGeneral.get(i).getMascota()));
                        }
                    } //3
                    if (listaDatos.get(0).getNombre().equals("Estandar") && listaDatos.get(0).getMascota().equals("Prohibido")) {
                        if ((listaGeneral.get(i).getNombre().equals("Junior") && listaGeneral.get(i).getMascota().equals("Prohibido")) && (tama == 1)) {
                            listaDatos.add(new objConsultaReserva(listaGeneral.get(i).getId(), listaGeneral.get(i).getPlanta(),
                                    listaGeneral.get(i).getNombre(), listaGeneral.get(i).getMascota()));
                        }
                    } //1
                    if (listaDatos.get(0).getNombre().equals("Junior") && listaDatos.get(0).getMascota().equals("Prohibido")) {
                        if ((listaGeneral.get(i).getNombre().equals("Estandar") && listaGeneral.get(i).getMascota().equals("Prohibido")) && (tama == 1)) {
                            listaDatos.add(new objConsultaReserva(listaGeneral.get(i).getId(), listaGeneral.get(i).getPlanta(),
                                    listaGeneral.get(i).getNombre(), listaGeneral.get(i).getMascota()));
                        }
                    }
                } else if (listaDatos.size() == 2) {//-------------
                    //3
                    if (listaDatos.get(1).getNombre().equals("Estandar") && listaDatos.get(1).getMascota().equals("Prohibido")) {
                        if ((listaGeneral.get(i).getNombre().equals("Estandar") && listaGeneral.get(i).getMascota().equals("Prohibido")) && (tama == 2)) {
                            listaDatos.add(new objConsultaReserva(listaGeneral.get(i).getId(), listaGeneral.get(i).getPlanta(),
                                    listaGeneral.get(i).getNombre(), listaGeneral.get(i).getMascota()));
                        }
                    } //1
                    else if (listaDatos.get(1).getNombre().equals("Estandar") && listaDatos.get(1).getMascota().equals("Prohibido")) {
                        if ((listaGeneral.get(i).getNombre().equals("Junior") && listaGeneral.get(i).getMascota().equals("Prohibido")) && (tama == 2)) {
                            listaDatos.add(new objConsultaReserva(listaGeneral.get(i).getId(), listaGeneral.get(i).getPlanta(),
                                    listaGeneral.get(i).getNombre(), listaGeneral.get(i).getMascota()));
                        }
                    } //2
                    else if (listaDatos.get(1).getNombre().equals("Junior") && listaDatos.get(1).getMascota().equals("Prohibido")) {
                        if ((listaGeneral.get(i).getNombre().equals("Estandar") && listaGeneral.get(i).getMascota().equals("Prohibido")) && (tama == 2)) {
                            listaDatos.add(new objConsultaReserva(listaGeneral.get(i).getId(), listaGeneral.get(i).getPlanta(),
                                    listaGeneral.get(i).getNombre(), listaGeneral.get(i).getMascota()));
                        }
                    }
                }
            }
        }
        return listaDatos;
    }

    public ArrayList<objConsultaReserva> habitacionesMascota(String fecha1, String fecha2) {
        ArrayList<objConsultaReserva> listaGeneral = bdreserva.todaHabitMascota(fecha1, fecha2);
        return listaGeneral;
    }

    public ArrayList<objConsultaReserva> habitacionesSinMascota(String fecha1, String fecha2) {
        ArrayList<objConsultaReserva> listaGeneral = bdreserva.todasSinMascota(fecha1, fecha2);
        return listaGeneral;
    }

    public ArrayList<objConsultaReserva> todasHabitaciones(String fecha1, String fecha2) {
        ArrayList<objConsultaReserva> listaGeneral = bdreserva.TodasHabit(fecha1, fecha2);
        return listaGeneral;
    }

}
