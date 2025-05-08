package test;

import datos.Contacto;
import datos.Sucursal;
import datos.Servicio;
import negocio.ContactoABM;
import negocio.SucursalABM;
import negocio.ServicioABM;

public class TestSucursal {
    public static void main(String[] args) {
        SucursalABM sucursalABM = new SucursalABM();
        //ContactoABM contactoABM = new ContactoABM();
        ServicioABM servicioABM = new ServicioABM();

        //Sucursal sucursal = new Sucursal("Sucursal Este");
        //sucursalABM.agregarSucursal(sucursal); // Guardar en la BD antes de usarla
        //sucursalABM.agregarContactoASucursal(2L, contactoABM.traerContacto(1L));
        //sucursalABM.agregarServicioASucursal(4L, servicioABM.traerServicio(1L));

        //System.out.println(sucursalABM.traerSucursal(1l));
    }
}