package datos;

import java.time.LocalDate;

public class Empleado extends Persona{

    private long idEmpleado;
    private String legajo;

    public Empleado() {
    }

    public Empleado(String nombre, String apellido, int dni, LocalDate fechaDeNacimiento, String legajo) {
        super(nombre, apellido, dni, fechaDeNacimiento);
        this.legajo = legajo;
    }

    public long getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(long idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getLegajo() {
        return legajo;
    }

    public void setLegajo(String legajo) {
        this.legajo = legajo;
    }

    @Override
    public String toString() {
        return "Empleado{" + "idEmpleado=" + idEmpleado + ", legajo='" + legajo + '\'' + ", nombre='" + nombre + '\'' + ", apellido='" + apellido + '\'' + ", dni=" + dni + ", fechaDeNacimiento=" + fechaDeNacimiento + '}';
    }
}
