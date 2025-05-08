package test;
import datos.Contacto;
import negocio.ContactoABM;
import negocio.SucursalABM;

public class TestContacto {
    public static void main(String[] args) {
        SucursalABM sucursalABM = new SucursalABM();
        ContactoABM contactoABM = new ContactoABM();
    
        Contacto contacto = new Contacto ("Sucursalsur@gmail.com", "1234876577", "Calle Falsa 555");
        contactoABM.agregarContacto(contacto.getEmail(), contacto.getTelefono(), contacto.getDireccion(), sucursalABM.traerSucursal(12l)); // Guardar en la BD antes de usarla
        
    }


}
