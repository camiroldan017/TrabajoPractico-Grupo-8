package negocio;

import dao.ContactoDao;
import datos.Contacto;
import datos.Turno;

import java.util.List;

public class ContactoABM {

    private ContactoDao dao = new ContactoDao();

    public Contacto traerContacto(long idContacto) {
        return dao.traerContactoPorId(idContacto);
    }

    public List<Contacto> traerContactos() throws Exception {
            // Traemos todos los contactos de la base de datos y los guardamos en una lista
            List<Contacto> contactos = dao.traerTodosLosContactos();
            // Si la lista de contactos está vacía, lanzamos una excepción
            if (contactos.isEmpty()) throw new Exception("\nNo hay contactos registrados.\n");
            return contactos;
    }

    public long agregarContacto(String email, String telefono, String direccion) throws Exception {
        if(dao.existeContacto(email, telefono, direccion)) throw new Exception ("Ya existe contacto con los datos ingresados");
        Contacto contacto = new Contacto(email, telefono, direccion);
        dao.guardarContacto(contacto);
        return contacto.getIdContacto();
    }

    public void modificarContacto(Contacto contacto) throws Exception {
        if(contacto == null) {
            throw new Exception("El contacto no puede ser nulo.");
        }
        dao.actualizarContacto(contacto);
    }

    public void eliminarContacto(long idContacto) throws Exception {
        // Traemos el contacto por su ID desde la base de datos
        Contacto contacto= dao.traerContactoPorId(idContacto);
        
        // Verificamos si el contacto existe
        if (contacto == null) throw new Exception("El turno a eliminar ID: " + idContacto + " no existe.");

        // Si existe, lo eliminamos 
        dao.eliminarContacto(contacto);
        System.out.println("El turno con ID " + idContacto + " fue eliminado.");
}
    
}
