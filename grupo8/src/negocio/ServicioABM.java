package negocio;

import dao.ServicioDao;
import datos.Servicio;
import datos.Sucursal;
import java.util.List;


public class ServicioABM {

    private ServicioDao dao = new ServicioDao();

    public Servicio traerServicio(long idServicio) {
        return dao.traerServicioPorId(idServicio);
    }

    public List<Servicio> traerServicios() {
        return dao.traerTodosLosServicios();
    }

    public long agregarServicio(String nombre, String duracion, Sucursal sucursal) {
        Servicio servicio = new Servicio(nombre, duracion, sucursal);
        dao.guardarServicio(servicio);
        return servicio.getIdServicio();
    }

    public void modificarServicio(Servicio servicio) {
        dao.actualizarServicio(servicio);
    }

    public void eliminarServicio(long idServicio) {
        Servicio servicio = dao.traerServicioPorId(idServicio);
        if (servicio != null) {
            dao.eliminarServicio(servicio);
        } else {
            throw new RuntimeException("No se encontró el servicio con ID: " + idServicio);
        }
    }

}
