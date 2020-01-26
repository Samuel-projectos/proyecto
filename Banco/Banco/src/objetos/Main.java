package objetos;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

import Exepciones.ExepcionNumerica;

public class Main {

	public static void main(String[] args) throws IOException {
		ArrayList<Cliente> clientes = null;
		HashMap<String, Cuenta> cuentas;
		Scanner scn = new Scanner(System.in);
		ExepcionNumerica src=new ExepcionNumerica();
		Cuenta c= new Cuenta(null);
		
		int op;
		do {
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
			op=src.controlaInt();
			if (op<0||op>8) {
				System.out.println("Elija entre las opciones");
			}
			else if (op==1&&clientes.size()<=0) {
				System.out.println("Introduzca su Dni: ");
				String Dni=scn.next();
				do {
					if(validarDni(Dni)==true) {
						System.out.println("DNI valido");
					}
					else {
						System.out.println("DNI no valido, vuelva a introducirlo");
					}
				} while(validarDni(Dni)==false);
				
				System.out.println("Introduzca su Nombre: ");
				String Nombre=scn.next();
				System.out.println("Introduzca su Apellidos: ");
				String Apellidos=scn.next();
				System.out.println("Introduzca su Direccion: ");
				String Direccion=scn.next();
				System.out.println("Introduzca su Telefono: ");
				int Telefono=scn.nextInt();
				do {
					if(validarTelefono(Telefono)==true) {
						System.out.println("DNI valido");
					}
					else {
						System.out.println("DNI no valido, vuelva a introducirlo");
					}
				} while(validarTelefono(Telefono)==false);
				clientes.add(new Cliente(Dni, Nombre, Apellidos, Direccion, Telefono));
			}
			else if (clientes.size()<=0) {
				System.out.println("No hay clientes");
			}
			else {
				switch (op) {
					case 1: 
						System.out.println(comprobarCantidad());
						System.out.println("Introduzca su Dni: ");
						String Dni=scn.next();
						do {
							if(validarDni(Dni)==true) {
								System.out.println("DNI valido");
							}
							else {
								System.out.println("DNI no valido, vuelva a introducirlo");
							}
						} while(validarDni(Dni)==false);
						
						System.out.println("Introduzca su Nombre: ");
						String Nombre=scn.next();
						System.out.println("Introduzca su Apellidos: ");
						String Apellidos=scn.next();
						System.out.println("Introduzca su Direccion: ");
						String Direccion=scn.next();
						System.out.println("Introduzca su Telefono: ");
						int Telefono=scn.nextInt();
						do {
							if(validarTelefono(Telefono)==true) {
								System.out.println("DNI valido");
							}
							else {
								System.out.println("DNI no valido, vuelva a introducirlo");
							}
						} while(validarTelefono(Telefono)==false);
						clientes.add(new Cliente(Dni, Nombre, Apellidos, Direccion, Telefono));
						break;
					case 2:
						
						break;
					case 3:
						Iterator<Cliente> nombreIterator = clientes.iterator();
						while(nombreIterator.hasNext()){
							String elemento = ((Iterator<String>) clientes).next();
							System.out.print(elemento+" / ");
						}
						break;
					case 4:
						System.out.println("¿Cuanto dinero desea ingresar?");
						c.ingresar(0);
						System.out.println("Su saldo es: "+c.getSaldo());
						
						break;
					case 5:
						c.retirar(0);
						break;
					case 6:
						c.consultar();
						break;
					case 7:
						c.revisionMensual();
						break;
					case 8:
						c.cambiarComision(0);
						break;						
				}
			}
		} while (op!=0||op>8||op<0);
	}




	public static boolean comprobarCantidad() {
		int contador = 0;
		if (contador>=1000) {
			return false;
		}
		else {
			return true;
		}
	}

	public static boolean validarDni (String DNI){

	    if (DNI.toUpperCase().matches("^[0-9]{8}[A-Z]{1}$")) {
	        System.out.println("DNI válido");
	        return true;

	    }else{
	        System.out.println("DNI no válido");
	        return false;
	    }  
	}
	
	public static boolean validarTelefono(Integer numero) {
		if (numero.SIZE==9) {
			return true;
		}
		else {
			return false;
		}
	}
}
