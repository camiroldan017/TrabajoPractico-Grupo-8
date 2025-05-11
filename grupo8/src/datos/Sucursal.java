package datos;

import java.util.HashSet;
import java.util.Set;

public class Sucursal {
    private long idSucursal;
    private String nombre;
    private String direccion;
    private String telefono;
    private Set<Empleado> empleados;
    private Set<Servicio> servicios;
    private Set<Turno> turnos;

    public Sucursal() {
    }

    public Sucursal(String nombre, String direccion, String telefono) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.empleados = new HashSet<>();
        this.servicios = new HashSet<>();
        this.turnos = new HashSet<>();
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

    

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
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
        return  "Sucursal [idSucursal= "  +  idSucursal  +  ",  nombre= "  +  nombre  +  ",  direccion= "  +  direccion  +  
                ",  telefono= "  +  telefono   +  "]\n"; 
    }
}