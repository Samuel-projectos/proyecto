package acciones;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
import Exepciones.ExepcionNumerica;
import acciones.AccClientes;
import objetos.Cuenta;

public class AccCuenta {
	/**
	 * Usamos el hashMap para que almacene los cuentas y poder encontrarlo mediante una key que será el DNI
	 */
	/*
	 * Usamos el hashMap para que almacene los cuentas y poder encontrarlo mediante una key que será el DNI
	 */
	HashMap<String, Cuenta> cuentas;
	AccClientes cliente;

	public AccCuenta(AccClientes clientes) {
		cuentas=new HashMap<>();
		cliente=clientes;
	}
	
	/**
	 * Metodos
	 */
	/*
	 * Metodos
	 */
	/**
	 * Metodo que crea una cuenta a partir del dni del cliente
	 */
	/*
	 * Metodo que crea una cuenta a partir del dni del cliente
	 */
	public void crearCuenta() {
		Scanner scn =new Scanner(System.in);
		String dni;
		do {
			System.out.println("Introduce el dni:");
			dni=scn.next();
			if (validarDni(dni)==false) {
			System.out.println("DNI no valido, vuelva a intentar");
			}
			if(cliente.key(dni)==true) {
				Cuenta c=new Cuenta();
				cuentas.put(dni, c);
				System.out.println("Cuenta creada");
			}
			else {
				System.out.println("El cliente no existe");
			}
		}while (validarDni(dni)==false);
			
	}
	
	/**
	 * Metodo que nos permite ingresar dinero en el saldo de la cuenta
	 * @throws IOException
	 */
	/*
	 * Metodo que nos permite ingresar dinero en el saldo de la cuenta
	 * @throws IOException
	 */
	public void ingresar() throws IOException {
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
		cuentas.get(dni).añadir(n);
		System.out.println("Su saldo es: "+cuentas.get(dni).getSaldo());	
	}
	
	/**
	 * Metodo que muestra las cuentas
	 */
	/*
	 * Metodo que muestra las cuentas
	 */
	public void listarCuentas() {
		for (String i : cuentas.keySet()) {
			System.out.println(i);
			cuentas.get(i).consultar();
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
	public void retirar() throws IOException {
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
		cuentas.get(dni).retirar(r);
		System.out.println("Su saldo es: "+cuentas.get(dni).getSaldo());
	}
	
	/**
	 * Metodo que nos muestra el saldo de la cuenta
	 */
	/*
	 * Metodo que nos muestra el saldo de la cuenta
	 */
	public void mostrar() {
		Scanner scn=new Scanner(System.in);
		String dni;
		do {
			System.out.println("Introduce el dni:");
			dni=scn.next();
		}while (validarDni(dni)==false);
		if(clienteEsta(dni)==true) {
			System.out.println("Su saldo es: "+cuentas.get(dni).getSaldo());
		}
		else {
			clienteEsta(dni);
		}
	}
	
	/**
	 * Metodo que nos hace la revisionMensual
	 */
	/*
	 * Metodo que nos hace la revisionMensual
	 */
	public void revision() {
		Scanner scn=new Scanner(System.in);
		String dni;
		do {
			System.out.println("Introduce el dni:");
			dni=scn.next();
		}while (validarDni(dni)==false);
		if(clienteEsta(dni)==true) {
			System.out.println("Su saldo es: "+cuentas.get(dni).revisionMensual());
		}
		else {
			clienteEsta(dni);
		}
	}
	
	/**
	 * Metodo que nos permite cambiar la comision de una cuenta
	 * @throws IOException
	 */
	/*
	 * Metodo que nos permite cambiar la comision de una cuenta
	 * @throws IOException
	 */
	public void comision() throws IOException {
		String dni;
		Scanner scn=new Scanner(System.in);
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
		System.out.println("Introduzca la nueva comision");
		int c=src.controlaInt();
		cuentas.get(dni).cambiarComision(c);
		System.out.println("Su nueva comision: "+cuentas.get(dni).getComision());
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
		if (cliente.key(dni)==true) {
			return true;
		}
		else {
			return false;
		}
	}
}
