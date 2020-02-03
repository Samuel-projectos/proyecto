package objetos;
/**
 * 
 * @author Samuel Robles Rivas
 * @author David Pérez Aviles
 *
 */
public class Cliente {
	/**
	 * @param dni = Numero identificador del cliente
	 * @param nombre = nombre del cliente
	 * @param apellido = apellido del cliente
	 * @param direccion = direccion del cliente
	 * @param telefono = telefono del cliente
	 */
	/*
	 * @param dni = Numero identificador del cliente
	 * @param nombre = nombre del cliente
	 * @param apellido = apellido del cliente
	 * @param direccion = direccion del cliente
	 * @param telefono = telefono del cliente
	 */
	private String dni;
	private String nombre;
	private String apellido;
	private String direccion;
	private int telefono;
	private static int contador=0;
	
	/**
	 * @param dni = Numero identificador del cliente
	 * @param nombre = nombre del cliente
	 * @param apellido = apellido del cliente
	 * @param direccion = direccion del cliente
	 * @param telefono = telefono del cliente
	 */
	/*
	 * @param dni = Numero identificador del cliente
	 * @param nombre = nombre del cliente
	 * @param apellido = apellido del cliente
	 * @param direccion = direccion del cliente
	 * @param telefono = telefono del cliente
	 */
	public Cliente(String dni, String nombre, String apellido, String direccion, int telefono) {
		this.dni=dni;
		this.nombre=nombre;
		this.apellido=apellido;
		this.direccion=direccion;
		this.telefono=telefono;
		contador+=1;
	}
	
	/**
	 * Getters y Setters del cliente
	 */
	/*
	 * Getters y Setters del cliente
	 */
	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	
	/**
	 * Metodo para comprobar la cantidad de Clientes existentes
	 * @return boolean = Devuelve verdadero o falso si se puede crear un cliente
	 */
	/*
	 * Metodo para comprobar la cantidad de Clientes existentes
	 * @return boolean = Devuelve verdadero o falso si se puede crear un cliente
	 */
	public boolean comprobarCantidad() {
		if (contador>=1000) {
			return false;
		}
		else {
			return true;
		}
	}
	
	/**
	 * Metodo que muestra los datos del cliente
	 */
	/*
	 * Metodo que muestra los datos del cliente
	 */
	public void mostrar() {
		System.out.println(dni+"\n"+nombre+"\n"+apellido+"\n"+direccion+"\n"+telefono);
	}
	
}
