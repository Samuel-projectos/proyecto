package main;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
import Exepciones.ExepcionNumerica;
import acciones.AccClientes;
import acciones.AccCuenta;
import objetos.Cliente;
import objetos.Cuenta;

/**
 * 
 * @author Samuel Robles Rivas
 * @author David P�rez Aviles
 *
 */
/*
 * 
 * @author Samuel Robles Rivas
 * @author David P�rez Aviles
 *
 */
public class Main {
	
	/**
	 * Main
	 * @param args
	 * @throws IOException
	 */
	/*
	 * Main
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		int op;
		Scanner scn = new Scanner(System.in);
		ExepcionNumerica src=new ExepcionNumerica();
		AccClientes cliente=new AccClientes();
		AccCuenta cuenta=new AccCuenta(cliente);
		String dni;

		do {
			menu();
			op=src.controlaInt();
			if (op<0||op>8) {
				System.out.println("Elija entre las opciones");
			}
			else {
				switch (op) {
					case 1: 
						cliente.crearCliente();
						break;
					case 2:
						String key=null;
						do {
							System.out.println("Introduce el DNI");
							key=scn.next();
							if (validarDni(key)==true) {
								cuenta.crearCuenta(key);
							}
							else {
								System.out.println("El DNI no es v�lido");
							}
						}while (validarDni(key)!=true);
						break;
					case 3:
						int i;
						do {
							clientesCuentasAmbos();
							i = src.controlaInt();
							switch (i) {
							case 1: 
								cliente.listarClientes();
								break;
							
							case 2:
								cuenta.listarCuentas();
								break;
							case 3:
								System.out.println("Clientes:");
								cliente.listarClientes();
								System.out.println("Cuentas:");
								cuenta.listarCuentas();
							default:
								System.out.println("Opci�n no v�lida");
							}
						} while(i<1||i>3);
						break;
					case 4:
						key=null;
						do {
							System.out.println("Introduce el DNI");
							key=scn.next();
							if (validarDni(key)==true) {
								cuenta.ingresarSaldo(key);
							}
							else {
								System.out.println("El DNI no es v�lido");
							}
						}while (validarDni(key)!=true);
						break;
					case 5:
						key=null;
						do {
							System.out.println("Introduce el DNI");
							key=scn.next();
							if (validarDni(key)==true) {
								cuenta.retirarSaldo(key);							}
							else {
								System.out.println("El DNI no es v�lido");
							}
						}while (validarDni(key)!=true);
						break;
					case 6:
						cuenta.mostrar();
						break;
					case 7:
						cuenta.revision();
						break;
					case 8:
						cuenta.comision();
						break;						
				}
			}
		} while (op!=0||op>8||op<0);
	}

	/**
	 * Metodo que muestra el menu
	 */
	/*
	 * Metodo que muestra el menu
	 */
	public static void menu() {
		System.out.println("1. Nuevo Cliente");
		System.out.println("2. Nueva Cuenta");
		System.out.println("3. Listar Clientes y Cuentas");
		System.out.println("4. Ingresar Dinero");
		System.out.println("5. Retirar Dinero");
		System.out.println("6. Consultar Saldo");
		System.out.println("7. Revision Mensual");
		System.out.println("8. Cambiar comision mensual");
		System.out.println("0. Salir del programa");
		System.out.println("Elija su opcion: ");
	}

	/**
	 * Muestra un menu para selecionar que debemos mostrar
	 */
	/*
	 * Muestra un menu para selecionar que debemos mostrar
	 */
	public static void clientesCuentasAmbos() {
		System.out.println("1. Mostrar clientes");
		System.out.println("2. Mostrar cuentas");
		System.out.println("3. Mostrar ambos");
		System.out.println("Elija su opcion: ");
	}
	/**
	 * Metodo que contiene el contador de clientes
	 * @return false: no puede crear m�s, true: puede crear m�s
	 */
	/*
	 * Metodo que contiene el contador de clientes
	 * @return false: no puede crear m�s, true: puede crear m�s
	 */
	public static boolean comprobarCantidad() {
		int contador = 0;
		if (contador>=1000) {
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
	 * Comprueba si el DNI is v�lido
	 * @param DNI
	 * @return true: es v�lido, false: no es valido
	 */
	/*
	 * Comprueba si el DNI is v�lido
	 * @param DNI
	 * @return true: es v�lido, false: no es valido
	 */
	public static boolean validarDni (String DNI){
	    if (DNI.toUpperCase().matches("^[0-9]{8}[A-Z]{1}$")) {
	        return true;

	    }else{
	        return false;
	    }  
	}
}
	