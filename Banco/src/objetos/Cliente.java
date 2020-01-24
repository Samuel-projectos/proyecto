package objetos;

public class Cliente {
	private String dni;
	private String nombre;
	private String apellido;
	private String direccion;
	private int telefono;
	private static int contador=0;
		
	public Cliente(String dni, String nombre, String apellido, String direccion, int telefono) {
		this.dni=dni;
		this.nombre=nombre;
		this.apellido=apellido;
		this.direccion=direccion;
		this.telefono=telefono;
		contador+=1;
	}
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
	
	public boolean comprobarCantidad() {
		if (contador>=1000) {
			return false;
		}
		else {
			return true;
		}
	}
	
}
