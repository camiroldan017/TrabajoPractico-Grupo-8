package test;

import negocio.ServicioABM;
import negocio.SucursalABM;

public class TestServicio {

    public static void main(String[] args) {
        ServicioABM servicioABM = new ServicioABM();
        SucursalABM sucursalABM = new SucursalABM();
        
        long idServicio = servicioABM.agregarServicio("Limpieza", "2 horas", sucursalABM.traerSucursal(2L));
        System.out.println("Servicio agregado con ID: " + idServicio);
        
        /* 
        System.out.println("Lista de servicios:");
        for (Servicio servicio : servicioABM.traerServicios()) {
            System.out.println(servicio);
        }
        */
        
        // Eliminar un servicio
        /* 
        servicioABM.eliminarServicio(idServicio);
        System.out.println("Servicio eliminado con ID: " + idServicio);
        */
}
}
