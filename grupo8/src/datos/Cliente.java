package datos;

import java.time.LocalDate;
import java.util.Set;

public class Cliente extends Persona{
	private long idCliente;
	private Set<Turno> turnos; // lista de turnos del cliente
	
	public Cliente() {
	} // siempre hay que implementar el constructor vacío

	// no va el id en el constructor por ser autoincrementable
	public Cliente(String apellido, String nombre, int dni, LocalDate fechaDeNacimiento, Set<Turno> turnos) {
		super(apellido, nombre, dni, fechaDeNacimiento); // llama al constructor de la clase padre
		this.turnos = turnos; // inicializa la lista de turnos

	}

	public long getIdCliente() {
		return idCliente;
	}

	// siempre va protected, para que no sea modificado
	protected void setIdCliente(long idCliente) {
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
		return "Cliente{" + "idCliente=" + idCliente + '\'' + ", nombre='" + nombre + '\'' + ", apellido='" + apellido + '\'' + ", dni=" + dni + ", fechaDeNacimiento=" + fechaDeNacimiento + ", Turnos=" + turnos + '}';
	}
}
