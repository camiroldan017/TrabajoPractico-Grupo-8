package test;

import negocio.SucursalABM;

public class TestSucursal {
    public static void main(String[] args) {
        SucursalABM sucursalABM = new SucursalABM();
        //ContactoABM contactoABM = new ContactoABM();
        //ServicioABM servicioABM = new ServicioABM();

        try {
            // Traer una sucursal por ID
            long idSucursal = sucursalABM.agregarSucursal("Sucursal Norte", "Falsa 123", "33348765");
            System.out.println("Sucursal agregada con ID: " + idSucursal);
        
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        /* 
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
        */
    }
}