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
        //ServicioABM servicioABM = new ServicioABM();

        try {
            // Traer una sucursal por ID
            long idSucursal = sucursalABM.agregarSucursal("Sucursal Norte");
            System.out.println("Sucursal agregada con ID: " + idSucursal);
           
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try{
            System.out.println("Lista de sucursales:" + sucursalABM.traerSucursales());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try	 {
            sucursalABM.eliminarSucursal(2);
            System.out.println("Sucursal eliminado con ID: " + 2);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}