package test;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;

import datos.Turno;
import negocio.PersonaABM;
import negocio.ServicioABM;
import negocio.SucursalABM;
import negocio.TurnoABM;

public class TestTurno {

    public static void main(String[] args) {
        TurnoABM turnoABM = new TurnoABM();
        PersonaABM personaABM = new PersonaABM();
        PersonaABM personaABM2 = new PersonaABM();
        ServicioABM servicioABM = new ServicioABM();
        SucursalABM sucursalABM = new SucursalABM();
        
        // Creamos 4 turnos nuevos
        Turno turno1 = new Turno(Date.valueOf(LocalDate.of(2025, 6, 10)), LocalTime.of(10, 00, 00), "confirmado",
                    personaABM.traerCliente(6L), personaABM2.traerEmpleado(5L), servicioABM.traerServicio(1L),
                    sucursalABM.traerSucursal(2L));
        Turno turno2 = new Turno(Date.valueOf(LocalDate.of(2025, 7, 23)), LocalTime.of(14, 30, 00), "confirmado",
                    personaABM.traerCliente(7L), personaABM2.traerEmpleado(5L), servicioABM.traerServicio(2L),
                    sucursalABM.traerSucursal(2L));
        Turno turno3 = new Turno(Date.valueOf(LocalDate.of(2025, 8, 17)), LocalTime.of(18, 45, 00), "confirmado",
                    personaABM.traerCliente(8L), personaABM2.traerEmpleado(9L), servicioABM.traerServicio(3L),
                    sucursalABM.traerSucursal(2L));
        Turno turno4 = new Turno(Date.valueOf(LocalDate.of(2025, 5, 1)), LocalTime.of(9, 15, 00), "confirmado",
                    personaABM.traerCliente(8L), personaABM2.traerEmpleado(9L), servicioABM.traerServicio(2L),
                    sucursalABM.traerSucursal(2L));

        System.out.println("\n");

        // Agregamos los turnos a la BD
        try {
            turnoABM.agregarTurno(turno1);
            turnoABM.agregarTurno(turno2);
            turnoABM.agregarTurno(turno3);
            turnoABM.agregarTurno(turno4);
        } catch (Exception e) {
            // TODO: handle exception
            // Manejamos la excepción y mostramos un mensaje en consola
            System.out.println("ERROR AL QUERER AGREGAR EL TURNO: " + e.getMessage());
        }

        // Intentamos reservar un turno para un servicio que ya tiene un turno reservado para la fecha
        // y hora que se desea reservar
        try {
            turnoABM.agregarTurno(Date.valueOf(LocalDate.of(2025, 6, 10)), LocalTime.of(10, 00, 00), "pendiente",
                personaABM.traerCliente(8L), personaABM2.traerEmpleado(9L), servicioABM.traerServicio(1L),
                sucursalABM.traerSucursal(2L));
        } catch (Exception e) {
            // TODO: handle exception
            // Manejamos la excepción y mostramos un mensaje en consola
            System.out.println("ERROR AL QUERER AGREGAR EL TURNO: " + e.getMessage());
        }

        // Intentamos reservar un turno para un cliente que ya tiene un turno reservado para otro
        // servicio en la fecha y hora que desea reservar
        try {
            turnoABM.agregarTurno(Date.valueOf(LocalDate.of(2025, 7, 23)), LocalTime.of(14, 30, 00), "pendiente",
                personaABM.traerCliente(7L), personaABM2.traerEmpleado(9L), servicioABM.traerServicio(1L),
                sucursalABM.traerSucursal(2L));
        } catch (Exception e) {
            // TODO: handle exception
            // Manejamos la excepción y mostramos un mensaje en consola
            System.out.println("ERROR AL QUERER AGREGAR EL TURNO: " + e.getMessage());
        }

        // Intentamos reservar un turno asignandole un empleado que ya tiene un turno asignado
        // para esa fecha y hora
        try {
            turnoABM.agregarTurno(Date.valueOf(LocalDate.of(2025, 8, 17)), LocalTime.of(18, 45, 00), "pendiente",
                personaABM.traerCliente(6L), personaABM2.traerEmpleado(9L), servicioABM.traerServicio(2L),
                sucursalABM.traerSucursal(2L));
        } catch (Exception e) {
            // TODO: handle exception
            // Manejamos la excepción y mostramos un mensaje en consola
            System.out.println("ERROR AL QUERER AGREGAR EL TURNO: " + e.getMessage());
        }

        // Traemos todos los turnos
        try {
            System.out.println("\nLISTA DE TURNOS:\n" + turnoABM.traerTurnos());
        } catch (Exception e) {
            // TODO: handle exception
            // Manejamos la excepción y mostramos un mensaje en consola
            System.out.println(e.getMessage());
        }

        // Buscamos un turno que no existe
        try {
            turnoABM.traerTurno(100L);
        } catch (Exception e) {
            // TODO: handle exception
            // Manejamos la excepción y mostramos un mensaje en consola
            System.out.println("\nERROR AL BUSCAR TURNO: " + e.getMessage());
        }

        // Modificamos el turno con ID 1
        try {
            turnoABM.modificarTurno(turnoABM.traerTurno(1L), Date.valueOf(LocalDate.of(2025, 9, 5)), LocalTime.of(07, 15, 00), "confirmado");
        } catch (Exception e) {
            // TODO: handle exception
            // Manejamos la excepción y mostramos un mensaje en consola
            System.out.println("\nERROR AL QUERER MODIFICAR TURNO: " + e.getMessage());
        }

        // Intentamos modificar el turno con ID 2 para el mismo servicio que el turno 4 en la misma fecha y hora
        try {
            turnoABM.modificarTurno(turnoABM.traerTurno(2L), Date.valueOf(LocalDate.of(2025, 5, 1)), LocalTime.of(9, 15, 00), "pendiente");
        } catch (Exception e) {
            // TODO: handle exception
            // Manejamos la excepción y mostramos un mensaje en consola
            System.out.println("ERROR AL QUERER MODIFICAR TURNO: " + e.getMessage());
        }

        // Mostramos la lista de turnos actualizada
        try {
            System.out.println("\nLISTA DE TURNOS:\n" + turnoABM.traerTurnos());
        } catch (Exception e) {
            // TODO: handle exception
            // Manejamos la excepción y mostramos un mensaje en consola
            System.out.println(e.getMessage());
        }

        // Intentamos eliminar un turno que no existe
        try {
            turnoABM.eliminarTurno(100L);
        } catch (Exception e) {
            // TODO: handle exception
            // Manejamos la excepción y mostramos un mensaje en consola
            System.out.println("\nERROR AL QUERER ELIMINAR EL TURNO: " + e.getMessage() + "\n");
        }
        
        // Eliminamos todos los turnos
        try {
            turnoABM.eliminarTurno(1L);
            turnoABM.eliminarTurno(2L);
            turnoABM.eliminarTurno(3L);
            turnoABM.eliminarTurno(4L);
        } catch (Exception e) {
            // TODO: handle exception
            // Manejamos la excepción y mostramos un mensaje en consola
            System.out.println("\nERROR AL QUERER ELIMINAR EL TURNO: " + e.getMessage());
        }

        // Mostramos la lista de turnos vacía
        try {
            System.out.println("\nLISTA DE TURNOS:\n" + turnoABM.traerTurnos());
        } catch (Exception e) {
            // TODO: handle exception
            // Manejamos la excepción y mostramos un mensaje en consola
            System.out.println(e.getMessage());
        }
    }
}
