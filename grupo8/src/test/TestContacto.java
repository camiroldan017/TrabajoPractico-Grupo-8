package test;
import datos.Contacto;
import negocio.ContactoABM;


public class TestContacto {
    public static void main(String[] args) {
        ContactoABM contactoABM = new ContactoABM();
    
        try{
            Contacto contacto = new Contacto ("Sucursalsur@gmail.com", "1234876577", "Calle Falsa 555");
             contactoABM.agregarContacto(contacto.getEmail(), contacto.getTelefono(), contacto.getDireccion()); // Guardar en la BD antes de usarla
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
       
    }


}
