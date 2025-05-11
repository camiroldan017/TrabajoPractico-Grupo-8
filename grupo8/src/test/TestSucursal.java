package test;

import negocio.SucursalABM;

public class TestSucursal {
    public static void main(String[] args) {
        SucursalABM sucursalABM = new SucursalABM();
        //ServicioABM servicioABM = new ServicioABM();

        try {
            long idSucursal = sucursalABM.agregarSucursal("Sucursal Norte", "Falsa 123", "22244566");
            System.out.println("Sucursal agregada con ID: " + idSucursal);
        
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        try {
            long idSucursal = sucursalABM.agregarSucursal("Sucursal Sur", "Mitre 454", "42405688");
            System.out.println("Sucursal agregada con ID: " + idSucursal);
        
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            long idSucursal = sucursalABM.agregarSucursal("Sucursal Centro", "San Juan 325", "42415522");
            System.out.println("Sucursal agregada con ID: " + idSucursal);
        
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            long idSucursal = sucursalABM.agregarSucursal("Sucursal Oeste", "Almafuerte 78", "42425544");
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
            sucursalABM.eliminarSucursal(4);
            System.out.println("Sucursal eliminada con ID: " + 4);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }
}