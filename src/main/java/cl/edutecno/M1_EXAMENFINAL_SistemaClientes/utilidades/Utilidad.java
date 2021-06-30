package cl.edutecno.M1_EXAMENFINAL_SistemaClientes.utilidades;

import java.io.File;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Utilidad {

	// Metodos
	public void tiempoEspera() {

		System.out.println("");
		System.out.print("Abadonando el Sistema de Clientes");

		try {
			System.out.print(".");
			TimeUnit.SECONDS.sleep(1);
			System.out.print(".");
			TimeUnit.SECONDS.sleep(1);
			System.out.print(".");
			TimeUnit.SECONDS.sleep(1);
			System.out.print(".\n");
			TimeUnit.SECONDS.sleep(1);
			System.out.println("Acaba de salir del sistema");
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO: handle exception
			System.out.println("Error de ejecucion de tiempo: " + e.getMessage());
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error no identificado: " + e.getMessage());
		}

	}

	public void limpiezaPantalla() {
		for (int i = 0; i < 200; i++) {
			System.out.println("");
		}
		System.exit(0);
	}
	
	public boolean comprobarFichero(File fichero) {

		Scanner scS = new Scanner(System.in);
		boolean crear = false;
		boolean condicion = true;
		String respuesta = " ";

		try {
			if (fichero.exists() != true) {
				crear = true;
			} else {
				System.out.print("El archivo notas.txt ya existe, ¿Desea sobreescibirlo? [s/n]: ");
				respuesta = scS.nextLine();
				while (condicion) {
					if (respuesta.equalsIgnoreCase("s")) {
						crear = true;
						condicion = false;
					} else if (respuesta.equalsIgnoreCase("n")) {
						System.out.println("No se escribira en el archivo notas.txt");
						crear = false;
						condicion = false;
					} else {
						System.out.println("Opcion invalida");
					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Ha ocurrido un error al crear el archivo - " + e.getMessage());
		}
		return crear;
	}

}
