package test;

import datos.Servicio;
import negocio.ServicioABM;
import negocio.SucursalABM;

public class TestServicio {

    public static void main(String[] args) {
        ServicioABM servicioABM = new ServicioABM();
        SucursalABM sucursalABM = new SucursalABM();

        // Muestra que no hay nada en la lista servicio
        try {
            System.out.println("\nLista de servicios:\n" + servicioABM.traerServicios());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
       
        //Añadimos servicios con sucursales
        try {
        
            long idServicio = servicioABM.agregarServicio("Depilacion", "30 minutos", sucursalABM.traerSucursal(1L));
            System.out.print("Servicio agregado con ID: " + idServicio);
            long idServicio2 = servicioABM.agregarServicio("Corte de pelo", "45 minutos", sucursalABM.traerSucursal(2L));
            System.out.print("Servicio agregado con ID: " + idServicio2);
            long idServicio3 = servicioABM.agregarServicio("Manicura", "60 minutos", sucursalABM.traerSucursal(3L));
            System.out.print("Servicio agregado con ID: " + idServicio3);
            long idServicio4 = servicioABM.agregarServicio("Masajes", "75 minutos", sucursalABM.traerSucursal(1L));
            System.out.print("Servicio agregado con ID: " + idServicio4);
            long idServicio5 = servicioABM.agregarServicio("Pestañas", "50 minutos", sucursalABM.traerSucursal(2L));
            System.out.print("Servicio agregado con ID: " + idServicio5);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        try {
            System.out.println("\nLista de servicios:\n" + servicioABM.traerServicios());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        // Modificar un servicio
        try {
            Servicio servicio = servicioABM.traerServicio(1L);
            servicioABM.modificarServicio(servicio, "Depilacion Laser", "45 minutos", sucursalABM.traerSucursal(1L));
            System.out.print("Servicio modificado con ID: " + servicio.getIdServicio());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Eliminar un servicio
        try	 {
            servicioABM.eliminarServicio(5L);
            System.out.println("\nServicio eliminado con ID: " + 5);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }     
}
}
