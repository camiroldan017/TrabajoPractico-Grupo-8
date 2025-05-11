package test;
import datos.Contacto;
import negocio.ContactoABM;


public class TestContacto {
    public static void main(String[] args) {
        ContactoABM contactoABM = new ContactoABM();
       

        //probamos excepcion lista vacia
        try {
            System.out.println("\nLista de contactos:" + contactoABM.traerContactos());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }



      System.out.println("Creando contactos...");
        try{
            Contacto contacto = new Contacto ("sofia@gmail.com", "1134231577", "Calle Laguna 555");
             contactoABM.agregarContacto(contacto.getEmail(), contacto.getTelefono(), contacto.getDireccion()); // Guardar en la BD antes de usarla
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        try{
            Contacto contacto = new Contacto ("marcelo123@gmail.com", "1154856955", " Av. libertador 123");
             contactoABM.agregarContacto(contacto.getEmail(), contacto.getTelefono(), contacto.getDireccion()); // Guardar en la BD antes de usarla
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try{
            Contacto contacto = new Contacto ("Catalina12@gmail.com", "1188857844", "9 de julio 2578");
             contactoABM.agregarContacto(contacto.getEmail(), contacto.getTelefono(), contacto.getDireccion()); // Guardar en la BD antes de usarla
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try{
            Contacto contacto = new Contacto ("juanjose0@gmail.com", "1157896985", "Av. Pavon 5021");
             contactoABM.agregarContacto(contacto.getEmail(), contacto.getTelefono(), contacto.getDireccion()); // Guardar en la BD antes de usarla
        }catch (Exception e) {
            System.out.println(e.getMessage());
        } 
        

        try{
            Contacto contacto = new Contacto ("camila@gmail.com", "1157891111", "Monteverde 2020");
             contactoABM.agregarContacto(contacto.getEmail(), contacto.getTelefono(), contacto.getDireccion()); // Guardar en la BD antes de usarla
        }catch (Exception e) {
            System.out.println(e.getMessage());
        } 

        try{
            Contacto contacto = new Contacto ("micaInsfran@gmail.com", "1157345866", "Cascadas 21");
             contactoABM.agregarContacto(contacto.getEmail(), contacto.getTelefono(), contacto.getDireccion()); // Guardar en la BD antes de usarla
        }catch (Exception e) {
            System.out.println(e.getMessage());
        } 
    
        try{
            Contacto contacto = new Contacto ("nico@gmail.com", "1157345999", "Caracas 120");
             contactoABM.agregarContacto(contacto.getEmail(), contacto.getTelefono(), contacto.getDireccion()); // Guardar en la BD antes de usarla
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try{
            Contacto contacto = new Contacto ("fede@gmail.com", "115325999", "Lima 100");
             contactoABM.agregarContacto(contacto.getEmail(), contacto.getTelefono(), contacto.getDireccion()); // Guardar en la BD antes de usarla
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //contacto para eliminar
        try{
            Contacto contacto = new Contacto ("FernandaAlarcon@gmail.com", "1122558778", "san juan 12");
             contactoABM.agregarContacto(contacto.getEmail(), contacto.getTelefono(), contacto.getDireccion()); // Guardar en la BD antes de usarla
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

            


        //intentamos agregar un mismo contacto para probar excepcion
        try{
            Contacto contacto = new Contacto ("sofia@gmail.com", "1134231577", "Calle Laguna 555");
             contactoABM.agregarContacto(contacto.getEmail(), contacto.getTelefono(), contacto.getDireccion()); // Guardar en la BD antes de usarla
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Eliminar un contacto
        try	 {
            contactoABM.eliminarContacto(9L);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


        //traemos todos los contactos agregados
        try {
            System.out.println("\nLista de contactos:" + contactoABM.traerContactos());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    


}
