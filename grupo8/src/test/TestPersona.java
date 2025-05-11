package test;

import java.sql.Date;
import java.time.LocalDate;
import negocio.ContactoABM;
import negocio.PersonaABM;
import negocio.SucursalABM;

public class TestPersona {
    public static void main(String[] args) {

        PersonaABM personaABM = new PersonaABM();
        SucursalABM sucursalABM = new SucursalABM();
        ContactoABM contactoABM = new ContactoABM();
        
        System.out.println("\nCreando nuevos clientes...");
        
        long idCliente;
        
        try {
        idCliente = personaABM.agregarCliente("Sofia", "Gonzales", 25555513, 
        Date.valueOf(LocalDate.of(2002, 6, 10)), contactoABM.traerContacto(1L), 1);
        System.out.println("\nCliente agregado con ID: " + idCliente);
        } catch (Exception e) {
        // TODO Auto-generated catch block
        System.out.println(e.getMessage());
        }
        
        try {
        idCliente = personaABM.agregarCliente("Marcelo", "Domenech", 22466555,
        Date.valueOf(LocalDate.of(1997, 4, 20)), contactoABM.traerContacto(2L), 2);
        System.out.println("\nCliente agregado con ID: " + idCliente);
        } catch (Exception e) {
        // TODO Auto-generated catch block
        System.out.println(e.getMessage());
        }

        try {
            idCliente = personaABM.agregarCliente("Catalina", "Gomez", 45125478,
            Date.valueOf(LocalDate.of(2000, 5, 30)), contactoABM.traerContacto(3L), 3);
            System.out.println("\nCliente agregado con ID: " + idCliente);
            } catch (Exception e) {
            // TODO Auto-generated catch block
            System.out.println(e.getMessage());
            }

        try {
                idCliente = personaABM.agregarCliente("Juan Jose", "Insfran", 45458789,
                Date.valueOf(LocalDate.of(2000, 3, 27)), contactoABM.traerContacto(4L), 4);
                System.out.println("\nCliente agregado con ID: " + idCliente);
                } catch (Exception e) {
                // TODO Auto-generated catch block
                System.out.println(e.getMessage());
                }

    
        
        System.out.println("\nCreando nuevos empleados...");
        
        long idEmpleado;
        
        try {
        idEmpleado = personaABM.agregarEmpleado("Camila", "Lanceti", 19567890,
        Date.valueOf(LocalDate.of(2002, 9, 29)),contactoABM.traerContacto(5L), "A345",
        sucursalABM.traerSucursal(1L));
        System.out.println("\nEmpleado agregado con ID: " + idEmpleado);
        } catch (Exception e) {
        // TODO Auto-generated catch block
        System.out.println(e.getMessage());
        }

        try {
        idEmpleado = personaABM.agregarEmpleado("Lucas ", "Rodriguez",25034211,
        Date.valueOf(LocalDate.of(1992, 11, 9)),contactoABM.traerContacto(6L), "A992",
        sucursalABM.traerSucursal(1L));
        System.out.println("\nEmpleado agregado con ID: " + idEmpleado);
        } catch (Exception e) {
        // TODO Auto-generated catch block
        System.out.println(e.getMessage());
        }
        
         //intentar agregar un Empleado con un legajo ya existente
        try {
            System.out.println("\nIntentando agregar un empleado con un legajo ya existente...");
            idEmpleado = personaABM.agregarEmpleado("Micaela", "Insfran", 16453987,
                    Date.valueOf(LocalDate.of(2003, 5, 05)), contactoABM.traerContacto(7L),"A345",
                    sucursalABM.traerSucursal(1L));
            System.out.println("\nEmpleado agregado con ID: " + idEmpleado);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            System.out.println(e.getMessage());
        }
        
        //intentar agregar un cliente con un dni ya existente
        try {
            System.out.println("\nIntentando agregar un cliente con un dni ya existente...");
            idCliente = personaABM.agregarCliente("Fede", "Gonzales", 25555513,
                    Date.valueOf(LocalDate.of(2002, 6, 10)), contactoABM.traerContacto(8L), 1);
            System.out.println("\nCliente agregado con ID: " + idCliente);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            System.out.println(e.getMessage());
        }
        
        
        
        
        // Traer todas las personas
        try {
        
        System.out.println("\nLista de personas: \n" + personaABM.traerPersonas());
        } catch (Exception e) {
        // TODO Auto-generated catch block
        System.out.println(e.getMessage());
        }
        
        
        
        
        // Modificar una persona
        try {
            System.out.println("\nModificando una persona... Camila Lanceti");
            personaABM.modificarPersona(personaABM.traerPersona(5L),"Thiago", "Mendoza", 25897654, Date.valueOf(LocalDate.of(1997, 9, 28)), contactoABM.traerContacto(8L));
            System.out.println("\nPersona modificada: \n" + personaABM.traerPersona(5L));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            System.out.println(e.getMessage());
        }
        

        
        // Eliminar una persona
        try {
        System.out.println("\nEliminando una persona... ID: 4");
        personaABM.eliminarPersona(4L);
        System.out.println("\nPersona eliminada con ID: 4");
        } catch (Exception e) {
        // TODO Auto-generated catch block
        System.out.println(e.getMessage());
        }
    
        try {
            System.out.println("\nTrayendo el cliente y su contacto ... ID: 5");
            System.out.println(personaABM.traerPersonaYContactoPorId(1L));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("\nTrayendo el empleado y su contacto ... ID: 5");
            System.out.println(personaABM.traerPersonaYContactoPorId(5L));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            System.out.println(e.getMessage());
        }   
        

    }
}
