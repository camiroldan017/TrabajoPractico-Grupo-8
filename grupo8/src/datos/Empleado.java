package datos;

import java.time.LocalDate;
import java.util.Set;

public class Empleado extends Persona{

    private long idEmpleado;
    private String legajo;
    private Set<Turno> turnos; // lista de turnos del empleado
    private Set<Servicio> servicios; // lista de servicios que brinda el empleado
    private Sucursal sucursal; // sucursal a la que pertenece el empleado
    
    public Empleado() {}

    public Empleado(String nombre, String apellido, int dni, LocalDate fechaDeNacimiento,Contacto contacto, String legajo, Set<Turno> turnos, Set<Servicio> servicios, Sucursal sucursal) {
        super(nombre, apellido, dni, fechaDeNacimiento, contacto); 
        this.legajo = legajo;
        this.turnos = turnos; // inicializa la lista de turnos
        this.servicios = servicios; // inicializa la lista de servicios
        this.sucursal = sucursal; // inicializa la sucursal a la que pertenece el empleado  
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

    public Set<Servicio> getServicios() {
        return servicios;
    }

    public void setServicios(Set<Servicio> servicios) {
        this.servicios = servicios;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    @Override
    public String toString() {
        return "Empleado{" + "idEmpleado=" + idEmpleado + ", legajo='" + legajo + '\'' + ", nombre='" + nombre + '\'' + ", apellido='" + apellido + '\'' + ", dni=" + dni + ", fechaDeNacimiento=" + fechaDeNacimiento + ", turnos=" + turnos + ", servicios=" + servicios + ", sucursal= " + sucursal + '}';
    }
}
