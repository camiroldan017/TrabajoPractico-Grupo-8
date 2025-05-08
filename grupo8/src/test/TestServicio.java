package test;

import negocio.ServicioABM;
import negocio.SucursalABM;

public class TestServicio {

    public static void main(String[] args) {
        ServicioABM servicioABM = new ServicioABM();
        SucursalABM sucursalABM = new SucursalABM();
         
        try {
            // Traer un servicio por ID
            long idServicio = servicioABM.agregarServicio("Depilacion", " 90 minutos", sucursalABM.traerSucursal(2L));
            System.out.println("Servicio agregado con ID: " + idServicio);
            long idServicio2 = servicioABM.agregarServicio("Corte de pelo", " 60 minutos", sucursalABM.traerSucursal(2L));
            System.out.println("Servicio agregado con ID: " + idServicio2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        try {
            System.out.println("Lista de servicios:" + servicioABM.traerServicios());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
       
        /* 
        // Eliminar un servicio
        try	 {
            servicioABM.eliminarServicio(2);
            System.out.println("Servicio eliminado con ID: " + 2);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
       */
        
}
}
