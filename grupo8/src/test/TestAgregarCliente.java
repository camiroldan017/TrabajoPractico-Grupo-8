package test;

import java.time.LocalDate;
import negocio.ClienteABM;

public class TestAgregarCliente {
	public static void main(String[] args) {

		ClienteABM abm = new ClienteABM();
		long ultimoIdCliente = 0;
		try {
			ultimoIdCliente = abm.agregar("Camilas", "Roldan", 44000004, LocalDate.now());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.printf("Id cliente: %d", ultimoIdCliente);
		/*
		En el formateo de Strings con printf tiene varios especificadores de formato.
		Algunos de los más comunes son:
			%d: Entero con signo (para int y long).
			%f: Número de punto flotante (para float y double).
			%s: Cadena de caracteres.
			%c: Carácter.
			%b: Valor booleano.
		*/
	}
}
