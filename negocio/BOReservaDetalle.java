package negocio;

import datos.BDReservaPrueba;
import java.util.ArrayList;
import javax.swing.JTextArea;
import objetos.objConsultaReserva;
import objetos.objmonto;

/**
 *
 * @author yasni
 */
public class BOReservaDetalle {

    BDReservaPrueba dbreserva = new BDReservaPrueba();

    int monTotalH1, monTotalH2, monTotalH3 = 0;

    public BOReservaDetalle() {
    }

    int dias = 0;
    int montoNocheH1, montoNocheH2, montoNocheH3 = 0;
    String nomHab1, nomHab2, nomHab3 = "";
    int montoTodasHab = 0;
    int porcenPlantaHab1, porcenPlantaHab2, porcenPlantaHab3;
    String nomPlantaHab1, nomPlantaHab2, nomPlantaHab3;
    int totalPorcenPlantaHab1 = 0;

    int totalMascota, totalPagar = 0;

    int monHab1, monHab2, monHab3 = 0;
    //String nomHab1, nomHab2, nomHab3 = "";
    int monPlan1, monPlan2, monPlan3 = 0;
    String nomPlan1, nomPlan2, nomPlan3 = "";
    int porPlan1, porPlan2, porPlan3 = 0;
    int porPlanta1 = 15, porPlanta2 = 10, porPlanta3 = 5, porMascota = 25;

    public void detalle1HabitMasco(ArrayList<objConsultaReserva> listaDatos, JTextArea areaTexto, String fecha1, String fecha2) {
        int tamano = listaDatos.size();
        double dia;
        dia = dbreserva.consultadias(fecha1, fecha2);
        if (tamano == 1) {
            areaTexto.setText("");
            if (listaDatos.get(0).getPlanta().equals("Planta 1") && listaDatos.get(0).getNombre().equals("Junior") && listaDatos.get(0).getMascota().equals("Permitido")) {
                areaTexto.setText("");
                nomHab1 = listaDatos.get(0).getNombre();
                nomPlantaHab1 = listaDatos.get(0).getPlanta();
                dias = (int) dia;
                montoNocheH1 = 80;
                monTotalH1 = montoNocheH1 * dias;
                montoTodasHab = monTotalH1;
                porcenPlantaHab1 = (montoTodasHab * porPlanta1) / 100;
                totalMascota = (montoTodasHab * porMascota) / 100;
                totalPagar = montoTodasHab + porcenPlantaHab1 + totalMascota;
                tAreaHat1Mas(montoNocheH1, dias, monTotalH1, montoTodasHab, porPlanta1, porcenPlantaHab1, porMascota, totalMascota, totalPagar, nomHab1, nomPlantaHab1, areaTexto);
            } else if (listaDatos.get(0).getPlanta().equals("Planta 1") && listaDatos.get(0).getNombre().equals("Estandar") && listaDatos.get(0).getMascota().equals("Permitido")) {
                areaTexto.setText("");
                nomHab1 = listaDatos.get(0).getNombre();
                nomPlantaHab1 = listaDatos.get(0).getPlanta();
                montoNocheH1 = 110;
                monTotalH1 = montoNocheH1 * dias;
                montoTodasHab = monTotalH1;
                montoTodasHab = montoNocheH1;
                porcenPlantaHab1 = (montoTodasHab * porPlanta1) / 100;
                totalMascota = (montoTodasHab * porMascota) / 100;
                totalPagar = montoTodasHab + porcenPlantaHab1 + totalMascota;
                tAreaHat1Mas(montoNocheH1, dias, monTotalH1, montoTodasHab, porPlanta1, porcenPlantaHab1, porMascota, totalMascota, totalPagar, nomHab1, nomPlantaHab1, areaTexto);
                //break;
            } else if (listaDatos.get(0).getPlanta().equals("Planta 1") && listaDatos.get(0).getNombre().equals("Superior") && listaDatos.get(0).getMascota().equals("Permitido")) {
                areaTexto.setText("");
                nomHab1 = listaDatos.get(0).getNombre();
                nomPlantaHab1 = listaDatos.get(0).getPlanta();
                montoNocheH1 = 140;
                monTotalH1 = montoNocheH1 * dias;
                montoTodasHab = monTotalH1;
                porcenPlantaHab1 = (montoTodasHab * porPlanta1) / 100;
                totalMascota = (montoTodasHab * porMascota) / 100;
                totalPagar = montoTodasHab + porcenPlantaHab1 + totalMascota;
                tAreaHat1Mas(montoNocheH1, dias, monTotalH1, montoTodasHab, porPlanta1, porcenPlantaHab1, porMascota, totalMascota, totalPagar, nomHab1, nomPlantaHab1, areaTexto);
            }
        }
    }

    public void detalle1HabitSinMasco(ArrayList<objConsultaReserva> listaDatos, JTextArea areaTexto, String fecha1, String fecha2) {
        int tamano = listaDatos.size();
        double dia;
        dia = dbreserva.consultadias(fecha1, fecha2);
        dias = (int) dia;
        if (tamano == 1) {
            areaTexto.setText("");
            if (listaDatos.get(0).getPlanta().equals("Planta 1") && listaDatos.get(0).getNombre().equals("Junior") && listaDatos.get(0).getMascota().equals("Prohibido")) {
                areaTexto.setText("");
                nomHab1 = listaDatos.get(0).getNombre();
                nomPlantaHab1 = listaDatos.get(0).getPlanta();
                montoNocheH1 = 80;
                monTotalH1 = montoNocheH1 * dias;
                montoTodasHab = monTotalH1;
                porcenPlantaHab1 = (montoTodasHab * porPlanta1) / 100;
                //totalMascota = (montoTodasHab * porMascota) / 100;
                totalPagar = montoTodasHab + porcenPlantaHab1;
                //tAreaHat1Mas(montoNocheH1, montoTodasHab, porPlanta1, porcenPlantaHab1, porMascota, totalMascota, totalPagar, nomHab1, nomPlantaHab1, areaTexto);
                tAreaHat1SinMas(montoNocheH1, dias, monTotalH1, montoTodasHab, porPlanta1, porcenPlantaHab1, totalPagar, nomHab1, nomPlantaHab1, areaTexto);
            } else if (listaDatos.get(0).getPlanta().equals("Planta 1") && listaDatos.get(0).getNombre().equals("Estandar") && listaDatos.get(0).getMascota().equals("Prohibido")) {
                areaTexto.setText("");
                nomHab1 = listaDatos.get(0).getNombre();
                nomPlantaHab1 = listaDatos.get(0).getPlanta();
                montoNocheH1 = 110;
                monTotalH1 = montoNocheH1 * dias;
                montoTodasHab = monTotalH1;
                porcenPlantaHab1 = (montoTodasHab * porPlanta1) / 100;
                //totalMascota = (montoTodasHab * porMascota) / 100;
                totalPagar = montoTodasHab + porcenPlantaHab1;
                tAreaHat1SinMas(montoNocheH1, dias, monTotalH1, montoTodasHab, porPlanta1, porcenPlantaHab1, totalPagar, nomHab1, nomPlantaHab1, areaTexto);
                //break;
            } else if (listaDatos.get(0).getPlanta().equals("Planta 1") && listaDatos.get(0).getNombre().equals("Superior") && listaDatos.get(0).getMascota().equals("Prohibido")) {
                areaTexto.setText("");
                nomHab1 = listaDatos.get(0).getNombre();
                nomPlantaHab1 = listaDatos.get(0).getPlanta();
                montoNocheH1 = 140;
                monTotalH1 = montoNocheH1 * dias;
                montoTodasHab = monTotalH1;
                porcenPlantaHab1 = (montoTodasHab * porPlanta1) / 100;
                //totalMascota = (montoTodasHab * porMascota) / 100;
                totalPagar = montoTodasHab + porcenPlantaHab1;
                tAreaHat1SinMas(montoNocheH1, dias, monTotalH1, montoTodasHab, porPlanta1, porcenPlantaHab1, totalPagar, nomHab1, nomPlantaHab1, areaTexto);
            } else if (listaDatos.get(0).getPlanta().equals("Planta 2") && listaDatos.get(0).getNombre().equals("Junior") && listaDatos.get(0).getMascota().equals("Prohibido")) {
                areaTexto.setText("");
                nomHab1 = listaDatos.get(0).getNombre();
                nomPlantaHab1 = listaDatos.get(0).getPlanta();
                montoNocheH1 = 80;
                monTotalH1 = montoNocheH1 * dias;
                montoTodasHab = monTotalH1;
                porcenPlantaHab1 = (montoTodasHab * porPlanta2) / 100;
                //totalMascota = (montoTodasHab * porMascota) / 100;
                totalPagar = montoTodasHab + porcenPlantaHab1;
                tAreaHat1SinMas(montoNocheH1, dias, monTotalH1, montoTodasHab, porPlanta2, porcenPlantaHab1, totalPagar, nomHab1, nomPlantaHab1, areaTexto);
            } else if (listaDatos.get(0).getPlanta().equals("Planta 2") && listaDatos.get(0).getNombre().equals("Estandar") && listaDatos.get(0).getMascota().equals("Prohibido")) {
                areaTexto.setText("");
                nomHab1 = listaDatos.get(0).getNombre();
                nomPlantaHab1 = listaDatos.get(0).getPlanta();
                montoNocheH1 = 110;
                monTotalH1 = montoNocheH1 * dias;
                montoTodasHab = monTotalH1;
                porcenPlantaHab1 = (montoTodasHab * porPlanta2) / 100;
                //totalMascota = (montoTodasHab * porMascota) / 100;
                totalPagar = montoTodasHab + porcenPlantaHab1;
                tAreaHat1SinMas(montoNocheH1, dias, monTotalH1, montoTodasHab, porPlanta2, porcenPlantaHab1, totalPagar, nomHab1, nomPlantaHab1, areaTexto);
                //break;
            } else if (listaDatos.get(0).getPlanta().equals("Planta 2") && listaDatos.get(0).getNombre().equals("Superior") && listaDatos.get(0).getMascota().equals("Prohibido")) {
                areaTexto.setText("");
                nomHab1 = listaDatos.get(0).getNombre();
                nomPlantaHab1 = listaDatos.get(0).getPlanta();
                montoNocheH1 = 140;
                monTotalH1 = montoNocheH1 * dias;
                montoTodasHab = monTotalH1;
                porcenPlantaHab1 = (montoTodasHab * porPlanta2) / 100;
                // totalMascota = (montoTodasHab * porMascota) / 100;
                totalPagar = montoTodasHab + porcenPlantaHab1;
                tAreaHat1SinMas(montoNocheH1, dias, monTotalH1, montoTodasHab, porPlanta2, porcenPlantaHab1, totalPagar, nomHab1, nomPlantaHab1, areaTexto);
            } else if (listaDatos.get(0).getPlanta().equals("Planta 3") && listaDatos.get(0).getNombre().equals("Junior") && listaDatos.get(0).getMascota().equals("Prohibido")) {
                areaTexto.setText("");
                nomHab1 = listaDatos.get(0).getNombre();
                nomPlantaHab1 = listaDatos.get(0).getPlanta();
                montoNocheH1 = 80;
                monTotalH1 = montoNocheH1 * dias;
                montoTodasHab = monTotalH1;
                porcenPlantaHab1 = (montoTodasHab * porPlanta3) / 100;
                //totalMascota = (montoTodasHab * porMascota) / 100;
                totalPagar = montoTodasHab + porcenPlantaHab1;
                tAreaHat1SinMas(montoNocheH1, dias, monTotalH1, montoTodasHab, porPlanta3, porcenPlantaHab1, totalPagar, nomHab1, nomPlantaHab1, areaTexto);
            } else if (listaDatos.get(0).getPlanta().equals("Planta 3") && listaDatos.get(0).getNombre().equals("Estandar") && listaDatos.get(0).getMascota().equals("Prohibido")) {
                areaTexto.setText("");
                nomHab1 = listaDatos.get(0).getNombre();
                nomPlantaHab1 = listaDatos.get(0).getPlanta();
                montoNocheH1 = 110;
                monTotalH1 = montoNocheH1 * dias;
                montoTodasHab = monTotalH1;
                porcenPlantaHab1 = (montoTodasHab * porPlanta3) / 100;
                //totalMascota = (montoTodasHab * porMascota) / 100;
                totalPagar = montoTodasHab + porcenPlantaHab1;
                tAreaHat1SinMas(montoNocheH1, dias, monTotalH1, montoTodasHab, porPlanta3, porcenPlantaHab1, totalPagar, nomHab1, nomPlantaHab1, areaTexto);
                //break;
            } else if (listaDatos.get(0).getPlanta().equals("Planta 3") && listaDatos.get(0).getNombre().equals("Superior") && listaDatos.get(0).getMascota().equals("Prohibido")) {
                areaTexto.setText("");
                nomHab1 = listaDatos.get(0).getNombre();
                nomPlantaHab1 = listaDatos.get(0).getPlanta();
                montoNocheH1 = 140;
                monTotalH1 = montoNocheH1 * dias;
                montoTodasHab = monTotalH1;
                porcenPlantaHab1 = (montoTodasHab * porPlanta3) / 100;
                //    totalMascota = (montoTodasHab * porMascota) / 100;
                totalPagar = montoTodasHab + porcenPlantaHab1;
                tAreaHat1SinMas(montoNocheH1, dias, monTotalH1, montoTodasHab, porPlanta3, porcenPlantaHab1, totalPagar, nomHab1, nomPlantaHab1, areaTexto);
            }
        }
    }

