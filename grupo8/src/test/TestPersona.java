package test;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import datos.Persona;
import negocio.PersonaABM;
import negocio.SucursalABM;

public class TestPersona {
    public static void main(String[] args) {
        // Crear una nueva persona
        PersonaABM personaABM = new PersonaABM();
        
        System.out.println("Creando una nueva persona...");
        long idPersona = personaABM.agregarPersona("Juan", "Pérez", 12345678,
        Date.valueOf(LocalDate.now()));
        System.out.println("Persona agregada con ID: " + idPersona);
        
        // Traer todas las personas
        List<Persona> personas = personaABM.traerPersonas();
        if (personas != null && !personas.isEmpty()) {
        System.out.println("Lista de personas:");
        for (Persona p : personas) {
        System.out.println(p);
        }
        } else {
        System.out.println("No hay personas registradas.");
        }
        

        // Modificar una persona
        
        Persona persona = personaABM.traerPersona(idPersona);
        if (persona != null) {
        persona.setNombre("Juan Carlos");
        personaABM.modificarPersona(persona);
        System.out.println("Persona modificada: " + persona);
        }
        

        
        // Eliminar una persona
        personaABM.eliminarPersona(idPersona);
        System.out.println("Persona eliminada con ID: " + idPersona);
        

        
        System.out.println("Creando un nuevo cliente...");
        long idCliente = personaABM.agregarCliente("Ana", "Gómez", 23456789,
        Date.valueOf(LocalDate.of(1992, 11, 17)));
        System.out.println("Cliente agregado con ID: " + idCliente);
        
        SucursalABM sucursalABM = new SucursalABM();
        System.out.println("Creando un nuevo empleado...");
        long idEmpleado = personaABM.agregarEmpleado("Carlos", "Ruiz", 34567890,
                Date.valueOf(LocalDate.of(1996, 12, 05)), "A123",sucursalABM.traerSucursal(1L));
        System.out.println("Empleado agregado con ID: " + idEmpleado);

    }
}

