package datos;

import java.util.Set;

public class Servicio {
    private int idServicio;
    private String nombre;
    private String duracion;
    private Sucursal sucursal;
    private Set<Empleado> empleados;
    private Set<Turno> turnos;

    public Servicio() {
    }

    public Servicio(int idServicio, String nombre, String duracion, Sucursal sucursal) {
        this.idServicio = idServicio;
        this.nombre = nombre;
        this.duracion = duracion;
        this.sucursal = sucursal;
    }
    public int getIdServicio() {
        return idServicio;
    }
    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDuracion() {
        return duracion;
    }
    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }
    public Sucursal getSucursal() {
        return sucursal;
    }
    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
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
        return "Servicio [idServicio=" + idServicio + ", nombre=" + nombre + ", duracion=" + duracion + ", sucursal="
                + sucursal + "]";
    }

}