    public int montohabit(String habit) {
        int monto = 0;
        if (habit.equals("Junior")) {
            monto = 80;
        } else if (habit.equals("Estandar")) {
            monto = 110;
        } else if (habit.equals("Superior")) {
            monto = 140;
        }
        return monto;
    }

    public void detalle2HabitMas(ArrayList<objConsultaReserva> listaDatos, JTextArea areaTexto, String hab1, String hab2, String fecha1, String fecha2) {
        int tamano = listaDatos.size();
        double dia;
        dia = dbreserva.consultadias(fecha1, fecha2);
        dias = (int) dia;
        if (tamano == 2) {
            // for (int i = 0; i < listaDatos.size(); i++) {
            areaTexto.setText("");
            if ((listaDatos.get(0).getPlanta().equals("Planta 1") && listaDatos.get(0).getNombre().equals(hab1)) && (listaDatos.get(1).getPlanta().equals("Planta 1") && listaDatos.get(1).getNombre().equals(hab2))) {
                nomHab1 = listaDatos.get(0).getNombre();
                nomHab2 = listaDatos.get(1).getNombre();
                nomPlantaHab1 = listaDatos.get(0).getPlanta();
                nomPlantaHab2 = listaDatos.get(1).getPlanta();
                montoNocheH1 = montohabit(nomHab1);
                montoNocheH2 = montohabit(nomHab2);
                monTotalH1 = montoNocheH1 * dias;
                monTotalH2 = montoNocheH2 * dias;
                montoTodasHab = monTotalH1 + monTotalH2;
                porcenPlantaHab1 = (montoTodasHab * porPlanta1) / 100;
                porcenPlantaHab2 = (montoTodasHab * porPlanta1) / 100;
                totalMascota = (montoTodasHab * porMascota) / 100;
                totalPagar = montoTodasHab + porcenPlantaHab1 + porcenPlantaHab2 + totalMascota;
                tAreaHatMas2(montoNocheH1, montoNocheH2, dias, monTotalH1, monTotalH2, montoTodasHab, porPlanta1, porPlanta1, porcenPlantaHab1, porcenPlantaHab2, porMascota, totalMascota, totalPagar, nomHab1, nomHab2, nomPlantaHab1, nomPlantaHab2, areaTexto);
                // break;
            } else if ((listaDatos.get(0).getPlanta().equals("Planta 1") && listaDatos.get(0).getNombre().equals(hab2)) && (listaDatos.get(1).getPlanta().equals("Planta 1") && listaDatos.get(1).getNombre().equals(hab1))) {
                nomHab1 = listaDatos.get(0).getNombre();
                nomHab2 = listaDatos.get(1).getNombre();
                nomPlantaHab1 = listaDatos.get(0).getPlanta();
                nomPlantaHab2 = listaDatos.get(1).getPlanta();
                montoNocheH1 = montohabit(nomHab1);
                montoNocheH2 = montohabit(nomHab2);
                monTotalH1 = montoNocheH1 * dias;
                monTotalH2 = montoNocheH2 * dias;
                montoTodasHab = monTotalH1 + monTotalH2;
                porcenPlantaHab1 = (montoTodasHab * porPlanta1) / 100;
                porcenPlantaHab2 = (montoTodasHab * porPlanta1) / 100;
                totalMascota = (montoTodasHab * porMascota) / 100;
                totalPagar = montoTodasHab + porcenPlantaHab1 + porcenPlantaHab2 + totalMascota;
                tAreaHatMas2(montoNocheH1, montoNocheH2, dias, monTotalH1, monTotalH2, montoTodasHab, porPlanta1, porPlanta1, porcenPlantaHab1, porcenPlantaHab2, porMascota, totalMascota, totalPagar, nomHab1, nomHab2, nomPlantaHab1, nomPlantaHab2, areaTexto);
                // break;
            } else if ((listaDatos.get(0).getPlanta().equals("Planta 1") && listaDatos.get(0).getNombre().equals(hab1)) && (listaDatos.get(1).getPlanta().equals("Planta 2") && listaDatos.get(1).getNombre().equals(hab2))) {
                nomHab1 = listaDatos.get(0).getNombre();
                nomHab2 = listaDatos.get(1).getNombre();
                nomPlantaHab1 = listaDatos.get(0).getPlanta();
                nomPlantaHab2 = listaDatos.get(1).getPlanta();
                montoNocheH1 = montohabit(nomHab1);
                montoNocheH2 = montohabit(nomHab2);
                monTotalH1 = montoNocheH1 * dias;
                monTotalH2 = montoNocheH2 * dias;
                montoTodasHab = monTotalH1 + monTotalH2;
                porcenPlantaHab1 = (montoTodasHab * porPlanta1) / 100;
                porcenPlantaHab2 = (montoTodasHab * porPlanta2) / 100;
                totalMascota = (montoTodasHab * porMascota) / 100;
                totalPagar = montoTodasHab + porcenPlantaHab1 + porcenPlantaHab2 + totalMascota;
                tAreaHatMas2(montoNocheH1, montoNocheH2, dias, monTotalH1, monTotalH2, montoTodasHab, porPlanta1, porPlanta2, porcenPlantaHab1, porcenPlantaHab2, porMascota, totalMascota, totalPagar, nomHab1, nomHab2, nomPlantaHab1, nomPlantaHab2, areaTexto);
                // break;
            } else if ((listaDatos.get(0).getPlanta().equals("Planta 1") && listaDatos.get(0).getNombre().equals(hab2)) && (listaDatos.get(1).getPlanta().equals("Planta 2") && listaDatos.get(1).getNombre().equals(hab1))) {
                nomHab1 = listaDatos.get(0).getNombre();
                nomHab2 = listaDatos.get(1).getNombre();
                nomPlantaHab1 = listaDatos.get(0).getPlanta();
                nomPlantaHab2 = listaDatos.get(1).getPlanta();
                montoNocheH1 = montohabit(nomHab1);
                montoNocheH2 = montohabit(nomHab2);
                monTotalH1 = montoNocheH1 * dias;
                monTotalH2 = montoNocheH2 * dias;
                montoTodasHab = monTotalH1 + monTotalH2;
                porcenPlantaHab1 = (montoTodasHab * porPlanta1) / 100;
                porcenPlantaHab2 = (montoTodasHab * porPlanta2) / 100;
                totalMascota = (montoTodasHab * porMascota) / 100;
                totalPagar = montoTodasHab + porcenPlantaHab1 + porcenPlantaHab2 + totalMascota;
                tAreaHatMas2(montoNocheH1, montoNocheH2, dias, monTotalH1, monTotalH2, montoTodasHab, porPlanta1, porPlanta2, porcenPlantaHab1, porcenPlantaHab2, porMascota, totalMascota, totalPagar, nomHab1, nomHab2, nomPlantaHab1, nomPlantaHab2, areaTexto);
                // break;
            } else if ((listaDatos.get(0).getPlanta().equals("Planta 1") && listaDatos.get(0).getNombre().equals(hab1)) && (listaDatos.get(1).getPlanta().equals("Planta 3") && listaDatos.get(1).getNombre().equals(hab2))) {
                nomHab1 = listaDatos.get(0).getNombre();
                nomHab2 = listaDatos.get(1).getNombre();
                nomPlantaHab1 = listaDatos.get(0).getPlanta();
                nomPlantaHab2 = listaDatos.get(1).getPlanta();
                montoNocheH1 = montohabit(nomHab1);
                montoNocheH2 = montohabit(nomHab2);
                monTotalH1 = montoNocheH1 * dias;
                monTotalH2 = montoNocheH2 * dias;
                montoTodasHab = monTotalH1 + monTotalH2;
                porcenPlantaHab1 = (montoTodasHab * porPlanta1) / 100;
                porcenPlantaHab2 = (montoTodasHab * porPlanta3) / 100;
                totalMascota = (montoTodasHab * porMascota) / 100;
                totalPagar = montoTodasHab + porcenPlantaHab1 + porcenPlantaHab2 + totalMascota;
                tAreaHatMas2(montoNocheH1, montoNocheH2, dias, monTotalH1, monTotalH2, montoTodasHab, porPlanta1, porPlanta3, porcenPlantaHab1, porcenPlantaHab2, porMascota, totalMascota, totalPagar, nomHab1, nomHab2, nomPlantaHab1, nomPlantaHab2, areaTexto);
                //break;
            } else if ((listaDatos.get(0).getPlanta().equals("Planta 1") && listaDatos.get(0).getNombre().equals(hab2)) && (listaDatos.get(1).getPlanta().equals("Planta 3") && listaDatos.get(1).getNombre().equals(hab1))) {
                nomHab1 = listaDatos.get(0).getNombre();
                nomHab2 = listaDatos.get(1).getNombre();
                nomPlantaHab1 = listaDatos.get(0).getPlanta();
                nomPlantaHab2 = listaDatos.get(1).getPlanta();
                montoNocheH1 = montohabit(nomHab1);
                montoNocheH2 = montohabit(nomHab2);
                monTotalH1 = montoNocheH1 * dias;
                monTotalH2 = montoNocheH2 * dias;
                montoTodasHab = monTotalH1 + monTotalH2;
                porcenPlantaHab1 = (montoTodasHab * porPlanta1) / 100;
                porcenPlantaHab2 = (montoTodasHab * porPlanta3) / 100;
                totalMascota = (montoTodasHab * porMascota) / 100;
                totalPagar = montoTodasHab + porcenPlantaHab1 + porcenPlantaHab2 + totalMascota;
                tAreaHatMas2(montoNocheH1, montoNocheH2, dias, monTotalH1, monTotalH2, montoTodasHab, porPlanta1, porPlanta3, porcenPlantaHab1, porcenPlantaHab2, porMascota, totalMascota, totalPagar, nomHab1, nomHab2, nomPlantaHab1, nomPlantaHab2, areaTexto);
                //break;
            }
            if ((listaDatos.get(0).getPlanta().equals("Planta 2") && listaDatos.get(0).getNombre().equals(hab1)) && (listaDatos.get(1).getPlanta().equals("Planta 1") && listaDatos.get(1).getNombre().equals(hab2))) {
                nomHab1 = listaDatos.get(0).getNombre();
                nomHab2 = listaDatos.get(1).getNombre();
                nomPlantaHab1 = listaDatos.get(0).getPlanta();
                nomPlantaHab2 = listaDatos.get(1).getPlanta();
                montoNocheH1 = montohabit(nomHab1);
                montoNocheH2 = montohabit(nomHab2);
                monTotalH1 = montoNocheH1 * dias;
                monTotalH2 = montoNocheH2 * dias;
                montoTodasHab = monTotalH1 + monTotalH2;
                porcenPlantaHab1 = (montoTodasHab * porPlanta2) / 100;
                porcenPlantaHab2 = (montoTodasHab * porPlanta1) / 100;
                totalMascota = (montoTodasHab * porMascota) / 100;
                totalPagar = montoTodasHab + porcenPlantaHab1 + porcenPlantaHab2 + totalMascota;
                tAreaHatMas2(montoNocheH1, montoNocheH2, dias, monTotalH1, monTotalH2, montoTodasHab, porPlanta2, porPlanta1, porcenPlantaHab1, porcenPlantaHab2, porMascota, totalMascota, totalPagar, nomHab1, nomHab2, nomPlantaHab1, nomPlantaHab2, areaTexto);
                // break;
            } else if ((listaDatos.get(0).getPlanta().equals("Planta 2") && listaDatos.get(0).getNombre().equals(hab2)) && (listaDatos.get(1).getPlanta().equals("Planta 1") && listaDatos.get(1).getNombre().equals(hab1))) {
                nomHab1 = listaDatos.get(0).getNombre();
                nomHab2 = listaDatos.get(1).getNombre();
                nomPlantaHab1 = listaDatos.get(0).getPlanta();
                nomPlantaHab2 = listaDatos.get(1).getPlanta();
                montoNocheH1 = montohabit(nomHab1);
                montoNocheH2 = montohabit(nomHab2);
                monTotalH1 = montoNocheH1 * dias;
                monTotalH2 = montoNocheH2 * dias;
                montoTodasHab = monTotalH1 + monTotalH2;
                porcenPlantaHab1 = (montoTodasHab * porPlanta2) / 100;
                porcenPlantaHab2 = (montoTodasHab * porPlanta1) / 100;
                totalMascota = (montoTodasHab * porMascota) / 100;
                totalPagar = montoTodasHab + porcenPlantaHab1 + porcenPlantaHab2 + totalMascota;
                tAreaHatMas2(montoNocheH1, montoNocheH2, dias, monTotalH1, monTotalH2, montoTodasHab, porPlanta2, porPlanta1, porcenPlantaHab1, porcenPlantaHab2, porMascota, totalMascota, totalPagar, nomHab1, nomHab2, nomPlantaHab1, nomPlantaHab2, areaTexto);
                // break;
            } else if ((listaDatos.get(0).getPlanta().equals("Planta 2") && listaDatos.get(0).getNombre().equals(hab1)) && (listaDatos.get(1).getPlanta().equals("Planta 2") && listaDatos.get(1).getNombre().equals(hab2))) {
                nomHab1 = listaDatos.get(0).getNombre();
                nomHab2 = listaDatos.get(1).getNombre();
                nomPlantaHab1 = listaDatos.get(0).getPlanta();
                nomPlantaHab2 = listaDatos.get(1).getPlanta();
                montoNocheH1 = montohabit(nomHab1);
                montoNocheH2 = montohabit(nomHab2);
                monTotalH1 = montoNocheH1 * dias;
                monTotalH2 = montoNocheH2 * dias;
                montoTodasHab = monTotalH1 + monTotalH2;
                porcenPlantaHab1 = (montoTodasHab * porPlanta2) / 100;
                porcenPlantaHab2 = (montoTodasHab * porPlanta2) / 100;
                totalMascota = (montoTodasHab * porMascota) / 100;
                totalPagar = montoTodasHab + porcenPlantaHab1 + porcenPlantaHab2 + totalMascota;
                tAreaHatMas2(montoNocheH1, montoNocheH2, dias, monTotalH1, monTotalH2, montoTodasHab, porPlanta2, porPlanta2, porcenPlantaHab1, porcenPlantaHab2, porMascota, totalMascota, totalPagar, nomHab1, nomHab2, nomPlantaHab1, nomPlantaHab2, areaTexto);
                // break;
            } else if ((listaDatos.get(0).getPlanta().equals("Planta 2") && listaDatos.get(0).getNombre().equals(hab2)) && (listaDatos.get(1).getPlanta().equals("Planta 2") && listaDatos.get(1).getNombre().equals(hab1))) {
                nomHab1 = listaDatos.get(0).getNombre();
                nomHab2 = listaDatos.get(1).getNombre();
                nomPlantaHab1 = listaDatos.get(0).getPlanta();
                nomPlantaHab2 = listaDatos.get(1).getPlanta();
                montoNocheH1 = montohabit(nomHab1);
                montoNocheH2 = montohabit(nomHab2);
                monTotalH1 = montoNocheH1 * dias;
                monTotalH2 = montoNocheH2 * dias;
                montoTodasHab = monTotalH1 + monTotalH2;
                porcenPlantaHab1 = (montoTodasHab * porPlanta2) / 100;
                porcenPlantaHab2 = (montoTodasHab * porPlanta2) / 100;
                totalMascota = (montoTodasHab * porMascota) / 100;
                totalPagar = montoTodasHab + porcenPlantaHab1 + porcenPlantaHab2 + totalMascota;
                tAreaHatMas2(montoNocheH1, montoNocheH2, dias, monTotalH1, monTotalH2, montoTodasHab, porPlanta2, porPlanta2, porcenPlantaHab1, porcenPlantaHab2, porMascota, totalMascota, totalPagar, nomHab1, nomHab2, nomPlantaHab1, nomPlantaHab2, areaTexto);
                // break;
            } else if ((listaDatos.get(0).getPlanta().equals("Planta 2") && listaDatos.get(0).getNombre().equals(hab1)) && (listaDatos.get(1).getPlanta().equals("Planta 3") && listaDatos.get(1).getNombre().equals(hab2))) {
                nomHab1 = listaDatos.get(0).getNombre();
                nomHab2 = listaDatos.get(1).getNombre();
                nomPlantaHab1 = listaDatos.get(0).getPlanta();
                nomPlantaHab2 = listaDatos.get(1).getPlanta();
                montoNocheH1 = montohabit(nomHab1);
                montoNocheH2 = montohabit(nomHab2);
                monTotalH1 = montoNocheH1 * dias;
                monTotalH2 = montoNocheH2 * dias;
                montoTodasHab = monTotalH1 + monTotalH2;
                porcenPlantaHab1 = (montoTodasHab * porPlanta2) / 100;
                porcenPlantaHab2 = (montoTodasHab * porPlanta3) / 100;
                totalMascota = (montoTodasHab * porMascota) / 100;
                totalPagar = montoTodasHab + porcenPlantaHab1 + porcenPlantaHab2 + totalMascota;
                tAreaHatMas2(montoNocheH1, montoNocheH2, dias, monTotalH1, monTotalH2, montoTodasHab, porPlanta2, porPlanta3, porcenPlantaHab1, porcenPlantaHab2, porMascota, totalMascota, totalPagar, nomHab1, nomHab2, nomPlantaHab1, nomPlantaHab2, areaTexto);
                //break;
            } else if ((listaDatos.get(0).getPlanta().equals("Planta 2") && listaDatos.get(0).getNombre().equals(hab2)) && (listaDatos.get(1).getPlanta().equals("Planta 3") && listaDatos.get(1).getNombre().equals(hab1))) {
                nomHab1 = listaDatos.get(0).getNombre();
                nomHab2 = listaDatos.get(1).getNombre();
                nomPlantaHab1 = listaDatos.get(0).getPlanta();
                nomPlantaHab2 = listaDatos.get(1).getPlanta();
                montoNocheH1 = montohabit(nomHab1);
                montoNocheH2 = montohabit(nomHab2);
                monTotalH1 = montoNocheH1 * dias;
                monTotalH2 = montoNocheH2 * dias;
                montoTodasHab = monTotalH1 + monTotalH2;
                porcenPlantaHab1 = (montoTodasHab * porPlanta2) / 100;
                porcenPlantaHab2 = (montoTodasHab * porPlanta3) / 100;
                totalMascota = (montoTodasHab * porMascota) / 100;
                totalPagar = montoTodasHab + porcenPlantaHab1 + porcenPlantaHab2 + totalMascota;
                tAreaHatMas2(montoNocheH1, montoNocheH2, dias, monTotalH1, monTotalH2, montoTodasHab, porPlanta2, porPlanta3, porcenPlantaHab1, porcenPlantaHab2, porMascota, totalMascota, totalPagar, nomHab1, nomHab2, nomPlantaHab1, nomPlantaHab2, areaTexto);
                //break;
            }
            if ((listaDatos.get(0).getPlanta().equals("Planta 3") && listaDatos.get(0).getNombre().equals(hab1)) && (listaDatos.get(1).getPlanta().equals("Planta 1") && listaDatos.get(1).getNombre().equals(hab2))) {
                nomHab1 = listaDatos.get(0).getNombre();
                nomHab2 = listaDatos.get(1).getNombre();
                nomPlantaHab1 = listaDatos.get(0).getPlanta();
                nomPlantaHab2 = listaDatos.get(1).getPlanta();
                montoNocheH1 = montohabit(nomHab1);
                montoNocheH2 = montohabit(nomHab2);
                monTotalH1 = montoNocheH1 * dias;
                monTotalH2 = montoNocheH2 * dias;
                montoTodasHab = monTotalH1 + monTotalH2;
                porcenPlantaHab1 = (montoTodasHab * porPlanta3) / 100;
                porcenPlantaHab2 = (montoTodasHab * porPlanta1) / 100;
                totalMascota = (montoTodasHab * porMascota) / 100;
                totalPagar = montoTodasHab + porcenPlantaHab1 + porcenPlantaHab2 + totalMascota;
                tAreaHatMas2(montoNocheH1, montoNocheH2, dias, monTotalH1, monTotalH2, montoTodasHab, porPlanta3, porPlanta1, porcenPlantaHab1, porcenPlantaHab2, porMascota, totalMascota, totalPagar, nomHab1, nomHab2, nomPlantaHab1, nomPlantaHab2, areaTexto);
                // break;
            } else if ((listaDatos.get(0).getPlanta().equals("Planta 3") && listaDatos.get(0).getNombre().equals(hab2)) && (listaDatos.get(1).getPlanta().equals("Planta 1") && listaDatos.get(1).getNombre().equals(hab1))) {
                nomHab1 = listaDatos.get(0).getNombre();
                nomHab2 = listaDatos.get(1).getNombre();
                nomPlantaHab1 = listaDatos.get(0).getPlanta();
                nomPlantaHab2 = listaDatos.get(1).getPlanta();
                montoNocheH1 = montohabit(nomHab1);
                montoNocheH2 = montohabit(nomHab2);
                monTotalH1 = montoNocheH1 * dias;
                monTotalH2 = montoNocheH2 * dias;
                montoTodasHab = monTotalH1 + monTotalH2;
                porcenPlantaHab1 = (montoTodasHab * porPlanta3) / 100;
                porcenPlantaHab2 = (montoTodasHab * porPlanta1) / 100;
                totalMascota = (montoTodasHab * porMascota) / 100;
                totalPagar = montoTodasHab + porcenPlantaHab1 + porcenPlantaHab2 + totalMascota;
                tAreaHatMas2(montoNocheH1, montoNocheH2, dias, monTotalH1, monTotalH2, montoTodasHab, porPlanta3, porPlanta1, porcenPlantaHab1, porcenPlantaHab2, porMascota, totalMascota, totalPagar, nomHab1, nomHab2, nomPlantaHab1, nomPlantaHab2, areaTexto);
                // break;
            } else if ((listaDatos.get(0).getPlanta().equals("Planta 3") && listaDatos.get(0).getNombre().equals(hab1)) && (listaDatos.get(1).getPlanta().equals("Planta 2") && listaDatos.get(1).getNombre().equals(hab2))) {
                nomHab1 = listaDatos.get(0).getNombre();
                nomHab2 = listaDatos.get(1).getNombre();
                nomPlantaHab1 = listaDatos.get(0).getPlanta();
                nomPlantaHab2 = listaDatos.get(1).getPlanta();
                montoNocheH1 = montohabit(nomHab1);
                montoNocheH2 = montohabit(nomHab2);
                monTotalH1 = montoNocheH1 * dias;
                monTotalH2 = montoNocheH2 * dias;
                montoTodasHab = monTotalH1 + monTotalH2;
                porcenPlantaHab1 = (montoTodasHab * porPlanta3) / 100;
                porcenPlantaHab2 = (montoTodasHab * porPlanta2) / 100;
                totalMascota = (montoTodasHab * porMascota) / 100;
                totalPagar = montoTodasHab + porcenPlantaHab1 + porcenPlantaHab2 + totalMascota;
                tAreaHatMas2(montoNocheH1, montoNocheH2, dias, monTotalH1, monTotalH2, montoTodasHab, porPlanta3, porPlanta2, porcenPlantaHab1, porcenPlantaHab2, porMascota, totalMascota, totalPagar, nomHab1, nomHab2, nomPlantaHab1, nomPlantaHab2, areaTexto);
                // break;
            } else if ((listaDatos.get(0).getPlanta().equals("Planta 3") && listaDatos.get(0).getNombre().equals(hab2)) && (listaDatos.get(1).getPlanta().equals("Planta 2") && listaDatos.get(1).getNombre().equals(hab1))) {
                nomHab1 = listaDatos.get(0).getNombre();
                nomHab2 = listaDatos.get(1).getNombre();
                nomPlantaHab1 = listaDatos.get(0).getPlanta();
                nomPlantaHab2 = listaDatos.get(1).getPlanta();
                montoNocheH1 = montohabit(nomHab1);
                montoNocheH2 = montohabit(nomHab2);
                monTotalH1 = montoNocheH1 * dias;
                monTotalH2 = montoNocheH2 * dias;
                montoTodasHab = monTotalH1 + monTotalH2;
                porcenPlantaHab1 = (montoTodasHab * porPlanta3) / 100;
                porcenPlantaHab2 = (montoTodasHab * porPlanta2) / 100;
                totalMascota = (montoTodasHab * porMascota) / 100;
                totalPagar = montoTodasHab + porcenPlantaHab1 + porcenPlantaHab2 + totalMascota;
                tAreaHatMas2(montoNocheH1, montoNocheH2, dias, monTotalH1, monTotalH2, montoTodasHab, porPlanta3, porPlanta2, porcenPlantaHab1, porcenPlantaHab2, porMascota, totalMascota, totalPagar, nomHab1, nomHab2, nomPlantaHab1, nomPlantaHab2, areaTexto);
                // break;
            } else if ((listaDatos.get(0).getPlanta().equals("Planta 3") && listaDatos.get(0).getNombre().equals(hab1)) && (listaDatos.get(1).getPlanta().equals("Planta 3") && listaDatos.get(1).getNombre().equals(hab2))) {
                nomHab1 = listaDatos.get(0).getNombre();
                nomHab2 = listaDatos.get(1).getNombre();
                nomPlantaHab1 = listaDatos.get(0).getPlanta();
                nomPlantaHab2 = listaDatos.get(1).getPlanta();
                montoNocheH1 = montohabit(nomHab1);
                montoNocheH2 = montohabit(nomHab2);
                monTotalH1 = montoNocheH1 * dias;
                monTotalH2 = montoNocheH2 * dias;
                montoTodasHab = monTotalH1 + monTotalH2;
                porcenPlantaHab1 = (montoTodasHab * porPlanta3) / 100;
                porcenPlantaHab2 = (montoTodasHab * porPlanta3) / 100;
                totalMascota = (montoTodasHab * porMascota) / 100;
                totalPagar = montoTodasHab + porcenPlantaHab1 + porcenPlantaHab2 + totalMascota;
                tAreaHatMas2(montoNocheH1, montoNocheH2, dias, monTotalH1, monTotalH2, montoTodasHab, porPlanta3, porPlanta3, porcenPlantaHab1, porcenPlantaHab2, porMascota, totalMascota, totalPagar, nomHab1, nomHab2, nomPlantaHab1, nomPlantaHab2, areaTexto);
                //break;
            } else if ((listaDatos.get(0).getPlanta().equals("Planta 3") && listaDatos.get(0).getNombre().equals(hab2)) && (listaDatos.get(1).getPlanta().equals("Planta 3") && listaDatos.get(1).getNombre().equals(hab1))) {
                nomHab1 = listaDatos.get(0).getNombre();
                nomHab2 = listaDatos.get(1).getNombre();
                nomPlantaHab1 = listaDatos.get(0).getPlanta();
                nomPlantaHab2 = listaDatos.get(1).getPlanta();
                montoNocheH1 = montohabit(nomHab1);
                montoNocheH2 = montohabit(nomHab2);
                monTotalH1 = montoNocheH1 * dias;
                monTotalH2 = montoNocheH2 * dias;
                montoTodasHab = monTotalH1 + monTotalH2;
                porcenPlantaHab1 = (montoTodasHab * porPlanta3) / 100;
                porcenPlantaHab2 = (montoTodasHab * porPlanta3) / 100;
                totalMascota = (montoTodasHab * porMascota) / 100;
                totalPagar = montoTodasHab + porcenPlantaHab1 + porcenPlantaHab2 + totalMascota;
                tAreaHatMas2(montoNocheH1, montoNocheH2, dias, monTotalH1, monTotalH2, montoTodasHab, porPlanta3, porPlanta3, porcenPlantaHab1, porcenPlantaHab2, porMascota, totalMascota, totalPagar, nomHab1, nomHab2, nomPlantaHab1, nomPlantaHab2, areaTexto);
                //break;
            }
            //}
        }
    }

