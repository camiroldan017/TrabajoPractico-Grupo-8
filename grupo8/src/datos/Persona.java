package datos;

import java.time.LocalDate;

public abstract class Persona {

   protected long idPersona;
   protected String nombre;
   protected String apellido;
   protected int dni;
   protected LocalDate fechaDeNacimiento;



public Persona(){}

public Persona(String nombre, String apellido, int dni, LocalDate fechaDeNacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fechaDeNacimiento = fechaDeNacimiento;
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
 
    @Override
    public String toString() {
        return "Persona{" + "idPersona=" + idPersona + ", nombre='" + nombre + '\'' + ", apellido='" + apellido + '\'' + ", dni=" + dni + ", fechaDeNacimiento=" + fechaDeNacimiento + '}';
    }
}