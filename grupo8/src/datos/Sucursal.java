package datos;

import java.util.HashSet;
import java.util.Set;

public class Sucursal {
    private long idSucursal;
    private String nombre;
    private Contacto contacto;
    private Set<Empleado> empleados;
    private Set<Servicio> servicios;
    private Set<Turno> turnos;

    public Sucursal() {
    }

    public Sucursal(String nombre) {
        this.nombre = nombre;
        this.contacto = null;
        this.empleados = new HashSet<>();
        this.servicios = new HashSet<>();
        this.turnos = new HashSet<>();
    }

    public long getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(long idSucursal) {
        this.idSucursal = idSucursal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Contacto getContacto() {
        return contacto;
    }

    public void setContacto(Contacto contacto) {
        this.contacto = contacto;
    }

    public Set<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(Set<Empleado> empleados) {
        this.empleados = empleados;
    }

    public Set<Servicio> getServicios() {
        return servicios;
    }

    public void setServicios(Set<Servicio> servicios) {
        this.servicios = servicios;
    }

    public Set<Turno> getTurnos() {
        return turnos;
    }

    public void setTurnos(Set<Turno> turnos) {
        this.turnos = turnos;
    }

    @Override
    public String toString() {
        return "Sucursal{" +
                "idSucursal=" + idSucursal + ", nombre='" + nombre + '\'' + ", contacto=" + contacto + '}';
    }
}