    public void detalle2HabitSinMas(ArrayList<objConsultaReserva> listaDatos, JTextArea areaTexto, String hab1, String hab2, String fecha1, String fecha2) {
        int tamano = listaDatos.size();
        double dia;
        dia = dbreserva.consultadias(fecha1, fecha2);
        dias = (int) dia;
        if (tamano == 2) {
            // for (int i = 0; i < listaDatos.size(); i++) {
            areaTexto.setText("");
            if ((listaDatos.get(0).getPlanta().equals("Planta 1") && listaDatos.get(0).getNombre().equals(hab1)) && (listaDatos.get(1).getPlanta().equals("Planta 1") && listaDatos.get(1).getNombre().equals(hab2))) {
                //dias = Cantidias(hab1, hab2);
                nomHab1 = listaDatos.get(0).getNombre();
                nomHab2 = listaDatos.get(1).getNombre();
                nomPlantaHab1 = listaDatos.get(0).getPlanta();
                nomPlantaHab2 = listaDatos.get(1).getPlanta();
                montoNocheH1 = montohabit(nomHab1);
                montoNocheH2 = montohabit(nomHab2);
                monTotalH1 = montoNocheH1 * dias;
                monTotalH2 = montoNocheH2 * dias;
                montoTodasHab = monTotalH1 + monTotalH2;
                porcenPlantaHab1 = (montoTodasHab * porPlanta1) / 100;
                porcenPlantaHab2 = (montoTodasHab * porPlanta1) / 100;
                //totalMascota = (montoTodasHab * porMascota) / 100;
                totalPagar = montoTodasHab + porcenPlantaHab1 + porcenPlantaHab2;
                tAreaHatsinMas2(montoNocheH1, montoNocheH2, dias, monTotalH1, monTotalH2, montoTodasHab, porPlanta1, porPlanta1, porcenPlantaHab1, porcenPlantaHab2, totalPagar, nomHab1, nomHab2, nomPlantaHab1, nomPlantaHab2, areaTexto);
                // break;
            } else if ((listaDatos.get(0).getPlanta().equals("Planta 1") && listaDatos.get(0).getNombre().equals(hab2)) && (listaDatos.get(1).getPlanta().equals("Planta 1") && listaDatos.get(1).getNombre().equals(hab1))) {
                nomHab1 = listaDatos.get(0).getNombre();
                nomHab2 = listaDatos.get(1).getNombre();
                nomPlantaHab1 = listaDatos.get(0).getPlanta();
                nomPlantaHab2 = listaDatos.get(1).getPlanta();
                montoNocheH1 = montohabit(nomHab1);
                montoNocheH2 = montohabit(nomHab2);
                monTotalH1 = montoNocheH1 * dias;
                monTotalH2 = montoNocheH2 * dias;
                montoTodasHab = monTotalH1 + monTotalH2;
                porcenPlantaHab1 = (montoTodasHab * porPlanta1) / 100;
                porcenPlantaHab2 = (montoTodasHab * porPlanta1) / 100;
                //totalMascota = (montoTodasHab * porMascota) / 100;
                totalPagar = montoTodasHab + porcenPlantaHab1 + porcenPlantaHab2;
                tAreaHatsinMas2(montoNocheH1, montoNocheH2, dias, monTotalH1, monTotalH2, montoTodasHab, porPlanta1, porPlanta1, porcenPlantaHab1, porcenPlantaHab2, totalPagar, nomHab1, nomHab2, nomPlantaHab1, nomPlantaHab2, areaTexto);
                // break;
            } else if ((listaDatos.get(0).getPlanta().equals("Planta 1") && listaDatos.get(0).getNombre().equals(hab1)) && (listaDatos.get(1).getPlanta().equals("Planta 2") && listaDatos.get(1).getNombre().equals(hab2))) {
                nomHab1 = listaDatos.get(0).getNombre();
                nomHab2 = listaDatos.get(1).getNombre();
                nomPlantaHab1 = listaDatos.get(0).getPlanta();
                nomPlantaHab2 = listaDatos.get(1).getPlanta();
                montoNocheH1 = montohabit(nomHab1);
                montoNocheH2 = montohabit(nomHab2);
                monTotalH1 = montoNocheH1 * dias;
                monTotalH2 = montoNocheH2 * dias;
                montoTodasHab = monTotalH1 + monTotalH2;
                porcenPlantaHab1 = (montoTodasHab * porPlanta1) / 100;
                porcenPlantaHab2 = (montoTodasHab * porPlanta2) / 100;
                //totalMascota = (montoTodasHab * porMascota) / 100;
                totalPagar = montoTodasHab + porcenPlantaHab1 + porcenPlantaHab2;
                tAreaHatsinMas2(montoNocheH1, montoNocheH2, dias, monTotalH1, monTotalH2, montoTodasHab, porPlanta1, porPlanta2, porcenPlantaHab1, porcenPlantaHab2, totalPagar, nomHab1, nomHab2, nomPlantaHab1, nomPlantaHab2, areaTexto);
                // break;
            } else if ((listaDatos.get(0).getPlanta().equals("Planta 1") && listaDatos.get(0).getNombre().equals(hab2)) && (listaDatos.get(1).getPlanta().equals("Planta 2") && listaDatos.get(1).getNombre().equals(hab1))) {
                nomHab1 = listaDatos.get(0).getNombre();
                nomHab2 = listaDatos.get(1).getNombre();
                nomPlantaHab1 = listaDatos.get(0).getPlanta();
                nomPlantaHab2 = listaDatos.get(1).getPlanta();
                montoNocheH1 = montohabit(nomHab1);
                montoNocheH2 = montohabit(nomHab2);
                monTotalH1 = montoNocheH1 * dias;
                monTotalH2 = montoNocheH2 * dias;
                montoTodasHab = monTotalH1 + monTotalH2;
                porcenPlantaHab1 = (montoTodasHab * porPlanta1) / 100;
                porcenPlantaHab2 = (montoTodasHab * porPlanta2) / 100;
                //totalMascota = (montoTodasHab * porMascota) / 100;
                totalPagar = montoTodasHab + porcenPlantaHab1 + porcenPlantaHab2;
                tAreaHatsinMas2(montoNocheH1, montoNocheH2, dias, monTotalH1, monTotalH2, montoTodasHab, porPlanta1, porPlanta2, porcenPlantaHab1, porcenPlantaHab2, totalPagar, nomHab1, nomHab2, nomPlantaHab1, nomPlantaHab2, areaTexto);
                // break;
            } else if ((listaDatos.get(0).getPlanta().equals("Planta 1") && listaDatos.get(0).getNombre().equals(hab1)) && (listaDatos.get(1).getPlanta().equals("Planta 3") && listaDatos.get(1).getNombre().equals(hab2))) {
                nomHab1 = listaDatos.get(0).getNombre();
                nomHab2 = listaDatos.get(1).getNombre();
                nomPlantaHab1 = listaDatos.get(0).getPlanta();
                nomPlantaHab2 = listaDatos.get(1).getPlanta();
                montoNocheH1 = montohabit(nomHab1);
                montoNocheH2 = montohabit(nomHab2);
                monTotalH1 = montoNocheH1 * dias;
                monTotalH2 = montoNocheH2 * dias;
                montoTodasHab = monTotalH1 + monTotalH2;
                porcenPlantaHab1 = (montoTodasHab * porPlanta1) / 100;
                porcenPlantaHab2 = (montoTodasHab * porPlanta3) / 100;
                // totalMascota = (montoTodasHab * porMascota) / 100;
                totalPagar = montoTodasHab + porcenPlantaHab1 + porcenPlantaHab2;
                tAreaHatsinMas2(montoNocheH1, montoNocheH2, dias, monTotalH1, monTotalH2, montoTodasHab, porPlanta1, porPlanta3, porcenPlantaHab1, porcenPlantaHab2, totalPagar, nomHab1, nomHab2, nomPlantaHab1, nomPlantaHab2, areaTexto);
                //break;
            } else if ((listaDatos.get(0).getPlanta().equals("Planta 1") && listaDatos.get(0).getNombre().equals(hab2)) && (listaDatos.get(1).getPlanta().equals("Planta 3") && listaDatos.get(1).getNombre().equals(hab1))) {
                nomHab1 = listaDatos.get(0).getNombre();
                nomHab2 = listaDatos.get(1).getNombre();
                nomPlantaHab1 = listaDatos.get(0).getPlanta();
                nomPlantaHab2 = listaDatos.get(1).getPlanta();
                montoNocheH1 = montohabit(nomHab1);
                montoNocheH2 = montohabit(nomHab2);
                monTotalH1 = montoNocheH1 * dias;
                monTotalH2 = montoNocheH2 * dias;
                montoTodasHab = monTotalH1 + monTotalH2;
                porcenPlantaHab1 = (montoTodasHab * porPlanta1) / 100;
                porcenPlantaHab2 = (montoTodasHab * porPlanta3) / 100;
                // totalMascota = (montoTodasHab * porMascota) / 100;
                totalPagar = montoTodasHab + porcenPlantaHab1 + porcenPlantaHab2;
                tAreaHatsinMas2(montoNocheH1, montoNocheH2, dias, monTotalH1, monTotalH2, montoTodasHab, porPlanta1, porPlanta3, porcenPlantaHab1, porcenPlantaHab2, totalPagar, nomHab1, nomHab2, nomPlantaHab1, nomPlantaHab2, areaTexto);
                //break;
            }
            if ((listaDatos.get(0).getPlanta().equals("Planta 2") && listaDatos.get(0).getNombre().equals(hab1)) && (listaDatos.get(1).getPlanta().equals("Planta 1") && listaDatos.get(1).getNombre().equals(hab2))) {
                nomHab1 = listaDatos.get(0).getNombre();
                nomHab2 = listaDatos.get(1).getNombre();
                nomPlantaHab1 = listaDatos.get(0).getPlanta();
                nomPlantaHab2 = listaDatos.get(1).getPlanta();
                montoNocheH1 = montohabit(nomHab1);
                montoNocheH2 = montohabit(nomHab2);
                monTotalH1 = montoNocheH1 * dias;
                monTotalH2 = montoNocheH2 * dias;
                montoTodasHab = monTotalH1 + monTotalH2;
                porcenPlantaHab1 = (montoTodasHab * porPlanta2) / 100;
                porcenPlantaHab2 = (montoTodasHab * porPlanta1) / 100;
                // totalMascota = (montoTodasHab * porMascota) / 100;
                totalPagar = montoTodasHab + porcenPlantaHab1 + porcenPlantaHab2;
                tAreaHatsinMas2(montoNocheH1, montoNocheH2, dias, monTotalH1, monTotalH2, montoTodasHab, porPlanta2, porPlanta1, porcenPlantaHab1, porcenPlantaHab2, totalPagar, nomHab1, nomHab2, nomPlantaHab1, nomPlantaHab2, areaTexto);
                // break;
            } else if ((listaDatos.get(0).getPlanta().equals("Planta 2") && listaDatos.get(0).getNombre().equals(hab2)) && (listaDatos.get(1).getPlanta().equals("Planta 1") && listaDatos.get(1).getNombre().equals(hab1))) {
                nomHab1 = listaDatos.get(0).getNombre();
                nomHab2 = listaDatos.get(1).getNombre();
                nomPlantaHab1 = listaDatos.get(0).getPlanta();
                nomPlantaHab2 = listaDatos.get(1).getPlanta();
                montoNocheH1 = montohabit(nomHab1);
                montoNocheH2 = montohabit(nomHab2);
                monTotalH1 = montoNocheH1 * dias;
                monTotalH2 = montoNocheH2 * dias;
                montoTodasHab = monTotalH1 + monTotalH2;
                porcenPlantaHab1 = (montoTodasHab * porPlanta2) / 100;
                porcenPlantaHab2 = (montoTodasHab * porPlanta1) / 100;
                // totalMascota = (montoTodasHab * porMascota) / 100;
                totalPagar = montoTodasHab + porcenPlantaHab1 + porcenPlantaHab2;
                tAreaHatsinMas2(montoNocheH1, montoNocheH2, dias, monTotalH1, monTotalH2, montoTodasHab, porPlanta2, porPlanta1, porcenPlantaHab1, porcenPlantaHab2, totalPagar, nomHab1, nomHab2, nomPlantaHab1, nomPlantaHab2, areaTexto);
                // break;
            } else if ((listaDatos.get(0).getPlanta().equals("Planta 2") && listaDatos.get(0).getNombre().equals(hab1)) && (listaDatos.get(1).getPlanta().equals("Planta 2") && listaDatos.get(1).getNombre().equals(hab2))) {
                nomHab1 = listaDatos.get(0).getNombre();
                nomHab2 = listaDatos.get(1).getNombre();
                nomPlantaHab1 = listaDatos.get(0).getPlanta();
                nomPlantaHab2 = listaDatos.get(1).getPlanta();
                montoNocheH1 = montohabit(nomHab1);
                montoNocheH2 = montohabit(nomHab2);
                monTotalH1 = montoNocheH1 * dias;
                monTotalH2 = montoNocheH2 * dias;
                montoTodasHab = monTotalH1 + monTotalH2;
                porcenPlantaHab1 = (montoTodasHab * porPlanta2) / 100;
                porcenPlantaHab2 = (montoTodasHab * porPlanta2) / 100;
                //totalMascota = (montoTodasHab * porMascota) / 100;
                totalPagar = montoTodasHab + porcenPlantaHab1 + porcenPlantaHab2;
                tAreaHatsinMas2(montoNocheH1, montoNocheH2, dias, monTotalH1, monTotalH2, montoTodasHab, porPlanta2, porPlanta2, porcenPlantaHab1, porcenPlantaHab2, totalPagar, nomHab1, nomHab2, nomPlantaHab1, nomPlantaHab2, areaTexto);
                // break;
            } else if ((listaDatos.get(0).getPlanta().equals("Planta 2") && listaDatos.get(0).getNombre().equals(hab2)) && (listaDatos.get(1).getPlanta().equals("Planta 2") && listaDatos.get(1).getNombre().equals(hab1))) {
                nomHab1 = listaDatos.get(0).getNombre();
                nomHab2 = listaDatos.get(1).getNombre();
                nomPlantaHab1 = listaDatos.get(0).getPlanta();
                nomPlantaHab2 = listaDatos.get(1).getPlanta();
                montoNocheH1 = montohabit(nomHab1);
                montoNocheH2 = montohabit(nomHab2);
                monTotalH1 = montoNocheH1 * dias;
                monTotalH2 = montoNocheH2 * dias;
                montoTodasHab = monTotalH1 + monTotalH2;
                porcenPlantaHab1 = (montoTodasHab * porPlanta2) / 100;
                porcenPlantaHab2 = (montoTodasHab * porPlanta2) / 100;
                // totalMascota = (montoTodasHab * porMascota) / 100;
                totalPagar = montoTodasHab + porcenPlantaHab1 + porcenPlantaHab2;
                tAreaHatsinMas2(montoNocheH1, montoNocheH2, dias, monTotalH1, monTotalH2, montoTodasHab, porPlanta2, porPlanta2, porcenPlantaHab1, porcenPlantaHab2, totalPagar, nomHab1, nomHab2, nomPlantaHab1, nomPlantaHab2, areaTexto);
                // break;
            } else if ((listaDatos.get(0).getPlanta().equals("Planta 2") && listaDatos.get(0).getNombre().equals(hab1)) && (listaDatos.get(1).getPlanta().equals("Planta 3") && listaDatos.get(1).getNombre().equals(hab2))) {
                nomHab1 = listaDatos.get(0).getNombre();
                nomHab2 = listaDatos.get(1).getNombre();
                nomPlantaHab1 = listaDatos.get(0).getPlanta();
                nomPlantaHab2 = listaDatos.get(1).getPlanta();
                montoNocheH1 = montohabit(nomHab1);
                montoNocheH2 = montohabit(nomHab2);
                monTotalH1 = montoNocheH1 * dias;
                monTotalH2 = montoNocheH2 * dias;
                montoTodasHab = monTotalH1 + monTotalH2;
                porcenPlantaHab1 = (montoTodasHab * porPlanta2) / 100;
                porcenPlantaHab2 = (montoTodasHab * porPlanta3) / 100;
                // totalMascota = (montoTodasHab * porMascota) / 100;
                totalPagar = montoTodasHab + porcenPlantaHab1 + porcenPlantaHab2;
                tAreaHatsinMas2(montoNocheH1, montoNocheH2, dias, monTotalH1, monTotalH2, montoTodasHab, porPlanta2, porPlanta3, porcenPlantaHab1, porcenPlantaHab2, totalPagar, nomHab1, nomHab2, nomPlantaHab1, nomPlantaHab2, areaTexto);
                //break;
            } else if ((listaDatos.get(0).getPlanta().equals("Planta 2") && listaDatos.get(0).getNombre().equals(hab2)) && (listaDatos.get(1).getPlanta().equals("Planta 3") && listaDatos.get(1).getNombre().equals(hab1))) {
                nomHab1 = listaDatos.get(0).getNombre();
                nomHab2 = listaDatos.get(1).getNombre();
                nomPlantaHab1 = listaDatos.get(0).getPlanta();
                nomPlantaHab2 = listaDatos.get(1).getPlanta();
                montoNocheH1 = montohabit(nomHab1);
                montoNocheH2 = montohabit(nomHab2);
                monTotalH1 = montoNocheH1 * dias;
                monTotalH2 = montoNocheH2 * dias;
                montoTodasHab = monTotalH1 + monTotalH2;
                porcenPlantaHab1 = (montoTodasHab * porPlanta2) / 100;
                porcenPlantaHab2 = (montoTodasHab * porPlanta3) / 100;
                //totalMascota = (montoTodasHab * porMascota) / 100;
                totalPagar = montoTodasHab + porcenPlantaHab1 + porcenPlantaHab2;
                tAreaHatsinMas2(montoNocheH1, montoNocheH2, dias, monTotalH1, monTotalH2, montoTodasHab, porPlanta2, porPlanta3, porcenPlantaHab1, porcenPlantaHab2, totalPagar, nomHab1, nomHab2, nomPlantaHab1, nomPlantaHab2, areaTexto);
                //break;
            }
            if ((listaDatos.get(0).getPlanta().equals("Planta 3") && listaDatos.get(0).getNombre().equals(hab1)) && (listaDatos.get(1).getPlanta().equals("Planta 1") && listaDatos.get(1).getNombre().equals(hab2))) {
                nomHab1 = listaDatos.get(0).getNombre();
                nomHab2 = listaDatos.get(1).getNombre();
                nomPlantaHab1 = listaDatos.get(0).getPlanta();
                nomPlantaHab2 = listaDatos.get(1).getPlanta();
                montoNocheH1 = montohabit(nomHab1);
                montoNocheH2 = montohabit(nomHab2);
                monTotalH1 = montoNocheH1 * dias;
                monTotalH2 = montoNocheH2 * dias;
                montoTodasHab = monTotalH1 + monTotalH2;
                porcenPlantaHab1 = (montoTodasHab * porPlanta3) / 100;
                porcenPlantaHab2 = (montoTodasHab * porPlanta1) / 100;
                //totalMascota = (montoTodasHab * porMascota) / 100;
                totalPagar = montoTodasHab + porcenPlantaHab1 + porcenPlantaHab2;
                tAreaHatsinMas2(montoNocheH1, montoNocheH2, dias, monTotalH1, monTotalH2, montoTodasHab, porPlanta3, porPlanta3, porcenPlantaHab1, porcenPlantaHab2, totalPagar, nomHab1, nomHab2, nomPlantaHab1, nomPlantaHab2, areaTexto);
                // break;
            } else if ((listaDatos.get(0).getPlanta().equals("Planta 3") && listaDatos.get(0).getNombre().equals(hab2)) && (listaDatos.get(1).getPlanta().equals("Planta 1") && listaDatos.get(1).getNombre().equals(hab1))) {
                nomHab1 = listaDatos.get(0).getNombre();
                nomHab2 = listaDatos.get(1).getNombre();
                nomPlantaHab1 = listaDatos.get(0).getPlanta();
                nomPlantaHab2 = listaDatos.get(1).getPlanta();
                montoNocheH1 = montohabit(nomHab1);
                montoNocheH2 = montohabit(nomHab2);
                monTotalH1 = montoNocheH1 * dias;
                monTotalH2 = montoNocheH2 * dias;
                montoTodasHab = monTotalH1 + monTotalH2;
                porcenPlantaHab1 = (montoTodasHab * porPlanta3) / 100;
                porcenPlantaHab2 = (montoTodasHab * porPlanta1) / 100;
                //totalMascota = (montoTodasHab * porMascota) / 100;
                totalPagar = montoTodasHab + porcenPlantaHab1 + porcenPlantaHab2;
                tAreaHatsinMas2(montoNocheH1, montoNocheH2, dias, monTotalH1, monTotalH2, montoTodasHab, porPlanta3, porPlanta1, porcenPlantaHab1, porcenPlantaHab2, totalPagar, nomHab1, nomHab2, nomPlantaHab1, nomPlantaHab2, areaTexto);
                // break;
            } else if ((listaDatos.get(0).getPlanta().equals("Planta 3") && listaDatos.get(0).getNombre().equals(hab1)) && (listaDatos.get(1).getPlanta().equals("Planta 2") && listaDatos.get(1).getNombre().equals(hab2))) {
                nomHab1 = listaDatos.get(0).getNombre();
                nomHab2 = listaDatos.get(1).getNombre();
                nomPlantaHab1 = listaDatos.get(0).getPlanta();
                nomPlantaHab2 = listaDatos.get(1).getPlanta();
                montoNocheH1 = montohabit(nomHab1);
                montoNocheH2 = montohabit(nomHab2);
                monTotalH1 = montoNocheH1 * dias;
                monTotalH2 = montoNocheH2 * dias;
                montoTodasHab = monTotalH1 + monTotalH2;
                porcenPlantaHab1 = (montoTodasHab * porPlanta3) / 100;
                porcenPlantaHab2 = (montoTodasHab * porPlanta2) / 100;
                //totalMascota = (montoTodasHab * porMascota) / 100;
                totalPagar = montoTodasHab + porcenPlantaHab1 + porcenPlantaHab2;
                tAreaHatsinMas2(montoNocheH1, montoNocheH2, dias, monTotalH1, monTotalH2, montoTodasHab, porPlanta3, porPlanta2, porcenPlantaHab1, porcenPlantaHab2, totalPagar, nomHab1, nomHab2, nomPlantaHab1, nomPlantaHab2, areaTexto);
                // break;
            } else if ((listaDatos.get(0).getPlanta().equals("Planta 3") && listaDatos.get(0).getNombre().equals(hab2)) && (listaDatos.get(1).getPlanta().equals("Planta 2") && listaDatos.get(1).getNombre().equals(hab1))) {
                nomHab1 = listaDatos.get(0).getNombre();
                nomHab2 = listaDatos.get(1).getNombre();
                nomPlantaHab1 = listaDatos.get(0).getPlanta();
                nomPlantaHab2 = listaDatos.get(1).getPlanta();
                montoNocheH1 = montohabit(nomHab1);
                montoNocheH2 = montohabit(nomHab2);
                monTotalH1 = montoNocheH1 * dias;
                monTotalH2 = montoNocheH2 * dias;
                montoTodasHab = monTotalH1 + monTotalH2;
                porcenPlantaHab1 = (montoTodasHab * porPlanta3) / 100;
                porcenPlantaHab2 = (montoTodasHab * porPlanta2) / 100;
                //totalMascota = (montoTodasHab * porMascota) / 100;
                totalPagar = montoTodasHab + porcenPlantaHab1 + porcenPlantaHab2;
                tAreaHatsinMas2(montoNocheH1, montoNocheH2, dias, monTotalH1, monTotalH2, montoTodasHab, porPlanta3, porPlanta2, porcenPlantaHab1, porcenPlantaHab2, totalPagar, nomHab1, nomHab2, nomPlantaHab1, nomPlantaHab2, areaTexto);
                // break;
            } else if ((listaDatos.get(0).getPlanta().equals("Planta 3") && listaDatos.get(0).getNombre().equals(hab1)) && (listaDatos.get(1).getPlanta().equals("Planta 3") && listaDatos.get(1).getNombre().equals(hab2))) {
                nomHab1 = listaDatos.get(0).getNombre();
                nomHab2 = listaDatos.get(1).getNombre();
                nomPlantaHab1 = listaDatos.get(0).getPlanta();
                nomPlantaHab2 = listaDatos.get(1).getPlanta();
                montoNocheH1 = montohabit(nomHab1);
                montoNocheH2 = montohabit(nomHab2);
                monTotalH1 = montoNocheH1 * dias;
                monTotalH2 = montoNocheH2 * dias;
                montoTodasHab = monTotalH1 + monTotalH2;
                porcenPlantaHab1 = (montoTodasHab * porPlanta3) / 100;
                porcenPlantaHab2 = (montoTodasHab * porPlanta3) / 100;
                //totalMascota = (montoTodasHab * porMascota) / 100;
                totalPagar = montoTodasHab + porcenPlantaHab1 + porcenPlantaHab2;
                tAreaHatsinMas2(montoNocheH1, montoNocheH2, dias, monTotalH1, monTotalH2, montoTodasHab, porPlanta3, porPlanta3, porcenPlantaHab1, porcenPlantaHab2, totalPagar, nomHab1, nomHab2, nomPlantaHab1, nomPlantaHab2, areaTexto);
                //break;
            } else if ((listaDatos.get(0).getPlanta().equals("Planta 3") && listaDatos.get(0).getNombre().equals(hab2)) && (listaDatos.get(1).getPlanta().equals("Planta 3") && listaDatos.get(1).getNombre().equals(hab1))) {
                nomHab1 = listaDatos.get(0).getNombre();
                nomHab2 = listaDatos.get(1).getNombre();
                nomPlantaHab1 = listaDatos.get(0).getPlanta();
                nomPlantaHab2 = listaDatos.get(1).getPlanta();
                montoNocheH1 = montohabit(nomHab1);
                montoNocheH2 = montohabit(nomHab2);
                monTotalH1 = montoNocheH1 * dias;
                monTotalH2 = montoNocheH2 * dias;
                montoTodasHab = monTotalH1 + monTotalH2;
                porcenPlantaHab1 = (montoTodasHab * porPlanta3) / 100;
                porcenPlantaHab2 = (montoTodasHab * porPlanta3) / 100;
                // totalMascota = (montoTodasHab * porMascota) / 100;
                totalPagar = montoTodasHab + porcenPlantaHab1 + porcenPlantaHab2;
                tAreaHatsinMas2(montoNocheH1, montoNocheH2, dias, monTotalH1, monTotalH2, montoTodasHab, porPlanta3, porPlanta3, porcenPlantaHab1, porcenPlantaHab2, totalPagar, nomHab1, nomHab2, nomPlantaHab1, nomPlantaHab2, areaTexto);
                //break;
            }
            //}
        }
    }

