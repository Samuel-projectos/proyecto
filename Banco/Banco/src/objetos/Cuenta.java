package objetos;
	
/**
 * 
 * @author Samuel Robles Rivas
 * @author David Pérez Aviles
 *
 */

public class Cuenta {
	/**
	 * @param nCuenta = Es el número que tiene la cuenta
	 * @param saldo = La cantidad de dinero que posee
	 * @param interes_cuenta = Interés mensual que se le aplica a la cuenta 
	 * @param comision = Cantidad que se paga para mantener la cuenta
	 * @param cliente = Propietario de la cuenta
	 */
	/*
	 * @param nCuenta = Es el número que tiene la cuenta
	 * @param saldo = La cantidad de dinero que posee
	 * @param interes_cuenta = Interés mensual que se le aplica a la cuenta 
	 * @param comision = Cantidad que se paga para mantener la cuenta
	 * @param cliente = Propietario de la cuenta
	 */
	private static int nCuenta=0000;
	private double saldo;
	private double interes_cuenta;
	private double comision;
	private Cliente cliente;
	
	/**
	 * @param nCuenta = Número que tiene la cuenta
	 * @param saldo = 0 (variable)
	 * @param interes_cuenta = 0.1%
	 * @param comision = 0.6 (variable)
	 * @param cliente = Propietario de la cuenta
	 */
	/*
	 * @param nCuenta = Número que tiene la cuenta
	 * @param saldo = 0 (variable)
	 * @param interes_cuenta = 0.1%
	 * @param comision = 0.6 (variable)
	 * @param cliente = Propietario de la cuenta
	 */
	public Cuenta(Cliente cliente) {
		nCuenta+=1;
		saldo=0;
		interes_cuenta=0.1;
		comision=0.6;
		this.cliente=cliente;
	}

	/**
	 * Getters y Setters de la cuenta
	 */
	/*
	 * Getters y Setters de la cuenta
	 */
	public static int getNcuenta() {
		return nCuenta;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public double getComision() {
		return comision;
	}

	public void setComision(double comision) {
		this.comision = comision;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	/**
	 * Metodo para ingresar dinero
	 * @param cantidad = La cantidad que se ingresa
	 */
	/*
	 * Metodo para ingresar dinero
	 * @param cantidad = La cantidad que se ingresa
	 */
	public void ingresar(int cantidad) {
		this.saldo+=cantidad;
		System.out.println("Se ha ingresado "+cantidad+"€");
	}
	
	/**
	 * Metodo para retirar dinero
	 * @param cantidad = La cantidad que se retira
	 * Comprueba que se puede retirar dicha cantidad
	 */
	/*
	 * Metodo para retirar dinero
	 * @param cantidad = La cantidad que se retira
	 * Comprueba que se puede retirar dicha cantidad
	 */
	public void retirar(int cantidad) {
		if (saldo<cantidad) {
			System.out.println("No puedes extraer esa cantidad, tu saldo es menor.");
		}
		else {
			this.saldo-=cantidad;
			System.out.println("Se ha ingresado "+cantidad+"€");
		}
	}
	
	/**
	 * Metodo que muestra los datos de la cuenta 
	 */
	/*
	 * Metodo que muestra los datos de la cuenta 
	 */
	public void consultar() {
		System.out.println("\tNumero cuenta: "+getNcuenta()+"\n"
				+ "\tDNI: "+getCliente().getDni()+"\n"
						+ "\tSaldo: "+getSaldo()+"\n"
						+ "\tComisión: "+getComision());
	}
	
	/**
	 * Metodo que muestra el saldo con el interés y la comision.
	 * @return saldo
	 */
	/*
	 * Metodo que muestra el saldo con el interés y la comision.
	 * @return saldo
	 */
	public double revisionMensual() {
		saldo+=(saldo*interes_cuenta/100)-comision;
		return saldo;
	}
	
	/**
	 * Metodo que nos permite cambiar la comision
	 * @param comision = Contiene la nueva comision
	 */
	/*
	 * Metodo que nos permite cambiar la comision
	 * @param comision = Contiene la nueva comision
	 */
	public void cambiarComision(double comision) {
		this.comision=comision;
	}
	
	/**
	 * Metodo que comprueba la cantidad de cuentas existentes y devuelve si se puede o no crear una cuenta
	 * @return boolean = Devuelve verdadero o falso si se puede crear una cuenta
	 */
	/*
	 * Metodo que comprueba la cantidad de cuentas existentes y devuelve si se puede o no crear una cuenta
	 * @return boolean = Devuelve verdadero o falso si se puede crear una cuenta
	 */
	public boolean comprobarCantidad() {
		if (nCuenta>=1000) {
			return false;
		}
		else {
			return true;
		}
	}
}
