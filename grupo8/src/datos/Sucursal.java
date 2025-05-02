package datos;

import java.util.Set;

public class Sucursal {
    private long idSucursal;
    private String nombre;
    private Contacto contacto;
    private Set<Empleado> empleados;
    private Set<Turno> turnos;

    public Sucursal() {
    }

    public Sucursal(String nombre, Contacto contacto, Set<Empleado> empleados, Set<Turno> turnos) {
        this.nombre = nombre;
        this.contacto = contacto;
        this.empleados = empleados; // inicializa la lista de empleados
        this.turnos = turnos; // inicializa la lista de turnos
    }

    public long getIdSucursal() {
        return idSucursal;
    }

    protected void setIdSucursal(long idSucursal) {
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

    public Set<Turno> getTurnos() {
        return turnos;
    }

    public void setTurnos(Set<Turno> turnos) {
        this.turnos = turnos;
    }

    @Override
    public String toString() {
        return "Sucursal{" + "idSucursal=" + idSucursal + ", nombre='" + nombre + '\n' + ", contacto=" + contacto + ", empleados=" + empleados + ", turnos=" + turnos +'}';
    }
}