    public int porcePlanta(String planta) {
        int nPlanta = 0;
        if (planta.equals("Planta 1")) {
            nPlanta = 15;
        } else if (planta.equals("Planta 2")) {
            nPlanta = 10;
        } else if (planta.equals("Planta 3")) {
            nPlanta = 5;
        }
        return nPlanta;
    }

    public void detalle3HabitMas(ArrayList<objConsultaReserva> listaDatos, JTextArea areaTexto, String plan1, String plan2, String plan3, String fecha1, String fecha2) {
        int tamano = listaDatos.size();
        double dia;
        dia = dbreserva.consultadias(fecha1, fecha2);
        dias = (int) dia;
        if (tamano == 3) {
            // for (int i = 0; i < listaDatos.size(); i++) {
            areaTexto.setText("");
            if ((listaDatos.get(0).getPlanta().equals(plan1) && listaDatos.get(0).getNombre().equals("Junior")) && (listaDatos.get(1).getPlanta().equals(plan2) && listaDatos.get(1).getNombre().equals("Junior")) && (listaDatos.get(2).getPlanta().equals(plan3) && listaDatos.get(2).getNombre().equals("Junior"))) {
                nomHab1 = listaDatos.get(0).getNombre();
                nomHab2 = listaDatos.get(1).getNombre();
                nomHab3 = listaDatos.get(2).getNombre();
                nomPlantaHab1 = listaDatos.get(0).getPlanta();
                nomPlantaHab2 = listaDatos.get(1).getPlanta();
                nomPlantaHab3 = listaDatos.get(2).getPlanta();
                montoNocheH1 = montohabit(nomHab1);
                montoNocheH2 = montohabit(nomHab2);
                montoNocheH3 = montohabit(nomHab3);
                monTotalH1 = montoNocheH1 * dias;
                monTotalH2 = montoNocheH2 * dias;
                monTotalH3 = montoNocheH3 * dias;
                montoTodasHab = monTotalH1 + monTotalH2 + monTotalH3;
                porPlan1 = porcePlanta(nomPlantaHab1);
                porPlan2 = porcePlanta(nomPlantaHab2);
                porPlan3 = porcePlanta(nomPlantaHab3);
                porcenPlantaHab1 = (montoTodasHab * porcePlanta(nomPlantaHab1)) / 100;
                porcenPlantaHab2 = (montoTodasHab * porcePlanta(nomPlantaHab2)) / 100;
                porcenPlantaHab3 = (montoTodasHab * porcePlanta(nomPlantaHab3)) / 100;
                totalMascota = (montoTodasHab * porMascota) / 100;
                totalPagar = montoTodasHab + porcenPlantaHab1 + porcenPlantaHab2 + porcenPlantaHab3 + totalMascota;
                //tAreaHatMas2(montoNocheH1, montoNocheH2, dias, monTotalH1, monTotalH2, montoTodasHab, porPlanta1, porPlanta1, porcenPlantaHab1, porcenPlantaHab2, porMascota, totalMascota, totalPagar, nomHab1, nomHab2, nomPlantaHab1, nomPlantaHab2, areaTexto);
                tAreaHatMas3(montoNocheH1, montoNocheH2, montoNocheH3, dias, monTotalH1, monTotalH2, monTotalH3, montoTodasHab, porPlan1, porPlan2, porPlan3, porcenPlantaHab1, porcenPlantaHab2, porcenPlantaHab3, porMascota, totalMascota, totalPagar, nomHab1, nomHab2, nomHab3, nomPlantaHab1, nomPlantaHab2, nomPlantaHab3, areaTexto);
            }
        }
    }

