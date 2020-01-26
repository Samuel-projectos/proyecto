package Exepciones;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExepcionNumerica {
	BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
	boolean error = false;

	public int controlaInt() throws IOException {
		int entero = 0;
		do {
			try {
				entero = Integer.parseInt(entrada.readLine());
				error = false;
			} catch (NumberFormatException e) {
				// TODO: handle exception
				System.out.println("Valor no válido, introduce un número");
				error = true;
			}
		} while (error);
		return entero;
		}

		public double controlaDouble() throws IOException {
			double entero = 0;
			do {
				try {
					entero = Double.parseDouble(entrada.readLine());
					error = false;
				} catch (NumberFormatException e) {
					// TODO: handle exception
					System.out.println("Valor no válido, introduce un número con o sin decimal");
					error = true;
				}
			} while (error);
			return entero;
		}
}
