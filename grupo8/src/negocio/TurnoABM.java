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

    public Turno traerTurno(long idTurno) throws Exception {
            // Traemos el turno por su ID desde la base de datos
            Turno turno = dao.traerTurnoPorId(idTurno);

            // Si el turno es nulo, lanzamos una excepción
            if (turno == null) throw new Exception("El turno con 'ID " + idTurno + "' no existe.");
            return turno;
    }

    public Turno traerTurno(Date fecha, LocalTime hora, Servicio servicio, Sucursal sucursal) throws Exception {
            // Traemos el turno por su fecha, hora, servicio y sucursal desde la base de datos
            Turno turno = dao.traerTurnoPorFechaHoraServicioYSucursal(fecha, hora, servicio, sucursal);

            // Si el turno es nulo, lanzamos una excepción
            if (turno == null) throw new Exception("No se ha reservado ningún turno para '" + servicio.getNombre() + "' el día " + fecha
                    + " a las " + hora + " en la sucursal '" + sucursal.getNombre() + "'.");
            return turno;
    }

    public List<Turno> traerTurnos() throws Exception {
            // Traemos todos los turnos de la base de datos y los guardamos en una lista
            List<Turno> turnos = dao.traerTodosLosTurnos();

            // Si la lista de turnos está vacía, lanzamos una excepción
            if (turnos.isEmpty()) throw new Exception("\nNo hay turnos registrados.\n");
            return turnos;
    }

    public long agregarTurno(Date fecha, LocalTime hora, String estado, Cliente cliente, Empleado empleado,
            Servicio servicio, Sucursal sucursal) throws Exception {
            // Creamos un turno nuevo
            Turno turno = new Turno(fecha, hora, estado, cliente, empleado, servicio, sucursal);

            // Verificamos si ya hay un turno reservado para ese servicio en esa misma fecha, hora y sucursal
            if (dao.existeTurnoEnFechaHoraServicioYSucursal(fecha, hora, servicio, sucursal))
                throw new Exception("Ya existe una reserva para '" + servicio.getNombre() + "' el día " + fecha
                        + " a las " + hora + " en la sucursal " + sucursal.getNombre() + ".");

            // Verificamos si el cliente ya tiene un turno reservado para esa fecha y hora
            if (dao.clienteTieneTurnoEnFechaYHora(cliente, fecha, hora))
                throw new Exception("El cliente ya tiene un turno reservado para el dia " + fecha + " a las " + hora + ".");

            // Verificamos si el empleado ya tiene un turno asignado para esa fecha y hora
            if (dao.empleadoTieneTurnoAsignadoEnFechaYHora(empleado, fecha, hora))
                throw new Exception("El empleado ya tiene un turno asignado para el dia " + fecha + " a las " + hora + ".");

            // Una vez verificado todo, guardamos el turno
            dao.guardarTurno(turno);
            // Imprimimos un mensaje confirmando que el turno se guardó correctamente,
             // junto con los detalles del turno.
            System.out.println("TURNO GUARDADO CORRECTAMENTE: " + turno);
            return turno.getIdTurno(); // Retornamos el ID del turno guardado
    }

    public long agregarTurno(Turno turno) throws Exception {
        // Verificamos si el turno es nulo, de ser así, lanzamos una excepción
        if (turno == null) throw new Exception("El turno no puede ser nulo.");

        // Verificamos si ya hay un turno reservado para ese servicio en esa misma fecha, hora y sucursal
        if (dao.existeTurnoEnFechaHoraServicioYSucursal(turno.getFecha(), turno.getHora(), turno.getServicio(), turno.getSucursal()))
            throw new Exception("Ya existe una reserva para '" + turno.getServicio().getNombre() + "' el dia " + turno.getFecha()
                    + " a las " + turno.getHora() + " en la sucursal " + turno.getSucursal().getNombre() + ".");

        // Verificamos si el cliente ya tiene un turno reservado para esa fecha y hora
        if (dao.clienteTieneTurnoEnFechaYHora(turno.getCliente(), turno.getFecha(), turno.getHora()))
            throw new Exception("El cliente ya tiene un turno reservado para el dia " + turno.getFecha()
                    + " a las " + turno.getHora() + ".");

        // Verificamos si el empleado ya tiene un turno asignado para esa fecha y hora
        if (dao.empleadoTieneTurnoAsignadoEnFechaYHora(turno.getEmpleado(), turno.getFecha(), turno.getHora()))
            throw new Exception("El empleado ya tiene un turno asignado para el dia " + turno.getFecha()
                    + " a las " + turno.getHora() + ".");

        // Una vez verificado todo, guardamos el turno
        dao.guardarTurno(turno);
        // Imprimimos un mensaje confirmando que el turno se guardó correctamente,
        // junto con los detalles del turno.
        System.out.println("TURNO GUARDADO CORRECTAMENTE: " + turno);
        return turno.getIdTurno(); // Retornamos el ID del turno guardado
    }

    public void modificarTurno(Turno turno, Date fechaNueva, LocalTime horaNueva, String estadoNuevo) throws Exception {
            // Verificamos si el turno es nulo, de ser así, lanzamos una excepción
            if (turno == null) throw new Exception("El turno no puede ser nulo.");

            // Verificamos si ya existe un turno con la misma fecha, hora, servicio y sucursal
            if (dao.existeTurnoEnFechaHoraServicioYSucursal(fechaNueva, horaNueva, turno.getServicio(), turno.getSucursal()))
                throw new Exception("Ya existe una reserva para ese servicio el dia " + fechaNueva + " a las " + horaNueva + " en esa sucursal.");

            // Una vez verificado todo, modificamos el turno con los nuevos valores
            turno.setFecha(fechaNueva);
            turno.setHora(horaNueva);
            turno.setEstado(estadoNuevo);

            // Realizamos la modificación en la BD
            dao.actualizarTurno(turno);
            System.out.println("\nTURNO MODIFICADO CORRECTAMENTE: " + turno);
    }

    public void eliminarTurno(long idTurno) throws Exception {
            // Traemos el turno por su ID desde la base de datos
            Turno turno = dao.traerTurnoPorId(idTurno);
            
            // Verificamos si el turno existe
            if (turno == null) throw new Exception("El turno que desea eliminar (ID: " + idTurno + ") no existe.");

            // Si existe, lo eliminamos 
            dao.eliminarTurno(turno);
            System.out.println("El turno con 'ID " + idTurno + "' fue eliminado correctamente.");
    }
}