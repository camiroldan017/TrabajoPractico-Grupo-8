package datos;

import java.sql.Date;

public class Persona {
    private long idPersona;
    private String nombre;
    private String apellido;
    private int dni;
    private Date fechaNacimiento;

    public Persona() {
    }

    public Persona(String nombre, String apellido, int dni, Date fechaNacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fechaNacimiento = fechaNacimiento;
    }

    public long getIdPersona() {
        return idPersona;
    }
    public void setIdPersona(long idPersona) {
        this.idPersona = idPersona;
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
    public void setDni(int dni) {
        this.dni = dni;
    }
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    @Override
    public String toString() {
        return "Persona: idPersona=" + idPersona ;
    }

}