    public void detalle3HabiSintMas(ArrayList<objConsultaReserva> listaDatos, JTextArea areaTexto, String plan1, String plan2, String plan3, String fecha1, String fecha2) {
        int tamano = listaDatos.size();
        double dia;
        dia = dbreserva.consultadias(fecha1, fecha2);
        dias = (int) dia;
        if (tamano == 3) {
            // for (int i = 0; i < listaDatos.size(); i++) {
            areaTexto.setText("");
            if ((listaDatos.get(0).getPlanta().equals(plan1) && listaDatos.get(0).getNombre().equals("Junior")) && (listaDatos.get(1).getPlanta().equals(plan2) && listaDatos.get(1).getNombre().equals("Junior")) && (listaDatos.get(2).getPlanta().equals(plan3) && listaDatos.get(2).getNombre().equals("Junior"))) {
                nomHab1 = listaDatos.get(0).getNombre();
                nomHab2 = listaDatos.get(1).getNombre();
                nomHab3 = listaDatos.get(2).getNombre();
                nomPlantaHab1 = listaDatos.get(0).getPlanta();
                nomPlantaHab2 = listaDatos.get(1).getPlanta();
                nomPlantaHab3 = listaDatos.get(2).getPlanta();
                montoNocheH1 = montohabit(nomHab1);
                montoNocheH2 = montohabit(nomHab2);
                montoNocheH3 = montohabit(nomHab3);
                monTotalH1 = montoNocheH1 * dias;
                monTotalH2 = montoNocheH2 * dias;
                monTotalH3 = montoNocheH3 * dias;
                montoTodasHab = monTotalH1 + monTotalH2 + monTotalH3;
                porPlan1 = porcePlanta(nomPlantaHab1);
                porPlan2 = porcePlanta(nomPlantaHab2);
                porPlan3 = porcePlanta(nomPlantaHab3);
                porcenPlantaHab1 = (montoTodasHab * porcePlanta(nomPlantaHab1)) / 100;
                porcenPlantaHab2 = (montoTodasHab * porcePlanta(nomPlantaHab2)) / 100;
                porcenPlantaHab3 = (montoTodasHab * porcePlanta(nomPlantaHab3)) / 100;
                totalPagar = montoTodasHab + porcenPlantaHab1 + porcenPlantaHab2 + porcenPlantaHab3;
                //tAreaHatMas2(montoNocheH1, montoNocheH2, dias, monTotalH1, monTotalH2, montoTodasHab, porPlanta1, porPlanta1, porcenPlantaHab1, porcenPlantaHab2, porMascota, totalMascota, totalPagar, nomHab1, nomHab2, nomPlantaHab1, nomPlantaHab2, areaTexto);
                tAreaHatSinMas3(montoNocheH1, montoNocheH2, montoNocheH3, dias, monTotalH1, monTotalH2, monTotalH3, montoTodasHab, porPlan1, porPlan2, porPlan3, porcenPlantaHab1, porcenPlantaHab2, porcenPlantaHab3, totalPagar, nomHab1, nomHab2, nomHab3, nomPlantaHab1, nomPlantaHab2, nomPlantaHab3, areaTexto);
            }
        }
    }

