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
	AccClientes clientes;
	
	/**
	 * Constructor
	 * @param clientes: almacena todos los clientes creados
	 */
	public AccCuenta(AccClientes clientes) {
		cuentas=new HashMap<>();
		this.clientes=clientes;
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
	public void crearCuenta(String key) {
		cuentas.put(key, new Cuenta(clientes));
	}
	
	/**
	 * Metodo que nos permite ingresar dinero en el saldo de la cuenta
	 * @throws IOException
	 */
	/*
	 * Metodo que nos permite ingresar dinero en el saldo de la cuenta
	 * @throws IOException
	 */
	public void ingresarSaldo(String key) throws IOException {
		cuentas.get(key).añadir();
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
	public void retirarSaldo(String key) throws IOException {
		cuentas.get(key).retirarSaldo();
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
		}while (clientes.key(dni)==false);
		if(clientes.key(dni)==true) {
			System.out.println("Su saldo es: "+cuentas.get(dni).getSaldo());
		}
		else {
			System.out.println("No existe el usuario");
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
		}while (clientes.key(dni)==false);
		if(clientes.key(dni)==true) {
			System.out.println("Su saldo es: "+cuentas.get(dni).revisionMensual());
		}
		else {
			System.out.println("El cliente no existe");
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
		}while (clientes.key(dni)==false);
		if(clientes.key(dni)==true) {
		}
		else {
			System.out.println("El cliente no existe");
		}
		System.out.println("Introduzca la nueva comision");
		int c=src.controlaInt();
		cuentas.get(dni).cambiarComision(c);
		System.out.println("Su nueva comision: "+cuentas.get(dni).getComision());
	}
}
