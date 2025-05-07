package test;

import datos.Sucursal;
import negocio.SucursalABM;

public class TestSucursal {
    public static void main(String[] args) {
        SucursalABM sucursalABM = new SucursalABM();
        Sucursal sucursal = new Sucursal("Sucursal Centro");
        sucursalABM.agregarSucursal(sucursal); // Guardar en la BD antes de usarla

        System.out.println(sucursalABM.traerSucursal(1l));
    }
}