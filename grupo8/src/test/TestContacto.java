package test;
import datos.Contacto;
import negocio.ContactoABM;


public class TestContacto {
    public static void main(String[] args) {
        ContactoABM contactoABM = new ContactoABM();
    
        try{
            Contacto contacto = new Contacto ("Sofia@gmail.com", "1234231577", "Calle Laguna 555");
             contactoABM.agregarContacto(contacto.getEmail(), contacto.getTelefono(), contacto.getDireccion()); // Guardar en la BD antes de usarla
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    
    }


}
