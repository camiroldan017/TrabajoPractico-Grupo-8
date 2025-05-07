package datos;

import java.sql.Date;
import java.util.Set;

public class Cliente extends Persona {
    private long idCliente;
    private Set<Turno> turnos;

    public Cliente() {
    }

    public Cliente( String nombre, String apellido, int dni, Date fechaNacimiento) {
        super(nombre, apellido, dni, fechaNacimiento);
    
    }

    public long getIdCliente() {
        return idCliente;
    }
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
    public Set<Turno> getTurnos() {
        return turnos;
    }
    public void setTurnos(Set<Turno> turnos) {
        this.turnos = turnos;
    }

    @Override 
    public String toString() {
        return "Cliente [idCliente=" + idCliente + ", turnos=" + turnos + "]";
    }

}