package datos;

import java.util.Set;

public class Servicio {
   private long idServicio;
   private String nombre;
   private String duracion;
   private Set<Empleado> empleados; // lista de empleados que brindan el servicio
   private Set <Turno> turnos; // lista de turnos del servicio


   public Servicio() {
   } 

   public Servicio (String nombre, String duracion, Set<Empleado> empleados, Set<Turno> turnos) {
       this.nombre = nombre;
       this.duracion = duracion;
       this.empleados = empleados; // inicializa la lista de empleados
       this.turnos = turnos; // inicializa la lista de turnos
   }
    public long getIdServicio() {
         return idServicio;
    }
    protected void setIdServicio(long idServicio) {
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
         return "Servicio{" + "idServicio=" + idServicio + ", nombre=" + nombre + ", duracion=" + duracion + ", empleados=" + empleados + '}';       
}
}
