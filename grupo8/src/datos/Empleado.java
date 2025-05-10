package datos;

import java.sql.Date;
import java.util.Set;

public class Empleado extends Persona {
    private long idEmpleado;
    private int nroEmpleado;
    private String legajo;
    private Sucursal sucursal;
    private Set<Turno> turnos;
    private Set<Servicio> servicios;

    public Empleado() {
        super();
    }

    public Empleado(String nombre, String apellido, int dni, Date fechaNacimiento, Contacto contacto, int nroEmpleado, String legajo, Sucursal sucursal) {
        super(nombre, apellido, dni, fechaNacimiento, contacto);
        this.nroEmpleado = nroEmpleado;
        this.legajo = legajo;
        this.sucursal = sucursal;
    }

    public long IdEmpleado() {
        return idEmpleado;
    }
    protected void setIdEmpleado(long idEmpleado) {
        this.idEmpleado = idEmpleado;
    }
    public String getLegajo() {
        return legajo;
    }
    public void setLegajo(String legajo) {
        this.legajo = legajo;
    }
    public int getNroEmpleado() {
        return nroEmpleado;
    }
    public void setNroEmpleado(int nroEmpleado) {
        this.nroEmpleado = nroEmpleado;
    }
    public Sucursal getSucursal() {
        return sucursal;
    }
    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
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
    @Override
    public String toString() {
        return "Empleado: " + super.toString() + "[Nombre=" + getNombre() + ", Apellido=" + getApellido() + ", DNI=" + getDni() + ", Fecha de Nacimiento=" + getFechaNacimiento() + ", Legajo=" + legajo + ", Contacto="+ getContacto()  + "]";
    }
}