    public void tAreaHat1Mas(int monNocheH1, int cantiDias, int monTotalHa1, int monTodasH, int porPlan1, int porcePlanHab1, int porMasco, int totalMasco, int totalPagar, String nomHab, String nomPlanta, JTextArea areaTexto) {
        // areaTexto.append("Monto por noche de la habitacion " + nomHab + ": " + String.valueOf(monNocheH1));
        areaTexto.append("Monto por noche de la habitacion " + nomHab + ": " +"$"+  String.valueOf(monNocheH1) + " * " + cantiDias +" dias"+ " = " +"$"+  String.valueOf(monTotalHa1));
        areaTexto.append("\nMonto de las habitaciones: " +"$"+  String.valueOf(monTodasH)); //Monto total de todas las hab
        areaTexto.append("\nMonto de la habitacion con el porcentaje de "
                + "la " + nomPlanta + ": " +"$"+  String.valueOf(monTodasH) + " * " +"$"+  String.valueOf(porPlan1) + " % " + " = " +"$"+  String.valueOf(porcePlanHab1)); //Monto con poorcentaje de la 1 hab
        areaTexto.append("\nMonto de la habitacion con el porcentaje de la mascota: " +"$"+  String.valueOf(monTodasH) + " * " +"$"+  String.valueOf(porMasco) + " % " + " = " +"$"+  String.valueOf(totalMasco));
        areaTexto.append("\nMonto total a pagar:" +"$"+  monTodasH + " + " +"$"+  porcePlanHab1 + " + " +"$"+  totalMasco + " = " +"$"+  totalPagar);
        objmonto.listamonto.add( new objmonto(totalPagar));
    }

