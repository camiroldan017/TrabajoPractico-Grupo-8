package datos;

import java.time.LocalDate;

public class Cliente extends Persona{
	private long idCliente;
	
	public Cliente() {
	} // siempre hay que implementar el constructor vacío

	// no va el id en el constructor por ser autoincrementable
	public Cliente(String apellido, String nombre, int dni, LocalDate fechaDeNacimiento) {
		super(apellido, nombre, dni, fechaDeNacimiento); // llama al constructor de la clase padre

	}

	public long getIdCliente() {
		return idCliente;
	}

	// siempre va protected, para que no sea modificado
	protected void setIdCliente(long idCliente) {
		this.idCliente = idCliente;
	}
	
	@Override
	public String toString() {
		return "Cliente{" + "idCliente=" + idCliente + ", nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni + ", fechaDeNacimiento=" + fechaDeNacimiento + '}';
	}
}
