package datos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import objetos.objConsultaReserva;

/**
 *
 * @author yasni
 */
public class BDReservaPrueba {

    private Statement s = null;
    private Connection connection = null;
    BDConexion conexion = new BDConexion();
    private ResultSet rs = null;

    //Consulta que solamente extrae 1 habitacion Junior, con mascota
    public double consultadias(String fechaentrada, String fechasalida) {
        double dia = 0;
        try {
            connection = conexion.Conexion();
            s = connection.createStatement();
            rs = s.executeQuery("select extract(days from (timestamp '" + fechasalida + "' - timestamp '" + fechaentrada + "')) as cantidias");
            while (rs.next()) {
                dia = rs.getDouble("cantidias");
            }
            System.out.println(dia);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de conexión", "Mensaje", JOptionPane.ERROR_MESSAGE);
        }
        return dia;

    }

    public ArrayList<objConsultaReserva> consultasGeneral() {
        ArrayList<objConsultaReserva> datos = new ArrayList<>();
        try {
            connection = conexion.Conexion();
            s = connection.createStatement();
            rs = s.executeQuery("select h.id,h.planta,t.nombre,h.estado,h.mascota from habitacion h, tipo_hab t where h.tipo = t.id");
            while (rs.next()) {
                datos.add(new objConsultaReserva(rs.getInt("id"), rs.getString("planta"), rs.getString("nombre"), rs.getString("estado"), rs.getString("mascota")));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de conexión", "Mensaje", JOptionPane.ERROR_MESSAGE);
        }
        return datos;
    }

    //Consulta que solamente extrae 1 habitacion Junior, con mascota
    public ArrayList<objConsultaReserva> consultaJunior1(String fecha1, String fecha2) {
        ArrayList<objConsultaReserva> datos = new ArrayList<>();
        try {
            connection = conexion.Conexion();
            s = connection.createStatement();
            rs = s.executeQuery("select e.id, e.planta,n.nombre, e.mascota from habitacion e, tipo_hab n, historial u where  e.tipo = n.id and e.estado  = 'Disponible' and n.nombre = 'Junior' union select e.id, e.planta,n.nombre, e.mascota from habitacion e, tipo_hab n, historial u, usuario_hab l where e.tipo = n.id and e.id = l.id_hab and l.id = u.usuario_hab and '" + fecha1 + "' not between u.ingreso and u.salida and '" + fecha2 + "' not between u.ingreso and u.salida and n.nombre = 'Junior' order by id");
            while (rs.next()) {
                datos.add(new objConsultaReserva(rs.getInt("id"), rs.getString("planta"), rs.getString("nombre"), rs.getString("mascota")));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de conexión", "Mensaje", JOptionPane.ERROR_MESSAGE);
        }
        return datos;
    }

    //Consulta que solamente extrae 1 habitacion Junior, con mascota
    public ArrayList<objConsultaReserva> consultaEstandar(String fecha1, String fecha2) {
        ArrayList<objConsultaReserva> datos = new ArrayList<>();
        try {
            connection = conexion.Conexion();
            s = connection.createStatement();
            rs = s.executeQuery("select e.id, e.planta,n.nombre, e.mascota from habitacion e, tipo_hab n, historial u where  e.tipo = n.id and e.estado  = 'Disponible' and n.nombre = 'Estandar' union select e.id, e.planta,n.nombre, e.mascota from habitacion e, tipo_hab n, historial u, usuario_hab l where e.tipo = n.id and e.id = l.id_hab and l.id = u.usuario_hab and '" + fecha1 + "' not between u.ingreso and u.salida and '" + fecha2 + "' not between u.ingreso and u.salida and n.nombre = 'Estandar' order by id");
            while (rs.next()) {
                datos.add(new objConsultaReserva(rs.getInt("id"), rs.getString("planta"), rs.getString("nombre"), rs.getString("mascota")));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de conexión", "Mensaje", JOptionPane.ERROR_MESSAGE);
        }
        return datos;
    }

    public ArrayList<objConsultaReserva> consultaEstandarJunior(String fecha1, String fecha2) {
        ArrayList<objConsultaReserva> datos = new ArrayList<>();
        try {
            connection = conexion.Conexion();
            s = connection.createStatement();
            rs = s.executeQuery("select e.id, e.planta,n.nombre, e.mascota "
                    + "from habitacion e, tipo_hab n, historial u "
                    + "where  e.tipo = n.id and e.estado  = 'Disponible' and (n.nombre = 'Estandar' or n.nombre = 'Junior') "
                    + "union"
                    + " select e.id, e.planta,n.nombre, e.mascota "
                    + "from habitacion e, tipo_hab n, historial u, usuario_hab l "
                    + "where e.tipo = n.id and e.id = l.id_hab and l.id = u.usuario_hab and '" + fecha1 + "' not between u.ingreso and u.salida "
                            + "and '" + fecha2 + "' not between u.ingreso and u.salida and (n.nombre = 'Estandar' or n.nombre = 'Junior') order by id");
            while (rs.next()) {
                datos.add(new objConsultaReserva(rs.getInt("id"), rs.getString("planta"), rs.getString("nombre"), rs.getString("mascota")));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de conexión", "Mensaje", JOptionPane.ERROR_MESSAGE);
        }
        return datos;
    }

    //Consulta que solamente extrae 1 habitacion Junior, con mascota
    public ArrayList<objConsultaReserva> consultaSuperior(String fecha1, String fecha2) {
        ArrayList<objConsultaReserva> datos = new ArrayList<>();
        try {
            connection = conexion.Conexion();
            s = connection.createStatement();
            rs = s.executeQuery("select e.id, e.planta,n.nombre, e.mascota from habitacion e, tipo_hab n, historial u where  e.tipo = n.id and e.estado  = 'Disponible' and n.nombre = 'Superior' union select e.id, e.planta,n.nombre, e.mascota from habitacion e, tipo_hab n, historial u, usuario_hab l where e.tipo = n.id and e.id = l.id_hab and l.id = u.usuario_hab and  '2022-11-12' not between u.ingreso and u.salida and '2022-11-13'not between u.ingreso and u.salida and n.nombre = 'Superior' order by id");
            while (rs.next()) {
                datos.add(new objConsultaReserva(rs.getInt("id"), rs.getString("planta"), rs.getString("nombre"), rs.getString("mascota")));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de conexión", "Mensaje", JOptionPane.ERROR_MESSAGE);
        }
        return datos;
    }

    public ArrayList<objConsultaReserva> consultaSuperiorJunior(String fecha1, String fecha2) {
        ArrayList<objConsultaReserva> datos = new ArrayList<>();
        try {
            connection = conexion.Conexion();
            s = connection.createStatement();
            rs = s.executeQuery("select e.id, e.planta,n.nombre, e.mascota from habitacion e, tipo_hab n, historial u where  e.tipo = n.id and e.estado  = 'Disponible' and (n.nombre = 'Superior' or n.nombre = 'Junior') union select e.id, e.planta,n.nombre, e.mascota from habitacion e, tipo_hab n, historial u, usuario_hab l where e.tipo = n.id and e.id = l.id_hab and l.id = u.usuario_hab and '" + fecha1 + "' not between u.ingreso and u.salida and '" + fecha2 + "' not between u.ingreso and u.salida and (n.nombre = 'Superior' or n.nombre = 'Junior') order by id");
            while (rs.next()) {
                datos.add(new objConsultaReserva(rs.getInt("id"), rs.getString("planta"), rs.getString("nombre"), rs.getString("mascota")));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de conexión", "Mensaje", JOptionPane.ERROR_MESSAGE);
        }
        return datos;
    }

    public ArrayList<objConsultaReserva> consultaSuperiorEstandar(String fecha1, String fecha2) {
        ArrayList<objConsultaReserva> datos = new ArrayList<>();
        try {
            connection = conexion.Conexion();
            s = connection.createStatement();
            rs = s.executeQuery("select e.id, e.planta,n.nombre, e.mascota from habitacion e, tipo_hab n, historial u where  e.tipo = n.id and e.estado  = 'Disponible' and (n.nombre = 'Superior' or n.nombre = 'Estandar') union select e.id, e.planta,n.nombre, e.mascota from habitacion e, tipo_hab n, historial u, usuario_hab l where e.tipo = n.id and e.id = l.id_hab and l.id = u.usuario_hab and '" + fecha1 + "' not between u.ingreso and u.salida and '" + fecha2 + "' not between u.ingreso and u.salida and (n.nombre = 'Superior' or n.nombre = 'Estandar') order by id");
            while (rs.next()) {
                datos.add(new objConsultaReserva(rs.getInt("id"), rs.getString("planta"), rs.getString("nombre"), rs.getString("mascota")));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de conexión", "Mensaje", JOptionPane.ERROR_MESSAGE);
        }
        return datos;
    }

    //Consulta TODAS LAS HABITACIONES CON MASCOTAS
    public ArrayList<objConsultaReserva> todaHabitMascota(String fecha1, String fecha2) {
        ArrayList<objConsultaReserva> datos = new ArrayList<>();
        try {
            connection = conexion.Conexion();
            s = connection.createStatement();
            rs = s.executeQuery("select e.id, e.planta,n.nombre, e.mascota from habitacion e, tipo_hab n, historial u where  e.tipo = n.id and e.estado  ='Disponible' union select e.id, e.planta,n.nombre, e.mascota from habitacion e, tipo_hab n, historial u, usuario_hab l where e.tipo = n.id and e.id = l.id_hab and l.id = u.usuario_hab and '" + fecha1 + "' not between u.ingreso and u.salida and '" + fecha2 + "' not between u.ingreso and u.salida and n.nombre = 'Superior' order by id");
            while (rs.next()) {
                datos.add(new objConsultaReserva(rs.getInt("id"), rs.getString("planta"), rs.getString("nombre"), rs.getString("mascota")));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de conexión", "Mensaje", JOptionPane.ERROR_MESSAGE);
        }
        return datos;
    }

    public ArrayList<objConsultaReserva> todasSinMascota(String fecha1, String fecha2) {
        ArrayList<objConsultaReserva> datos = new ArrayList<>();
        try {
            connection = conexion.Conexion();
            s = connection.createStatement();
            rs = s.executeQuery("select e.id, e.planta,n.nombre, e.mascota from habitacion e, tipo_hab n, historial u where  e.tipo = n.id and e.estado  ='Disponible' and e.mascota = 'Prohibido'  union select e.id, e.planta,n.nombre, e.mascota from habitacion e, tipo_hab n, historial u, usuario_hab l where e.tipo = n.id and e.id = l.id_hab and l.id = u.usuario_hab and '" + fecha1 + "' not between u.ingreso and u.salida and '" + fecha2 + "' not between u.ingreso and u.salida order by id");
            while (rs.next()) {
                datos.add(new objConsultaReserva(rs.getInt("id"), rs.getString("planta"), rs.getString("nombre"), rs.getString("mascota")));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de conexión", "Mensaje", JOptionPane.ERROR_MESSAGE);
        }
        return datos;
    }

    public ArrayList<objConsultaReserva> TodasHabit(String fecha1, String fecha2) {
        ArrayList<objConsultaReserva> datos = new ArrayList<>();
        try {
            connection = conexion.Conexion();
            s = connection.createStatement();
            rs = s.executeQuery("select e.id, e.planta,n.nombre, e.mascota from habitacion e, tipo_hab n, historial u where  e.tipo = n.id and e.estado  ='Disponible' union select e.id, e.planta,n.nombre, e.mascota from habitacion e, tipo_hab n, historial u, usuario_hab l where e.tipo = n.id and e.id = l.id_hab and l.id = u.usuario_hab and '" + fecha1 + "' not between u.ingreso and u.salida and '" + fecha2 + "' not between u.ingreso and u.salida order by id");
            while (rs.next()) {
                datos.add(new objConsultaReserva(rs.getInt("id"), rs.getString("planta"), rs.getString("nombre"), rs.getString("mascota")));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de conexión", "Mensaje", JOptionPane.ERROR_MESSAGE);
        }
        return datos;
    }

    public String consultaMascota(int idHabit) {
        String acceso = "";
        try {
            connection = conexion.Conexion();
            s = connection.createStatement();
            rs = s.executeQuery("select h.mascota from habitacion h where id = '" +idHabit+ "'");
            while (rs.next()) {
                acceso = rs.getString("mascota");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de conexión", "Mensaje", JOptionPane.ERROR_MESSAGE);
        }
        return acceso;

    }
}
