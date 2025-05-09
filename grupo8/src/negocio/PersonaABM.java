package negocio;

import dao.PersonaDao;
import datos.Cliente;
import datos.Contacto;
import datos.Empleado;
import datos.Persona;
import datos.Sucursal;

import java.sql.Date;
import java.util.List;

public class PersonaABM {
    private PersonaDao dao = new PersonaDao();

    public Persona traerPersona(long idPersona) throws Exception {
        Persona persona = dao.traerPersonaPorId(idPersona);
        if (persona == null) {
            throw new Exception("No existe una persona con el ID: " + idPersona);
        }
        return persona;
    }

    public Persona traerPersonaPorDni(int dni) {
        return dao.traerPersonaPorDni(dni);
    }

    public List<Persona> traerPersonas() throws Exception {
        List<Persona> lista = dao.traerTodasLasPersonas();
        if (lista == null || lista.isEmpty()) {
            throw new Exception("No hay personas agregadas.");
        }
        return lista;
    }

    /* SE COMENTA PORQUE NO SE UTILIZA EN EL PROYECTO
    public long agregarPersona(String nombre, String apellido, int dni, Date fechaNacimiento) throws Exception {
        traerPersonaPorDni(dni);
        Persona persona = new Persona(nombre, apellido, dni, fechaNacimiento);
        dao.guardarPersona(persona);
        return persona.getIdPersona();
    }
    */

    public void modificarPersona(Persona persona, String nombre, String apellido, int dni, Date fechaNacimiento)
            throws Exception {
        Persona aux = traerPersona(persona.getIdPersona());
        if (nombre == null)
            throw new Exception("El nombre no puede ser nulo");
        if (apellido == null)
            throw new Exception("El apellido no puede ser nulo");
        if (fechaNacimiento == null)
            throw new Exception("La fecha de nacimiento no puede ser nula");

        aux.setNombre(nombre);
        aux.setApellido(apellido);
        aux.setDni(dni);
        aux.setFechaNacimiento(fechaNacimiento);
        dao.actualizarPersona(aux);
    }

    public void eliminarPersona(long idPersona) throws Exception {
        Persona persona = traerPersona(idPersona);
        if (persona != null) {
            dao.eliminarPersona(persona);
        } else {
            throw new Exception("Persona no encontrada con id: " + idPersona);
        }
    }

    public long agregarCliente( String nombre, String apellido, int dni, Date fechaNacimiento, Contacto contacto, int nroCliente) throws Exception {
        if(traerPersonaPorDni(dni) != null) {
            throw new Exception("Ya existe un cliente con el DNI: " + dni);
        }
        Cliente cliente = new Cliente (nombre, apellido, dni, fechaNacimiento,contacto , nroCliente);
        dao.guardarPersona(cliente);
        return cliente.getIdPersona();
    }

    public boolean empleadoExiste (String legajo) {
        boolean existe = false;
        if(dao.traerEmpleadoPorLegajo(legajo) != null) {        
            existe = true;
        }
        return existe;
    }

    public long agregarEmpleado(String nombre, String apellido, int dni, Date fechaNacimiento,Contacto contacto, int nroEmpleado,String legajo,
            Sucursal sucursal) throws Exception {
        if(empleadoExiste(legajo)) {
            throw new Exception("Ya existe un empleado con el legajo: " + legajo);
        }
        Empleado empleado = new Empleado(nombre, apellido, dni, fechaNacimiento, contacto, nroEmpleado, legajo, sucursal);
        dao.guardarPersona(empleado);
        return empleado.getIdPersona();
    }

    public void modificarEmpleado(String nombre, String apellido, int dni, Date fechaNacimiento,Contacto contacto, int nroEmpleado, String legajo,
            Sucursal sucursal) throws Exception {
        Persona personaAux = traerPersonaPorDni(dni);
        if (nombre == null)
            throw new Exception("El nombre no puede ser nulo");
        if (apellido == null)
            throw new Exception("El apellido no puede ser nulo");
        if (fechaNacimiento == null)
            throw new Exception("La fecha de nacimiento no puede ser nula");

        if (personaAux instanceof Empleado) {
            if (((Empleado) personaAux).getLegajo().equals(legajo)) {
                throw new Exception("Ya existe un empleado con el legajo: " + legajo);
            }
        }

        Empleado empleado = (Empleado) traerPersonaPorDni(dni);
        empleado.setNombre(nombre);
        empleado.setApellido(apellido);
        empleado.setDni(dni);
        empleado.setFechaNacimiento(fechaNacimiento);
        empleado.setContacto(contacto);
        empleado.setNroEmpleado(nroEmpleado);
        empleado.setLegajo(legajo);
        empleado.setSucursal(sucursal);
        dao.actualizarPersona(empleado);
    }

    public Empleado traerEmpleado(long idEmpleado) {
        return dao.traerEmpleadoPorId(idEmpleado);
    }

    public Cliente traerCliente(long idCliente) {
        return dao.traerClientePorId(idCliente);
    }

    
    /*TRAER QUE NO SE UTILIZA EN EL PROYECTO
    public List<Empleado> traerEmpleados() throws Exception {
        List<Empleado> lista = dao.traerTodosLosEmpleados();
        if (lista == null || lista.isEmpty()) {
            throw new Exception("No hay empleados agregados.");
        }
        return lista;
    }

    public List<Cliente> traerClientes() throws Exception {
        List<Cliente> lista = dao.traerTodosLosClientes();
        if (lista == null || lista.isEmpty()) {
            throw new Exception("No hay clientes agregados.");
        }
        return lista;
    }
    */
}