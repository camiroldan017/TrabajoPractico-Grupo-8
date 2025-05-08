package negocio;

import java.sql.Date;
import java.time.LocalTime;
import java.util.List;

import dao.TurnoDao;
import datos.Cliente;
import datos.Empleado;
import datos.Servicio;
import datos.Sucursal;
import datos.Turno;

public class TurnoABM {

    private TurnoDao dao = new TurnoDao();

    public Turno traerTurno(long idTurno) {
        try {
            Turno turno = dao.traerTurnoPorId(idTurno);

            // Si el turno es nulo, lanzamos una excepción
            if (turno == null) {
                throw new IllegalArgumentException("El turno con 'ID " + idTurno + "' no existe.");
            }

            return turno;

        } catch (IllegalArgumentException e) {
            // Manejamos la excepción y mostramos un mensaje en consola
            System.out.println("ERROR AL BUSCAR TURNO: " + e.getMessage());
            return null; // Retornamos null si no se encuentra el turno
        }
    }

    public List<Turno> traerTurnos() {
        try {
            List<Turno> turnos = dao.traerTodosLosTurnos();

            // Si la lista de turnos está vacía, lanzamos una excepción
            if (turnos.isEmpty()) {
                throw new IllegalStateException("No hay turnos registrados.");
            }

            return turnos;

        } catch (IllegalStateException e) {
            // Manejamos la excepción y mostramos un mensaje en consola
            System.out.println(e.getMessage());
            return null; // Retornamos null si no se encuentra el turno
        }
    }

    public long agregarTurno(Date fecha, LocalTime hora, String estado, Cliente cliente, Empleado empleado,
            Servicio servicio, Sucursal sucursal) {
        try {
            Turno turno = new Turno(fecha, hora, estado, cliente, empleado, servicio, sucursal);

            // Verificamos si ya existe un turno con la misma fecha, hora y servicio
            if (dao.existeTurnoEnFechaYHoraYServicio(fecha, hora, servicio)) {
                throw new IllegalArgumentException("Ya existe un turno en esa fecha, hora y con ese servicio.");
            }

            // Verificamos si el cliente ya tiene un turno con la misma fecha y hora
            if (dao.clienteTieneTurnoEnFechaYHora(cliente, fecha, hora)) {
                throw new IllegalArgumentException("El cliente ya tiene un turno en esa fecha y hora.");
            }

            // Verificamos si el empleado ya tiene un turno asignado con la misma fecha y
            // hora
            if (dao.empleadoTieneTurnoAsignadoEnFechaYHora(empleado, fecha, hora)) {
                throw new IllegalArgumentException("El empleado ya tiene un turno asignado en esa fecha y hora.");
            }

            // Ya teniendo todo verificado, guardamos el turno
            dao.guardarTurno(turno);
            // Avisamos que el turno se guardó correctamente y lo mostramos por consola
            System.out.println("TURNO GUARDADO CORRECTAMENTE: " + turno);
            return turno.getIdTurno(); // Retornamos el ID del turno guardado

        } catch (IllegalArgumentException e) {
            // Manejamos la excepción y mostramos un mensaje en consola
            System.out.println("ERROR AL QUERER AGREGAR EL TURNO: " + e.getMessage());
            return -1; // Indicamos que no se pudo agregar el turno
        }
    }

    public long agregarTurno(Turno turno) {
        try {
            // Verificamos si el turno es nulo
            if (turno == null) {
                throw new IllegalArgumentException("El turno no puede ser nulo.");
            }

            // Verificamos si ya hay un turno en esa fecha, hora y servicio
            if (dao.existeTurnoEnFechaYHoraYServicio(turno.getFecha(), turno.getHora(), turno.getServicio())) {
                throw new IllegalArgumentException("Ya existe un turno en esa fecha, hora y con ese servicio.");
            }

            // Verificamos si el cliente ya tiene un turno con la misma fecha y hora
            if (dao.clienteTieneTurnoEnFechaYHora(turno.getCliente(), turno.getFecha(), turno.getHora())) {
                throw new IllegalArgumentException("El cliente ya tiene un turno en esa fecha y hora.");
            }

            // Verificamos si el empleado ya tiene un turno asignado con la misma fecha y
            // hora
            if (dao.empleadoTieneTurnoAsignadoEnFechaYHora(turno.getEmpleado(), turno.getFecha(), turno.getHora())) {
                throw new IllegalArgumentException("El empleado ya tiene un turno asignado en esa fecha y hora.");
            }

            // Ya teniendo todo verificado, guardamos el turno
            dao.guardarTurno(turno);
            // Avisamos que el turno se guardó correctamente y lo mostramos por consola
            System.out.println("TURNO GUARDADO CORRECTAMENTE: " + turno);
            return turno.getIdTurno(); // Retornamos el ID del turno guardado

        } catch (IllegalArgumentException e) {
            // Manejamos la excepción y mostramos un mensaje en consola
            System.out.println("ERROR AL QUERER AGREGAR EL TURNO: " + e.getMessage());
            return -1; // Indicamos que no se pudo agregar el turno
        }
    }

    public void modificarTurno(Turno turno, Date fechaNueva, LocalTime horaNueva, String estadoNuevo) {
        try {
            // Verificamos si el turno es nulo antes de hacer cualquier operación con él
            if (turno == null) {
                throw new IllegalArgumentException("El turno que desea modificar no existe.");
            }

            // Verificamos si ya existe un turno con la misma fecha, hora y servicio
            if (dao.existeTurnoEnFechaYHoraYServicio(fechaNueva, horaNueva, turno.getServicio())) {
                throw new IllegalArgumentException("Ya existe un turno en esa fecha, hora y con ese servicio.");
            }

            // Ya teniendo todo verificado, modificamos el turno con los nuevos valores
            turno.setFecha(fechaNueva);
            turno.setHora(horaNueva);
            turno.setEstado(estadoNuevo);

            // Realizamos la modificación
            dao.actualizarTurno(turno);
            System.out.println("TURNO MODIFICADO CORRECTAMENTE: " + turno);
        } catch (IllegalArgumentException e) {
            // Manejamos la excepción y mostramos un mensaje en consola
            System.out.println("ERROR AL QUERER MODIFICAR EL TURNO: " + e.getMessage());
        }
    }

    public void eliminarTurno(long idTurno) {
        try {
            Turno turno = dao.traerTurnoPorId(idTurno);
            if (turno != null) {
                dao.eliminarTurno(turno);
                System.out.println("El turno con 'ID " + idTurno + "' fue eliminado correctamente.");
            } else {
                throw new RuntimeException("El turno que desea eliminar (ID: " + idTurno + ") no existe.");
            }
        } catch (RuntimeException e) {
            // Manejamos la excepción y mostramos un mensaje en consola
            System.out.println("ERROR AL QUERER ELIMINAR EL TURNO: " + e.getMessage());
        }
    }

}