    public void tAreaHat1SinMas(int monNocheH1, int cantiDias, int monTotalHa1, int monTodasH, int porPlan1, int porcePlanHab1, int totalPagar, String nomHab, String nomPlanta, JTextArea areaTexto) {
        areaTexto.append("Monto por noche de la habitacion " + nomHab + ": " +"$"+ String.valueOf(monNocheH1) + " * " + cantiDias +" dias"+ " = " + String.valueOf(monTotalHa1));
        areaTexto.append("\nMonto de las habitaciones: " +"$" + String.valueOf(monTodasH)); //Monto total de todas las hab
        areaTexto.append("\nMonto de la habitacion con el porcentaje de "
                + "la " + nomPlanta + ": " +"$" + String.valueOf(monTodasH) + " * " +"$" + String.valueOf(porPlan1) + " % " + " = " +"$" + String.valueOf(porcePlanHab1)); //Monto con poorcentaje de la 1 hab
        areaTexto.append("\nMonto total a pagar:" +"$" + monTodasH + " + " +"$" + porcePlanHab1 + " = " +"$" + totalPagar);
        objmonto.listamonto.add( new objmonto(totalPagar));

    }

    public void tAreaHatMas2(int monNocheH1, int monNocheH2, int cantiDias, int monTotalHa1, int monTotalHa2, int monTodasH, int porPlan1, int porPlan2, int porcePlanHab1, int porcePlanHab2, int porMasco, int totalMasco, int totalPagar, String nomHab1, String nomHab2, String nomPlanta1, String nomPlanta2, JTextArea areaTexto) {
        areaTexto.append("Monto por noche de la habitacion " + nomHab1 + ": " +"$"+ String.valueOf(monNocheH1) + " * " + cantiDias +" dias"+  " = " +"$"+ String.valueOf(monTotalHa1));
        areaTexto.append("\nMonto por noche de la habitacion " + nomHab2 + ": " +"$"+ String.valueOf(monNocheH2) + " + " + cantiDias +" dias"+ " = " +"$"+ String.valueOf(monTotalHa2));
        areaTexto.append("\nMonto de las habitaciones: " +"$"+ String.valueOf(monTotalHa1) + " + " +"$"+ String.valueOf(monTotalHa2) + " = " +"$"+ String.valueOf(monTodasH)); //Monto total de todas las hab
        areaTexto.append("\nMonto de la habitacion con el porcentaje de "
                + "la " + nomPlanta1 + ": " +"$"+ String.valueOf(monTodasH) + " * " +"$"+ String.valueOf(porPlan1) + " % " + " = " +"$"+ String.valueOf(porcePlanHab1)); //Monto con poorcentaje de la 1 hab
        areaTexto.append("\nMonto de la habitacion con el porcentaje de "
                + "la " + nomPlanta2 + ": " +"$"+ String.valueOf(monTodasH) + " * " +"$"+ String.valueOf(porPlan2) + " % " + " = " +"$"+ String.valueOf(porcePlanHab2)); //Monto con poorcentaje de la 2 hab
        areaTexto.append("\nMonto de la habitacion con el porcentaje de la mascota: " +"$"+ String.valueOf(monTodasH) + " * " +"$"+ String.valueOf(porMasco) + " % " + " = " +"$"+ String.valueOf(totalMasco));
        areaTexto.append("\nMonto total a pagar:" +"$"+ monTodasH + " + " +"$"+ porcePlanHab1 + " + " +"$"+ porcePlanHab2 + " + " +"$"+ totalMasco + " = " +"$"+ totalPagar);
        objmonto.listamonto.add( new objmonto(totalPagar));
    }

