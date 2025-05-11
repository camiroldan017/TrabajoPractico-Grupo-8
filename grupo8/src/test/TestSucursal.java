package test;

import datos.Sucursal;
import negocio.SucursalABM;

public class TestSucursal {
    public static void main(String[] args) {
        SucursalABM sucursalABM = new SucursalABM();
        
        //Muestra que no hay nada en la lista sucursal 
        try{
            System.out.println("\nLista de sucursales:\n" + sucursalABM.traerSucursales());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            long idSucursal = sucursalABM.agregarSucursal("Sucursal Norte", "Falsa 123", "22244566");
            System.out.print("Sucursal agregada con ID: " + idSucursal);
        
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        try {
            long idSucursal = sucursalABM.agregarSucursal("Sucursal Sur", "Mitre 454", "42405688");
            System.out.print("Sucursal agregada con ID: " + idSucursal);
        
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            long idSucursal = sucursalABM.agregarSucursal("Sucursal Centro", "San Juan 325", "42415522");
            System.out.print("Sucursal agregada con ID: " + idSucursal);
        
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            long idSucursal = sucursalABM.agregarSucursal("Sucursal Oeste", "Almafuerte 78", "42425544");
            System.out.print("Sucursal agregada con ID: " + idSucursal);
        
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try{
            System.out.println("\nLista de sucursales:\n" + sucursalABM.traerSucursales());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try{
            Sucursal sucursal = sucursalABM.traerSucursal(1L);
            sucursalABM.modificarSucursal(sucursal, "Sucursal Viamonte", "Falsa 458", "42244566");
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try	 {
            sucursalABM.eliminarSucursal(4);
            System.out.println("Sucursal eliminada con ID: " + 4);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

         try{
            System.out.println("\nLista de sucursales:\n" + sucursalABM.traerSucursales());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }
}