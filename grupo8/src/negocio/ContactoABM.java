package negocio;

import dao.ContactoDao;
import datos.Contacto;
import datos.Sucursal;
import java.util.List;

public class ContactoABM {

    private ContactoDao dao = new ContactoDao();

    public Contacto traerContacto(long idContacto) {
        return dao.traerContactoPorId(idContacto);
    }

    public List<Contacto> traerContactos() {
        return dao.traerTodosLosContactos();
    }

    public long agregarContacto(String email, String telefono, String direccion, Sucursal sucursal) {
        Contacto contacto = new Contacto();
        //estas lineas de aca abajo me generan duda(?
        contacto.setEmail(email);
        contacto.setTelefono(telefono);
        contacto.setDireccion(direccion);
        contacto.setSucursal(sucursal);
        dao.guardarContacto(contacto);
        return contacto.getIdContacto();
    }

    public void modificarContacto(Contacto contacto) {
        dao.actualizarContacto(contacto);
    }

    public void eliminarContacto(long idContacto) {
        Contacto contacto = dao.traerContactoPorId(idContacto);
        if (contacto != null) {
            dao.eliminarContacto(contacto);
        } else {
            throw new RuntimeException("Contacto no encontrado con id: " + idContacto);
        }

 }
}
