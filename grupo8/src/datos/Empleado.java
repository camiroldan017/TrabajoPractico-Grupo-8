package datos;

import java.time.LocalDate;
import java.util.Set;

public class Empleado extends Persona{

    private long idEmpleado;
    private String legajo;
    private Set<Turno> turnos; // lista de turnos del empleado

    public Empleado() {
    }

    public Empleado(String nombre, String apellido, int dni, LocalDate fechaDeNacimiento, String legajo, Set<Turno> turnos) {
        super(nombre, apellido, dni, fechaDeNacimiento);
        this.legajo = legajo;
        this.turnos = turnos; // inicializa la lista de turnos
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

    public Set<Turno> getTurnos() {
        return turnos;
    }

    public void setTurnos(Set<Turno> turnos) {
        this.turnos = turnos;
    }

    @Override
    public String toString() {
        return "Empleado{" + "idEmpleado=" + idEmpleado + ", legajo='" + legajo + '\'' + ", nombre='" + nombre + '\'' + ", apellido='" + apellido + '\'' + ", dni=" + dni + ", fechaDeNacimiento=" + fechaDeNacimiento + ", turnos=" + turnos + '}';
    }
}
