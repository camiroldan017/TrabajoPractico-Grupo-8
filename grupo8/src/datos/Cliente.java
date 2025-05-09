package datos;

import java.sql.Date;
import java.util.Set;

public class Cliente extends Persona {
    private long idCliente;
    private int nroCliente;
    private Set<Turno> turnos;

    public Cliente() {
    }

    public Cliente(String nombre, String apellido, int dni, Date fechaNacimiento, Contacto contacto, int nroCliente) {
        super(nombre, apellido, dni, fechaNacimiento, contacto);
        this.nroCliente = nroCliente;
    }

    public long getIdCliente() {
        return idCliente;
    }
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getNroCliente() {
        return nroCliente;
    }
    public void setNroCliente(int nroCliente) {
        this.nroCliente = nroCliente;
    }
    public Set<Turno> getTurnos() {
        return turnos;
    }
    public void setTurnos(Set<Turno> turnos) {
        this.turnos = turnos;
    }


    @Override
    public String toString() {
        return "Cliente: " + super.toString() +  "[ NroCliente=" + nroCliente + ", Nombre=" + getNombre() + ", Apellido=" + getApellido() + ", DNI=" + getDni() + ", Fecha de Nacimiento=" + getFechaNacimiento() + ", Contacto="+ getContacto()  + "]";
    }
}