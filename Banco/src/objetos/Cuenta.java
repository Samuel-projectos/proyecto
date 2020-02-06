package objetos;

import java.io.IOException;
import java.util.Scanner;

import Exepciones.ExepcionNumerica;
import acciones.AccClientes;

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
	private AccClientes clientes;
	
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
	public Cuenta(AccClientes clientes) {
		nCuenta+=1;
		saldo=0;
		interes_cuenta=0.1;
		comision=0.6;
		this.clientes=clientes;
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
	
	/**
	 * Metodo para ingresar dinero
	 * @param cantidad = La cantidad que se ingresa
	 * @throws IOException 
	 */
	/*
	 * Metodo para ingresar dinero
	 * @param cantidad = La cantidad que se ingresa
	 */
	public void añadir() throws IOException {
		Scanner scn=new Scanner(System.in);
		ExepcionNumerica src=new ExepcionNumerica();
		String dni;
		do {
			System.out.println("Introduce el dni:");
			dni=scn.next();
		}while (validarDni(dni)==false);
		if(clienteEsta(dni)==true) {
		}
		else {
			clienteEsta(dni);
		}
		System.out.println("¿Cuanto dinero desea ingresar?");
		int n=src.controlaInt();
		saldo+=n;
		System.out.println("Su saldo es: "+saldo);
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
	 * Metodo que nos permite retirar dinero de nuestra cuenta.
	 * @throws IOException
	 */
	/*
	 * Metodo que nos permite retirar dinero de nuestra cuenta.
	 * @throws IOException
	 */
	public void retirarSaldo() throws IOException {
		Scanner scn=new Scanner(System.in);
		String dni;
		ExepcionNumerica src=new ExepcionNumerica();
		do {
			System.out.println("Introduce el dni:");
			dni=scn.next();
		}while (validarDni(dni)==false);
		if(clienteEsta(dni)==true) {
		}
		else {
			clienteEsta(dni);
		}
		System.out.println("¿Cuanto dinero desea retirar?");
		int r=src.controlaInt();
		retirar(r);
		System.out.println("Su saldo es: "+saldo);
	}
	
	/**
	 * Metodo que muestra los datos de la cuenta 
	 */
	/*
	 * Metodo que muestra los datos de la cuenta 
	 */
	public void consultar() {
		System.out.println("\tNumero cuenta: "+nCuenta+"\n"
						+ "\tSaldo: "+saldo+"\n"
						+ "\tComisión: "+comision);
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
	
	/**
	 * Validaciones
	 */
	/*
	 * Validaciones
	 */
	/**
	 * Comprueba si el DNI is válido
	 * @param DNI
	 * @return true: es válido, false: no es valido
	 */
	/*
	 * Comprueba si el DNI is válido
	 * @param DNI
	 * @return true: es válido, false: no es valido
	 */
	public static boolean validarDni (String DNI){
	    if (DNI.toUpperCase().matches("^[0-9]{8}[A-Z]{1}$")) {
	        return true;

	    }else{
	        return false;
	    }  
	}
	
	/**
	 * Comprueba si el teléfono es válido
	 * @param numero
	 * @return true: es valido, false: es invalido
	 */
	/*
	 * Comprueba si el teléfono es válido
	 * @param numero
	 * @return true: es valido, false: es invalido
	 */
	public static boolean validarTelefono(Integer numero) {
		String n=numero+"";
		if (n.toUpperCase().matches("^[0-9]{9}")) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * Metodo para saber si el clienta ya está creado
	 * @param dni
	 * @return
	 */
	/*
	 * Metodo para saber si el clienta ya está creado
	 * @param dni
	 * @return
	 */
	public boolean clienteEsta(String dni) {
		if (clientes.key(dni)==true) {
			return true;
		}
		else {
			return false;
		}
	}
}
