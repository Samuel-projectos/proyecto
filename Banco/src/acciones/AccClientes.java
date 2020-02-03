package acciones;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

import Exepciones.ExepcionNumerica;
import objetos.Cliente;

public class AccClientes {
	static HashMap<String, Cliente> clientes;
	
	/**
	 * Metodo que nos crea el cliente y de forma valida
	 * @throws IOException
	 */
	/*
	 * Metodo que nos crea el cliente y de forma valida
	 * @throws IOException
	 */
	public void crearCliente() throws IOException {
		String dni;
		Scanner scn=new Scanner(System.in);
		ExepcionNumerica src =new ExepcionNumerica();
		do {
			System.out.println("Introduzca su Dni: ");
			dni=scn.next();
			if(validarDni(dni)==true) {
				System.out.println("DNI valido");
			}
			else {
				System.out.println("DNI no valido, vuelva a introducirlo");
			}
		} while(validarDni(dni)==false);
		
		System.out.println("Introduzca su Nombre: ");
		String Nombre=scn.next();
		
		System.out.println("Introduzca su Apellidos: ");
		String Apellidos=scn.next();
		
		System.out.println("Introduzca su Direccion: ");
		String Direccion=scn.next();
		
		int Telefono;
		do {
		System.out.println("Introduzca su Telefono: ");
		Telefono=src.controlaInt();
			if(validarTelefono(Telefono)==true) {
				System.out.println("Telefono valido");
			}
			else {
				System.out.println("Telefono no valido, vuelva a introducirlo");
			}
		} while(validarTelefono(Telefono)==false);
		Cliente cliente=new Cliente(dni, Nombre, Apellidos, Direccion, Telefono);
		clientes.put(dni, cliente);
	}
	
	/**
	 * Metodo que devuelve el contenido
	 */
	/*
	 * Metodo que devuelve el contenido
	 */
	public Cliente clienteDni(String dni) {
		return clientes.get(dni);
	}
	
	/**
	 * Metodo que muestra los clientes
	 */
	/*
	 * Metodo que muestra los clientes
	 */
	public void listarClientes() {
		for (String i : clientes.keySet()) {
			clientes.get(i).mostrar();
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
}
