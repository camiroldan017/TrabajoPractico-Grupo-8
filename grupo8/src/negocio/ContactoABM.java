package negocio;

import dao.ContactoDao;
import datos.Contacto;
import java.util.List;

public class ContactoABM {

    private ContactoDao dao = new ContactoDao();

    public Contacto traerContacto(long idContacto) {
        return dao.traerContactoPorId(idContacto);
    }

    public List<Contacto> traerContactos() {
        return dao.traerTodosLosContactos();
    }

    public long agregarContacto(String email, String telefono, String direccion) throws Exception {
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
        Contacto contacto = dao.traerContactoPorId(idContacto);
        if (contacto != null)  throw new Exception("Contacto no encontrado con id: " + idContacto);
            dao.eliminarContacto(contacto);
    }
}
