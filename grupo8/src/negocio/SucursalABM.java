package negocio;

import dao.SucursalDao;
import datos.Sucursal;
import java.util.List;

public class SucursalABM {
    private SucursalDao dao = new SucursalDao();

    public Sucursal traerSucursal(long idSucursal) {
        return dao.traerSucursalPorId(idSucursal);
    }

    public List<Sucursal> traerSucursales() {
        return dao.traerTodasLasSucursales();
    }

    public long agregarSucursal(String nombre) {
        Sucursal sucursal = new Sucursal(nombre);
        dao.guardarSucursal(sucursal);
        return sucursal.getIdSucursal();
    }

    public long agregarSucursal(Sucursal sucursal) {
        if (sucursal == null) {
            throw new IllegalArgumentException("La sucursal no puede ser nula.");
        }
        dao.guardarSucursal(sucursal);
        return sucursal.getIdSucursal();
    }

    public void modificarSucursal(Sucursal sucursal) {
        dao.actualizarSucursal(sucursal);
    }

    public void eliminarSucursal(long idSucursal) {
        Sucursal sucursal = dao.traerSucursalPorId(idSucursal);
        if (sucursal != null) {
            dao.eliminarSucursal(sucursal);
        } else {
            throw new RuntimeException("Sucursal no encontrada con id: " + idSucursal);
        }
    }
}