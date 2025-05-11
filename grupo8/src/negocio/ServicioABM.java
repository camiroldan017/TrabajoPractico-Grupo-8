package negocio;

import dao.ServicioDao;
import datos.Servicio;
import datos.Sucursal;
import java.util.List;


public class ServicioABM {

    private ServicioDao dao = new ServicioDao();

    public Servicio traerServicio(long idServicio) throws Exception {
        //Traemos el servicio por ID
        Servicio servicio = dao.traerServicioPorId(idServicio);

        if (servicio == null) {
            //Si el servicio no existe, lanzamos una excepción
            throw new Exception("NO existe un servicio con el ID: " + idServicio); 
        }
        return dao.traerServicioPorId(idServicio);
    }

    public List<Servicio> traerServicios() throws Exception {
        //Traemos todos los servicios de la base de datos y los guardamos en una lista
        List<Servicio> lista = dao.traerTodosLosServicios();

        if (lista == null || lista.isEmpty()) {
            // Si la lista de servicios está vacía, lanzamos una excepción
            throw new Exception ("\nNo hay servicios registrados.");
        }
        return dao.traerTodosLosServicios();
    }

    public long agregarServicio(String nombre, String duracion, Sucursal sucursal) throws Exception {
        // Creamos un nuevo servicio
        Servicio servicio = new Servicio(nombre, duracion, sucursal);

        //El nombre del servicio no puede ser nulo
        if(nombre == null) {
            throw new Exception("El nombre del servicio no puede ser nulo o vacío.");
        }

        //La duración del servicio no puede ser nula
        if(duracion == null) {
            throw new Exception("La duración del servicio no puede ser nula o vacía.");
        }

        //La sucursal no puede ser nula
        if(sucursal == null) {
            throw new Exception("La sucursal no puede ser nula.");
        }
        
        // Guardamos el servicio en la base de datos
        dao.guardarServicio(servicio);
        System.out.println("\nEl servicio se ha guardado correctamente: " + servicio);
        return servicio.getIdServicio();
    }

    public long agregarServicio(Servicio servicio) throws Exception {
        // Verificamos si el servicio es nulo, de ser así, lanzamos una excepción
        if (servicio == null) {
            throw new Exception("El servicio no puede ser nulo.");
        }

        // Guardamos el servicio en la base de datos
        dao.guardarServicio(servicio);
        System.out.println("El servicio se ha guardado correctamente: " + servicio);
        return servicio.getIdServicio();
    }

    public void modificarServicio(Servicio servicio, String nombreNuevo, String duracionNueva, Sucursal sucursalNueva) throws Exception {
        // Verificamos si el servicio es nulo, de ser así, lanzamos una excepción
        if (servicio == null) {
            throw new Exception ("El servicio no puede ser nulo.");
        }

        if(nombreNuevo == null) {
            throw new Exception("El nombre del servicio no puede ser nulo o vacío.");
        }

        //La duración del servicio no puede ser nula
        if(duracionNueva == null) {
            throw new Exception("La duración del servicio no puede ser nula o vacía.");
        }

        //La sucursal no puede ser nula
        if(sucursalNueva == null) {
            throw new Exception("La sucursal no puede ser nula.");
        }

        //Modificamos los atributos del servicio por los nuevos valores
        servicio.setNombre(nombreNuevo);
        servicio.setDuracion(duracionNueva);    
        servicio.setSucursal(sucursalNueva);
        
        //Se realiza la actualización del servicio en la base de datos
        dao.actualizarServicio(servicio);
        System.out.println("El servicio se ha modificado: " + servicio);
    }

    public void eliminarServicio(long idServicio) throws Exception {    
        // Traemos el servicio por ID
        Servicio servicio = dao.traerServicioPorId(idServicio);

        // Verificamos si el servicio es nulo, de ser así, lanzamos una excepción
        if (servicio != null) {
            dao.eliminarServicio(servicio);
        } else {
            throw new Exception ("NO existe servicio con el ID: " + idServicio);
        }
    }

}
