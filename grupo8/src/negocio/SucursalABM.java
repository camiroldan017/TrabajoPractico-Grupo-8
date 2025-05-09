package negocio;

import dao.SucursalDao;
import datos.Contacto;
import datos.Sucursal;
import datos.Servicio;
import java.util.List;

public class SucursalABM {
    private SucursalDao dao = new SucursalDao();

    public Sucursal traerSucursal(long idSucursal) throws Exception {
        // Traemos la sucursal por ID
        Sucursal sucursal = dao.traerSucursalPorId(idSucursal);

        // Si la sucursal no existe, lanzamos una excepción
       if(sucursal == null) {
            throw new Exception("La sucursal no puede ser nula.");
        }
        return dao.traerSucursalPorId(idSucursal);
    }

    public List<Sucursal> traerSucursales() throws Exception {
        // Traemos todas las sucursales de la base de datos y las guardamos en una lista
        List<Sucursal> lista = dao.traerTodasLasSucursales();

        if(lista == null || lista.isEmpty()) {
            // Si la lista de sucursales está vacía, lanzamos una excepción
            throw new Exception("No hay sucursales registradas.");
        }
        return dao.traerTodasLasSucursales();
    }

    public long agregarSucursal(String nombre, String direccion, String telefono) throws Exception {
        // Creamos una nueva sucursal
        Sucursal sucursal = new Sucursal(nombre,direccion, telefono);

        // El nombre de la sucursal no puede ser nulo o vacío
        if(nombre == null || nombre.isEmpty()) {
            throw new Exception ("El nombre de la sucursal no puede ser nulo o vacío.");
        }

        // Guardamos la sucursal en la base de datos
        dao.guardarSucursal(sucursal);

        // Verificamos si la sucursal se guardó correctamente
        System.out.println("La sucursal se ha guardado correctamente: " + sucursal);
        return sucursal.getIdSucursal();
    }

    public long agregarSucursal(Sucursal sucursal) throws Exception {
        if (sucursal == null) {
            throw new Exception("La sucursal no puede ser nula.");
        }

        // Guardamos la sucursal en la base de datos
        dao.guardarSucursal(sucursal);

        // Verificamos si la sucursal se guardó correctamente
        System.out.println("La sucursal se ha guardado correctamente: " + sucursal);
        return sucursal.getIdSucursal();
    }

    public void modificarSucursal(Sucursal sucursal, String nombreNuevo, String direccionNueva, String telefonoNuevo) throws Exception {
        // Verificamos si la sucursal es nula, de ser así, lanzamos una excepción
        if (sucursal == null) {
            throw new Exception ("La sucursal no puede ser nula.");
        }

        //Verificamos si el nombre nuevo es nulo o vacío
        if(nombreNuevo == null || nombreNuevo.isEmpty()) {
            throw new Exception("El nombre de la sucursal no puede ser nulo o vacío.");
        }

        // Verificamos si la direccion es nula, de ser así, lanzamos una excepción
        if (direccionNueva == null) {
            throw new Exception("La direccion no puede ser nula.");
        }

        // Verificamos si la direccion es nula, de ser así, lanzamos una excepción
        if (telefonoNuevo == null) {
            throw new Exception("El telefono no puede ser nulo.");
        }
        // Modificamos la sucursal con los nuevos datos
        sucursal.setNombre(nombreNuevo);
        sucursal.setDireccion (direccionNueva);
        sucursal.setTelefono(telefonoNuevo);
    
        //Se realiza la actualización de la sucursal en la base de datos
        dao.actualizarSucursal(sucursal);

        System.out.println("La sucursal se ha modificado correctamente: " + sucursal);
    }

    public void eliminarSucursal(long idSucursal) {
        //Traemos la sucursal por ID
        Sucursal sucursal = dao.traerSucursalPorId(idSucursal);

        // Si la sucursal no existe, lanzamos una excepción
        if (sucursal != null) {
            dao.eliminarSucursal(sucursal);
        } else {
            throw new RuntimeException("Sucursal no encontrada con id: " + idSucursal);
        }
    }


    public void agregarServicioASucursal(long idSucursal, Servicio  servicio) {
        dao.agregarServicioASucursal(idSucursal, servicio);
    }
}