    public void tAreaHatsinMas2(int monNocheH1, int monNocheH2, int cantiDias, int monTotalHa1, int monTotalHa2, int monTodasH, int porPlan1, int porPlan2, int porcePlanHab1, int porcePlanHab2, int totalPagar, String nomHab1, String nomHab2, String nomPlanta1, String nomPlanta2, JTextArea areaTexto) {
        areaTexto.append("Monto por noche de la habitacion " + nomHab1 + ": " +"$"+ String.valueOf(monNocheH1) + " * " + cantiDias +" dias"+  " = " +"$"+ String.valueOf(monTotalHa1));
        areaTexto.append("\nMonto por noche de la habitacion " + nomHab2 + ": " +"$"+ String.valueOf(monNocheH2) + " + " + cantiDias +" dias"+  " = " +"$"+ String.valueOf(monTotalHa2));
        areaTexto.append("\nMonto de las habitaciones: " +"$"+ String.valueOf(monTotalHa1) + " + " +"$"+ String.valueOf(monTotalHa2) + " = " +"$"+ String.valueOf(monTodasH)); //Monto total de todas las hab
        areaTexto.append("\nMonto de la habitacion con el porcentaje de "
                + "la " + nomPlanta1 + ": " +"$"+ String.valueOf(monTodasH) + " * " +"$"+ String.valueOf(porPlan1) + " % " + " = " +"$"+ String.valueOf(porcePlanHab1)); //Monto con poorcentaje de la 1 hab
        areaTexto.append("\nMonto de la habitacion con el porcentaje de "
                + "la " + nomPlanta2 + ": " +"$"+ String.valueOf(monTodasH) + " * " +"$"+ String.valueOf(porPlan2) + " % " + " = " +"$"+ String.valueOf(porcePlanHab2)); //Monto con poorcentaje de la 2 hab
        areaTexto.append("\nMonto total a pagar:" +"$"+ monTodasH + " + " +"$"+ porcePlanHab1 + " + " +"$"+ porcePlanHab2 + " = " +"$"+ totalPagar);
       objmonto.listamonto.add( new objmonto(totalPagar));
    }

    public void tAreaHatMas3(int monNocheH1, int monNocheH2, int monNocheH3, int cantiDias, int monTotalHa1, int monTotalHa2, int monTotalHa3, int monTodasH, int porPlan1, int porPlan2, int porPlan3, int porcePlanHab1, int porcePlanHab2, int porcePlanHab3, int porMasco, int totalMasco, int totalPagar, String nomHab1, String nomHab2, String nomHab3, String nomPlanta1, String nomPlanta2, String nomPlanta3, JTextArea areaTexto) {
        areaTexto.append("Monto por noche de la habitacion " + nomHab1 + ": " +"$" + String.valueOf(monNocheH1) + " * " + cantiDias +" dias"+ " = " +"$" + String.valueOf(monTotalHa1));
        areaTexto.append("\nMonto por noche de la habitacion " + nomHab2 + ": " +"$" + String.valueOf(monNocheH2) + " * " + cantiDias +" dias"+ " = " +"$" + String.valueOf(monTotalHa2));
        areaTexto.append("\nMonto por noche de la habitacion " + nomHab3 + ": " +"$" + String.valueOf(monNocheH3) + " * " + cantiDias +" dias"+ " = " +"$" + String.valueOf(monTotalHa3));
        areaTexto.append("\nMonto de las habitaciones: " +"$" + String.valueOf(monTotalHa1) + " + " +"$" + String.valueOf(monTotalHa2) + " + " +"$" + String.valueOf(monTotalHa3) + " = " +"$" + String.valueOf(monTodasH)); //Monto total de todas las hab
        areaTexto.append("\nMonto de la habitacion con el porcentaje de "
                + "la " + nomPlanta1 + ": " +"$" + String.valueOf(monTodasH) + " * " +"$" + String.valueOf(porPlan1) + " % " + " = " +"$" + String.valueOf(porcePlanHab1)); //Monto con poorcentaje de la 1 hab
        areaTexto.append("\nMonto de la habitacion con el porcentaje de "
                + "la " + nomPlanta2 + ": " +"$" + String.valueOf(monTodasH) + " * " +"$" + String.valueOf(porPlan2) + " % " + " = " +"$" + String.valueOf(porcePlanHab2)); //Monto con poorcentaje de la 2 hab
        areaTexto.append("\nMonto de la habitacion con el porcentaje de "
                + "la " + nomPlanta3 + ": " +"$" + String.valueOf(monTodasH) + " * " +"$" + String.valueOf(porPlan3) + " % " + " = " +"$" + String.valueOf(porcePlanHab3)); //Monto con poorcentaje de la 2 hab
        areaTexto.append("\nMonto de la habitacion con el porcentaje de la mascota: " +"$" + String.valueOf(monTodasH) + " * " +"$" + String.valueOf(porMasco) + " % " + " = " +"$" + String.valueOf(totalMasco));
        areaTexto.append("\nMonto total a pagar:" +"$" + monTodasH + " + " +"$" + porcePlanHab1 + " + " +"$" + porcePlanHab2 + " + " +"$" + porcePlanHab3 + " + " +"$" + totalMasco + " = " +"$" + totalPagar);
        objmonto.listamonto.add( new objmonto(totalPagar));
    }

    public void tAreaHatSinMas3(int monNocheH1, int monNocheH2, int monNocheH3, int cantiDias, int monTotalHa1, int monTotalHa2, int monTotalHa3, int monTodasH, int porPlan1, int porPlan2, int porPlan3, int porcePlanHab1, int porcePlanHab2, int porcePlanHab3, int totalPagar, String nomHab1, String nomHab2, String nomHab3, String nomPlanta1, String nomPlanta2, String nomPlanta3, JTextArea areaTexto) {
        areaTexto.append("Monto por noche de la habitacion " + nomHab1 + ": " +"$" + String.valueOf(monNocheH1) + " * " + cantiDias +" dias"+ " = " +"$" + String.valueOf(monTotalHa1));
        areaTexto.append("\nMonto por noche de la habitacion " + nomHab2 + ": " +"$" + String.valueOf(monNocheH2) + " * " + cantiDias +" dias"+ " = " +"$" + String.valueOf(monTotalHa2));
        areaTexto.append("\nMonto por noche de la habitacion " + nomHab3 + ": " +"$" + String.valueOf(monNocheH3) + " * " + cantiDias +" dias"+ " = " +"$" + String.valueOf(monTotalHa3));
        areaTexto.append("\nMonto de las habitaciones: " +"$" + String.valueOf(monTotalHa1) + " + " +"$" + String.valueOf(monTotalHa2) + " + " +"$" + String.valueOf(monTotalHa3) + " = " +"$" + String.valueOf(monTodasH)); //Monto total de todas las hab
        areaTexto.append("\nMonto de la habitacion con el porcentaje de "
                + "la " + nomPlanta1 + ": " +"$" + String.valueOf(monTodasH) + " * " +"$" + String.valueOf(porPlan1) + " % " + " = " +"$" + String.valueOf(porcePlanHab1)); //Monto con poorcentaje de la 1 hab
        areaTexto.append("\nMonto de la habitacion con el porcentaje de "
                + "la " + nomPlanta2 + ": " +"$" + String.valueOf(monTodasH) + " * " +"$" + String.valueOf(porPlan2) + " % " + " = " +"$" + String.valueOf(porcePlanHab2)); //Monto con poorcentaje de la 2 hab
        areaTexto.append("\nMonto de la habitacion con el porcentaje de "
                + "la " + nomPlanta3 + ": " +"$" + String.valueOf(monTodasH) + " * " +"$" + String.valueOf(porPlan3) + " % " + " = " +"$" + String.valueOf(porcePlanHab3)); //Monto con poorcentaje de la 2 hab
        areaTexto.append("\nMonto total a pagar:" +"$" +  monTodasH + " + " +"$" +  porcePlanHab1 + " + " +"$" +  porcePlanHab2 + " + " +"$" +  porcePlanHab3 + " = " +"$" +  totalPagar);
        objmonto.listamonto.add( new objmonto(totalPagar));
    }
}
