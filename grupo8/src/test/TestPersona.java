package test;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import datos.Persona;
import negocio.ContactoABM;
import negocio.PersonaABM;
import negocio.SucursalABM;

public class TestPersona {
    public static void main(String[] args) {

        PersonaABM personaABM = new PersonaABM();
        SucursalABM sucursalABM = new SucursalABM();
        ContactoABM contactoABM = new ContactoABM();
        System.out.println("Creando un nuevo cliente...");
        
        long idCliente;
        
        try {
        idCliente = personaABM.agregarCliente("Sofia", "Gonzales", 25555513, 
        Date.valueOf(LocalDate.of(2002, 6, 10)), contactoABM.traerContacto(3L), 1);
        System.out.println("Cliente agregado con ID: " + idCliente);
        } catch (Exception e) {
        // TODO Auto-generated catch block
        System.out.println(e.getMessage());
        }
        
        try {
        idCliente = personaABM.agregarCliente("Tiago", "Domenech", 22466555,
        Date.valueOf(LocalDate.of(1997, 4, 20)), contactoABM.traerContacto(3L), 2);
        System.out.println("Cliente agregado con ID: " + idCliente);
        } catch (Exception e) {
        // TODO Auto-generated catch block
        System.out.println(e.getMessage());
        }
        
        /* 
        System.out.println("Creando un nuevo empleado...");
        
        long idEmpleado;

        try {
        idEmpleado = personaABM.agregarEmpleado("Sofia", "Lanceti", 19567890,
        Date.valueOf(LocalDate.of(1999, 10, 15)),contactoABM.traerContacto(3l),1, "A345",
        sucursalABM.traerSucursal(11L));
        System.out.println("Empleado agregado con ID: " + idEmpleado);
        } catch (Exception e) {
        // TODO Auto-generated catch block
        System.out.println(e.getMessage());
        }
        
        try {
        idEmpleado = personaABM.agregarEmpleado("Car", "Rodri",25034211,
        Date.valueOf(LocalDate.of(2003, 5, 05)),contactoABM.traerContacto(1L),2, "A992",
        sucursalABM.traerSucursal(13L));
        System.out.println("Empleado agregado con ID: " + idEmpleado);
        } catch (Exception e) {
        // TODO Auto-generated catch block
        System.out.println(e.getMessage());
        }
        
        
        // Traer todas las personas
        try {
        List<Persona> personas = personaABM.traerPersonas();
        System.out.println("Lista de personas:" + personas);
        } catch (Exception e) {
        // TODO Auto-generated catch block
        System.out.println(e.getMessage());
        }
        
        //intentar agregar un Empleado con un legajo ya existente
        try {
            idEmpleado = personaABM.agregarEmpleado("Caro", "Rodriguez", 25555513,
                    Date.valueOf(LocalDate.of(2003, 5, 05)), "A992",
                    sucursalABM.traerSucursal(13L));
            System.out.println("Empleado agregado con ID: " + idEmpleado);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            System.out.println(e.getMessage());
        }
        
        //intentar agregar un cliente con un dni ya existente
        try {
            idCliente = personaABM.agregarCliente("Sofia", "Gonzales", 25555513,
                    Date.valueOf(LocalDate.of(2002, 6, 10)));
            System.out.println("Cliente agregado con ID: " + idCliente);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            System.out.println(e.getMessage());
        }
        
        
        // Modificar una persona
        try {
            System.out.println("Modificando una persona... tiago domenech");
            personaABM.modificarPersona(personaABM.traerPersona(16l),"Thiago", "Mendoza", 25897654, Date.valueOf(LocalDate.of(1997, 9, 28)));
            System.out.println("Persona modificada: " + personaABM.traerPersona(16l));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            System.out.println(e.getMessage());
        }
        
        
        // Eliminar una persona
        try {
        personaABM.eliminarPersona(18L);
        System.out.println("Persona eliminada con ID: 18");
        } catch (Exception e) {
        // TODO Auto-generated catch block
        System.out.println(e.getMessage());
        }
     */   
    }
}
