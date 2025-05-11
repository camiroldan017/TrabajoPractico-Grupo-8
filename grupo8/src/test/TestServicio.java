package test;

import negocio.ServicioABM;
import negocio.SucursalABM;

public class TestServicio {

    public static void main(String[] args) {
        ServicioABM servicioABM = new ServicioABM();
        SucursalABM sucursalABM = new SucursalABM();
         
        try {
         
            long idServicio = servicioABM.agregarServicio("Depilacion", "30 minutos", sucursalABM.traerSucursal(1L));
            System.out.println("Servicio agregado con ID: " + idServicio);
            long idServicio2 = servicioABM.agregarServicio("Corte de pelo", "45 minutos", sucursalABM.traerSucursal(2L));
            System.out.println("Servicio agregado con ID: " + idServicio2);
            long idServicio3 = servicioABM.agregarServicio("Manicura", "60 minutos", sucursalABM.traerSucursal(3L));
            System.out.println("Servicio agregado con ID: " + idServicio3);
            long idServicio4 = servicioABM.agregarServicio("Masajes", "75 minutos", sucursalABM.traerSucursal(1L));
            System.out.println("Servicio agregado con ID: " + idServicio4);
            long idServicio5 = servicioABM.agregarServicio("Pestañas", "50 minutos", sucursalABM.traerSucursal(2L));
            System.out.println("Servicio agregado con ID: " + idServicio5);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        try {
            System.out.println("\nLista de servicios:" + servicioABM.traerServicios());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
       
        
        // Eliminar un servicio
        try	 {
            servicioABM.eliminarServicio(5L);
            System.out.println("Servicio eliminado con ID: " + 5);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
       
        
}
}
