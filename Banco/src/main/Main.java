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
 * @author David Pérez Aviles
 *
 */
/*
 * 
 * @author Samuel Robles Rivas
 * @author David Pérez Aviles
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
						cuenta.crearCuenta();
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
								System.out.println("Opción no válida");
							}
						} while(i<1||i>3);
						break;
					case 4:
						cuenta.ingresar();
						break;
					case 5:
						cuenta.retirar();
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
	 * @return false: no puede crear más, true: puede crear más
	 */
	/*
	 * Metodo que contiene el contador de clientes
	 * @return false: no puede crear más, true: puede crear más
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
}
	