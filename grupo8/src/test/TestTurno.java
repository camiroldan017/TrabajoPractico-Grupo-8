package test;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

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

        // Agregar Turno
        Turno turno = new Turno(Date.valueOf(LocalDate.of(2024, 10, 7)), LocalTime.of(10, 00, 00), "confirmado",
                personaABM.traerCliente(7L), personaABM2.traerEmpleado(5L), servicioABM.traerServicio(1L),
                sucursalABM.traerSucursal(2L));
        turnoABM.agregarTurno(turno); // Guardar en la BD antes de usarlo

        // Agregar Turno
        turnoABM.agregarTurno(Date.valueOf(LocalDate.of(2025, 07, 10)), LocalTime.of(14, 30, 00), "confirmado",
                personaABM.traerCliente(6L), personaABM2.traerEmpleado(5L), servicioABM.traerServicio(2L),
                sucursalABM.traerSucursal(2L)); // Guardar en la BD antes de usarla

        // Traer todos los Turnos
        List<Turno> turnos = turnoABM.traerTurnos();
        System.out.println("Lista de turnos:\n" + turnos);

        // Traer Turno
        Turno t = turnoABM.traerTurno(1L);

        // Modifcar Turno
        turnoABM.modificarTurno(t, Date.valueOf(LocalDate.of(2023, 04, 9)), LocalTime.of(07, 15, 00), "pendiente");

        // Mostramos la lista de turnos modificada
        turnos = turnoABM.traerTurnos();
        System.out.println("Lista de turnos:\n" + turnos);

        // Eliminar Turno
        turnoABM.eliminarTurno(1L);

        // Mostramos la lista de turnos sin el turno eliminado
        turnos = turnoABM.traerTurnos();
        System.out.println("Lista de turnos:\n" + turnos);

    }

}
