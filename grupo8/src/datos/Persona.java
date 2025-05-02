package datos;

import java.time.LocalDate;

public abstract class Persona {

   protected long idPersona;
   protected String nombre;
   protected String apellido;
   protected int dni;
   protected LocalDate fechaDeNacimiento;
   protected Contacto contacto; // Se puede agregar un contacto a la persona, pero no es obligatorio



public Persona(){}

public Persona(String nombre, String apellido, int dni, LocalDate fechaDeNacimiento, Contacto contacto) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.contacto = contacto;
}

    // Getters and Setters
    protected void setIdPersona(long idPersona) {
        this.idPersona = idPersona;
    }

    public long getIdPersona() {
        return idPersona;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getDni() {
        return dni;
    }
    public void setContacto(Contacto contacto) {
        this.contacto = contacto;
    }
    public Contacto getContacto() {
        return contacto;
    }
    
    @Override
    public String toString() {
        return "Persona{" + "idPersona=" + idPersona + ", nombre='" + nombre + '\'' + ", apellido='" + apellido + '\'' + ", dni=" + dni + ", fechaDeNacimiento=" + fechaDeNacimiento + ", contacto=" + contacto + '}';
    }
}