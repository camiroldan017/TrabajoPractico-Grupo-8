package test;
import datos.Contacto;
import negocio.ContactoABM;
import negocio.SucursalABM;

public class TestContacto {
    public static void main(String[] args) {
        SucursalABM sucursalABM = new SucursalABM();
        ContactoABM contactoABM = new ContactoABM();
    
        Contacto contacto = new Contacto ("Sucursalcentro@gmail.com", "123456789", "Av. Siempre Viva 123");
        contactoABM.agregarContacto(contacto.getEmail(), contacto.getTelefono(), contacto.getDireccion(), sucursalABM.traerSucursal(2l)); // Guardar en la BD antes de usarla
        
    }


}
