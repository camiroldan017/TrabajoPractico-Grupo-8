package negocio;

import dao.PersonaDao;
import datos.Cliente;
import datos.Empleado;
import datos.Persona;
import datos.Sucursal;

import java.sql.Date;
import java.util.List;

public class PersonaABM {
    private PersonaDao dao = new PersonaDao();

    public Persona traerPersona(long idPersona) {
        return dao.traerPersonaPorId(idPersona);
    }

    public List<Persona> traerPersonas() {
        return dao.traerTodasLasPersonas();
    }

    public long agregarPersona(String nombre, String apellido, int dni, Date fechaNacimiento) {
        Persona persona = new Persona(nombre, apellido, dni, fechaNacimiento);
        dao.guardarPersona(persona);
        return persona.getIdPersona();
    }

    public void modificarPersona(Persona persona) {
        dao.actualizarPersona(persona);
    }

    public void eliminarPersona(long idPersona) {
        Persona persona = dao.traerPersonaPorId(idPersona);
        if (persona != null) {
            dao.eliminarPersona(persona);
        } else {
            throw new RuntimeException("Persona no encontrada con id: " + idPersona);
        }
    }

    public long agregarCliente(String nombre, String apellido, int dni, Date fechaNacimiento) {
        Cliente cliente = new Cliente(nombre, apellido, dni, fechaNacimiento);
        dao.guardarPersona(cliente);
        return cliente.getIdPersona();
    }

    public long agregarEmpleado(String nombre, String apellido, int dni, Date fechaNacimiento, String legajo,
            Sucursal sucursal) {
        Empleado empleado = new Empleado(nombre, apellido, dni, fechaNacimiento, legajo, sucursal);
        dao.guardarPersona(empleado);
        return empleado.getIdPersona();
    }

}

